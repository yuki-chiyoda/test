package com.internousdev.kiyurumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.internousdev.kiyurumi.dto.MCategoryDTO;
import com.internousdev.kiyurumi.util.DBConnector;

public class MCategoryDAO {
	public List<MCategoryDTO> getMCategoryList(){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
		String sql = "select * from m_category ORDER BY category_id";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				MCategoryDTO mCategoryDTO = new MCategoryDTO();
				mCategoryDTO.setId(resultSet.getInt("id"));
				mCategoryDTO.setCategoryId(resultSet.getInt("category_id"));
				mCategoryDTO.setCategoryName(resultSet.getString("category_name"));
				mCategoryDTO.setCategoryDescription(resultSet.getString("category_description"));
				mCategoryDTO.setInsertDate(resultSet.getDate("insert_date"));
				mCategoryDTO.setUpdateDate(resultSet.getDate("update_date"));
				mCategoryDtoList.add(mCategoryDTO);
			}
			Iterator<MCategoryDTO> iterator = mCategoryDtoList.iterator();
			if(!(iterator.hasNext())) {
				mCategoryDtoList = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mCategoryDtoList;
	}

	// categoryIdを算出した時にcategoryNameを表示出来るようにする。

	public MCategoryDTO getMCategory(int categoryId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		MCategoryDTO MCategoryDTO = new MCategoryDTO();

		String sql = "SELECT * FROM m_category WHERE category_id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MCategoryDTO.setCategoryName(rs.getString("category_name"));
				MCategoryDTO.setCategoryId(rs.getInt("category_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MCategoryDTO;
	}

	// 全国カテゴリーを選択出来ない用。

	public List<MCategoryDTO> itemCreateMCategoryList() {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

		/* sql文にてテーブル"m_category"内の全てのデータの取得。
		 * idが1より大きいものを指定。
		 */
		String sql = "SELECT * FROM m_category WHERE id > 1";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				MCategoryDTO mCategoryDto = new MCategoryDTO();
				mCategoryDto.setId(resultSet.getInt("id"));
				mCategoryDto.setCategoryId(resultSet.getInt("category_id"));
				mCategoryDto.setCategoryName(resultSet.getString("category_name"));
				mCategoryDto.setCategoryDescription(resultSet.getString("category_description"));
				mCategoryDto.setInsertDate(resultSet.getDate("insert_date"));
				mCategoryDto.setUpdateDate(resultSet.getDate("update_date"));

				// 追加したデータをListに格納
				mCategoryDtoList.add(mCategoryDto);
			}

			// "iterator"メソッドを用いてリスト内のデータを順次参照し
			// 次のデータがなくなったとき空データ"null"を挿入
			// "データが空である"というデータを入れることで無用なエラーの防止
			Iterator<MCategoryDTO> iterator = mCategoryDtoList.iterator();
			if (!(iterator.hasNext())) {
				mCategoryDtoList = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mCategoryDtoList;
	}

}
