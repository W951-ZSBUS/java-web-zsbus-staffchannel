package com.w951.zsbus.staffchannel.dto;

import java.io.Serializable;

/**
 * 
 * 系统版本：v1.0<br>
 * 开发人员：Ccz<br>
 * 日期：2014-05-27<br>
 * 时间：14:41:30<br>
 * 功能描述：写明作用，调用方式，使用场景，以及特殊情况<br>
 *
 */
public class StaffDTO implements Serializable {
	private static final long serialVersionUID = -1L;

    private String staffId;
    private String staffNo;
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
    private String branchId;
	private String branchName;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    
    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }
    
    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    
    public Integer getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(Integer staffSex) {
        this.staffSex = staffSex;
    }
    
    public String getStaffBirthdate() {
        return staffBirthdate;
    }

    public void setStaffBirthdate(String staffBirthdate) {
        this.staffBirthdate = staffBirthdate;
    }
    
    public Integer getStaffAge() {
        return staffAge;
    }

    public void setStaffAge(Integer staffAge) {
        this.staffAge = staffAge;
    }
    
    public String getStaffEntrydate() {
        return staffEntrydate;
    }

    public void setStaffEntrydate(String staffEntrydate) {
        this.staffEntrydate = staffEntrydate;
    }
    
    public Integer getStaffPolitical() {
        return staffPolitical;
    }

    public void setStaffPolitical(Integer staffPolitical) {
        this.staffPolitical = staffPolitical;
    }
    
    public Integer getStaffMarriage() {
        return staffMarriage;
    }

    public void setStaffMarriage(Integer staffMarriage) {
        this.staffMarriage = staffMarriage;
    }
    
    public String getStaffDeparture() {
        return staffDeparture;
    }

    public void setStaffDeparture(String staffDeparture) {
        this.staffDeparture = staffDeparture;
    }
    
    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }
    
    public String getStaffRemark() {
        return staffRemark;
    }

    public void setStaffRemark(String staffRemark) {
        this.staffRemark = staffRemark;
    }
    
    public String getStaffCreatename() {
        return staffCreatename;
    }

    public void setStaffCreatename(String staffCreatename) {
        this.staffCreatename = staffCreatename;
    }
    
    public String getStaffCreatedate() {
        return staffCreatedate;
    }

    public void setStaffCreatedate(String staffCreatedate) {
        this.staffCreatedate = staffCreatedate;
    }

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

}