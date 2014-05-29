package com.w951.zsbus.staffchannel.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.w951.zsbus.staffchannel.dto.BranchDTO;
import com.w951.zsbus.staffchannel.entity.Branch;
import com.w951.zsbus.staffchannel.service.BranchService;
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
public class BranchServiceImpl implements BranchService {
	@Resource
	private HibernateDao hibernateDao;
	
	private static final String QUERY_BRANCH_BY_PID = "FROM Branch t WHERE t.branchPid = :branchPid";

	@Transactional(propagation = Propagation.REQUIRED)
	public String delete(Branch entity) {
		entity = get(entity.getBranchId());
		if (entity.getBranchPid().equals("0")) {
			return "禁止操作系统目录";
		} else {
			// 递归删除所属目录
			List<Branch> list = hibernateDao.queryListByHql(QUERY_BRANCH_BY_PID, new String[][] { new String[] { "branchPid", entity.getBranchId() } });
			for (Branch branch : list) {
				deleteTree(branch);
				hibernateDao.delete(branch);
			}
			hibernateDao.delete(entity);

			return null;
		}
	}

	public Branch get(String id) {
		return hibernateDao.get(new Branch(), id);
	}

	public long getCount() {
		return hibernateDao.getCount(new Branch());
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String insert(Branch entity) {
		hibernateDao.insert(entity);
		return null;
	}

	public List<Branch> queryList(String... order) {
		if (order != null) {
			return hibernateDao.queryList(new Branch(), order);
		} else {
			return hibernateDao.queryList(new Branch());
		}
	}

	public List<Branch> queryPageList(int pageIndex, int pageSize,
			String... order) {
		if (order != null) {
			return hibernateDao.queryPageList(new Branch(), pageIndex,
					pageSize, order);
		} else {
			return hibernateDao.queryPageList(new Branch(), pageIndex,
					pageSize);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public String update(Branch entity) {
		Branch obj = get(entity.getBranchId());
		BeanUtil.beanToBean(entity, obj);
		hibernateDao.update(entity);
		return null;
	}
	
	/*----------自定义接口----------*/

	@Override
	public List<BranchDTO> queryTreeByPid(String pid) {
		List<BranchDTO> dtos = new ArrayList<BranchDTO>();
		List<Branch> list = hibernateDao.queryListByHql(QUERY_BRANCH_BY_PID, new String[][] { new String[] { "branchPid", pid } });

		for (Branch branch : list) {
			BranchDTO dto = new BranchDTO();
			BeanUtil.beanToBean(dto, branch);
			dtos.add(dto);

			// 使用递归创建整棵树

			createTree(dto);
		}

		return dtos;
	}
	
	@Override
	public List<BranchDTO> queryTree() {
		List<BranchDTO> dtos = new ArrayList<BranchDTO>();
		List<Branch> list = queryList();

		for (Branch branch : list) {
			BranchDTO dto = new BranchDTO();
			BeanUtil.beanToBean(dto, branch);
			dtos.add(dto);

			// 使用递归创建整棵树

			createTree(dto);
		}

		return dtos;
	}

	/**
	 * 递归查询
	 * 
	 * @param dto
	 */
	private void createTree(BranchDTO dto) {
		List<Branch> subList = hibernateDao.queryListByHql(QUERY_BRANCH_BY_PID, new String[][] { new String[] { "branchPid", dto.getBranchId() } });
		if (subList != null && subList.size() > 0) {
			List<BranchDTO> subDtos = new ArrayList<BranchDTO>();
			// 递归中的循环是不会因为重新调用自身而不再循环，会一层一层往上继续循环
			for (Branch subBranch : subList) {
				BranchDTO subDto = new BranchDTO();
				BeanUtil.beanToBean(subDto, subBranch);
				subDtos.add(subDto);

				createTree(subDto);
			}
			dto.setChildren(subDtos);
		}
	}

	/**
	 * 递归删除
	 * 
	 * @param category
	 */
	private void deleteTree(Branch branch) {
		List<Branch> subList = hibernateDao.queryListByHql(QUERY_BRANCH_BY_PID, new String[][] { new String[] { "branchPid", branch.getBranchId() } });
		if (subList != null && subList.size() > 0) {
			for (Branch subBranch : subList) {
				deleteTree(subBranch);
				hibernateDao.delete(subBranch);
			}
		}
	}

}