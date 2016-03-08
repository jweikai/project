package com.model.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import com.Const;
import com.annotation.Mapping;
import com.annotation.PO2VO;
import com.opensymphony.xwork2.ActionContext;
import com.service.AuthorityService;
@PO2VO({"roles"})
public class UserVO {
	private Long id;
	private String name;
	private String school;
	private String email;
	private String headImg;
	private Boolean isEmail;
	
	@Mapping(RoleVO.class)
	private List<RoleVO> rolesVO = new ArrayList<RoleVO>(0);
	
	public List<RoleVO> getRolesVO() {
		return rolesVO;
	}
	public void setRolesVO(List<RoleVO> rolesVO) {
		this.rolesVO = rolesVO;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public Boolean getIsEmail() {
		return isEmail;
	}
	public void setIsEmail(Boolean isEmail) {
		this.isEmail = isEmail;
	}
	public boolean hasAuthorityByName(String aName) {
		if ( Const.isAdmin(name) ) {
			return true;
		}
		for (RoleVO r : rolesVO) {			
			for (AuthorityVO a : r.getAuthoritiesVO()) {
				if ( a.getName().equals(aName) ) return true;
			}
		}
		return false;
	}
	
	public boolean hasAuthorityByUrl(String url) {		
		if ( Const.isAdmin(name) ) {
			return true;
		}
		int pos = url.indexOf("?");
		if (pos > -1) {
			url = url.substring(0, pos);
		}
		Collection<String> allAuthorityList = (Collection<String>) ActionContext.getContext().getApplication().get("allAuthorityList");
		if ( !allAuthorityList.contains(url) ) {
			return true;
		}
		for (RoleVO r : rolesVO) {			
			for (AuthorityVO a : r.getAuthoritiesVO()) {
				if ( a.getUrl() == null ) continue;
				if ( url.startsWith(a.getUrl())  ){
					return true;
				}
			}
		}
		return false;
	}
}
