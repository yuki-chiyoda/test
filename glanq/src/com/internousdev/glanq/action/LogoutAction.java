package com.internousdev.glanq.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.UserInfoDAO;
import com.internousdev.glanq.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

/*ActionSupportを継承、sessionAwareを実装*/
public class LogoutAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private Map<String, Object> session;

	public String execute() {

		// ERROR処理
		String result = ERROR;

		// userInfoDaoをインスタンス化
		UserInfoDAO userInfoDao = new UserInfoDAO();

		// セッション内のloginId(key)をもとに取り出した値をString型に変換し、loginId（String)に代入する
		String loginId = String.valueOf(session.get("loginId"));

		/*
		 * セッション内のsavedLoginId(key)をもとに取り出した値をString型に変換し、valueOfに代入する。
		 * //代入したvalueOfをBoolean型に変換し、savedLoginIdに代入する
		 */ boolean savedLoginId = Boolean.valueOf(String.valueOf(session.get("savedLoginId")));

		UserInfoDTO userInfoDto = new UserInfoDTO();
		userInfoDto = userInfoDao.getUserInfo(loginId);

		String loginPassword = userInfoDto.getPassword();

		// countにloginIdとloginPasswordを代入
		int count = userInfoDao.logout(loginId, loginPassword);

		// もしcountの値が0以上の場合、
		if (count > 0) {

			// sessionの中を全て除去
			session.clear();

			// sessionの中へsavedLoginId(key)を基にsavedLoginId(value)を登録する
			session.put("savedLoginId", savedLoginId);

			// sessionの中へloginId(key)を基にloginId(value)を登録する
			session.put("saveId", loginId);

			// SUCCESS処理を実行
			result = SUCCESS;
		}

		// resultが返る
		return result;
	}

	// valuestackに渡すためのゲッター、セッター
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
