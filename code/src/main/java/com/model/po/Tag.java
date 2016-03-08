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
 * Tag entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tag", catalog = "code")
public class Tag implements java.io.Serializable {

	// Fields

	private Long id;
	private Problem problem;
	private String name;

	// Constructors

	/** default constructor */
	public Tag() {
	}

	/** full constructor */
	public Tag(Problem problem, String name) {
		this.problem = problem;
		this.name = name;
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

	@Column(name = "name", length = 25)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}