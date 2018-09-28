package com.internousdev.kiyurumi.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.CartInfoDAO;
import com.internousdev.kiyurumi.dto.CartInfoDTO;
import com.internousdev.kiyurumi.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware{

	private Collection<String> checkList;
	private String categoryId;
	private String productId;
	private String sex;
	private List<String> sexList = new ArrayList<String>();
	private static final String MALE="男性";
	private static final String FEMALE="女性";
	private String defaultSexValue=MALE;
	private String userId;

	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String price;
	private String birthPlace;
	private String birthDate;
	private String productCount;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private Map<String,Object> session;

	public String execute(){
		String result = ERROR;
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		int count = 0;
		session.remove("checkListErrorMessageList");

		List<String> checkListErrorMessageList = new ArrayList<String>();
		if(checkList == null){
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}

		for(String productId:checkList){
			count += cartInfoDAO.delete(productId, String.valueOf(userId.split(", ",0)[0]));
		}

		if(count <= 0){
			checkListErrorMessageList.add("チェックされていません。");
			session.put("checkListErrorMessageList", checkListErrorMessageList);
			return ERROR;
		}else{
			String userId = null;
			List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
//			ログインIDがあればログインID、なくてtempUserIDがあればtempUserIdを入れる（必ずどちらかあるﾊｽﾞ）
			if(session.containsKey("loginId")){
				userId = String.valueOf(session.get("loginId"));
			}else if(session.containsKey("tempUserId")){
				userId = String.valueOf(session.get("tempUserId"));
			}

//			消した後、残りのカート情報を再度取得
			cartInfoDtoList = cartInfoDAO.getCartInfoDtoList(userId);
			Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();
			if(!(iterator.hasNext())){
				cartInfoDtoList = null;
			}
			session.put("cartInfoDtoList", cartInfoDtoList);

			int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPrice(userId)));
			session.put("totalPrice", totalPrice);

			sexList.add(MALE);
			sexList.add(FEMALE);
			result=SUCCESS;
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
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getProductCount() {
		return productCount;
	}
	public void setProductCount(String productCount) {
		this.productCount = productCount;
	}
	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}
	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public static String getMale() {
		return MALE;
	}
	public static String getFemale() {
		return FEMALE;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
