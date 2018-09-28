package com.internousdev.kiyurumi.action;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.MCategoryDAO;
import com.internousdev.kiyurumi.dao.ProductInfoDAO;
import com.internousdev.kiyurumi.dto.MCategoryDTO;
import com.internousdev.kiyurumi.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminItemUpdateAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private int id;
	private int productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private int price;
	private String imageFilePath;
	private String imageFileName;
	private String birthDate;
	private String birthPlace;
	private int status;
	private Date updateDate;
	private Date registDate;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	public String execute(){
		String result=ERROR;
		ProductInfoDTO productInfoDTO=new ProductInfoDTO();
		ProductInfoDAO productInfoDAO=new ProductInfoDAO();
		productInfoDTO=productInfoDAO.itemDetail(id);

		// キーが存在するか確認
		if (!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.itemCreateMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		if(!(productInfoDTO==null)){
		session.remove("productNameErrorMessageList");
		session.remove("productNameKanaErrorMessageList");
		session.remove("productDescriptionErrorMessageList");
		session.remove("priceErrorMessageList");
		session.remove("birthPlaceErrorMessageList");
		session.remove("birthDateErrorMessageList");
		session.remove("itemImageFileNameErrorMessageList");


		session.put("id",productInfoDTO.getId());
		session.put("productId",productInfoDTO.getProductId());
		session.put("productName",productInfoDTO.getProductName());
		session.put("productNameKana",productInfoDTO.getProductNameKana());
		session.put("productDescription",productInfoDTO.getProductDescription());
		session.put("categoryId",productInfoDTO.getCategoryId());
		session.put("price",productInfoDTO.getPrice());
		session.put("imageFilePath",productInfoDTO.getImageFilePath());
		session.put("imageFileName",productInfoDTO.getImageFileName());
		session.put("birthDate",productInfoDTO.getBirthDate());
		session.put("birthPlace",productInfoDTO.getBirthPlace());
		session.put("status",productInfoDTO.getStatus());
		session.put("registDate",productInfoDTO.getRegistDate());
		session.put("updateDate",productInfoDTO.getUpdateDate());
		result=SUCCESS;
		}
		return result;
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

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
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

	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
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

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}
	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

}
