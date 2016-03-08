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
 * History entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "history", catalog = "code")
public class History implements java.io.Serializable {

	// Fields

	private Long id;
	private User user;
	private String ip;
	private Timestamp loginTime;
	private String loginArea;

	// Constructors

	/** default constructor */
	public History() {
	}

	/** minimal constructor */
	public History(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	/** full constructor */
	public History(User user, String ip, Timestamp loginTime, String loginArea) {
		this.user = user;
		this.ip = ip;
		this.loginTime = loginTime;
		this.loginArea = loginArea;
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

	@Column(name = "ip", length = 20)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "loginTime", nullable = false, length = 19)
	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	@Column(name = "loginArea", length = 40)
	public String getLoginArea() {
		return this.loginArea;
	}

	public void setLoginArea(String loginArea) {
		this.loginArea = loginArea;
	}

}