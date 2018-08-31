package com.internousdev.kanri.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.kanri.dao.AllItemDAO;
import com.internousdev.kanri.dto.AllItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AllItemAction  extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private String deleteFlg;
	private String message;
	private ArrayList<AllItemDTO> allItemList = new ArrayList<AllItemDTO>();
	private AllItemDAO allItemDAO = new AllItemDAO();

	public String execute() throws SQLException{
		/* if(!session.containsKey("id")){
			return ERROR;
		}*/
		if(deleteFlg == null){
			allItemList = allItemDAO.getAllItemInfo();

		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result = SUCCESS;
		return result;
	}

	private void delete() throws SQLException{
		int res = allItemDAO.allItemDelete();

		if(res > 0){
			allItemList = null;
			setMessage("商品を正しく削除しました。");
		}else if(res == 0){
			setMessage("商品情報の削除に失敗しました。");
		}
	}public String getDeleteFlg(){
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg = deleteFlg;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public  ArrayList<AllItemDTO> getAllItemList(){
		return this.allItemList;
	}

	public void setAllItemList(ArrayList<AllItemDTO> allItemList){
		this.allItemList = allItemList;
	}
	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message = message;
	}




}
