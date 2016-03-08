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
 * Top entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "top", catalog = "code")
public class Top implements java.io.Serializable {

	// Fields

	private Long id;
	private Battle battle;
	private User user;
	private Competition competition;
	private Integer solveCount;
	private Integer positiveHack;
	private Integer negativeHack;
	private Integer score;
	private Timestamp useTime;
	private Integer rank;
	private Integer rating;

	// Constructors

	/** default constructor */
	public Top() {
	}

	/** full constructor */
	public Top(Battle battle, User user, Competition competition,
			Integer solveCount, Integer positiveHack, Integer negativeHack,
			Integer score, Timestamp useTime, Integer rank, Integer rating) {
		this.battle = battle;
		this.user = user;
		this.competition = competition;
		this.solveCount = solveCount;
		this.positiveHack = positiveHack;
		this.negativeHack = negativeHack;
		this.score = score;
		this.useTime = useTime;
		this.rank = rank;
		this.rating = rating;
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
	@JoinColumn(name = "userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "competitionId")
	public Competition getCompetition() {
		return this.competition;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	@Column(name = "solveCount")
	public Integer getSolveCount() {
		return this.solveCount;
	}

	public void setSolveCount(Integer solveCount) {
		this.solveCount = solveCount;
	}

	@Column(name = "positiveHack")
	public Integer getPositiveHack() {
		return this.positiveHack;
	}

	public void setPositiveHack(Integer positiveHack) {
		this.positiveHack = positiveHack;
	}

	@Column(name = "negativeHack")
	public Integer getNegativeHack() {
		return this.negativeHack;
	}

	public void setNegativeHack(Integer negativeHack) {
		this.negativeHack = negativeHack;
	}

	@Column(name = "score")
	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "useTime", length = 19)
	public Timestamp getUseTime() {
		return this.useTime;
	}

	public void setUseTime(Timestamp useTime) {
		this.useTime = useTime;
	}

	@Column(name = "rank")
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Column(name = "rating")
	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}