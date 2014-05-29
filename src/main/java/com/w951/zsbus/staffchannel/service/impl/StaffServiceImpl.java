package com.w951.zsbus.staffchannel.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.w951.zsbus.staffchannel.entity.Staff;
import com.w951.zsbus.staffchannel.service.StaffService;
import com.w951.orm.hibernate.HibernateDao;
import com.w951.util.bean.BeanUtil;

/**
 * 
 * 系统版本：v1.0<br>
 * 开发人员：Ccz<br>
 * 日期：2014-05-27<br>
 * 时间：14:41:30<br>
 * 功能描述：写明作用，调用方式，使用场景，以及特殊情况<br>
 *
 */
@Component
public class StaffServiceImpl implements StaffService {
	@Resource
	private HibernateDao hibernateDao;
	
	private static final String QUERY_STAFFCOUNT_BY_BRANCH = "SELECT COUNT(*) FROM Staff t WHERE t.branch.branchId = :branchId";
	private static final String QUERY_STAFF_BY_BRANCH = "FROM Staff t WHERE t.branch.branchId = :branchId";

	@Transactional(propagation = Propagation.REQUIRED)
	public String delete(Staff entity) {
		entity = get(entity.getStaffId());
		hibernateDao.delete(entity);
		return null;
	}

	public Staff get(String id) {
		return hibernateDao.get(new Staff(), id);
	}

	public long getCount() {
		return hibernateDao.getCount(new Staff());
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String insert(Staff entity) {
		hibernateDao.insert(entity);
		return null;
	}

	public List<Staff> queryList(String... order) {
		if (order != null) {
			return hibernateDao.queryList(new Staff(), order);
		} else {
			return hibernateDao.queryList(new Staff());
		}
	}

	public List<Staff> queryPageList(int pageIndex, int pageSize,
			String... order) {
		if (order != null) {
			return hibernateDao.queryPageList(new Staff(), pageIndex,
					pageSize, order);
		} else {
			return hibernateDao.queryPageList(new Staff(), pageIndex,
					pageSize);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String update(Staff entity) {
		Staff obj = get(entity.getStaffId());
		BeanUtil.beanToBean(entity, obj);
		hibernateDao.update(entity);
		return null;
	}
	
	/*----------自定义接口----------*/

	@Override
	public long getCountByBranchId(String branchId) {
		return hibernateDao.getCountByHql(QUERY_STAFFCOUNT_BY_BRANCH,
				new String[][] { new String[] { "branchId", branchId } });
	}
	
	@Override
	public List<Staff> queryPageListByBranchId(String branchId, int pageIndex, int pageSize) {
		return hibernateDao.queryPageListByHql(QUERY_STAFF_BY_BRANCH,
				pageIndex, pageSize, new String[][] { new String[] {"branchId", branchId } });
	}

}