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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Selectproblems entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "selectproblems", catalog = "code")
public class Selectproblems implements java.io.Serializable {

	// Fields

	private Long id;
	private Battle battle;
	private Competition competition;
	private Integer cproblemId;
	private Long realProblemId;
	private Integer score;
	private Set<Solvedproblem> solvedproblems = new HashSet<Solvedproblem>(0);
	private Set<Respond> responds = new HashSet<Respond>(0);

	// Constructors

	/** default constructor */
	public Selectproblems() {
	}

	/** full constructor */
	public Selectproblems(Battle battle, Competition competition,
			Integer cproblemId, Long realProblemId, Integer score,
			Set<Solvedproblem> solvedproblems, Set<Respond> responds) {
		this.battle = battle;
		this.competition = competition;
		this.cproblemId = cproblemId;
		this.realProblemId = realProblemId;
		this.score = score;
		this.solvedproblems = solvedproblems;
		this.responds = responds;
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
	@JoinColumn(name = "battleId")
	public Battle getBattle() {
		return this.battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "competitionId")
	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	@Column(name = "cProblemId")
	public Integer getCproblemId() {
		return this.cproblemId;
	}

	public void setCproblemId(Integer cproblemId) {
		this.cproblemId = cproblemId;
	}

	@Column(name = "realProblemId")
	public Long getRealProblemId() {
		return this.realProblemId;
	}

	public void setRealProblemId(Long realProblemId) {
		this.realProblemId = realProblemId;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "selectproblems")
	public Set<Solvedproblem> getSolvedproblems() {
		return this.solvedproblems;
	}

	public void setSolvedproblems(Set<Solvedproblem> solvedproblems) {
		this.solvedproblems = solvedproblems;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "selectproblems")
	public Set<Respond> getResponds() {
		return this.responds;
	}

	public void setResponds(Set<Respond> responds) {
		this.responds = responds;
	}

}