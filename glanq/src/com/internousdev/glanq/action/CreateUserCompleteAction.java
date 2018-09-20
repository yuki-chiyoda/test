package com.internousdev.glanq.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.CartInfoDAO;
import com.internousdev.glanq.dao.UserInfoDAO;
import com.internousdev.glanq.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware {

	/**
	 * これまでずっと渡されてきた情報を ついに登録する
	 *
	 * DAOクラスの登録用メソッドを呼び出し、情報を渡す
	 *
	 * その後、ログイン認証を行う カート内に商品があればそれを登録したIDに引き継ぐ 認証がうまくいけばSUCCESSを返す
	 */

	private String loginId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;

	private String categoryId;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int count = userInfoDAO.createUser(loginId, password, familyName, firstName, familyNameKana, firstNameKana, sex,
				email);
		// ユーザー登録用メソッドを呼び出し、引数に情報を渡す

		if (count > 0) {

			// 登録できていればログイン認証に移る
			if (userInfoDAO.login(loginId, password) > 0) {
				UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(loginId, password);
				// ユーザー情報を取得し、ユーザーID, status をセッションに格納
				session.put("loginId", userInfoDTO.getUserId());
				session.put("status", userInfoDTO.getStatus());

				CartInfoDAO cartInfoDAO = new CartInfoDAO();
				@SuppressWarnings("unused")
				int counts = cartInfoDAO.linkToLoginId(String.valueOf(session.get("tempUserId")), loginId);
				/**
				 * 仮ユーザーIDを元にカート情報を作成した ユーザーIDに紐付ける
				 */
			}
			// ログインフラグをsessionに格納

			session.put("logined", 1);
			result = SUCCESS;
		}
		return result;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
