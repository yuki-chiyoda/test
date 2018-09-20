package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.CartInfoDAO;
import com.internousdev.glanq.dto.CartInfoDTO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware {

	private Collection<String> checkList;
	private String categoryId;
	private String productId;

	// 性別関連
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;

	// カート内の商品の情報
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String price;
	private String releaseCompany;
	private String releaseDate;
	private String productCount;
	private String subtotal;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}
		CartInfoDAO ciDAO = new CartInfoDAO();
		int count = 0;

		List<String> checkListErrorMessageList = new ArrayList<String>();

		/*
		 * checkListに値が存在しない場合(削除用のラジオボタンが選択されていない時)
		 */
		if (checkList == null) {
			checkListErrorMessageList.add("チェックされていません");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			session.remove("checkList");
			return ERROR;
		}

		/*
		 * チェックボックスの値とidが一致している時、そのidと同じレコードの値を削除する
		 * その後削除件数をdeleteのメソッドは戻すのでcountの変数に格納
		 */
		for (String id : checkList) {
			System.out.println(id);
			count += ciDAO.delete(id);
		}

		// 削除件数が戻ってこない場合にもエラーメッセージ
		if (count <= 0) {
			checkListErrorMessageList.add("削除できませんでした");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		} else {

			// エラーメッセージの重複表示対策
			String userId = null;
			List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();

			// userIdにsessionに現行入っているidの情報を格納
			if (session.containsKey("loginId")) {
				userId = String.valueOf(session.get("loginId"));
			} else if (session.containsKey("tempUserId")) {
				userId = String.valueOf(session.get("tempUserId"));
			}

			// カートに関連する情報を全てciDTOListに格納
			cartInfoDtoList = ciDAO.getCartInfoDtoList(userId);
			Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();

			// 値が途切れたらnullを格納
			if (!(iterator.hasNext())) {
				cartInfoDtoList = null;
			}

			session.put("cartInfoDtoList", cartInfoDtoList);

			/*
			 * 合計金額をgetTotalPriceメソッドで取得 データ型をint→String→intの変換
			 */
			int totalPrice = Integer.parseInt(String.valueOf(ciDAO.getTotalPrice(userId)));
			session.put("totalPrice", totalPrice);

			sexList.add(MALE);
			sexList.add(FEMALE);
			result = SUCCESS;
			session.remove("checkListErrorMessageList");

		}
		return result;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public String getDefaultSexValue() {
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
		this.defaultSexValue = defaultSexValue;
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

}
