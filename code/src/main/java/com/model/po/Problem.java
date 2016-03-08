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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Problem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "problem", catalog = "code")
public class Problem implements java.io.Serializable {

	// Fields

	private Long id;
	private String title;
	private Integer type;
	private String description;
	private String inputDesc;
	private String outputDesc;
	private Integer timeLimit;
	private Integer memoryLimit;
	private String testInput;
	private String testOutput;
	private String hint;
	private String source;
	private Timestamp createTime;
	private Boolean isLock;
	private Integer difficulty;
	private Set<Tag> tags = new HashSet<Tag>(0);
	private Set<Solvedproblem> solvedproblems = new HashSet<Solvedproblem>(0);
	private Set<Discuss> discusses = new HashSet<Discuss>(0);
	private Set<Respond> responds = new HashSet<Respond>(0);

	// Constructors

	/** default constructor */
	public Problem() {
	}

	/** minimal constructor */
	public Problem(Timestamp createTime) {
		this.createTime = createTime;
	}

	/** full constructor */
	public Problem(String title, Integer type, String description,
			String inputDesc, String outputDesc,
			Integer timeLimit, Integer memoryLimit, String testInput,
			String testOutput, String hint, String source,
			Timestamp createTime, Boolean isLock, Integer difficulty,
			Set<Tag> tags, Set<Solvedproblem> solvedproblems,
			Set<Discuss> discusses, Set<Respond> responds) {
		this.title = title;
		this.type = type;
		this.description = description;
		this.inputDesc = inputDesc;
		this.outputDesc = outputDesc;
		this.timeLimit = timeLimit;
		this.memoryLimit = memoryLimit;
		this.testInput = testInput;
		this.testOutput = testOutput;
		this.hint = hint;
		this.source = source;
		this.createTime = createTime;
		this.isLock = isLock;
		this.difficulty = difficulty;
		this.tags = tags;
		this.solvedproblems = solvedproblems;
		this.discusses = discusses;
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

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	@Column(name = "description", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "inputDesc", length = 65535)
	public String getInputDesc() {
		return inputDesc;
	}
	public void setInputDesc(String inputDesc) {
		this.inputDesc = inputDesc;
	}
	
	@Column(name = "outputDesc", length = 65535)
	public String getOutputDesc() {
		return outputDesc;
	}
	public void setOutputDesc(String outputDesc) {
		this.outputDesc = outputDesc;
	}

	@Column(name = "timeLimit")
	public Integer getTimeLimit() {
		return this.timeLimit;
	}

	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}

	@Column(name = "memoryLimit")
	public Integer getMemoryLimit() {
		return this.memoryLimit;
	}

	public void setMemoryLimit(Integer memoryLimit) {
		this.memoryLimit = memoryLimit;
	}

	@Column(name = "testInput", length = 500)
	public String getTestInput() {
		return this.testInput;
	}

	public void setTestInput(String testInput) {
		this.testInput = testInput;
	}

	@Column(name = "testOutput", length = 500)
	public String getTestOutput() {
		return this.testOutput;
	}

	public void setTestOutput(String testOutput) {
		this.testOutput = testOutput;
	}

	@Column(name = "hint", length = 65535)
	public String getHint() {
		return this.hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	@Column(name = "source", length = 100)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "createTime", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Column(name = "isLock")
	public Boolean getIsLock() {
		return this.isLock;
	}

	public void setIsLock(Boolean isLock) {
		this.isLock = isLock;
	}

	@Column(name = "difficulty")
	public Integer getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problem")
	public Set<Tag> getTags() {
		return this.tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problem")
	public Set<Solvedproblem> getSolvedproblems() {
		return this.solvedproblems;
	}

	public void setSolvedproblems(Set<Solvedproblem> solvedproblems) {
		this.solvedproblems = solvedproblems;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problem")
	public Set<Discuss> getDiscusses() {
		return this.discusses;
	}

	public void setDiscusses(Set<Discuss> discusses) {
		this.discusses = discusses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "problem")
	public Set<Respond> getResponds() {
		return this.responds;
	}

	public void setResponds(Set<Respond> responds) {
		this.responds = responds;
	}

}