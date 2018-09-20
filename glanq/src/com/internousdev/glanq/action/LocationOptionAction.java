package com.internousdev.glanq.action;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.DestinationInfoDAO;
import com.internousdev.glanq.dto.DestinationInfoDTO;
import com.internousdev.glanq.dto.PurchaseHistoryInfoDTO;
import com.internousdev.glanq.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class LocationOptionAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private Collection<String> checkList;
	private String productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String price;
	private String releaseCompany;
	private String releaseDate;
	private String productCount;
	private String subtotal;
	private Map<String, Object> session;

	private String GoLocationFlg;

	public String execute() {
		/*
		 * 画面遷移のみだと思ったら全然そんなことは無かった
		 *
		 * Cartから送られてきた商品情報をpurchaseHistoryInfoDtoListに格納してsessionにputする処理を書く
		 *
		 * これはもともとSettlementConfirmActionでやるはずだった処理
		 * 今回はCart.jspの決済ボタンの遷移先がSettlementConfirmActionでは無くこのアクションなので、
		 * こっちでやってあげないと購入履歴が正しく保存されない...はず
		 *
		 */
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		if (session.containsKey("loginId")) {
			DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
			List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<>();
			try {
				destinationInfoDtoList = destinationInfoDAO.getDestinationInfo(String.valueOf(session.get("loginId")));
				Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
				if (!(iterator.hasNext())) {
					destinationInfoDtoList = null;
				}
				session.put("destinationInfoDtoList", destinationInfoDtoList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDtoList = new ArrayList<PurchaseHistoryInfoDTO>();

		CommonUtility commonUtility = new CommonUtility();
		String[] productIdList = commonUtility.parseArrayList(productId);
		String[] productNameList = commonUtility.parseArrayList(productName);
		String[] productNameKanaList = commonUtility.parseArrayList(productNameKana);
		String[] imageFilePathList = commonUtility.parseArrayList(imageFilePath);
		String[] imageFileNameList = commonUtility.parseArrayList(imageFileName);
		String[] priceList = commonUtility.parseArrayList(price);
		String[] releaseCompanyList = commonUtility.parseArrayList(releaseCompany);
		String[] releaseDateList = commonUtility.parseArrayList(releaseDate);
		String[] productCountList = commonUtility.parseArrayList(productCount);
		String[] subtotalList = commonUtility.parseArrayList(subtotal);

		for (int i = 0; i < productIdList.length; i++) {
			PurchaseHistoryInfoDTO purchaseHistoryInfoDTO = new PurchaseHistoryInfoDTO();
			purchaseHistoryInfoDTO.setUserId(String.valueOf(session.get("loginId")));
			purchaseHistoryInfoDTO.setProductId(Integer.parseInt(String.valueOf(productIdList[i])));
			purchaseHistoryInfoDTO.setProductName(String.valueOf(productNameList[i]));
			purchaseHistoryInfoDTO.setProductNameKana(String.valueOf(productNameKanaList[i]));
			purchaseHistoryInfoDTO.setImageFilePath(String.valueOf(imageFilePathList[i]));
			purchaseHistoryInfoDTO.setImageFileName(String.valueOf(imageFileNameList[i]));
			purchaseHistoryInfoDTO.setPrice(Integer.parseInt(String.valueOf(priceList[i])));
			purchaseHistoryInfoDTO.setReleaseCompany(String.valueOf(releaseCompanyList[i]));

			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
				purchaseHistoryInfoDTO.setReleaseDate(simpleDateFormat.parse(String.valueOf(releaseDateList[i])));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			purchaseHistoryInfoDTO.setProductCount(Integer.parseInt(String.valueOf(productCountList[i])));
			purchaseHistoryInfoDTO.setSubtotal(Integer.parseInt(String.valueOf(subtotalList[i])));
			purchaseHistoryInfoDtoList.add(purchaseHistoryInfoDTO);
		}
		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfoDtoList);
		/* LocationChoiceActionで確認するTokenを発行する */
		String lToken = "test";
		session.put("locationToken", lToken);

		if (!session.containsKey("loginId")) {
			// loginIdが確認されない場合はログイン画面へと誘導する。
			session.remove("loginIdErrorMessageList");
			session.remove("passwordErrorMessageList");
			session.remove("loginErrorMessageList");
			result = ERROR;
			// （追加）ここから遷移したことを知らせるためのパラメータgoLocationFlgを設定。
			setGoLocationFlg("true");
		} else {
			result = SUCCESS;
			String settlementToken = "canSettlement";
			session.put("settlementToken", settlementToken);
		}

		return result;
	}

	/* getter&setter */

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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

	public String getGoLocationFlg() {
		return GoLocationFlg;
	}

	public void setGoLocationFlg(String goLocationFlg) {
		GoLocationFlg = goLocationFlg;
	}

}
