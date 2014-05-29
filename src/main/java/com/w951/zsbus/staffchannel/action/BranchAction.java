package com.w951.zsbus.staffchannel.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.w951.util.action.CommonAction;
import com.w951.util.bean.BeanUtil;
import com.w951.util.date.DateUtil;
import com.w951.util.dto.User;
import com.w951.zsbus.staffchannel.dto.BranchDTO;
import com.w951.zsbus.staffchannel.entity.Branch;
import com.w951.zsbus.staffchannel.service.BranchService;

public class BranchAction extends CommonAction {
	private static final long serialVersionUID = -1L;
	private JSONObject result;
	private JSONArray resultArray;
	private Map<String, Object> request;
	private Map<String, Object> session;

	@Resource
	private BranchService branchService;
	
	// 参数

	private Branch branch;
	private int page;
	private int rows;
	
	// Action
	
	@Override
	public String insert() throws Exception {
		User admin = (User) session.get("admin");
		
		branch.setBranchCreatename(admin.getUserName());
		branch.setBranchCreatedate(DateUtil.getDateTime());
		String message = branchService.insert(branch);

		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}

	@Override
	public String delete() throws Exception {
		String message = branchService.delete(branch);

		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}

	@Override
	public String update() throws Exception {
		String message = branchService.update(branch);

		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}

	@Override
	public String query() throws Exception {
		List<Branch> list = branchService.queryPageList(page, rows);

		BranchDTO dto = null;
		List<BranchDTO> dtos = new ArrayList<BranchDTO>();
		if (list != null && list.size() > 0) {
			for (Branch obj : list) {
				dto = new BranchDTO();
				BeanUtil.beanToBean(dto, obj);
				dtos.add(dto);
			}
		}

		jsonData.put("total", branchService.getCount());
		jsonData.put("rows", dtos);
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}
	
	// Array
	
	public String queryTreeArrayByPid() throws Exception {
		List<BranchDTO> dtos = branchService.queryTreeByPid("0");
		resultArray = JSONArray.fromObject(dtos);
		return "array";
	}
	
	public String queryTreeArray() throws Exception {
		List<BranchDTO> dtos = branchService.queryTree();		
		resultArray = JSONArray.fromObject(dtos);
		
		return "array";
	}

	// getter setter

	public Map<String, Object> getRequest() {
		return request;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public JSONObject getResult() {
		return result;
	}

	public void setResult(JSONObject result) {
		this.result = result;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public JSONArray getResultArray() {
		return resultArray;
	}

	public void setResultArray(JSONArray resultArray) {
		this.resultArray = resultArray;
	}

}
