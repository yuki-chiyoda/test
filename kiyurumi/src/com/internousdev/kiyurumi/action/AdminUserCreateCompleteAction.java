package com.internousdev.kiyurumi.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.UserInfoDAO;
import com.internousdev.kiyurumi.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserCreateCompleteAction extends ActionSupport implements SessionAware{

	private Map<String ,Object> session;
	private String loginId;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String userId;
	private String password;
	private int status;
	private List<String> loginIdCheckMessageList = new ArrayList<String>();
	public String execute(){
		String result= ERROR;
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		InputChecker inputChecker = new InputChecker();
		loginIdCheckMessageList=inputChecker.doLoginIdCheck(loginId);
		if(!sex.equals("1")){
			sex = "0";
		}
		if(loginIdCheckMessageList.size()==0) {
		int count = userInfoDAO.createUserAdmin(familyName, firstName, familyNameKana, firstNameKana, sex, email, userId, password);

		if(count>0){
			result = SUCCESS;
		}else {
			session.put("loginIdCheckMessageList", loginIdCheckMessageList);
			result = ERROR;
		}
		}
		return result;
	}

	public List<String> getLoginIdCheckMessageList() {
		return loginIdCheckMessageList;
	}

	public void setLoginIdCheckMessageList(List<String> loginIdCheckMessageList) {
		this.loginIdCheckMessageList = loginIdCheckMessageList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

}