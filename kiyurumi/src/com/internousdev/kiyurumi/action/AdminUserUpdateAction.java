package com.internousdev.kiyurumi.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.UserInfoDAO;
import com.internousdev.kiyurumi.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserUpdateAction extends ActionSupport implements SessionAware{

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
	private String password;
	public Map<String ,Object> session;
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexvalue = MALE;
	private Date updateDate;

	public String execute(){
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO = userInfoDAO.getUserDate(id);
		String result = ERROR;

		if(!(userInfoDTO == null)){

		session.remove("familyNameErrorMessageList");
		session.remove("firstNameErrorMessageList");
		session.remove("familyNameKanaErrorMessageList");
		session.remove("firstNameKanaErrorMessageList");
		session.remove("emailErrorMessageList");
		session.remove("loginIdErrorMessageList");
		session.remove("loginIdCheckMessageList");
		session.remove("passwordErrorMessageList");

		session.put("id", userInfoDTO.getId());

		session.put("familyName", userInfoDTO.getFamilyName());
		session.put("firstName", userInfoDTO.getFirstName());
		session.put("familyNameKana", userInfoDTO.getFamilyNameKana());
		session.put("firstNameKana", userInfoDTO.getFirstNameKana());
		if(sex==0){
			session.put("sex", MALE);
		}else{
			session.put("sex", String.valueOf(session.get("sex")));
		}
		sexList.add(MALE);
		sexList.add(FEMALE);
		session.put("sexList", userInfoDTO.getSex());
		session.put("status", userInfoDTO.getStatus());
		session.put("email", userInfoDTO.getEmail());
		session.put("userId", userInfoDTO.getUserId());
		session.put("password", userInfoDTO.getPassword());
		session.put("updateDate" ,userInfoDTO.getUpdateDate());
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

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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
}