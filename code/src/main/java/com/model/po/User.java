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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "code")
public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String password;
	private String school;
	private String email;
	private String headImg;
	private Boolean isEmail;
	private Timestamp createTime;
	private Integer rating;
	private Integer rank;
	private Integer level;
	private Integer vantages;
	private Boolean isLock;
	private String lockReason;
	private Set<Hack> hacks = new HashSet<Hack>(0);
	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Reply> replies = new HashSet<Reply>(0);
	private Set<Respond> responds = new HashSet<Respond>(0);
	private Set<Team> teams = new HashSet<Team>(0);
	private Set<History> histories = new HashSet<History>(0);
	private Set<Discuss> discusses = new HashSet<Discuss>(0);
	private Set<Letter> lettersForUserFromId = new HashSet<Letter>(0);
	private Set<Competition> competitions = new HashSet<Competition>(0);
	private Set<Friendgroup> friendgroups = new HashSet<Friendgroup>(0);
	private Set<Relation> relations = new HashSet<Relation>(0);
	private Set<Solvedproblem> solvedproblems = new HashSet<Solvedproblem>(0);
	private Set<Letter> lettersForUserToId = new HashSet<Letter>(0);
	private Set<Competition> competitions_1 = new HashSet<Competition>(0);
	private Set<Top> tops = new HashSet<Top>(0);
	private Set<Broadcast> broadcasts = new HashSet<Broadcast>(0);
	private Set<Notice> notices = new HashSet<Notice>(0);
	private Set<Battle> battles = new HashSet<Battle>(0);
	private Set<Team> teams_1 = new HashSet<Team>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Timestamp createTime) {
		this.createTime = createTime;
	}

	/** full constructor */
	public User(String name, String password, String school, String email,
			String headImg, Boolean isEmail, Timestamp createTime,
			Integer rating, Integer rank, Integer level, Integer vantages,
			Boolean isLock, String lockReason, Set<Hack> hacks,
			Set<Role> roles, Set<Reply> replies, Set<Respond> responds,
			Set<Team> teams, Set<History> histories, Set<Discuss> discusses,
			Set<Letter> lettersForUserFromId, Set<Competition> competitions,
			Set<Friendgroup> friendgroups, Set<Relation> relations,
			Set<Solvedproblem> solvedproblems, Set<Letter> lettersForUserToId,
			Set<Competition> competitions_1, Set<Top> tops,
			Set<Broadcast> broadcasts, Set<Notice> notices,
			Set<Battle> battles, Set<Team> teams_1) {
		this.name = name;
		this.password = password;
		this.school = school;
		this.email = email;
		this.headImg = headImg;
		this.isEmail = isEmail;
		this.createTime = createTime;
		this.rating = rating;
		this.rank = rank;
		this.level = level;
		this.vantages = vantages;
		this.isLock = isLock;
		this.lockReason = lockReason;
		this.hacks = hacks;
		this.roles = roles;
		this.replies = replies;
		this.responds = responds;
		this.teams = teams;
		this.histories = histories;
		this.discusses = discusses;
		this.lettersForUserFromId = lettersForUserFromId;
		this.competitions = competitions;
		this.friendgroups = friendgroups;
		this.relations = relations;
		this.solvedproblems = solvedproblems;
		this.lettersForUserToId = lettersForUserToId;
		this.competitions_1 = competitions_1;
		this.tops = tops;
		this.broadcasts = broadcasts;
		this.notices = notices;
		this.battles = battles;
		this.teams_1 = teams_1;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "school", length = 50)
	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "headImg", length = 50)
	public String getHeadImg() {
		return this.headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	@Column(name = "isEmail")
	public Boolean getIsEmail() {
		return this.isEmail;
	}

	public void setIsEmail(Boolean isEmail) {
		this.isEmail = isEmail;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "rating")
	public Integer getRating() {
		return this.rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	@Column(name = "rank")
	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "vantages")
	public Integer getVantages() {
		return this.vantages;
	}

	public void setVantages(Integer vantages) {
		this.vantages = vantages;
	}

	@Column(name = "isLock")
	public Boolean getIsLock() {
		return this.isLock;
	}

	public void setIsLock(Boolean isLock) {
		this.isLock = isLock;
	}

	@Column(name = "lockReason", length = 500)
	public String getLockReason() {
		return this.lockReason;
	}

	public void setLockReason(String lockReason) {
		this.lockReason = lockReason;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Hack> getHacks() {
		return this.hacks;
	}

	public void setHacks(Set<Hack> hacks) {
		this.hacks = hacks;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", catalog = "code", joinColumns = { @JoinColumn(name = "userId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "roleId", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Respond> getResponds() {
		return this.responds;
	}

	public void setResponds(Set<Respond> responds) {
		this.responds = responds;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_team", catalog = "code", joinColumns = { @JoinColumn(name = "userId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "teamId", nullable = false, updatable = false) })
	public Set<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<History> getHistories() {
		return this.histories;
	}

	public void setHistories(Set<History> histories) {
		this.histories = histories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Discuss> getDiscusses() {
		return this.discusses;
	}

	public void setDiscusses(Set<Discuss> discusses) {
		this.discusses = discusses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUserFromId")
	public Set<Letter> getLettersForUserFromId() {
		return this.lettersForUserFromId;
	}

	public void setLettersForUserFromId(Set<Letter> lettersForUserFromId) {
		this.lettersForUserFromId = lettersForUserFromId;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_competition", catalog = "code", joinColumns = { @JoinColumn(name = "userId", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "competition", nullable = false, updatable = false) })
	public Set<Competition> getCompetitions() {
		return this.competitions;
	}

	public void setCompetitions(Set<Competition> competitions) {
		this.competitions = competitions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Friendgroup> getFriendgroups() {
		return this.friendgroups;
	}

	public void setFriendgroups(Set<Friendgroup> friendgroups) {
		this.friendgroups = friendgroups;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Relation> getRelations() {
		return this.relations;
	}

	public void setRelations(Set<Relation> relations) {
		this.relations = relations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Solvedproblem> getSolvedproblems() {
		return this.solvedproblems;
	}

	public void setSolvedproblems(Set<Solvedproblem> solvedproblems) {
		this.solvedproblems = solvedproblems;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userByUserToId")
	public Set<Letter> getLettersForUserToId() {
		return this.lettersForUserToId;
	}

	public void setLettersForUserToId(Set<Letter> lettersForUserToId) {
		this.lettersForUserToId = lettersForUserToId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Competition> getCompetitions_1() {
		return this.competitions_1;
	}

	public void setCompetitions_1(Set<Competition> competitions_1) {
		this.competitions_1 = competitions_1;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Top> getTops() {
		return this.tops;
	}

	public void setTops(Set<Top> tops) {
		this.tops = tops;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Broadcast> getBroadcasts() {
		return this.broadcasts;
	}

	public void setBroadcasts(Set<Broadcast> broadcasts) {
		this.broadcasts = broadcasts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Notice> getNotices() {
		return this.notices;
	}

	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Battle> getBattles() {
		return this.battles;
	}

	public void setBattles(Set<Battle> battles) {
		this.battles = battles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Team> getTeams_1() {
		return this.teams_1;
	}

	public void setTeams_1(Set<Team> teams_1) {
		this.teams_1 = teams_1;
	}

}