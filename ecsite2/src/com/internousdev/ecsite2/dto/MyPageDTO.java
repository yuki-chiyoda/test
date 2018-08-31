package com.internousdev.ecsite2.dto;

public class MyPageDTO {

	private String itemName;
	private String totalPrice;
	private String totalCount;
	private String payment;
	private String userName;
	private String id;
	private String insert_date;


	public String getItemName(){
		return this.itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public String getTotalPrice(){
		return this.totalPrice;
	}
	public void setTotalPrice(String totalPrice){
		this.totalPrice = totalPrice;
	}
	public String getTotalCount(){
		return this.totalCount;
	}
	public void setTotalCount(String totalCount){
		this.totalCount = totalCount;
	}
	public String getPayment(){
		return this.payment;
	}
	public void setPayment(String payment){
		this.payment = payment;
	}
	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getInsert_date(){
		return this.insert_date;
	}
	public void setInsert_date(String insert_date){
		this.insert_date = insert_date;
	}

}


