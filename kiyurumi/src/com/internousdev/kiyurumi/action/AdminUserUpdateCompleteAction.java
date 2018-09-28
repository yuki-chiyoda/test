package com.internousdev.kiyurumi.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserUpdateCompleteAction extends ActionSupport implements SessionAware{

	public Map<String ,Object> session;
	private int id;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private int sex;
	private List<String> sexList = new ArrayList<String>();
	private int status;
	private String email;
	private String loginId;
	private String userId;
	private String password;
	private Date registDate;
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexvalue = MALE;

	public String execute(){
		String result = ERROR;

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		session.put("id", id);
		int count = userInfoDAO.userUpdate(Integer.parseInt(session.get("id").toString()),familyName, firstName, familyNameKana, firstNameKana, sex, email, userId, password,Integer.parseInt(session.get("status").toString()));

		if(count > 0){
			session.remove("password");
			session.remove("familyName");
			session.remove("firstName");
			session.remove("familyNameKana");
			session.remove("firstNameKana");
			session.remove("sex");
			session.remove("email");

			result = SUCCESS;
		}
		return result;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public List<String> getSexList() {
		return sexList;
	}
	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public String getDefaultSexvalue() {
		return defaultSexvalue;
	}
	public void setDefaultSexvalue(String defaultSexvalue) {
		this.defaultSexvalue = defaultSexvalue;
	}
	public static String getMale() {
		return MALE;
	}
	public static String getFemale() {
		return FEMALE;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}