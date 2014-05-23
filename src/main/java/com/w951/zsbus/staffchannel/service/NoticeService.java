package com.w951.zsbus.staffchannel.service;

import org.springframework.transaction.annotation.Transactional;

import com.w951.util.service.CommonService;
import com.w951.zsbus.staffchannel.entity.Notice;

/**
 * 
 * 系统版本：v1.0<br>
 * 开发人员：Ccz<br>
 * 日期：2014-05-22<br>
 * 时间：15:16:11<br>
 * 功能描述：写明作用，调用方式，使用场景，以及特殊情况<br>
 *
 */
@Transactional
public interface NoticeService extends CommonService<Notice> {
	
}