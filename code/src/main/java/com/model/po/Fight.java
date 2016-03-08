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
 * Fight entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "fight", catalog = "code")
public class Fight implements java.io.Serializable {

	// Fields

	private Long id;
	private Team team;
	private Battle battle;
	private Integer status;
	private Integer battleTeam;
	private Integer battleResult;

	// Constructors

	/** default constructor */
	public Fight() {
	}

	/** minimal constructor */
	public Fight(Team team, Battle battle) {
		this.team = team;
		this.battle = battle;
	}

	/** full constructor */
	public Fight(Team team, Battle battle, Integer status, Integer battleTeam,
			Integer battleResult) {
		this.team = team;
		this.battle = battle;
		this.status = status;
		this.battleTeam = battleTeam;
		this.battleResult = battleResult;
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
	@JoinColumn(name = "teamId", nullable = false)
	public Team getTeam() {
		return this.team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "battleId", nullable = false)
	public Battle getBattle() {
		return this.battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "battleTeam")
	public Integer getBattleTeam() {
		return this.battleTeam;
	}

	public void setBattleTeam(Integer battleTeam) {
		this.battleTeam = battleTeam;
	}

	@Column(name = "battleResult")
	public Integer getBattleResult() {
		return this.battleResult;
	}

	public void setBattleResult(Integer battleResult) {
		this.battleResult = battleResult;
	}

}