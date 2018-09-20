package com.internousdev.glanq.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.CartInfoDAO;
import com.internousdev.glanq.dto.CartInfoDTO;
import com.internousdev.glanq.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware{

	/*
	 *商品一覧からカートへのデータ移動を行うアクション
	 */

	private int productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private String productCount;
	private Date releaseDate;
	private String releaseCompany;
	private String productDescription;
	private String dontNever;

//	private String categoryId;

	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		String userId = null;
		String tempUserId = null;

		//本登録のIdも仮登録のIdも存在しない場合
		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
			CommonUtility cu = new CommonUtility();
			//ランダムな値を仮IDとしてsessionに送る
			session.put("tempUserId", cu.getRamdomValue());
		}

		//すでにログイン済みならばsessionからIDを再取得
		if(session.containsKey("loginId")){
			userId = String.valueOf(session.get("loginId"));
		}

		//loginIdがなく、仮Idのみ発行されている場合は両方のテーブルに値をsessionから代入する
		if(!(session.containsKey("loginId")) && session.containsKey("tempUserId")){
			userId= String.valueOf(session.get("tempUserId"));
			tempUserId = String.valueOf(session.get("tempUserId"));
		}

		productCount = String.valueOf((productCount.split(" ,",0))[0]);

		//cart内の情報をregistメソッドでDBに送る、一件以上送れるとSUCCESSを返す
		CartInfoDAO ciDAO = new CartInfoDAO();
		int count = ciDAO.regist(userId, tempUserId, productId, productCount, price);

		if(count > 0){
			result = SUCCESS;
		}

		List<CartInfoDTO> cartInfoDtoList = new ArrayList<CartInfoDTO>();
		cartInfoDtoList = ciDAO.getCartInfoDtoList(userId);

		//iteratorでリストの中身を変数に代入します
		Iterator<CartInfoDTO> iterator = cartInfoDtoList.iterator();

		//次の要素がないレコードにはnullを代入します
		if(!(iterator.hasNext())){
			cartInfoDtoList = null;
		}

		//重複させないように０にする。
		session.remove("dontNever",dontNever);

		session.put("cartInfoDtoList", cartInfoDtoList);

		//合計金額をgetTotalPriceのメソッドで取得int型に変換して変数に代入
		int totalPrice = Integer.parseInt(String.valueOf(ciDAO.getTotalPrice(userId)));
		session.put("totalPrice", totalPrice);

		try{
			session.remove("checkListErrorMessageList");
		}catch (Exception e){
			e.printStackTrace();
		}

		return result;

	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
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

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public String getProductCount(){
		return productCount;
	}

	public void setProductCount(String productCount){
		this.productCount = productCount;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}


	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Map<String ,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getDontNever() {
		return dontNever;
	}

	public void setDontNever(String dontNever) {
		this.dontNever = dontNever;
	}

}
