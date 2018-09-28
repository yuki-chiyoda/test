package com.internousdev.kiyurumi.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.AdminAllSelectDAO;
import com.internousdev.kiyurumi.dto.CartInfoDTO;
import com.internousdev.kiyurumi.dto.DestinationInfoDTO;
import com.internousdev.kiyurumi.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAllSelectAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;

	private ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();
	private ArrayList<DestinationInfoDTO> destinationList = new ArrayList<DestinationInfoDTO>();
	private ArrayList<MCategoryDTO> mCategoryList = new ArrayList<MCategoryDTO>();

	public String execute() throws SQLException {
		AdminAllSelectDAO adminAllSelectDAO = new AdminAllSelectDAO();
		cartList = adminAllSelectDAO.getCartInfo();
		mCategoryList = adminAllSelectDAO.getMCategoryInfo();
		destinationList = adminAllSelectDAO.getDestinationInfo();

		String result = SUCCESS;

		return result;

	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartInfoDTO> cartList) {
		this.cartList = cartList;
	}

	public ArrayList<DestinationInfoDTO> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(ArrayList<DestinationInfoDTO> destinationList) {
		this.destinationList = destinationList;
	}

	public ArrayList<MCategoryDTO> getmCategoryList() {
		return mCategoryList;
	}

	public void setmCategoryList(ArrayList<MCategoryDTO> mCategoryList) {
		this.mCategoryList = mCategoryList;
	}

}
