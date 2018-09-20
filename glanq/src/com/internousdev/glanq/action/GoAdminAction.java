package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.MCategoryDAO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoAdminAction extends ActionSupport implements SessionAware {
	private String categoryId;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private Map<String, Object> session;
	public String execute(){

		// ステータスが１の時だけアクションを動かす。
		String result = "errorhome";
		String token = String.valueOf(session.get("token"));
		if (token != "admin") {
			return result;
		}
		//検索機能でバグが表示しないようにsessionにmCategoryListの情報を入れている。
		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		session.put("loginIDErrorMessageList", "");
		session.put("passwordErrorMessageList", "");
		return SUCCESS;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}
	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
