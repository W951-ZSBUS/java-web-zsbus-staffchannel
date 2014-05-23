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
import com.w951.zsbus.staffchannel.dto.NoticeDTO;
import com.w951.zsbus.staffchannel.entity.Notice;
import com.w951.zsbus.staffchannel.service.NoticeService;

public class NoticeAction extends CommonAction {
	private static final long serialVersionUID = -1L;
	private JSONObject result;
	private JSONArray resultArray;
	private Map<String, Object> request;
	private Map<String, Object> session;

	@Resource
	private NoticeService noticeService;
	
	// 参数

	private Notice notice;
	private int page;
	private int rows;
	
	// Action
	
	@Override
	public String insert() throws Exception {
		User admin = (User) session.get("admin");
		
		notice.setNoticeCreatename(admin.getUserName());
		notice.setNoticeCreatedate(DateUtil.getDateTime());
		String message = noticeService.insert(notice);

		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}

	@Override
	public String delete() throws Exception {
		String message = noticeService.delete(notice);

		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}

	@Override
	public String update() throws Exception {
		String message = noticeService.update(notice);

		if (message != null) {
			jsonData.put("message", message);
		}
		
		result = JSONObject.fromObject(jsonData);

		return SUCCESS;
	}

	@Override
	public String query() throws Exception {
		List<Notice> list = noticeService.queryPageList(page, rows, "noticeCreatedate", "DESC");

		NoticeDTO dto = null;
		List<NoticeDTO> dtos = new ArrayList<NoticeDTO>();
		if (list != null && list.size() > 0) {
			for (Notice obj : list) {
				dto = new NoticeDTO();
				BeanUtil.beanToBean(dto, obj);
				dtos.add(dto);
			}
		}

		jsonData.put("total", noticeService.getCount());
		jsonData.put("rows", dtos);
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

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
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
