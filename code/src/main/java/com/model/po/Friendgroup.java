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
 * Friendgroup entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "friendgroup", catalog = "code")
public class Friendgroup implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private String groupName;
	private Set<Relation> relations = new HashSet<Relation>(0);

	// Constructors

	/** default constructor */
	public Friendgroup() {
	}

	/** full constructor */
	public Friendgroup(User user, String groupName, Set<Relation> relations) {
		this.user = user;
		this.groupName = groupName;
		this.relations = relations;
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
	@JoinColumn(name = "userId")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "groupName", length = 50)
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "friendgroup")
	public Set<Relation> getRelations() {
		return this.relations;
	}

	public void setRelations(Set<Relation> relations) {
		this.relations = relations;
	}

}