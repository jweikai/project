package com.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.annotation.Mapping;
import com.annotation.PO2VO;
@PO2VO({"authorities"})
public class RoleVO {
	private Long id;
	private String name;
	private String content;
	@Mapping(AuthorityVO.class)
	private List<AuthorityVO> authoritiesVO = new ArrayList<AuthorityVO>(0);
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<AuthorityVO> getAuthoritiesVO() {
		return authoritiesVO;
	}
	public void setAuthoritiesVO(List<AuthorityVO> authoritiesVO) {
		this.authoritiesVO = authoritiesVO;
	}
}
