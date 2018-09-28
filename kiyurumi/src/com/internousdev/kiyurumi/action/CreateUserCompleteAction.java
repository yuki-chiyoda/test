package com.internousdev.kiyurumi.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.UserInfoDAO;
import com.internousdev.kiyurumi.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String loginId;
	private String password;
	private String categoryId;
	private Map<String, Object> session;
	private List<String> loginIdCheckMessageList = new ArrayList<String>();
	public String execute() {
		String result = ERROR;
		UserInfoDAO UserInfoDao = new UserInfoDAO();
		InputChecker inputChecker = new InputChecker();
		loginIdCheckMessageList=inputChecker.doLoginIdCheck(loginId);
		if(!sex.equals("1")){
			sex = "0";
		}
		if(loginIdCheckMessageList.size()==0) {
			int count = UserInfoDao.createUser(familyName,firstName,familyNameKana,firstNameKana,sex,email,loginId,password);
			if(count > 0) {
//				↓ログイン保持
				session.put("logined", 1);
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

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}