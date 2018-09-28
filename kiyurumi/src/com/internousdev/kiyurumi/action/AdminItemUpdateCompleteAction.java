package com.internousdev.kiyurumi.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.ProductInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminItemUpdateCompleteAction extends ActionSupport implements SessionAware{

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
	private String updateDate;

	public String execute(){
		String result=ERROR;

		ProductInfoDAO productInfoDAO=new ProductInfoDAO();

		session.put("id",id);
		session.put("price",price);



		int count=productInfoDAO.itemUpdate(
				session.get("productName").toString(),
				session.get("productNameKana").toString(),
				session.get("productDescription").toString(),
				Integer.parseInt(session.get("categoryId").toString()),
				Integer.parseInt(session.get("price").toString()),
				session.get("image_file_path").toString(),
				session.get("image_file_name").toString(),
				session.get("birthDate").toString(),
				session.get("birthPlace").toString(),
				Integer.parseInt(session.get("id").toString())
				);

		if(count>0){
			session.remove("productName");
			session.remove("puroductNameKana");
			session.remove("productDescription");
			session.remove("categoryId");
			session.remove("price");
			session.remove("birthDate");
			session.remove("birthPlace");
			session.remove("image_file_path");
			session.remove("image_file_name");
			session.remove("image_flg");
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

	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

}
