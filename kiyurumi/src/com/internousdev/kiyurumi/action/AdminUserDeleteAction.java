package com.internousdev.kiyurumi.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.UserInfoDAO;
import com.internousdev.kiyurumi.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class AdminUserDeleteAction extends ActionSupport implements SessionAware{

	private Map<String ,Object>session;
	private Collection<String> checkList;
	private String id;
	private String userId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String status;
	private Date registDate;
	private Date updateDate;

	List<UserInfoDTO> userInfoDtoList = new ArrayList<UserInfoDTO>();

	public String execute(){
		String result= SUCCESS;
		UserInfoDAO userInfoDAO= new UserInfoDAO();
		int count = 0;
		session.remove("checkListErrorMessageList");

		List<String> checkListErrorMessageList= new ArrayList<String>();

		if(checkList == null){
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			userInfoDtoList = userInfoDAO.getSelectUserInfo();
			Iterator<UserInfoDTO> iterator = userInfoDtoList.iterator();
			if (!(iterator.hasNext())) { // 次のデータがある場合true
				userInfoDtoList = null;
			}
			session.put("productInfoDTOList", userInfoDtoList);
			return SUCCESS;
		}

		//checkされていたときの処理//

		boolean deleteFlg = true;
		for (String id : checkList) {
			int intId =  Integer.parseInt(id);
			UserInfoDTO dto = userInfoDAO.getUserDate(intId);
			if (dto.getLogined() == 1) {
				deleteFlg = false;
			}
		}
		if (deleteFlg) {
			for (String id : checkList) {
				count += userInfoDAO.userDelete(Integer.parseInt(id));
			}
			result = SUCCESS;
		} else {
			checkListErrorMessageList.add("ログイン中のIDは削除できません。");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			result = SUCCESS;
		}

		if(count<=0 && deleteFlg){
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList",checkListErrorMessageList);
			result = SUCCESS;
		}

		userInfoDtoList = userInfoDAO.getSelectUserInfo();
		Iterator<UserInfoDTO> iterator= userInfoDtoList.iterator();
		if(!(iterator.hasNext())){
			userInfoDtoList= null;
		}
		session.put("userInfoDtoList", userInfoDtoList);
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public List<UserInfoDTO> getUserInfoDtoList() {
		return userInfoDtoList;
	}

	public void setUserInfoDtoList(List<UserInfoDTO> userInfoDtoList) {
		this.userInfoDtoList = userInfoDtoList;
	}


}