package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.DestinationInfoDAO;
import com.internousdev.glanq.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LocationChoiceConfirmAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private Map<String, Object> session;
	private int parkId;
	private String firstName;
	private String firstNameKana;
	private String familyName;
	private String familyNameKana;
	private String email;
	private String telNumber;
	private String userAddress;

	public String execute() {

		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
		List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<>();
		try {
			destinationInfoDtoList = destinationInfoDAO.getDestinationInfoFromId(parkId);
			Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
			if (!(iterator.hasNext())) {
				destinationInfoDtoList = null;
			}
			session.put("parkId", parkId);
			session.put("firstName", firstName);
			session.put("destinationInfoDtoList", destinationInfoDtoList);
			result = SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			result = ERROR;
		}

		return result;
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

	public int getParkId() {
		return parkId;
	}

	public void setParkId(int parkId) {
		this.parkId = parkId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

}
