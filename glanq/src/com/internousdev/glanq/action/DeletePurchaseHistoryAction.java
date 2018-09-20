package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.PurchaseHistoryInfoDAO;
import com.internousdev.glanq.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;
	private Map<String, Object> session;

	// executeメソッドの実行
	public String execute() {

		/* エラー処理 */
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		/* purchaseHistoryInfoDAOのインスタンス化 */
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();

		/* sessionのloginIdをString型に変更 purchaseHistoryInfoDAOを全て削除 */
		int count = purchaseHistoryInfoDAO.deleteAll(String.valueOf(session.get("loginId")));

		/* countが0より大きいとき */
		if (count > 0) {

			/*
			 * purchaseHistoryInfoDtoListインスタンス化
			 * purchaseHistoryInfoDAOの中のPurchaseHistoryListからsessionのloginIdをString型に変更して所得
			 */
			List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = purchaseHistoryInfoDAO
					.getPurchaseHistoryList(String.valueOf(session.get("loginId")));

			/* iteratorインスタンス化 */
			Iterator<PurchaseHistoryInfoDTO> iterator = purchaseHistoryInfoDtoList.iterator();

			/* iteratorに次の要素？がなければ */
			if (!(iterator.hasNext())) {

				/* purchaseHistoryInfoDtoListにnullを返す */
				purchaseHistoryInfoDtoList = null;
			}
			/*
			 * session(purchaseHistoryInfoDtoList[key]
			 * にpurchaseHistoryInfoDtoList[value]を追加)
			 */
			session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);

			/* sexListにMALE,FEMALEを追加 */
			sexList.add(MALE);
			sexList.add(FEMALE);

			/* if文がtureならresultにsuccess返す */
			result = SUCCESS;
		}
		/* resultを返す */
		return result;
	}
	//

	// geter setter
	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public String getDefaultSexValue() {
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
		this.defaultSexValue = defaultSexValue;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
