package com.model.po;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Logs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "logs", catalog = "code")
public class Logs implements java.io.Serializable {

	// Fields

	private Long id;
	private String doing;
	private String ip;
	private Boolean isSuccess;
	private String url;
	private Long userId;
	private String userRealName;
	private String msg;
	private String params;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public Logs() {
	}

	/** minimal constructor */
	public Logs(Timestamp time) {
		this.time = time;
	}

	/** full constructor */
	public Logs(String doing, String ip, Boolean isSuccess, String url,
			Long userId, String userRealName, String msg, String params,
			Timestamp time) {
		this.doing = doing;
		this.ip = ip;
		this.isSuccess = isSuccess;
		this.url = url;
		this.userId = userId;
		this.userRealName = userRealName;
		this.msg = msg;
		this.params = params;
		this.time = time;
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

	@Column(name = "doing")
	public String getDoing() {
		return this.doing;
	}

	public void setDoing(String doing) {
		this.doing = doing;
	}

	@Column(name = "ip", length = 64)
	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "isSuccess")
	public Boolean getIsSuccess() {
		return this.isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	@Column(name = "url", length = 125)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "userId")
	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Column(name = "userRealName", length = 50)
	public String getUserRealName() {
		return this.userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	@Column(name = "msg", length = 125)
	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Column(name = "params", length = 65535)
	public String getParams() {
		return this.params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	@Column(name = "time", nullable = false, length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}