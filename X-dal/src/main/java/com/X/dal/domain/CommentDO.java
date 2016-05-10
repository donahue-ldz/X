package com.X.dal.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Comment对象
 */
public class CommentDO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 帖子ID
	 */
	private Long topicID;
	/**
	 * 评论人ID
	 */
	private Long userID;
	/**
	 * 评论人角色 学生  教师 管理员
	 */
	private String userRole;

	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 状态
	 */
	private String status;

	private Date gmtCreate;
	private Date gmtModified;

	public Long getId() {
		return id;
	}

	public CommentDO setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getTopicID() {
		return topicID;
	}

	public CommentDO setTopicID(Long topicID) {
		this.topicID = topicID;
		return this;
	}

	public Long getUserID() {
		return userID;
	}

	public CommentDO setUserID(Long userID) {
		this.userID = userID;
		return this;
	}

	public String getUserRole() {
		return userRole;
	}

	public CommentDO setUserRole(String userRole) {
		this.userRole = userRole;
		return this;
	}

	public String getContent() {
		return content;
	}

	public CommentDO setContent(String content) {
		this.content = content;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public CommentDO setStatus(String status) {
		this.status = status;
		return this;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public CommentDO setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
		return this;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public CommentDO setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
		return this;
	}
}