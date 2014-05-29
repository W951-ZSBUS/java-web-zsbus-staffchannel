package com.w951.zsbus.staffchannel.entity;
// default package

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 * Branch entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "zsbus_staffchannel_branch")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Branch implements java.io.Serializable {
	private static final long serialVersionUID = -2029479601584404772L;
	private String branchId;
	private String branchPid;
	private String branchNo;
	private String branchName;
	private String branchManager;
	private String branchSummary;
	private String branchPhone;
	private String branchEmail;
	private String branchRemark;
	private String branchCreatename;
	private String branchCreatedate;
	private List<Staff> staffs = new ArrayList<Staff>();

	
	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "branch_id", unique = true, nullable = false, length = 32)
	public String getBranchId() {
		return this.branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	@Column(name = "branch_pid", length = 32)
	public String getBranchPid() {
		return branchPid;
	}

	public void setBranchPid(String branchPid) {
		this.branchPid = branchPid;
	}

	@Column(name = "branch_no", length = 10)
	public String getBranchNo() {
		return this.branchNo;
	}

	public void setBranchNo(String branchNo) {
		this.branchNo = branchNo;
	}

	@Column(name = "branch_name", length = 20)
	public String getBranchName() {
		return this.branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Column(name = "branch_manager", length = 10)
	public String getBranchManager() {
		return this.branchManager;
	}

	public void setBranchManager(String branchManager) {
		this.branchManager = branchManager;
	}

	@Column(name = "branch_summary", length = 100)
	public String getBranchSummary() {
		return this.branchSummary;
	}

	public void setBranchSummary(String branchSummary) {
		this.branchSummary = branchSummary;
	}

	@Column(name = "branch_phone", length = 20)
	public String getBranchPhone() {
		return this.branchPhone;
	}

	public void setBranchPhone(String branchPhone) {
		this.branchPhone = branchPhone;
	}

	@Column(name = "branch_email", length = 20)
	public String getBranchEmail() {
		return this.branchEmail;
	}

	public void setBranchEmail(String branchEmail) {
		this.branchEmail = branchEmail;
	}

	@Column(name = "branch_remark", length = 100)
	public String getBranchRemark() {
		return this.branchRemark;
	}

	public void setBranchRemark(String branchRemark) {
		this.branchRemark = branchRemark;
	}

	@Column(name = "branch_createname", length = 10)
	public String getBranchCreatename() {
		return this.branchCreatename;
	}

	public void setBranchCreatename(String branchCreatename) {
		this.branchCreatename = branchCreatename;
	}

	@Column(name = "branch_createdate", length = 19)
	public String getBranchCreatedate() {
		return this.branchCreatedate;
	}

	public void setBranchCreatedate(String branchCreatedate) {
		this.branchCreatedate = branchCreatedate;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "branch")
	public List<Staff> getStaffs() {
		return this.staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

}