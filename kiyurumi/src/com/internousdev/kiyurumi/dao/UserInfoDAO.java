package com.internousdev.kiyurumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.kiyurumi.dto.UserInfoDTO;
import com.internousdev.kiyurumi.util.DBConnector;

public class UserInfoDAO{

//管理者用ユーザー更新 メソッド

	public int userUpdate(int id ,String familyName, String firstName, String familyNameKana,
			String firstNameKana, int sex, String email, String loginId, String password ,int status){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "UPDATE user_info SET user_id=?, password=?, family_name=?, first_name= ?, family_name_kana=?, first_name_kana=?, sex=?, email=?, status=?, update_date=now() WHERE id=?";

		PreparedStatement ps;
		int count=0;
		try{
			ps=con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setInt(7, sex);
			ps.setString(8, email);
			ps.setInt(9, status);
			ps.setInt(10, id);
			count=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;

	}

//ユーザーIDチェック用メソッド
	public int checkUserId(String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql ="select count(*) as count from user_info where user_id = ?";
		int count = 0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("count");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	//ログイン画面エラー
	public int checkLoginId(String loginId){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="select count(*) as count from user_info where user_id=?";

		int count = 0;
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				count = resultSet.getInt("count");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

//管理者更新画面用メソッド
		public UserInfoDTO getUserDate(int id){
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();
			String sql = "SELECT * FROM user_info WHERE id = ?";
			UserInfoDTO userInfoDTO = new UserInfoDTO();
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					userInfoDTO.setId(rs.getInt("id"));
					userInfoDTO.setFamilyName(rs.getString("family_name"));
					userInfoDTO.setFirstName(rs.getString("first_name"));
					userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
					userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
					userInfoDTO.setSex(rs.getInt("sex"));
					userInfoDTO.setEmail(rs.getString("email"));
					userInfoDTO.setLogined(rs.getInt("logined"));
					userInfoDTO.setStatus(rs.getInt("status"));
					userInfoDTO.setUserId(rs.getString("user_id"));
					userInfoDTO.setPassword(rs.getString("password"));
					userInfoDTO.setRegistDate(rs.getDate("regist_date"));
					userInfoDTO.setUpdateDate(rs.getDate("update_date"));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return userInfoDTO;
		}

//	管理者画面の購入履歴の管理者かどうか確認時使用（purchaseHistoryAction周辺）
		public int getUserDate(String loginId){
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();
			String sql = "SELECT * FROM user_info WHERE user_id = ?";
			UserInfoDTO userInfoDTO = new UserInfoDTO();
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,loginId);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					userInfoDTO.setStatus(rs.getInt("status"));
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			int status = userInfoDTO.getStatus();
			return status;
		}

	//管理者ユーザー削除用
		public int userDelete(int id){
			DBConnector db = new DBConnector();
			Connection con = db.getConnection();
			String sql = "DELETE FROM user_info WHERE id = ?";

			PreparedStatement ps;
			int result = 0;
			try{
				ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				result=ps.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return result;
		}

	//新規ユーザー登録用
	public int createUser(String familyName, String firstName, String familyNameKana,
			String firstNameKana, String sex, String email, String loginId, String password) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "insert into user_info(user_id, password, family_name, first_name, family_name_kana,"
				+ " first_name_kana, sex, email, status, logined, regist_date)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, familyName);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, familyNameKana);
			preparedStatement.setString(6, firstNameKana);
			preparedStatement.setString(7, sex);
			preparedStatement.setString(8, email);
			preparedStatement.setInt(9, 0);
			preparedStatement.setInt(10, 1);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	//新規ユーザー登録用
	public int createUserAdmin(String familyName, String firstName, String familyNameKana,
			String firstNameKana, String sex, String email, String userId, String password) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "insert into user_info(user_id, password, family_name, first_name, family_name_kana,"
				+ " first_name_kana, sex, email, status, logined, regist_date)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, familyName);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, familyNameKana);
			preparedStatement.setString(6, firstNameKana);
			preparedStatement.setString(7, sex);
			preparedStatement.setString(8, email);
			preparedStatement.setInt(9, 0);
			preparedStatement.setInt(10, 0);
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	//パスワード再設定時、ユーザーが存在してるかいないか見分ける用
	public boolean isExistsUserInfo(String loginId, String password) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		boolean result = false;
		String sql = "select count(*) as count from user_info where user_id=? and password=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				if (resultSet.getInt("count") > 0) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	//パスワード再設定時用
	public String concealPassword(String password) {
		int beginIndex = 0;
		int endIndex = 1;
		if(password.length() > 1) {
			endIndex = 2;
		}
		StringBuilder stringBuilder = new StringBuilder("****************");

		String concealPassword = stringBuilder.replace(beginIndex, endIndex, password.substring(beginIndex,endIndex)).toString();
		return concealPassword;
	}

	//パスワード再設定用
	public int resetPassword(String loginId, String password) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "update user_info set password=? , update_date=now() where user_id=?";
		int result = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, loginId);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public UserInfoDTO getUserInfo(String loginId, String password) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "select * from user_info where user_id=? and password=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				userInfoDTO.setId(resultSet.getInt("id"));
				userInfoDTO.setUserId(resultSet.getString("user_id"));
				userInfoDTO.setPassword(resultSet.getString("password"));
				userInfoDTO.setFamilyName(resultSet.getString("family_name"));
				userInfoDTO.setFirstName(resultSet.getString("first_name"));
				userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				userInfoDTO.setSex(resultSet.getInt("sex"));
				userInfoDTO.setEmail(resultSet.getString("email"));
				userInfoDTO.setStatus(resultSet.getInt("status"));
				userInfoDTO.setLogined(resultSet.getInt("status"));
				userInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;
	}

	public UserInfoDTO getUserInfo(String loginId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "select * from user_info where user_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				userInfoDTO.setId(resultSet.getInt("id"));
				userInfoDTO.setUserId(resultSet.getString("user_id"));
				userInfoDTO.setPassword(resultSet.getString("password"));
				userInfoDTO.setFamilyName(resultSet.getString("family_name"));
				userInfoDTO.setFirstName(resultSet.getString("first_name"));
				userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				userInfoDTO.setSex(resultSet.getInt("sex"));
				userInfoDTO.setEmail(resultSet.getString("email"));
				userInfoDTO.setStatus(resultSet.getInt("status"));
				userInfoDTO.setLogined(resultSet.getInt("logined"));
				userInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				userInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;
	}

	public int login(String loginId, String password) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int result=0;
		String sql = "update user_info set logined=1 where user_id=? and password=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int logout(String loginId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int result=0;
		String sql = "update user_info set logined=0 where user_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<UserInfoDTO> getSelectUserInfo(){
		List<UserInfoDTO> userInfoDtoList = new ArrayList<UserInfoDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "SELECT * FROM user_info";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				UserInfoDTO userInfoDTO = new UserInfoDTO();
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setStatus(rs.getInt("status"));
				userInfoDTO.setLogined(rs.getInt("logined"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
				userInfoDtoList.add(userInfoDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userInfoDtoList;
	}

}