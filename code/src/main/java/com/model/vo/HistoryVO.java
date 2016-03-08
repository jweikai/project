package com.model.vo;

import java.sql.Timestamp;

import com.annotation.PO2VO;
import com.model.po.User;

@PO2VO({"user"})
public class HistoryVO {
	private Long id;	
	private String ip;
	private Timestamp loginTime;
	private String loginArea;
	
	private UserVO userVO;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getLoginArea() {
		return loginArea;
	}

	public void setLoginArea(String loginArea) {
		this.loginArea = loginArea;
	}

	public UserVO getUserVO() {
		return userVO;
	}

	public void setUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
}
