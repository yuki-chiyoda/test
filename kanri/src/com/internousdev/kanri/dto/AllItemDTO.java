package com.internousdev.kanri.dto;
public class AllItemDTO {

	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String insert_date;
	private String update_date;

	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getItemName(){
		return this.itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public String getItemPrice(){
		return this.itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice = itemPrice;
	}
	public String getItemStock(){
		return this.itemStock;
	}
	public void setItemStock(String itemStock){
		this.itemStock = itemStock;
	}
	public String getInsert_date(){
		return this.insert_date;
	}
	public void setInsert_date(String insert_date){
		this.insert_date = insert_date;
	}
	public String getUpdate_date(){
		return this.update_date;
	}
	public void setUpdate_date(String update_date){
		this.update_date = update_date;
	}

}