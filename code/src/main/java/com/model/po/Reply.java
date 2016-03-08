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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Reply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "reply", catalog = "code")
public class Reply implements java.io.Serializable {

	// Fields

	private Long id;
	private Reply reply;
	private User user;
	private Discuss discuss;
	private String replyContent;
	private Timestamp replyTime;
	private Set<Reply> replies = new HashSet<Reply>(0);

	// Constructors

	/** default constructor */
	public Reply() {
	}

	/** minimal constructor */
	public Reply(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	/** full constructor */
	public Reply(Reply reply, User user, Discuss discuss, String replyContent,
			Timestamp replyTime, Set<Reply> replies) {
		this.reply = reply;
		this.user = user;
		this.discuss = discuss;
		this.replyContent = replyContent;
		this.replyTime = replyTime;
		this.replies = replies;
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
	@JoinColumn(name = "parentId")
	public Reply getReply() {
		return this.reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
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
	@JoinColumn(name = "discussId")
	public Discuss getDiscuss() {
		return this.discuss;
	}

	public void setDiscuss(Discuss discuss) {
		this.discuss = discuss;
	}

	@Column(name = "replyContent", length = 65535)
	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Column(name = "replyTime", nullable = false, length = 19)
	public Timestamp getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "reply")
	public Set<Reply> getReplies() {
		return this.replies;
	}

	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}

}