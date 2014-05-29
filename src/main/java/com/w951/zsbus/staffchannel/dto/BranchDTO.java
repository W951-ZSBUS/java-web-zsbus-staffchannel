package com.w951.zsbus.staffchannel.dto;

import java.io.Serializable;
import java.util.List;


/**
 * 
 * 系统版本：v1.0<br>
 * 开发人员：Ccz<br>
 * 日期：2014-05-27<br>
 * 时间：14:41:30<br>
 * 功能描述：写明作用，调用方式，使用场景，以及特殊情况<br>
 *
 */
public class BranchDTO implements Serializable {
	private static final long serialVersionUID = -1L;

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
    private List<BranchDTO> children;

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }
     
    public String getBranchPid() {
		return branchPid;
	}

	public void setBranchPid(String branchPid) {
		this.branchPid = branchPid;
	}

	public String getBranchNo() {
        return branchNo;
    }

    public void setBranchNo(String branchNo) {
        this.branchNo = branchNo;
    }
    
    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }
    
    public String getBranchManager() {
        return branchManager;
    }

    public void setBranchManager(String branchManager) {
        this.branchManager = branchManager;
    }
    
    public String getBranchSummary() {
        return branchSummary;
    }

    public void setBranchSummary(String branchSummary) {
        this.branchSummary = branchSummary;
    }
    
    public String getBranchPhone() {
        return branchPhone;
    }

    public void setBranchPhone(String branchPhone) {
        this.branchPhone = branchPhone;
    }
    
    public String getBranchEmail() {
        return branchEmail;
    }

    public void setBranchEmail(String branchEmail) {
        this.branchEmail = branchEmail;
    }
    
    public String getBranchRemark() {
        return branchRemark;
    }

    public void setBranchRemark(String branchRemark) {
        this.branchRemark = branchRemark;
    }
    
    public String getBranchCreatename() {
        return branchCreatename;
    }

    public void setBranchCreatename(String branchCreatename) {
        this.branchCreatename = branchCreatename;
    }
    
    public String getBranchCreatedate() {
        return branchCreatedate;
    }

    public void setBranchCreatedate(String branchCreatedate) {
        this.branchCreatedate = branchCreatedate;
    }

	public List<BranchDTO> getChildren() {
		return children;
	}

	public void setChildren(List<BranchDTO> children) {
		this.children = children;
	}
    
}