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
 * Solvedproblem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "solvedproblem", catalog = "code")
public class Solvedproblem implements java.io.Serializable {

	// Fields

	private Long id;
	private Selectproblems selectproblems;
	private Problem problem;
	private User user;
	private Boolean isSolve;
	private Timestamp solveTime;
	private Integer score;
	private Timestamp punishTime;
	private Integer submitCount;
	private Integer errorCount;

	// Constructors

	/** default constructor */
	public Solvedproblem() {
	}

	/** full constructor */
	public Solvedproblem(Selectproblems selectproblems, Problem problem,
			User user, Boolean isSolve, Timestamp solveTime, Integer score,
			Timestamp punishTime, Integer submitCount, Integer errorCount) {
		this.selectproblems = selectproblems;
		this.problem = problem;
		this.user = user;
		this.isSolve = isSolve;
		this.solveTime = solveTime;
		this.score = score;
		this.punishTime = punishTime;
		this.submitCount = submitCount;
		this.errorCount = errorCount;
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
	@JoinColumn(name = "selectProblemId")
	public Selectproblems getSelectproblems() {
		return this.selectproblems;
	}

	public void setSelectproblems(Selectproblems selectproblems) {
		this.selectproblems = selectproblems;
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

	@Column(name = "isSolve")
	public Boolean getIsSolve() {
		return this.isSolve;
	}

	public void setIsSolve(Boolean isSolve) {
		this.isSolve = isSolve;
	}

	@Column(name = "solveTime", length = 19)
	public Timestamp getSolveTime() {
		return this.solveTime;
	}

	public void setSolveTime(Timestamp solveTime) {
		this.solveTime = solveTime;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "punishTime", length = 19)
	public Timestamp getPunishTime() {
		return this.punishTime;
	}

	public void setPunishTime(Timestamp punishTime) {
		this.punishTime = punishTime;
	}

	@Column(name = "submitCount")
	public Integer getSubmitCount() {
		return this.submitCount;
	}

	public void setSubmitCount(Integer submitCount) {
		this.submitCount = submitCount;
	}

	@Column(name = "errorCount")
	public Integer getErrorCount() {
		return this.errorCount;
	}

	public void setErrorCount(Integer errorCount) {
		this.errorCount = errorCount;
	}

}