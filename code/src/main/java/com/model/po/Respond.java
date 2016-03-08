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
 * Respond entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "respond", catalog = "code")
public class Respond implements java.io.Serializable {

	// Fields

	private Long id;
	private Selectproblems selectproblems;
	private Problem problem;
	private User user;
	private String code;
	private Integer costTime;
	private Integer costMemory;
	private Integer status;
	private Timestamp respondTime;
	private String language;
	private Integer codeLength;
	private Set<Hack> hacks = new HashSet<Hack>(0);

	// Constructors

	/** default constructor */
	public Respond() {
	}

	/** minimal constructor */
	public Respond(Problem problem, User user, Timestamp respondTime) {
		this.problem = problem;
		this.user = user;
		this.respondTime = respondTime;
	}

	/** full constructor */
	public Respond(Selectproblems selectproblems, Problem problem, User user,
			String code, Integer costTime, Integer costMemory, Integer status,
			Timestamp respondTime, String language, Integer codeLength,
			Set<Hack> hacks) {
		this.selectproblems = selectproblems;
		this.problem = problem;
		this.user = user;
		this.code = code;
		this.costTime = costTime;
		this.costMemory = costMemory;
		this.status = status;
		this.respondTime = respondTime;
		this.language = language;
		this.codeLength = codeLength;
		this.hacks = hacks;
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
	@JoinColumn(name = "selectProblemsId")
	public Selectproblems getSelectproblems() {
		return this.selectproblems;
	}

	public void setSelectproblems(Selectproblems selectproblems) {
		this.selectproblems = selectproblems;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "problemId", nullable = false)
	public Problem getProblem() {
		return this.problem;
	}

	public void setProblem(Problem problem) {
		this.problem = problem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "code", length = 65535)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "costTime")
	public Integer getCostTime() {
		return this.costTime;
	}

	public void setCostTime(Integer costTime) {
		this.costTime = costTime;
	}

	@Column(name = "costMemory")
	public Integer getCostMemory() {
		return this.costMemory;
	}

	public void setCostMemory(Integer costMemory) {
		this.costMemory = costMemory;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "respondTime", nullable = false, length = 19)
	public Timestamp getRespondTime() {
		return this.respondTime;
	}

	public void setRespondTime(Timestamp respondTime) {
		this.respondTime = respondTime;
	}

	@Column(name = "language", length = 20)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name = "codeLength")
	public Integer getCodeLength() {
		return this.codeLength;
	}

	public void setCodeLength(Integer codeLength) {
		this.codeLength = codeLength;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "respond")
	public Set<Hack> getHacks() {
		return this.hacks;
	}

	public void setHacks(Set<Hack> hacks) {
		this.hacks = hacks;
	}

}