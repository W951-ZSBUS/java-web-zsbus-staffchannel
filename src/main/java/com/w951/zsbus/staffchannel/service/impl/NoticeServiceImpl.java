package com.w951.zsbus.staffchannel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.w951.zsbus.staffchannel.entity.Notice;
import com.w951.zsbus.staffchannel.service.NoticeService;
import com.w951.orm.hibernate.HibernateDao;
import com.w951.util.bean.BeanUtil;

/**
 * 
 * 系统版本：v1.0<br>
 * 开发人员：Ccz<br>
 * 日期：2014-05-22<br>
 * 时间：15:16:11<br>
 * 功能描述：写明作用，调用方式，使用场景，以及特殊情况<br>
 *
 */
@Component
public class NoticeServiceImpl implements NoticeService {
	@Resource
	private HibernateDao hibernateDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public String delete(Notice entity) {
		entity = get(entity.getNoticeId());
		hibernateDao.delete(entity);
		return null;
	}

	public Notice get(String id) {
		return hibernateDao.get(new Notice(), id);
	}

	public long getCount() {
		return hibernateDao.getCount(new Notice());
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String insert(Notice entity) {
		hibernateDao.insert(entity);
		return null;
	}

	public List<Notice> queryList(String... order) {
		if (order != null) {
			return hibernateDao.queryList(new Notice(), order);
		} else {
			return hibernateDao.queryList(new Notice());
		}
	}

	public List<Notice> queryPageList(int pageIndex, int pageSize,
			String... order) {
		if (order != null) {
			return hibernateDao.queryPageList(new Notice(), pageIndex,
					pageSize, order);
		} else {
			return hibernateDao.queryPageList(new Notice(), pageIndex,
					pageSize);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String update(Notice entity) {
		Notice obj = get(entity.getNoticeId());
		BeanUtil.beanToBean(entity, obj);
		hibernateDao.update(entity);
		return null;
	}

}