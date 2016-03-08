package com.action.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.Const;
import com.action.base.BaseAction;
import com.annotation.Admin;
import com.commons.MyBeanUtils;
import com.commons.QueryHelper;
import com.model.po.User;
import com.model.vo.Json;
import com.model.vo.PageBean;
import com.model.vo.UserVO;
import com.opensymphony.xwork2.ActionContext;
import com.service.UserService;

@Admin
@Controller
@Scope("prototype")
public class AdminUserAction extends BaseAction<User>{
	@Resource
	private UserService userService;
	
	public String list() {
		boolean isKey = true;
		if ( key == null || "".equals(key.trim()) ) isKey = false; 
		QueryHelper queryHelper = new QueryHelper(User.class, "u")
			.addCondition("u.id != ?", Const.SUPER_USER_ID)
			.addCondition(isKey, "name like ?", "%"+key+"%");
		PageBean pageBean = userService.getPageBean(pageNum, pageSize, queryHelper);
		ActionContext.getContext().getValueStack().push(pageBean); 
		return "list";
	}
	private Long[] ids;
	public void delete() {
		Json json = new Json();		
		try {
			userService.delete(ids);
		}catch ( Exception e ) {
			json.setMsg(e.getMessage());
			writeJson(json);
			return ;
		}
		json.setMsg("删除成功");
		json.setSuccess(true);
		writeJson(json);
	}
	
	public String lockUI() {		
		ServletActionContext.getContext().getValueStack().push(userService.getById(model.getId()));		
		return "lockUI";
	}
	public String lock() {
		User user = userService.getById(model.getId());
		user.setIsLock(model.getIsLock());
		user.setLockReason(model.getLockReason());
		userService.update(user);
		return "lock";
	}
		
	private String key;
	public void search() {
		Json json = new Json();		
		if ( key == null && key.trim().equals("") ) {
			json.setSuccess(false);
			json.setMsg("请输入用户名");
		}else {
			json.setSuccess(true);
			List<User> list = userService.search(key);
			if ( list.size() == 0 ) {
				json.setSuccess(true);
				json.setMsg("用户不存在");
				json.setObj(Collections.EMPTY_LIST);
				writeJson(json);
				return ;
			}
			List<UserVO> usersVO = new ArrayList<UserVO>();			
			MyBeanUtils.copyList(usersVO, list, UserVO.class, 1);			
			json.setObj(usersVO);
		}
		writeJson(json);
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
}
