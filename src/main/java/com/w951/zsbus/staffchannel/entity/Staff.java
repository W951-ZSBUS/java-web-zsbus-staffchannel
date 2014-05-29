package com.w951.zsbus.staffchannel.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "zsbus_staffchannel_staff")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Staff implements java.io.Serializable {
	private static final long serialVersionUID = -6647745916041769350L;
	private String staffId;
	private Branch branch;
	private String staffNo;
	private String staffPassword;
	private String staffName;
	private Integer staffSex;
	private String staffBirthdate;
	private Integer staffAge;
	private String staffEntrydate;
	private Integer staffPolitical;
	private Integer staffMarriage;
	private String staffDeparture;
	private String staffAddress;
	private String staffRemark;
	private String staffCreatename;
	private String staffCreatedate;
	
	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "staff_id", unique = true, nullable = false, length = 32)
	public String getStaffId() {
		return this.staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_branch_id")
	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Column(name = "staff_no", length = 20)
	public String getStaffNo() {
		return this.staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}
	
	@Column(name = "staff_password", length = 20)
	public String getStaffPassword() {
		return this.staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	@Column(name = "staff_name", length = 20)
	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Column(name = "staff_sex")
	public Integer getStaffSex() {
		return this.staffSex;
	}

	public void setStaffSex(Integer staffSex) {
		this.staffSex = staffSex;
	}

	@Column(name = "staff_birthdate", length = 10)
	public String getStaffBirthdate() {
		return this.staffBirthdate;
	}

	public void setStaffBirthdate(String staffBirthdate) {
		this.staffBirthdate = staffBirthdate;
	}

	@Column(name = "staff_age")
	public Integer getStaffAge() {
		return this.staffAge;
	}

	public void setStaffAge(Integer staffAge) {
		this.staffAge = staffAge;
	}

	@Column(name = "staff_entrydate", length = 10)
	public String getStaffEntrydate() {
		return this.staffEntrydate;
	}

	public void setStaffEntrydate(String staffEntrydate) {
		this.staffEntrydate = staffEntrydate;
	}

	@Column(name = "staff_political")
	public Integer getStaffPolitical() {
		return this.staffPolitical;
	}

	public void setStaffPolitical(Integer staffPolitical) {
		this.staffPolitical = staffPolitical;
	}

	@Column(name = "staff_marriage")
	public Integer getStaffMarriage() {
		return this.staffMarriage;
	}

	public void setStaffMarriage(Integer staffMarriage) {
		this.staffMarriage = staffMarriage;
	}

	@Column(name = "staff_departure", length = 20)
	public String getStaffDeparture() {
		return this.staffDeparture;
	}

	public void setStaffDeparture(String staffDeparture) {
		this.staffDeparture = staffDeparture;
	}

	@Column(name = "staff_address", length = 50)
	public String getStaffAddress() {
		return this.staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	@Column(name = "staff_remark", length = 100)
	public String getStaffRemark() {
		return this.staffRemark;
	}

	public void setStaffRemark(String staffRemark) {
		this.staffRemark = staffRemark;
	}

	@Column(name = "staff_createname", length = 10)
	public String getStaffCreatename() {
		return this.staffCreatename;
	}

	public void setStaffCreatename(String staffCreatename) {
		this.staffCreatename = staffCreatename;
	}

	@Column(name = "staff_createdate", length = 19)
	public String getStaffCreatedate() {
		return this.staffCreatedate;
	}

	public void setStaffCreatedate(String staffCreatedate) {
		this.staffCreatedate = staffCreatedate;
	}

}