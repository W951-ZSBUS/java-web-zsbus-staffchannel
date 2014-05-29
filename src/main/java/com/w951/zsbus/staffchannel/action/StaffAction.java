package com.w951.zsbus.staffchannel.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.w951.util.action.CommonAction;
import com.w951.util.bean.BeanUtil;
import com.w951.util.bean.StringUtil;
import com.w951.util.date.DateUtil;
import com.w951.util.dto.User;
import com.w951.zsbus.staffchannel.dto.StaffDTO;
import com.w951.zsbus.staffchannel.entity.Staff;
import com.w951.zsbus.staffchannel.service.StaffService;

public class StaffAction extends CommonAction {
	private static final long serialVersionUID = -1L;
	private JSONObject result;
	private JSONArray resultArray;
	private Map<String, Object> request;
	private Map<String, Object> session;

	@Resource
	private StaffService staffService;
	
	// 参数

	private Staff staff;
	private int page;
	private int rows;
	private String branchId;
	private String passWord = "123456";
	
	// Action
	
	@Override
	public String insert() throws Exception {
		User admin = (User) session.get("admin");
		
		staff.setStaffCreatename(admin.getUserName());
		staff.setStaffCreatedate(DateUtil.getDateTime());
		//计算年龄
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date Date1 =  format.parse(staff.getStaffBirthdate());
		Date Date2 = format.parse(DateUtil.getDateTime());
		long dt = (Date2.getTime()-Date1.getTime())/1000/(60*60*24*365);
		staff.setStaffAge((int)dt);
		//设置默认密码
		staff.setStaffPassword(StringUtil.toMD5(passWord));
		
		String message = staffService.insert(staff);

		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}

	@Override
	public String delete() throws Exception {
		String message = staffService.delete(staff);

		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}

	@Override
	public String update() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date Date1 =  format.parse(staff.getStaffBirthdate());
		Date Date2 = format.parse(DateUtil.getDateTime());
		long dt = (Date2.getTime()-Date1.getTime())/1000/(60*60*24*365);
		staff.setStaffAge((int)dt);
		String message = staffService.update(staff);

		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}
	
	public String updateBranch() throws Exception {		
		String message = staffService.update(staff);

		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}

	@Override
	public String query() throws Exception {
		List<Staff> list = staffService.queryPageList(page, rows);

		StaffDTO dto = null;
		List<StaffDTO> dtos = new ArrayList<StaffDTO>();
		if (list != null && list.size() > 0) {
			for (Staff obj : list) {
				dto = new StaffDTO();
				dto.setBranchId(obj.getBranch().getBranchId());
				dto.setBranchName(obj.getBranch().getBranchName());
				BeanUtil.beanToBean(dto, obj);
				dtos.add(dto);
			}
		}

		jsonData.put("total", staffService.getCount());
		jsonData.put("rows", dtos);
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}
	
	public String queryByBranch() throws Exception {
		List<Staff> list = staffService.queryPageListByBranchId(branchId, page, rows);

		StaffDTO dto = null;
		List<StaffDTO> dtos = new ArrayList<StaffDTO>();
		if (list != null && list.size() > 0) {
			for (Staff obj : list) {
				dto = new StaffDTO();
				dto.setBranchId(obj.getBranch().getBranchId());
				dto.setBranchName(obj.getBranch().getBranchName());
				BeanUtil.beanToBean(dto, obj);
				dtos.add(dto);
			}
		}

		jsonData.put("total", staffService.getCountByBranchId(branchId));
		jsonData.put("rows", dtos);
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}
	
	public String updateResetPassWord(){
		//重置密码		
		staff.setStaffPassword(StringUtil.toMD5(passWord));
		String message = staffService.update(staff);
		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);
		return SUCCESS;
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

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
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

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

}
