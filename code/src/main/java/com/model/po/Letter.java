package com.model.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Letter entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "letter", catalog = "code")
public class Letter implements java.io.Serializable {

	// Fields

	private Long id;
	private User userByUserToId;
	private User userByUserFromId;
	private String title;
	private String description;
	private Timestamp postTime;

	// Constructors

	/** default constructor */
	public Letter() {
	}

	/** minimal constructor */
	public Letter(User userByUserToId, User userByUserFromId, Timestamp postTime) {
		this.userByUserToId = userByUserToId;
		this.userByUserFromId = userByUserFromId;
		this.postTime = postTime;
	}

	/** full constructor */
	public Letter(User userByUserToId, User userByUserFromId, String title,
			String description, Timestamp postTime) {
		this.userByUserToId = userByUserToId;
		this.userByUserFromId = userByUserFromId;
		this.title = title;
		this.description = description;
		this.postTime = postTime;
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
	@JoinColumn(name = "userToId", nullable = false)
	public User getUserByUserToId() {
		return this.userByUserToId;
	}

	public void setUserByUserToId(User userByUserToId) {
		this.userByUserToId = userByUserToId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userFromId", nullable = false)
	public User getUserByUserFromId() {
		return this.userByUserFromId;
	}

	public void setUserByUserFromId(User userByUserFromId) {
		this.userByUserFromId = userByUserFromId;
	}

	@Column(name = "title", length = 50)
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

	@Column(name = "postTime", nullable = false, length = 19)
	public Timestamp getPostTime() {
		return this.postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

}