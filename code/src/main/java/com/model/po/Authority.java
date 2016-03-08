package com.model.po;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.Const;

/**
 * Authority entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "authority", catalog = "code")
public class Authority implements java.io.Serializable {

	// Fields

	private Long id;
	private Authority authority;
	private String name;
	private String url;
	private String icon;
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Authority> authorities = new HashSet<Authority>(0);

	// Constructors

	/** default constructor */
	public Authority() {
	}

	/** full constructor */
	public Authority(Authority authority, String name, String url, String icon,
			Set<Role> roles, Set<Authority> authorities) {
		this.authority = authority;
		this.name = name;
		this.url = url;
		this.icon = icon;
		this.roles = roles;
		this.authorities = authorities;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentId")
	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url", length = 100)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "icon", length = 100)
	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "authorities")
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "authority")
	@OrderBy("id asc")
	public Set<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	public String colorCls() {
		return Const.randomC(name);
	}
	
	public String changeUrl() {
		String[] sUrl = url.split("_");
		return sUrl[0] + "/" + sUrl[1];
	}	
}