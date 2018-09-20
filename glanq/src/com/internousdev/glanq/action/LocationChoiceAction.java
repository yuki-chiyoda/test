package com.internousdev.glanq.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.DestinationInfoDAO;
import com.internousdev.glanq.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LocationChoiceAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private Map<String, Object> session;

	DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
	List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<>();

	public String execute() {
		/* 画面遷移のみ */
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}
		String lToken = String.valueOf(session.get("locationToken"));
		if (lToken == "test") {

			try {
				destinationInfoDtoList = destinationInfoDAO.getDestinationInfo("admin");
				Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
				if (!(iterator.hasNext())) {
					destinationInfoDtoList = null;
				}
				session.put("destinationInfoDtoList", destinationInfoDtoList);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			result = SUCCESS;
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

}
