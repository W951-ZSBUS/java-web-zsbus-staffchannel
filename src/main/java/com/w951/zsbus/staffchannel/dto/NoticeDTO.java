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
public class NoticeDTO implements Serializable {
	private static final long serialVersionUID = -1L;

    private String noticeId;
    private String noticeTitle;
    private String noticeContent;
    private String noticeCreatedate;
    private String noticeCreatename;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }
    
    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }
    
    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
    
    public String getNoticeCreatedate() {
        return noticeCreatedate;
    }

    public void setNoticeCreatedate(String noticeCreatedate) {
        this.noticeCreatedate = noticeCreatedate;
    }
    
    public String getNoticeCreatename() {
        return noticeCreatename;
    }

    public void setNoticeCreatename(String noticeCreatename) {
        this.noticeCreatename = noticeCreatename;
    }
    

}