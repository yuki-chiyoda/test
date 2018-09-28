package com.internousdev.kiyurumi.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.MCategoryDAO;
import com.internousdev.kiyurumi.dao.PurchaseHistoryInfoDAO;
import com.internousdev.kiyurumi.dao.UserInfoDAO;
import com.internousdev.kiyurumi.dto.MCategoryDTO;
import com.internousdev.kiyurumi.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport implements SessionAware{
	private String categoryId;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private Map<String, Object> session;
	public String execute() {
		String result;

		PurchaseHistoryInfoDAO purchaseHistoryInfoDao = new PurchaseHistoryInfoDAO();
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int status=userInfoDAO.getUserDate(String.valueOf(session.get("loginId")));
//もし管理者だったら全件、そうでなければ自分のもの
		if(status==1){
		purchaseHistoryInfoDtoList = purchaseHistoryInfoDao.getPurchaseHistoryList();

		result ="admin";
		}else{
		purchaseHistoryInfoDtoList = purchaseHistoryInfoDao.getPurchaseHistoryList(String.valueOf(session.get("loginId")));
		result=SUCCESS;
		}
		Iterator<PurchaseHistoryInfoDTO> iterator = purchaseHistoryInfoDtoList.iterator();
		if(!(iterator.hasNext())) {
			purchaseHistoryInfoDtoList = null;
		}
		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);

		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}
		return result;
	}


	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}


	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}


	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
