package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.UserInfoDAO;
import com.internousdev.glanq.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware {

	/**
	 * 入力情報を元に入力内容が正しいか判断する InputCheckerを利用し、JSPから渡された情報をそれぞれ判別し、 結果をリストに格納
	 *
	 * 入力内容が正しくなければエラーメッセージをセッションに格納し ERRORを返す
	 *
	 * いずれの場合も入力された情報を保存するため、 ここでもセッションに情報を格納する
	 */

	private String loginId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;

	private List<String> familyNameErrorMessageList = new ArrayList<String>();
	private List<String> firstNameErrorMessageList = new ArrayList<String>();
	private List<String> familyNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> firstNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> emailErrorMessageList = new ArrayList<String>();
	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> duplicateList = new ArrayList<String>();

	private List<String> sexList = new ArrayList<String>();
	private String categoryId;

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		// 入力された情報が正しく入力されているかチェックする
		InputChecker inputChecker = new InputChecker();
		familyNameErrorMessageList = inputChecker.docheck("姓", familyName, 1, 16, true, true, true, false, false, false,
				false);
		firstNameErrorMessageList = inputChecker.docheck("名", firstName, 1, 16, true, true, true, false, false, false,
				false);
		familyNameKanaErrorMessageList = inputChecker.docheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false,
				false, false, false);
		firstNameKanaErrorMessageList = inputChecker.docheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false,
				false, false, false);
		emailErrorMessageList = inputChecker.docheck("メールアドレス", email, 14, 32, true, false, false, true, true, false,
				false);
		loginIdErrorMessageList = inputChecker.docheck("ログインID", loginId, 1, 8, true, false, false, true, false, false,
				false);
		passwordErrorMessageList = inputChecker.docheck("パスワード", password, 1, 16, true, false, false, true, false,
				false, false);
		/**
		 * 姓、名など入力された情報をInputCheckerのdoCheckメソッドに渡していく
		 * 引数には「渡す値の種類」、「値そのもの（入力された情報）」、「最小文字数」、「最大文字数」、
		 * そして、その情報に使用可能な文字列をtrueで渡していく 結果はエラーメッセージを入れるリストに格納していく
		 */

		session.remove("familyNameErrorMessageList");
		session.remove("firstNameErrorMessageList");
		session.remove("familyNameKanaErrorMessageList");
		session.remove("firstNameKanaErrorMessageList");
		session.remove("emailErrorMessageList");
		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("duplicateList");
		// エラーメッセージを一度排除

		if (familyNameErrorMessageList.size() == 0 && firstNameErrorMessageList.size() == 0
				&& familyNameKanaErrorMessageList.size() == 0 && firstNameKanaErrorMessageList.size() == 0
				&& emailErrorMessageList.size() == 0 && loginIdErrorMessageList.size() == 0
				&& passwordErrorMessageList.size() == 0) {
			result = SUCCESS;
			// エラーメッセージに格納された要素が0（入力文字が使用可能な文字）の場合はSUCCESS

		} else {
			session.put("familyNameErrorMessageList", familyNameErrorMessageList);
			session.put("firstNameErrorMessageList", firstNameErrorMessageList);
			session.put("familyNameKanaErrorMessageList", familyNameKanaErrorMessageList);
			session.put("firstNameKanaErrorMessageList", firstNameKanaErrorMessageList);
			session.put("emailErrorMessageList", emailErrorMessageList);
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			result = ERROR;
			/**
			 * エラーメッセージに格納された要素がひとつでも存在する場合は セッションにその情報を格納していく
			 * このセッションはJSPファイルで使用する
			 */
		}

		// セッションに情報を格納
		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("sex", sex);
		session.put("email", email);
		session.put("createLoginId", loginId);

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		boolean isUserExists = userInfoDAO.isExistsUserInfo(loginId);
		/**
		 * 入力されたユーザーIDを元にすでにユーザーがいるかを検索 存在するならエラーメッセージをセッションに格納 ERRORを返す
		 */
		if (isUserExists) {
			duplicateList.add("ユーザーIDがすでに使用されています。");
			session.put("duplicateList", duplicateList);
			result = ERROR;
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

	public List<String> getFamilyNameErrorMessageList() {
		return familyNameErrorMessageList;
	}

	public void setFamilyNameErrorMessageList(List<String> familyNameErrorMessageList) {
		this.familyNameErrorMessageList = familyNameErrorMessageList;
	}

	public List<String> getFirstNameErrorMessageList() {
		return firstNameErrorMessageList;
	}

	public void setFirstNameErrorMessageList(List<String> firstNameErrorMessageList) {
		this.firstNameErrorMessageList = firstNameErrorMessageList;
	}

	public List<String> getFamilyNameKanaErrorMessageList() {
		return familyNameKanaErrorMessageList;
	}

	public void setFamilyNameKanaErrorMessageList(List<String> familyNameKanaErrorMessageList) {
		this.familyNameKanaErrorMessageList = familyNameKanaErrorMessageList;
	}

	public List<String> getFirstNameKanaErrorMessageList() {
		return firstNameKanaErrorMessageList;
	}

	public void setFirstNameKanaErrorMessageList(List<String> firstNameKanaErrorMessageList) {
		this.firstNameKanaErrorMessageList = firstNameKanaErrorMessageList;
	}

	public List<String> getEmailErrorMessageList() {
		return emailErrorMessageList;
	}

	public void setEmailErrorMessageList(List<String> emailErrorMessageList) {
		this.emailErrorMessageList = emailErrorMessageList;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
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
