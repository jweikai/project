package com.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.annotation.Mapping;
import com.annotation.PO2VO;

@PO2VO({"authorities"})
public class AuthorityVO {
	private Long id;
	@Mapping(AuthorityVO.class)
	private List<AuthorityVO> authoritiesVO = new ArrayList<AuthorityVO>(0);
	private String name;
	private String url;
	private String icon;
	private AuthorityVO parent;
	
	public AuthorityVO getParent() {
		return parent;
	}
	public void setParent(AuthorityVO parent) {
		this.parent = parent;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<AuthorityVO> getAuthoritiesVO() {
		return authoritiesVO;
	}
	public void setAuthoritiesVO(List<AuthorityVO> authoritiesVO) {
		this.authoritiesVO = authoritiesVO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}	
	public String changeUrl() {
		return url.split("_")[1];
	}
}
