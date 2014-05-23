package com.w951.zsbus.staffchannel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.w951.zsbus.staffchannel.entity.System;
import com.w951.zsbus.staffchannel.service.SystemService;
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
public class SystemServiceImpl implements SystemService {
	@Resource
	private HibernateDao hibernateDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public String delete(System entity) {
		entity = get(entity.getSystemId());
		hibernateDao.delete(entity);
		return null;
	}

	public System get(String id) {
		return hibernateDao.get(new System(), id);
	}

	public long getCount() {
		return hibernateDao.getCount(new System());
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String insert(System entity) {
		hibernateDao.insert(entity);
		return null;
	}

	public List<System> queryList(String... order) {
		if (order != null) {
			return hibernateDao.queryList(new System(), order);
		} else {
			return hibernateDao.queryList(new System());
		}
	}

	public List<System> queryPageList(int pageIndex, int pageSize,
			String... order) {
		if (order != null) {
			return hibernateDao.queryPageList(new System(), pageIndex,
					pageSize, order);
		} else {
			return hibernateDao.queryPageList(new System(), pageIndex,
					pageSize);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String update(System entity) {
		System obj = get(entity.getSystemId());
		BeanUtil.beanToBean(entity, obj);
		hibernateDao.update(entity);
		return null;
	}

}