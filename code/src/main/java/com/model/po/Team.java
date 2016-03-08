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
import javax.persistence.Table;

/**
 * Team entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "team", catalog = "code")
public class Team implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private String name;
	private Integer peopleLimit;
	private Set<User> users = new HashSet<User>(0);
	private Set<Fight> fights = new HashSet<Fight>(0);

	// Constructors

	/** default constructor */
	public Team() {
	}

	/** full constructor */
	public Team(User user, String name, Integer peopleLimit, Set<User> users,
			Set<Fight> fights) {
		this.user = user;
		this.name = name;
		this.peopleLimit = peopleLimit;
		this.users = users;
		this.fights = fights;
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
	@JoinColumn(name = "userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "peopleLimit")
	public Integer getPeopleLimit() {
		return this.peopleLimit;
	}

	public void setPeopleLimit(Integer peopleLimit) {
		this.peopleLimit = peopleLimit;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teams")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "team")
	public Set<Fight> getFights() {
		return this.fights;
	}

	public void setFights(Set<Fight> fights) {
		this.fights = fights;
	}

}