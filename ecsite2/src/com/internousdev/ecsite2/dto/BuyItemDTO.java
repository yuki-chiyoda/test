package com.internousdev.ecsite2.dto;

public class BuyItemDTO {
	private int id;
	private String itemPrice;
	private String itemName;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}

	public String getItemName(){
		return itemName;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

}