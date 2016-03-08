package com.action.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.Const;
import com.action.base.BaseAction;
import com.annotation.Admin;
import com.commons.CMDUtils;
import com.commons.ConfigUtil;
import com.model.po.Role;
import com.model.po.User;
import com.model.vo.CMDResult;
import com.model.vo.Json;
import com.opensymphony.xwork2.ActionContext;
import com.service.RoleService;
import com.service.UserService;

@Admin
@Controller
@Scope("prototype")
public class AdminAuthorityAction extends BaseAction<Role>{
	@Resource
	private RoleService roleService;
	@Resource
	private UserService userService;
	public String list() {
		List<User> users = userService.hasRoleUser();
		ActionContext.getContext().put("users", users);
		return "list";
	}
	private Long userId;
	public void delete() {
		Json json = new Json();
		try {
			Role role = roleService.getById(model.getId());
			User user = userService.getById(userId);
			user.getRoles().remove(role);		
			userService.update(user);			
		}catch ( Exception e ) {
			json.setMsg(e.getMessage());
			writeJson(json);
			return ;
		}
		json.setMsg("删除成功");
		json.setSuccess(true);
		writeJson(json);
	}
	private Long[] userIds;
	public String deleteAll() {
		List<User> users = userService.getByIds(userIds);
		for (User u : users) {
			u.setRoles(null);
			userService.update(u);
		}
		return "toList";
	}
	
	private Long[] roleIds;
	public String addUI() {
		ActionContext.getContext().put("roles", roleService.findAll());
		if ( userId != null ) {
			User user = userService.getById(userId);
			int index = 0;
			roleIds = new Long[user.getRoles().size()];
			for (Role role : user.getRoles()) {
				roleIds[index ++] = role.getId();
			}
			ActionContext.getContext().put("user", user);
		}
		return "addUI";
	}
	private String userName;
	
	public String add() {
		List<Role> roles = roleService.getByIds(roleIds);
		User user = null;
		if ( userId != null ) {
			user = userService.getById(userId);
		}else {
			user = userService.getByName(userName);
		}
		user.setRoles(new HashSet<Role>(roles));
		userService.update(user);
		return "toList";
	}
	public void back() {
		deleteManyFile(realpath, Const.LIMIT_DATA_BACK_LENGTH);
		String filename = "data-" + Const.getCurrentLocalData() + ".sql";	
		String cmd = String.format(ConfigUtil.get("back"), "user_role role_authority", "\"" + realpath + File.separator +filename + "\"");
		CMDResult r = CMDUtils.singleCMD(cmd);
		Json json = new Json();
		json.setSuccess(r.isSuccess());
		writeJson(json);
	}
	private void deleteManyFile(String filepath, int limitLen) {
		File[] fileList = new File(filepath).listFiles();
		if ( fileList.length < limitLen ) return;
		int limit = fileList.length - limitLen + 1;		
		for (int i = 0; i < limit; i ++) {
			fileList[i].delete();
		}
	}
	
	private String realpath = ServletActionContext.getServletContext().getRealPath(ConfigUtil.get("datapath"));
	public void recoverUI() {
		File[] list = new File(realpath).listFiles();
		List<String> filePaths = new ArrayList<String>();
		for (File f : list) {
			filePaths.add(f.getName());
		}
		Json json = new Json();
		json.setObj(filePaths);
		json.setSuccess(true);
		writeJson(json);
	}
	private String sqlName;
	public void recover() {
		File file = new File(realpath, sqlName);
		Json json = new Json();
		if ( !file.exists() ) {
			json.setSuccess(false);
			json.setMsg("文件不存在");
		}else {
			CMDResult r = CMDUtils.singleCMD(String.format(ConfigUtil.get("recover"), "\"" + file.getPath() + "\""));			
			json.setSuccess(r.isSuccess());
		}
		writeJson(json);
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Long[] roleIds) {
		this.roleIds = roleIds;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSqlName() {
		return sqlName;
	}
	public void setSqlName(String sqlName) {
		this.sqlName = sqlName;
	}
	public Long[] getUserIds() {
		return userIds;
	}
	public void setUserIds(Long[] userIds) {
		this.userIds = userIds;
	}
}
