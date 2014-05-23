package com.w951.zsbus.staffchannel.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "zsbus_staffchannel_notice")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Notice implements java.io.Serializable {
	private static final long serialVersionUID = -1026091917337623191L;
	private String noticeId;
	private String noticeTitle;
	private String noticeContent;
	private String noticeCreatedate;
	private String noticeCreatename;

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "notice_id", unique = true, nullable = false, length = 32)
	public String getNoticeId() {
		return this.noticeId;
	}

	public void setNoticeId(String noticeId) {
		this.noticeId = noticeId;
	}

	@Column(name = "notice_title", length = 50)
	public String getNoticeTitle() {
		return this.noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	@Column(name = "notice_content", length = 65535)
	public String getNoticeContent() {
		return this.noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	@Column(name = "notice_createdate", length = 19)
	public String getNoticeCreatedate() {
		return this.noticeCreatedate;
	}

	public void setNoticeCreatedate(String noticeCreatedate) {
		this.noticeCreatedate = noticeCreatedate;
	}

	@Column(name = "notice_createname", length = 20)
	public String getNoticeCreatename() {
		return this.noticeCreatename;
	}

	public void setNoticeCreatename(String noticeCreatename) {
		this.noticeCreatename = noticeCreatename;
	}

}