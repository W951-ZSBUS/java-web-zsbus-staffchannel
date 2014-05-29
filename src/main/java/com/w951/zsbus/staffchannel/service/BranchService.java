package com.w951.zsbus.staffchannel.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.w951.util.service.CommonService;
import com.w951.zsbus.staffchannel.dto.BranchDTO;
import com.w951.zsbus.staffchannel.entity.Branch;

/**
 * 
 * 系统版本：v1.0<br>
 * 开发人员：Ccz<br>
 * 日期：2014-05-27<br>
 * 时间：14:41:30<br>
 * 功能描述：写明作用，调用方式，使用场景，以及特殊情况<br>
 *
 */
@Transactional
public interface BranchService extends CommonService<Branch> {

	List<BranchDTO> queryTreeByPid(String pid);
	List<BranchDTO> queryTree();
	
}