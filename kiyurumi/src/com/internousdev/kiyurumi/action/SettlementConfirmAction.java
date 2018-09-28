package com.internousdev.kiyurumi.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.DestinationInfoDAO;
import com.internousdev.kiyurumi.dto.DestinationInfoDTO;
import com.internousdev.kiyurumi.dto.PurchaseHistoryInfoDTO;
import com.internousdev.kiyurumi.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware{
	private Collection<String> checkList;
	private String productId;
	private String productName;
	private String productNameKana;
	private String categoryId;
	private String price;
	private String imageFilePath;
	private String imageFileName;
	private String birthDate;
	private String birthPlace;
	private String productCount;
	private String subtotal;
	private Map<String, Object> session;
	private String settlement;

	public String execute() {
		session.put("settlement", settlement);

		String result = ERROR;
		if(session.containsKey("loginId")) {
			DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
			List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<>();
			try {
				destinationInfoDtoList = destinationInfoDAO.getDestinationInfo(String.valueOf(session.get("loginId")));
				Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
				if(!(iterator.hasNext())) {
					destinationInfoDtoList = null;
				}
				session.put("destinationInfoDtoList", destinationInfoDtoList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();

		CommonUtility commonUtility = new CommonUtility();

		if(productId != null){
		String[] productIdList = commonUtility.parseArrayList(productId);
		String[] productNameList = commonUtility.parseArrayList(productName);
		String[] productNameKanaList = commonUtility.parseArrayList(productNameKana);
		String[] priceList = commonUtility.parseArrayList(price);
		String[] imageFilePathList = commonUtility.parseArrayList(imageFilePath);
		String[] imageFileNameList = commonUtility.parseArrayList(imageFileName);
		String[] birthDateList = commonUtility.parseArrayList(birthDate);
		String[] birthPlaceList = commonUtility.parseArrayList(birthPlace);
		String[] productCountList = commonUtility.parseArrayList(productCount);
		String[] subtotalList = commonUtility.parseArrayList(subtotal);
		for(int i=0;i<productIdList.length;i++) {
			PurchaseHistoryInfoDTO purchaseHistoryInfoDTO = new PurchaseHistoryInfoDTO();
			purchaseHistoryInfoDTO.setUserId(String.valueOf(session.get("loginId")));
			purchaseHistoryInfoDTO.setProductId(Integer.parseInt(String.valueOf(productIdList[i])));
			purchaseHistoryInfoDTO.setProductName(String.valueOf(productNameList[i]));
			purchaseHistoryInfoDTO.setProductNameKana(String.valueOf(productNameKanaList[i]));
			purchaseHistoryInfoDTO.setPrice(Integer.parseInt(String.valueOf(priceList[i])));
			purchaseHistoryInfoDTO.setImageFilePath(String.valueOf(imageFilePathList[i]));
			purchaseHistoryInfoDTO.setImageFileName(String.valueOf(imageFileNameList[i]));
			purchaseHistoryInfoDTO.setBirthPlace(String.valueOf(birthPlaceList[i]));
			purchaseHistoryInfoDTO.setBirthDate(String.valueOf(birthDateList[i]));
			purchaseHistoryInfoDTO.setProductCount(Integer.parseInt(String.valueOf(productCountList[i])));
			purchaseHistoryInfoDTO.setSubtotal(Integer.parseInt(String.valueOf(subtotalList[i])));
			purchaseHistoryInfoDtoList.add(purchaseHistoryInfoDTO);
		}
		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);

		}

//		ログインIDがありかつログイン済だったらSUCCESS
		if(session.containsKey("loginId") && String.valueOf(session.get("logined")).equals("1")) {
			result = SUCCESS;
		}else {
			result = ERROR;
		}
		return result;
	}
	public Collection<String> getCheckList() {
		return checkList;
	}
	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNameKana() {
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getProductCount() {
		return productCount;
	}
	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getSettlement() {
		return settlement;
	}
	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}



}
