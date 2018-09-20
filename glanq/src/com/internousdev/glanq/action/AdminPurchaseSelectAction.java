package com.internousdev.glanq.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.MCategoryDAO;
import com.internousdev.glanq.dao.PurchaseHistoryInfoDAO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.internousdev.glanq.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminPurchaseSelectAction extends ActionSupport implements SessionAware {
	private String categoryId;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();
	private Map<String, Object> session;

	public String execute() throws SQLException{

		// ステータスが１の時だけAdmin.jspを表示させる。
		String result = "errorhome";
		String token = String.valueOf(session.get("token"));
		if (token != "admin"){
			return result;
		}

		result = ERROR;

		//ここでもPurchaseHistoryのDAOから情報を取ってList情報をjspで表示させる為に用いている処理。
		PurchaseHistoryInfoDAO purchaseHistoryInfoDao = new PurchaseHistoryInfoDAO();
		purchaseHistoryInfoDtoList = purchaseHistoryInfoDao.getPurchaseHistoryAllList();

		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);

		//ここでは検索機能にバグがおきないようにする為の処置
		if(!session.containsKey("mCategoryList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
			result = SUCCESS;
		}

		return result;
	}
	//以下ゲッタセッター
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
	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDtoList() {
		return purchaseHistoryInfoDtoList;
	}
	public void setPurchaseHistoryInfoDtoList(List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList) {
		this.purchaseHistoryInfoDtoList = purchaseHistoryInfoDtoList;
	}


}
