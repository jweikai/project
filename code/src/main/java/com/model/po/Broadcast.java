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
 * Broadcast entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "broadcast", catalog = "code")
public class Broadcast implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private String title;
	private String descript;
	private Timestamp initTime;

	// Constructors

	/** default constructor */
	public Broadcast() {
	}

	/** minimal constructor */
	public Broadcast(Timestamp initTime) {
		this.initTime = initTime;
	}

	/** full constructor */
	public Broadcast(User user, String title, String descript,
			Timestamp initTime) {
		this.user = user;
		this.title = title;
		this.descript = descript;
		this.initTime = initTime;
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

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "descript", length = 65535)
	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	@Column(name = "initTime", nullable = false, length = 19)
	public Timestamp getInitTime() {
		return this.initTime;
	}

	public void setInitTime(Timestamp initTime) {
		this.initTime = initTime;
	}

}