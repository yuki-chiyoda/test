package com.internousdev.kanri.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.kanri.util.DBConnector;
import com.internousdev.kanri.util.DateUtil;


public class ItemAddCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "insert into item_info_transaction(item_name,item_price,item_stock,insert_date) values(?,?,?,?)";

	public void addedItemInfo(String itemName, String itemPrice, String itemStock) throws SQLException{
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, itemName);
			preparedStatement.setString(2, itemPrice);
			preparedStatement.setString(3, itemStock);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

}