package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware {
	/**
	 * 新規ユーザー登録ページへと移動させるメソッド ページ移動の後、入力情報によってはエラーメッセージが発生する場合があるが
	 * このページではメッセージを除去しておく必要がある まずはエラーメッセージを除去 入力された情報をセッションに格納する
	 * また、JSPファイル上で表示する性別選択のため こちらでリストを用意する必要がある
	 *
	 * 最終的にSUCCESSで返す
	 */

	private String loginId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;
	private String email;
	private String categoryId;

	private List<String> sexList = new ArrayList<String>();
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		/**
		 * セッション内にputされたメッセージを削除する 一度エラーメッセージを表示した後、他のページから移動してきた際に
		 * メッセージが残ったままになることを防ぐため
		 */

		session.remove("familyNameErrorMessageList");
		session.remove("firstNameErrorMessageList");
		session.remove("familyNameKanaErrorMessageList");
		session.remove("firstNameKanaErrorMessageList");
		session.remove("emailErrorMessageList");
		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("duplicateList");

		/**
		 * セッションにJSPから渡された値を格納していく こうしておくことで何らかの理由でもう一度入力ページに戻された場合も
		 * 入力した情報は保持されている状態になる
		 */

		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);

		if (sex == null) {
			session.put("sex", MALE);
		} else {
			session.put("sex", String.valueOf(session.get("sex")));
		}
		/**
		 * 性別に関しては選択されていない場合は男性を格納する そうでない場合は選択されたものをString変換した後にセッションに格納
		 */

		sexList.add(MALE);
		sexList.add(FEMALE);
		session.put("sexList", sexList);
		/**
		 * このsexListはJSPファイルで表示する選択肢 男性・女性を選ぶものであるが、このクラスで指定した
		 * MALE=男性、FEMALE＝女性がJSPでの選択肢になる
		 */

		session.put("createLoginId", loginId);
		session.put("password", password);
		session.put("email", email);

		result = SUCCESS;
		return result;
		// SUCCESSを返す
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

	public String getDefaultSexValue() {
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
		this.defaultSexValue = defaultSexValue;
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

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
