package com.action.admin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import net.sf.ehcache.CacheManager;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.Const;
import com.action.base.BaseAction;
import com.annotation.Admin;
import com.commons.CacheUtil;
import com.commons.MyBeanUtils;
import com.model.po.Authority;
import com.model.po.Role;
import com.model.vo.Json;
import com.model.vo.RoleVO;
import com.model.vo.UserVO;
import com.opensymphony.xwork2.ActionContext;
import com.service.AuthorityService;
import com.service.RoleService;

@Admin
@Controller
@Scope("prototype")
public class AdminRoleAction extends BaseAction<Role>{
	@Resource
	private RoleService roleService;	
	public String list() {
		ActionContext.getContext().put("list", roleService.findAll());
		return "list";
	}
	private Long[] ids;
	
	public void delete() {
		Json json = new Json();
		try {
			roleService.delete(ids);
			CacheUtil.cacheRemoveObj("RoleService:findAll", CacheUtil.LEVEL02);
		}catch ( Exception e ) {
			json.setMsg(e.getMessage());
			writeJson(json);
			return ;
		}
		json.setMsg("删除成功");
		json.setSuccess(true);
		writeJson(json);
	}
	
	public String updateUI() {
		ActionContext.getContext().getValueStack().push(roleService.getById(model.getId()));
		return "saveUI";
	}
	public String update() {
		Role role = roleService.getById(model.getId());
		MyBeanUtils.copy(role, model);
		roleService.update(role);
		CacheUtil.cacheRemoveObj("RoleService:findAll", CacheUtil.LEVEL02);
		return "toList";
	}
	
	public String addUI() {
		return "saveUI";		
	}
	public String add() {
		roleService.save(model);	
		CacheUtil.cacheRemoveObj("RoleService:findAll", CacheUtil.LEVEL02);
		return "toList";
	}
	@Resource	
	private AuthorityService authorityService;
	private Long[] authorityIds;	//回显权限
	
	public String setUI() {
		Role role = roleService.getById(model.getId());		
		role.setAuthorities(new HashSet<Authority>(authorityService.findByRole(role)));
		ActionContext.getContext().getValueStack().push(role);
		if ( role.getAuthorities() != null ) {
			authorityIds = new Long[role.getAuthorities().size()];
			int index = 0;
			for (Authority authority : role.getAuthorities()) {
				authorityIds[index ++] = authority.getId();
			}
		}
		List<Authority> authorities = authorityService.findTopList();
		ActionContext.getContext().put("authorityTop", authorities);
		return "setUI";
	}
	public String set() {
		Role role = roleService.getById(model.getId());
		List<Authority> authorities = authorityService.getByIds(authorityIds);
		role.setAuthorities(new HashSet<Authority>(authorities));
		roleService.update(role);
		CacheUtil.cacheRemoveObj("RoleService:findAll", CacheUtil.LEVEL02);
		UserVO user = getCurrentUser();
		List<RoleVO> list = new ArrayList<RoleVO>();
		for (RoleVO r: user.getRolesVO() ) {
			if (r.getId() == model.getId()) {
				RoleVO rv = new RoleVO();
				MyBeanUtils.copy(rv, role, 1);
				list.add(rv);
			}else list.add(r);
		}
		user.setRolesVO(list);
		return "toList";
	}
	
	public Long[] getAuthorityIds() {
		return authorityIds;
	}
	public void setAuthorityIds(Long[] authorityIds) {
		this.authorityIds = authorityIds;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
}
