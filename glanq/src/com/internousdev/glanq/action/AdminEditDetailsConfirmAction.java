package com.internousdev.glanq.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.MCategoryDAO;
import com.internousdev.glanq.dao.ProductInfoDAO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.internousdev.glanq.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class AdminEditDetailsConfirmAction extends ActionSupport implements SessionAware{

//変数の宣言
	private String productName;
	private String productNameKana;
	private String productDescription;
	private String price;
	private String imageFileName;
	private String imageFilePath;
	private String releaseCompany;
	private Date releaseDate;
	private int productId;

	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

    //リストのインスタンス化
	private List<String>productNameErrorMessageList = new ArrayList<String>();
	private List<String>productNameKanaErrorMessageList = new ArrayList<String>();
	private List<String>productDescriptionErrorMessageList = new ArrayList<String>();
	private List<String>priceErrorMessageList = new ArrayList<String>();
	private List<String>releaseCompanyErrorMessageList = new ArrayList<String>();
	private List<String>releaseDateErrorMessageList = new ArrayList<String>();
	private List<String>userImageFileNameErrorMessageList = new ArrayList<String>();

	private int categoryId;
	//リストのインスタンス化
	private List<String>categoryIdList = new ArrayList<String>();


	// TODO コレクションフレームワークの教材を読む
	private Map<String,Object>session;


	public String execute() throws SQLException{
		// ステータスが１の時だけAdmin.jspを表示させる。
		String result = "errorhome";
		String token = String.valueOf(session.get("token"));
		if (token != "admin") {
			return result;
		}

		result = ERROR;
		//InputChekerをインスタンス化して正規表現かを検証
		InputChecker inputChecker = new InputChecker();

		//ReleaseDateに値が入っていない場合
	    if(releaseDate == null){
	    	//エラー表示を出す。
	    	releaseDateErrorMessageList.add("発売年月日を入力してください。yyyy/mm/ddで入力します。");
	    }else{
	    	//違う場合はここでDate型をString型に出力している。
		String releaseDate_str = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss").format(releaseDate);
		session.put("releaseDate", releaseDate_str);
	    }

		//前の画面からとってきた値をセッターゲッターに入れてセッションの中に入れる
		session.put("productName",productName);
		session.put("productNameKana",productNameKana);
		session.put("productDescription", productDescription);
		session.put("price",price);
		session.put("imageFileName",imageFileName);
		session.put("imageFilePath",imageFilePath);
		session.put("releaseCompany",releaseCompany);
		session.put("categoryId",categoryId);
		session.put("Status", 0);
        session.put("productId", productId);
        session.put("userImage", userImage);


        //ファイルアップロードの処理
        if(!(userImage == null)){
        	long fileMaxSize = 3145728;//3MB
        	String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("images");
        	System.out.println("Image Location:" + filePath);
        	File fileToCreate = new File(filePath, userImageFileName);
        	userImageFileNameErrorMessageList = inputChecker.docheck3("画像ファイル", userImageFileName, 1, 50, true, true, true, true, true, true, true);

        	//この中にif分を挿入し、画像のみのファイルを指定してあげる。
        	if(!(userImage(userImageContentType))){
        		userImageFileNameErrorMessageList.add("画像ファイルが異なります。jpegのみ挿入出来ます。");
        		result = ERROR;
        	}
        	if(userImage.length()>fileMaxSize){
        		userImageFileNameErrorMessageList.add("3MBより大きい画像ファイルは挿入出来ません。");
        		result = ERROR;
        	}
        try{
        	FileUtils.copyFile(userImage, fileToCreate);
        	session.put("image_file_name", userImageFileName);
        	session.put("image_file_path", "./images");
        	session.put("image_flg" , userImageFileName);
        	System.out.println(session.get("image_file_name"));
        	System.out.println(session.get("image_file_path"));
        }catch(IOException e){
        	e.printStackTrace();
        }
        }else{
        	userImageFileName="";
        	userImageFileNameErrorMessageList.add("画像ファイルを挿入してください。");
        	result = ERROR;
        }
      //ここでmCategoryDtoListを使用してcategoryIdを表示された名前で取ってくる。
      		MCategoryDAO mCategoryDAO = new MCategoryDAO();
      		MCategoryDTO mCategoryDTO = mCategoryDAO.getMCategory(categoryId);
      		//ユーザーID, status をセッションに格納
      		//putされたcategoryIdをメソッド内でセレクトし、categoryNameをsession内に保存する。
      		session.put("categoryName", mCategoryDTO.getCategoryName());

	//リストの中を正規表現判定
	productNameErrorMessageList = inputChecker.docheck("商品名",productName,1,32,true,true,true,true,true,true,true);
	productNameKanaErrorMessageList = inputChecker.docheck("商品ふりがな",productNameKana,1,32,false,false,true,false,false,false,true);
	productDescriptionErrorMessageList = inputChecker.docheck("商品詳細",productDescription,1,200,true,true,true,true,true,true,true);
	priceErrorMessageList = inputChecker.docheck2("価格", price, 1, 8, false, false, false, true, false, false, false);
	releaseCompanyErrorMessageList = inputChecker.docheck("発売会社名", releaseCompany, 1, 16, true, true, true, true, true, true, true);


	ProductInfoDAO productInfoDao = new ProductInfoDAO();

	//boolean型の場合はこのチェック文自体でtrueかfalseになるので==true等はいらない。
	//詳しくはProductInfoDAOの中身を参照。
    if(productInfoDao.checkProductInfo3(productId ,productName)){
    	productNameErrorMessageList.add("選択していない商品名での更新は出来ません。");
    }
    if(productInfoDao.checkProductInfo4(productId ,productNameKana)){
    	productNameKanaErrorMessageList.add("選択していない商品名のふりがなでは更新は出来ません。");
    }

	//もし全てのリストのサイズが0の場合成功  =エラーなし→成功
	if(productNameErrorMessageList.size()==0
			&& productNameKanaErrorMessageList.size()==0
			&& productDescriptionErrorMessageList.size()==0
			&& priceErrorMessageList.size()==0
			&& releaseCompanyErrorMessageList.size()==0
			&& userImageFileNameErrorMessageList.size()==0
			&& releaseDateErrorMessageList.size()==0 ){
		result = SUCCESS;

		//そうでなければエラーのListをセッションに入れる
	}else{
		session.put("productNameErrorMessageList", productNameErrorMessageList);
		session.put("productNameKanaErrorMessageList",productNameKanaErrorMessageList);
		session.put("productDescriptionErrorMessageList",productDescriptionErrorMessageList);
		session.put("priceErrorMessageList",priceErrorMessageList);
		session.put("releaseCompanyErrorMessageList",releaseCompanyErrorMessageList);
		session.put("releaseDateErrorMessageList",releaseDateErrorMessageList);
		session.put("userImageFileNameErrorMessageList" ,userImageFileNameErrorMessageList);
		result = ERROR;
	}

	return result;

	}

	private boolean userImage(String extension) {

		return (extension.equals("image/jpeg"));
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
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
	public List<String> getReleaseCompanyErrorMessageList() {
		return releaseCompanyErrorMessageList;
	}

	public void setReleaseCompanyErrorMessageList(List<String> releaseCompanyErrorMessageList) {
		this.releaseCompanyErrorMessageList = releaseCompanyErrorMessageList;
	}

	public List<String> getReleaseDateErrorMessageList() {
		return releaseDateErrorMessageList;
	}

	public void setReleaseDateErrorMessageList(List<String> releaseDateErrorMessageList) {
		this.releaseDateErrorMessageList = releaseDateErrorMessageList;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<String> getCategoryIdList() {
		return categoryIdList;
	}

	public void setCategoryIdList(List<String> categoryIdList) {
		this.categoryIdList = categoryIdList;
	}
	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}


	public List<String> getUserImageFileNameErrorMessageList() {
		return userImageFileNameErrorMessageList;
	}


	public void setUserImageFileNameErrorMessageList(List<String> userImageFileNameErrorMessageList) {
		this.userImageFileNameErrorMessageList = userImageFileNameErrorMessageList;
	}


	public String getUserImageContentType() {
		return userImageContentType;
	}


	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

}
