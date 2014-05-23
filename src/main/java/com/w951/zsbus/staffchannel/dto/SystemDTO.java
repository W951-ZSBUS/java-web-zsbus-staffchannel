package com.w951.zsbus.staffchannel.dto;

import java.io.Serializable;

/**
 * 
 * 系统版本：v1.0<br>
 * 开发人员：Ccz<br>
 * 日期：2014-05-22<br>
 * 时间：15:16:11<br>
 * 功能描述：写明作用，调用方式，使用场景，以及特殊情况<br>
 *
 */
public class SystemDTO implements Serializable {
	private static final long serialVersionUID = -1L;

    private String systemId;
    private String systemTitle;
    private String systemContent;
    private String systemCreatedate;
    private String systemCreatename;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
    
    public String getSystemTitle() {
        return systemTitle;
    }

    public void setSystemTitle(String systemTitle) {
        this.systemTitle = systemTitle;
    }
    
    public String getSystemContent() {
        return systemContent;
    }

    public void setSystemContent(String systemContent) {
        this.systemContent = systemContent;
    }
    
    public String getSystemCreatedate() {
        return systemCreatedate;
    }

    public void setSystemCreatedate(String systemCreatedate) {
        this.systemCreatedate = systemCreatedate;
    }
    
    public String getSystemCreatename() {
        return systemCreatename;
    }

    public void setSystemCreatename(String systemCreatename) {
        this.systemCreatename = systemCreatename;
    }
    

}