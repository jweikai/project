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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Discuss entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "discuss", catalog = "code")
public class Discuss implements java.io.Serializable {

	// Fields

	private Long id;
	private Problem problem;
	private User user;
	private String description;
	private Timestamp postTime;
	private Set<Reply> replies = new HashSet<Reply>(0);

	// Constructors

	/** default constructor */
	public Discuss() {
	}

	/** minimal constructor */
	public Discuss(Timestamp postTime) {
		this.postTime = postTime;
	}

	/** full constructor */
	public Discuss(Problem problem, User user, String description,
			Timestamp postTime, Set<Reply> replies) {
		this.problem = problem;
		this.user = user;
		this.description = description;
		this.postTime = postTime;
		this.replies = replies;
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
	@JoinColumn(name = "problemId")
	public Problem getProblem() {
		return this.problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "discuss")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

}