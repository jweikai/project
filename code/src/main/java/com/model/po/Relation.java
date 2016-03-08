package com.model.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Relation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "relation", catalog = "code")
public class Relation implements java.io.Serializable {

	// Fields

	private Long id;
	private Friendgroup friendgroup;
	private User user;

	// Constructors

	/** default constructor */
	public Relation() {
	}

	/** full constructor */
	public Relation(Friendgroup friendgroup, User user) {
		this.friendgroup = friendgroup;
		this.user = user;
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
	@JoinColumn(name = "groupId")
	public Friendgroup getFriendgroup() {
		return this.friendgroup;
	}

	public void setFriendgroup(Friendgroup friendgroup) {
		this.friendgroup = friendgroup;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}