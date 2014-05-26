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
 * System entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "zsbus_staffchannel_system")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class System implements java.io.Serializable {

	// Fields

	private String systemId;
	private String systemTitle;
	private String systemContent;
	private String systemCreatedate;
	private String systemCreatename;

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "system_id", unique = true, nullable = false, length = 32)
	public String getSystemId() {
		return this.systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	@Column(name = "system_title", length = 50)
	public String getSystemTitle() {
		return this.systemTitle;
	}

	public void setSystemTitle(String systemTitle) {
		this.systemTitle = systemTitle;
	}

	@Column(name = "system_content", length = 65535)
	public String getSystemContent() {
		return this.systemContent;
	}

	public void setSystemContent(String systemContent) {
		this.systemContent = systemContent;
	}

	@Column(name = "system_createdate", length = 19)
	public String getSystemCreatedate() {
		return this.systemCreatedate;
	}

	public void setSystemCreatedate(String systemCreatedate) {
		this.systemCreatedate = systemCreatedate;
	}

	@Column(name = "system_createname", length = 20)
	public String getSystemCreatename() {
		return this.systemCreatename;
	}

	public void setSystemCreatename(String systemCreatename) {
		this.systemCreatename = systemCreatename;
	}

}