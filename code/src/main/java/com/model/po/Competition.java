package com.model.po;

import java.sql.Timestamp;
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
import javax.persistence.Table;

/**
 * Competition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "competition", catalog = "code")
public class Competition implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private String title;
	private String description;
	private Timestamp startTime;
	private Timestamp endTime;
	private Boolean isPublic;
	private String language;
	private String password;
	private Boolean isLimitUser;
	private Integer type;
	private Set<User> users = new HashSet<User>(0);
	private Set<Top> tops = new HashSet<Top>(0);
	private Set<Selectproblems> selectproblemses = new HashSet<Selectproblems>(
			0);

	// Constructors

	/** default constructor */
	public Competition() {
	}

	/** minimal constructor */
	public Competition(Timestamp startTime, Timestamp endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	/** full constructor */
	public Competition(User user, String title, String description,
			Timestamp startTime, Timestamp endTime, Boolean isPublic,
			String language, String password, Boolean isLimitUser,
			Integer type, Set<User> users, Set<Top> tops,
			Set<Selectproblems> selectproblemses) {
		this.user = user;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isPublic = isPublic;
		this.language = language;
		this.password = password;
		this.isLimitUser = isLimitUser;
		this.type = type;
		this.users = users;
		this.tops = tops;
		this.selectproblemses = selectproblemses;
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
	@JoinColumn(name = "createUserId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "startTime", nullable = false, length = 19)
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Column(name = "endTime", nullable = false, length = 19)
	public Timestamp getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Column(name = "isPublic")
	public Boolean getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	@Column(name = "language", length = 100)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "password", length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "isLimitUser")
	public Boolean getIsLimitUser() {
		return this.isLimitUser;
	}

	public void setIsLimitUser(Boolean isLimitUser) {
		this.isLimitUser = isLimitUser;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "competitions")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "competition")
	public Set<Top> getTops() {
		return this.tops;
	}

	public void setTops(Set<Top> tops) {
		this.tops = tops;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "competition")
	public Set<Selectproblems> getSelectproblemses() {
		return this.selectproblemses;
	}

	public void setSelectproblemses(Set<Selectproblems> selectproblemses) {
		this.selectproblemses = selectproblemses;
	}

}