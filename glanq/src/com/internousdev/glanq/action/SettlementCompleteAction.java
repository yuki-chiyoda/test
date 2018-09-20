package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.CartInfoDAO;
import com.internousdev.glanq.dao.PurchaseHistoryInfoDAO;
import com.internousdev.glanq.dto.CartInfoDTO;
import com.internousdev.glanq.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware {

	/* private String id; */
	private int id;
	private String categoryId;
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}
		// SettlementTokenがあるかどうかしらべる
		String sToken = String.valueOf(session.get("settlementToken"));
		if (sToken != "canSettlement") {
			return result;
		}
		// 商品情報がきちんと入力されているかどうか調べる
		if (id == 0){
			return result;
		}

		@SuppressWarnings("unchecked") // 警告の抑制（警告を無視させる）
		ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = (ArrayList<PurchaseHistoryInfoDTO>) session
				.get("purchaseHistoryInfoDtoList");

		/* @SuppressWarnings("unchecked")//警告の抑制（警告を無視させる） */
		/*
		 * ArrayList<DestinationInfoDTO> destinationInfoDtoList =
		 * (ArrayList<DestinationInfoDTO>)session.get("destinationInfoDtoList");
		 */
		for (int i = 0; /* 初期値 */ i < purchaseHistoryInfoDtoList.size(); /* 条件式 */ i++/* 増減式 */) {
			purchaseHistoryInfoDtoList.get(i).setDestinationId(id);
			/* destinationInfoDtoList.get(0).getId() */
		}
		if (session.containsKey("cartInfoDtoList")) {
			PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();// 購入履歴にデータを渡す
			int count = 0;
			for (int i = 0; /* 初期値 */ i < purchaseHistoryInfoDtoList.size(); /* 条件式 */ i++/* 増減式 */) {
				count += purchaseHistoryInfoDAO.regist(String.valueOf(session.get("loginId")),
						purchaseHistoryInfoDtoList.get(i).getProductId(),
						purchaseHistoryInfoDtoList.get(i).getProductCount(),
						purchaseHistoryInfoDtoList.get(i).getDestinationId(),
						purchaseHistoryInfoDtoList.get(i).getSubtotal());
			}
			if (count > 0) {
				CartInfoDAO cartInfoDAO = new CartInfoDAO(); // カート内のデータを消す
				count = cartInfoDAO.deleteAll(String.valueOf(session.get("loginId")));
				if (count > 0) {
					List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
					cartInfoDtoList = cartInfoDAO.getCartInfoDtoList(String.valueOf(session.get("loginId")));
					Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
					if (!(iterator.hasNext())) {
						cartInfoDtoList = null;
					}
					session.put("cartInfoDtoList", cartInfoDtoList);

					int totalPrice = Integer.parseInt(
							String.valueOf(cartInfoDAO.getTotalPrice(String.valueOf(session.get("loginId")))));
					session.put("totalPrice", totalPrice);
					result = SUCCESS;
					session.remove("settlementToken");
				}
			}
		}
		return result;
	}

	/*
	 * public String getId() { return id; }
	 *
	 * public void setId(String id) { this.id = id; }
	 */
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
