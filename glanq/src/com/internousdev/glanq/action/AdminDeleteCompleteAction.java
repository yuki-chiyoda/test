package com.internousdev.glanq.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.CartInfoDAO;
import com.internousdev.glanq.dao.ProductInfoDAO;
import com.internousdev.glanq.dao.PurchaseHistoryInfoDAO;
import com.internousdev.glanq.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminDeleteCompleteAction extends ActionSupport implements SessionAware {

	private Collection<String> checkList;
	private String categoryId;
	private String productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String price;
	private String releaseCompany;
	private String releaseDate;
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute() throws SQLException {
		// ステータスが１の時だけAdmin.jspを表示させる。
		String result = "errorhome";
		String token = String.valueOf(session.get("token"));
		if (token != "admin") {
			return result;
		}

		result = ERROR;
		ProductInfoDAO productInfoDAO = new ProductInfoDAO(); // インスタンス化
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		PurchaseHistoryInfoDAO purchasehistoryInfoDAO = new PurchaseHistoryInfoDAO();
		int count = 0;
		// List型のStringにArrayListで生成したインスタンスを格納
		List<String> checkListErrorMessageList = new ArrayList<String>();
		// session内のcheckListErrorMessageListにcheckListErrorMessageListを格納
		if (checkList == null) {
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}
		// 拡張for文
		for (String productId : checkList) {
			System.out.println(productId);
			count += cartInfoDAO.deleteProduct(productId); // カート情報を消す
			count += purchasehistoryInfoDAO.deleteBasedonPid(productId); //購入履歴情報を消す。
			count += productInfoDAO.delete(productId); // 商品情報を消す


		}
		// session内のcheckListErrorMessageListにcheckListErrorMessageListを格納
		if (count <= 0) {
			checkListErrorMessageList.add("既に削除されています。");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		} else {
			// List型のProductInfoDTOにArrayListで生成したインスタンスを格納
			List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
			productInfoDtoList = productInfoDAO.getProductInfoList();
			Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();
			if (!(iterator.hasNext())) { // 次のデータがある場合にtrue
				productInfoDtoList = null;
			}
			session.put("productInfoDtoList", productInfoDtoList);

			result = SUCCESS;
		}
		return result;
	}

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<ProductInfoDTO> getProductInfoDtoList() {
		return productInfoDtoList;
	}

	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList) {
		this.productInfoDtoList = productInfoDtoList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}