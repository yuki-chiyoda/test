package com.internousdev.kiyurumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.kiyurumi.dto.CartInfoDTO;
import com.internousdev.kiyurumi.dto.DestinationInfoDTO;
import com.internousdev.kiyurumi.dto.MCategoryDTO;
import com.internousdev.kiyurumi.util.DBConnector;

public class AdminAllSelectDAO {



	public ArrayList<CartInfoDTO> getCartInfo()throws SQLException{
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		ArrayList<CartInfoDTO> cartInfoDTO=new ArrayList<CartInfoDTO>();
		String sql=
				"SELECT "
				+ "* "

				+ "FROM "
				+ "cart_info "

				+ "ORDER BY "
				+ "id";


				try{
					PreparedStatement preparedStatement=connection.prepareStatement(sql);

					ResultSet resultSet=preparedStatement.executeQuery();

					while(resultSet.next()){
						CartInfoDTO dto=new CartInfoDTO();
						dto.setId(resultSet.getInt("id"));
						dto.setUserId(resultSet.getString("user_id"));
						dto.setTempUserId(resultSet.getString("temp_user_id"));
						dto.setProductId(resultSet.getInt("product_id"));
						dto.setProductCount(resultSet.getInt("product_count"));
						dto.setPrice(resultSet.getInt("price"));
						dto.setRegistDate(resultSet.getDate("regist_date"));
						dto.setUpdateDate(resultSet.getDate("update_date"));
						cartInfoDTO.add(dto);
				}
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					connection.close();
				}
				return cartInfoDTO;
	}


public ArrayList<DestinationInfoDTO> getDestinationInfo()throws SQLException{
	DBConnector dbConnector=new DBConnector();
	Connection connection=dbConnector.getConnection();
	ArrayList<DestinationInfoDTO> destinationInfoDTO=new ArrayList<DestinationInfoDTO>();
	String sql=
			"SELECT "
			+ "* "

			+ "FROM "
			+ "destination_info "

			+ "ORDER BY "
			+ "id";


			try{
				PreparedStatement preparedStatement=connection.prepareStatement(sql);

				ResultSet resultSet=preparedStatement.executeQuery();

				while(resultSet.next()){
					DestinationInfoDTO dto=new DestinationInfoDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setUserId(resultSet.getString("user_id"));
					dto.setFamilyName(resultSet.getString("family_name"));
					dto.setFirstName(resultSet.getString("first_name"));
					dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
					dto.setFirstNameKana(resultSet.getString("first_name_kana"));
					dto.setEmail(resultSet.getString("email"));
					dto.setTelNumber(resultSet.getString("tel_number"));
					dto.setUserAddress(resultSet.getString("user_address"));
					dto.setRegistDate(resultSet.getDate("regist_date"));
					dto.setUpdateDate(resultSet.getDate("update_date"));
					destinationInfoDTO.add(dto);
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				connection.close();
			}
			return destinationInfoDTO;
}



public ArrayList<MCategoryDTO> getMCategoryInfo()throws SQLException{

	DBConnector dbConnector=new DBConnector();
	Connection connection=dbConnector.getConnection();
	ArrayList<MCategoryDTO> mCategoryDTO=new ArrayList<MCategoryDTO>();
	String sql=
			"SELECT "
			+ "* "

			+ "FROM "
			+ "m_category "

			+ "ORDER BY "
			+ "id";


			try{
				PreparedStatement preparedStatement=connection.prepareStatement(sql);

				ResultSet resultSet=preparedStatement.executeQuery();

				while(resultSet.next()){
					MCategoryDTO dto=new MCategoryDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setCategoryId(resultSet.getInt("category_id"));
					dto.setCategoryName(resultSet.getString("category_name"));
					dto.setCategoryDescription(resultSet.getString("category_description"));
					dto.setInsertDate(resultSet.getDate("insert_date"));
					dto.setUpdateDate(resultSet.getDate("update_date"));
					mCategoryDTO.add(dto);
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				connection.close();
			}
			return mCategoryDTO;
}

}

