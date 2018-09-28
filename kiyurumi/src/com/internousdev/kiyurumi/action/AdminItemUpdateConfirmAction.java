package com.internousdev.kiyurumi.action;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kiyurumi.dao.MCategoryDAO;
import com.internousdev.kiyurumi.dto.MCategoryDTO;
import com.internousdev.kiyurumi.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AdminItemUpdateConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;

	//通常部分//
	private int id;
	private int productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private String price;
	private String imageFilePath;
	private String imageFileName;
	private String birthDate;
	private String birthPlace;
	private String updateDate;
	private List<String>categoryIdList = new ArrayList<String>();

	//エラー部分//
	private List<String> productNameErrorMessageList=new ArrayList<String>();
	private List<String> productNameKanaErrorMessageList=new ArrayList<String>();
	private List<String> productDescriptionErrorMessageList=new ArrayList<String>();
	private List<String> priceErrorMessageList=new ArrayList<String>();
	private List<String> birthDateErrorMessageList=new ArrayList<String>();
	private List<String> birthPlaceErrorMessageList=new ArrayList<String>();
	private List<String> birthPlaceErrorMessageList1=new ArrayList<String>();
	private List<String> birthPlaceErrorMessageList2=new ArrayList<String>();

	//画像系//
	private File itemImage;
	private String itemImageFileName;
	private String itemImageContentType;
	private List<String> itemImageFileNameErrorMessageList=new ArrayList<String>();


	public String execute(){
		String result=ERROR;
		InputChecker inputChecker=new InputChecker();
		birthPlaceErrorMessageList1=inputChecker.doBirthPlaceCheck(birthPlace);
		session.put("id",id);
		session.put("productId",productId);
		session.put("productName",productName);
		session.put("productNameKana",productNameKana);
		session.put("productDescription",productDescription);
		session.put("categoryId",categoryId);
		session.put("price",price);
		session.put("imageFilePath", imageFilePath);
		session.put("imageFileName",imageFileName);
		session.put("birthDate",birthDate);
		session.put("birthPlace",birthPlace);
		session.put("itemImage",itemImage);
		session.put("updateDate",updateDate);

        //リリースデータに値が入っていない時
	    if(birthDate == null){
	    	//エラーリストのaddを追加する。
	    	birthDateErrorMessageList.add("生年月日を入力してください。");
	    }else{
	    	//値が入っていればDate型をString型にする。
		session.put("birthDate", birthDate);
	    }
//		生年月日修正/エラー判断部分
		if(!(birthDate.length()==0)){
		birthDate=birthDate.substring(0,10);
		session.put("birthDate",birthDate);
		}else{
		birthDateErrorMessageList=inputChecker.doBirthDateCheck(birthDate);
		}

		//ここでmCategoryDtoListを使用してcategoryIdを表示された名前で取ってくる。
		MCategoryDAO mCategoryDAO= new MCategoryDAO();
  		MCategoryDTO mCategoryDTO = mCategoryDAO.getMCategory(categoryId);
  		//putされたcategoryIdをメソッド内でセレクトし、categoryNameをsession内に保存する。//
  		session.put("categoryName", mCategoryDTO.getCategoryName());

		//ファイルアップロードの処理//
		if(!(itemImage==null)){
			long fileMaxSize=3145728;//3MB
			String filePath=ServletActionContext.getServletContext().getRealPath("/").concat("images");
			File fileToCreate=new File(filePath,itemImageFileName);
			itemImageFileNameErrorMessageList=inputChecker.doCheck("画像ファイル名",itemImageFileName,1, 50, true, true, true, true, true, true, true);

			//この中にif文を挿入し、画像のみファイルを指定//
			if(!(itemImage(itemImageContentType))){
				itemImageFileNameErrorMessageList.add("画像ファイルが異なります。jpegのみ挿入できます。");
				result=ERROR;
			}
			if(itemImage.length()>fileMaxSize){
				itemImageFileNameErrorMessageList.add("3MBより大きい画像ファイルは挿入できません。");
				result=ERROR;
			}
			try{
				FileUtils.copyFile(itemImage,fileToCreate);
				session.put("image_file_name",itemImageFileName);
				session.put("image_file_path","./images");
				session.put("image_flg",itemImageFileName);
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			itemImageFileName="";
			itemImageFileNameErrorMessageList.add("画像ファイルを挿入してください。");
			result=ERROR;
		}


		//エラーか否かの判断部分//
		productNameErrorMessageList=inputChecker.doCheck("商品名",productName,1,16,true,true,true,true,false,true,true);
		productNameKanaErrorMessageList=inputChecker.doCheck("商品名ふりがな",productNameKana,1,16,false,false,true,true,false,false,true);
		productDescriptionErrorMessageList=inputChecker.doCheck("商品詳細",productDescription,5,200,true,true,true,true,true,true,true);
		priceErrorMessageList=inputChecker.doCheck("価格",price,1,7,false,false,false,true,false,false,false);
		birthPlaceErrorMessageList2=inputChecker.doCheck("出身地",birthPlace,1,20,true,true,true,true,false,true,false);

		birthPlaceErrorMessageList.addAll(birthPlaceErrorMessageList1);
		birthPlaceErrorMessageList.addAll(birthPlaceErrorMessageList2);

		if(productNameErrorMessageList.size()==0
			&& productNameKanaErrorMessageList.size()==0
			&& productDescriptionErrorMessageList.size()==0
			&& priceErrorMessageList.size()==0
			&& birthDateErrorMessageList.size()==0
			&& birthPlaceErrorMessageList.size()==0
			&& itemImageFileNameErrorMessageList.size()==0){
			result=SUCCESS;
		}else{
			session.put("productNameErrorMessageList",productNameErrorMessageList);
			session.put("productNameKanaErrorMessageList",productNameKanaErrorMessageList);
			session.put("productDescriptionErrorMessageList",productDescriptionErrorMessageList);
			session.put("priceErrorMessageList",priceErrorMessageList);
			session.put("birthDateErrorMessageList",birthDateErrorMessageList);
			session.put("birthPlaceErrorMessageList",birthPlaceErrorMessageList);
			session.put("itemImageFileNameErrorMessageList", itemImageFileNameErrorMessageList);
			return result;
		}

		return SUCCESS;
	}


	private boolean itemImage(String extension){
		return (extension.equals("image/jpeg"));
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

	public List<String> getProductNameErrorMessageList() {
		return productNameErrorMessageList;
	}
	public void setProductNameErrorMessageList(List<String> productNameErrorMessageList) {
		this.productNameErrorMessageList = productNameErrorMessageList;
	}

	public List<String> getProductNameKanaErrorMessageList() {
		return productNameKanaErrorMessageList;
	}
	public void setProductNameKanaErrorMessageList(List<String> productNameKanaErrorMessageList) {
		this.productNameKanaErrorMessageList = productNameKanaErrorMessageList;
	}

	public List<String> getProductDescriptionErrorMessageList() {
		return productDescriptionErrorMessageList;
	}
	public void setProductDescriptionErrorMessageList(List<String> productDescriptionErrorMessageList) {
		this.productDescriptionErrorMessageList = productDescriptionErrorMessageList;
	}

	public List<String> getPriceErrorMessageList() {
		return priceErrorMessageList;
	}
	public void setPriceErrorMessageList(List<String> priceErrorMessageList) {
		this.priceErrorMessageList = priceErrorMessageList;
	}

	public List<String> getBirthPlaceErrorMessageList() {
		return birthPlaceErrorMessageList;
	}
	public void setBirthPlaceErrorMessageList(List<String> birthPlaceErrorMessageList) {
		this.birthPlaceErrorMessageList = birthPlaceErrorMessageList;
	}

	public List<String> getBirthDateErrorMessageList() {
		return birthDateErrorMessageList;
	}
	public void setBirthDateErrorMessageList(List<String> birthDateErrorMessageList) {
		this.birthDateErrorMessageList = birthDateErrorMessageList;
	}

	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public List<String> getCategoryIdList() {
		return categoryIdList;
	}
	public void setCategoryIdList(List<String> categoryIdList) {
		this.categoryIdList = categoryIdList;
	}

	public List<String> getBirthPlaceErrorMessageList1() {
		return birthPlaceErrorMessageList1;
	}
	public void setBirthPlaceErrorMessageList1(List<String> birthPlaceErrorMessageList1) {
		this.birthPlaceErrorMessageList1 = birthPlaceErrorMessageList1;
	}

	public List<String> getBirthPlaceErrorMessageList2() {
		return birthPlaceErrorMessageList2;
	}
	public void setBirthPlaceErrorMessageList2(List<String> birthPlaceErrorMessageList2) {
		this.birthPlaceErrorMessageList2 = birthPlaceErrorMessageList2;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	//画像関係//
	public File getItemImage() {
		return itemImage;
	}
	public void setItemImage(File itemImage) {
		this.itemImage = itemImage;
	}

	public String getItemImageFileName() {
		return itemImageFileName;
	}
	public void setItemImageFileName(String itemImageFileName) {
		this.itemImageFileName = itemImageFileName;
	}

	public String getItemImageContentType() {
		return itemImageContentType;
	}
	public void setItemImageContentType(String itemImageContentType) {
		this.itemImageContentType = itemImageContentType;
	}

	public List<String> getItemImageFileNameErrorMessageList() {
		return itemImageFileNameErrorMessageList;
	}
	public void setItemImageFileNameErrorMessageList(List<String> itemImageFileNameErrorMessageList) {
		this.itemImageFileNameErrorMessageList = itemImageFileNameErrorMessageList;
	}

}