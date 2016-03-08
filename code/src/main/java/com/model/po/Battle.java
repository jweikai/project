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
 * Battle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "battle", catalog = "code")
public class Battle implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private Integer type;
	private Timestamp limitTime;
	private Timestamp startTime;
	private Timestamp createTime;
	private Set<Top> tops = new HashSet<Top>(0);
	private Set<Selectproblems> selectproblemses = new HashSet<Selectproblems>(
			0);
	private Set<Fight> fights = new HashSet<Fight>(0);

	// Constructors

	/** default constructor */
	public Battle() {
	}

	/** full constructor */
	public Battle(User user, Integer type, Timestamp limitTime,
			Timestamp startTime, Timestamp createTime, Set<Top> tops,
			Set<Selectproblems> selectproblemses, Set<Fight> fights) {
		this.user = user;
		this.type = type;
		this.limitTime = limitTime;
		this.startTime = startTime;
		this.createTime = createTime;
		this.tops = tops;
		this.selectproblemses = selectproblemses;
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
	@JoinColumn(name = "createUserId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "limitTime", length = 19)
	public Timestamp getLimitTime() {
		return this.limitTime;
	}

	public void setLimitTime(Timestamp limitTime) {
		this.limitTime = limitTime;
	}

	@Column(name = "startTime", length = 19)
	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	@Column(name = "createTime", length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "battle")
	public Set<Top> getTops() {
		return this.tops;
	}

	public void setTops(Set<Top> tops) {
		this.tops = tops;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "battle")
	public Set<Selectproblems> getSelectproblemses() {
		return this.selectproblemses;
	}

	public void setSelectproblemses(Set<Selectproblems> selectproblemses) {
		this.selectproblemses = selectproblemses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "battle")
	public Set<Fight> getFights() {
		return this.fights;
	}

	public void setFights(Set<Fight> fights) {
		this.fights = fights;
	}

}