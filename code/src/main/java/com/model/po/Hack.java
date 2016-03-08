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
 * Hack entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "hack", catalog = "code")
public class Hack implements java.io.Serializable {

	// Fields

	private Long id;
	private Respond respond;
	private User user;
	private Integer type;

	// Constructors

	/** default constructor */
	public Hack() {
	}

	/** full constructor */
	public Hack(Respond respond, User user, Integer type) {
		this.respond = respond;
		this.user = user;
		this.type = type;
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
	@JoinColumn(name = "respondId")
	public Respond getRespond() {
		return this.respond;
	}

	public void setRespond(Respond respond) {
		this.respond = respond;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
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

}