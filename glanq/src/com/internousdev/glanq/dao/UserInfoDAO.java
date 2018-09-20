
package com.internousdev.glanq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.glanq.dto.UserInfoDTO;
import com.internousdev.glanq.util.DBConnector;

public class UserInfoDAO {

	/**
	 * このDAOで行う処理はuser_infoに関するもの 主にユーザー情報やパスワードに関するもの 処理内容は ①情報登録用メソッド(戻り値：int
	 * 更新件数) ②情報確認用メソッド 引数(ログインID、パスワード)(戻り値：boolean) ③情報確認用メソッド 引数(ログインID)
	 * (戻り値：boolean) ③情報取得用メソッド 引数(ログインID、パスワード) (戻り値：UserInfoDTO) ④情報確認用メソッド
	 * 引数(ログインID) (戻り値：UserInfoDTO) ⑤パスワードリセット用メソッド (戻り値：int 更新件数) ⑥ログイン用メソッド
	 * (戻り値：int 更新件数) ⑦ログアウト用メソッド (戻り値int 更新件数) ⑧パスワード隠匿用メソッド (戻り値：String
	 * 隠匿されたパスワード)
	 */

	// ユーザー登録用メソッド
	public int createUser(String loginId, String password, String familyName, String firstName, String familyNameKana,
			String firstNameKana, String sex, String email) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		/**
		 * JSPから渡された値 名前、性別、ログインIDなどを INSERT文を用いてDBに登録
		 */

		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, status, logined, regist_date, update_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), now())";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setString(7, sex);
			ps.setString(8, email);
			ps.setInt(9, 0);
			ps.setInt(10, 1);
			count = ps.executeUpdate();
			// 実行結果をint型で戻す

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// ユーザーがいるかどうかの判定用メソッド(ログインID、パスワード)
	public boolean isExistsUserInfo(String loginId, String password) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;

		/**
		 * ユーザーIDとパスワードを元に 該当するカラムが存在するかを COUNT文を用いて調べる
		 */

		String sql = "SELECT COUNT(*) AS count FROM user_info WHERE user_id = ? AND password = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getInt("count") > 0) {
					result = true;
				}
			}

			// 実行の結果 countカラムが一件以上存在すればtrueを返す

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	// ユーザーがいるかどうかの判定用メソッド(ログインID)
	public boolean isExistsUserInfo(String loginId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;

		/**
		 * ユーザーIDを元に 該当するカラムが存在するかを COUNT文を用いて調べる
		 */

		String sql = "SELECT COUNT(*) AS count FROM user_info WHERE user_id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getInt("count") > 0) {
					result = true;
				}
			}

			// 実行の結果 countカラムが一件以上存在すればtrueを返す

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	// ユーザー情報取得メソッド(ユーザーID、パスワード)
	public UserInfoDTO getUserInfo(String loginId, String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		/**
		 * ユーザーIDとパスワードを元に SELECT文を用いて データをすべてDTOに格納する
		 */

		String sql = "SELECT * FROM user_info WHERE user_id = ? AND password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setLogined(rs.getInt("logined"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;
	}

	// ユーザー情報取得用メソッド(ユーザーID)
	public UserInfoDTO getUserInfo(String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		/**
		 * ユーザーIDを元に SELECT文を用いて すべての情報をDTOに格納する
		 */

		String sql = "SELECT * FROM user_info WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setLogined(rs.getInt("logined"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;

	}

	// パスワード再設定用メソッド
	public int resetPassword(String userId, String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		/**
		 * ユーザーIDとパスワードを元に 該当するユーザーのパスワードを UPDATE文を用いて 更新する
		 */

		String sql = "UPDATE user_info SET password = ? WHERE user_id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, userId);
			count = ps.executeUpdate();

			// 実行の結果をcountに代入

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// ログイン用メソッド
	public int login(String loginId, String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		/**
		 * ユーザーIDとパスワードを元に UPDATE文を用いて DBのloginedの値を1に更新する
		 */

		String sql = "UPDATE user_info SET logined = 1 WHERE user_id = ? AND password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;

	}

	// ログアウト用メソッド
	public int logout(String loginId, String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count = 0;

		/**
		 * ユーザーIDとパスワードを元に UPDATE文を用いて DBのloginedの値を0に更新する
		 */

		String sql = "UPDATE user_info SET logined = 0 WHERE user_id = ? AND password = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// パスワード隠匿用のメソッド
	public String concealPassword(String password) {

		/**
		 * 引数として渡された値（パスワード）を 一度すべて「*」に置き換え その後、最初の数文字をパスワードに置き換えて表示する
		 * 例を挙げると「○○**************」 のようにする
		 */

		int beginIndex = 0;
		int endIndex = 1;
		if (password.length() > 1) {
			endIndex = 2;
		}

		StringBuilder stringBuilder = new StringBuilder("****************");
		/**
		 * StringBuilderは文字列置換用のクラス ココに16文字分の「＊」を引数として渡す
		 */

		String concealPassword = (stringBuilder.replace(beginIndex, endIndex, password.substring(beginIndex, endIndex))
				.toString());
		return concealPassword;

		/**
		 * StringBuilderクラスのreplaceメソッドを利用することで文字列の置換が可能 replace(int a, int b,
		 * String s)で a番目～b番目の文字をsに置き換えることが出来る
		 *
		 * .substringメソッドは呼び出したメソッドの一部を取得するためのメソッド .substring(int beginIndex,
		 * int endIndex)で何文字目から何文字目までという指定が可能 今回は頭の2文字目ぐらいまでをパスワードのものと置き換える
		 * 頭の2文字ぐらいを表示して後は**に置き換えることが出来る
		 */

	}

	/* AdminAllSelectActionで使う用 */
	/* user_infoテーブルから全てのデータを抜き出してUserInfoDTOListを作成する */
	public List<UserInfoDTO> getUserInfoAllList() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		List<UserInfoDTO> userInfoDtoList = new ArrayList<UserInfoDTO>();

		String sql = "SELECT * FROM user_info";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
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
				userInfoDTO.setLogined(rs.getInt("logined"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
				userInfoDtoList.add(userInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDtoList;

	}

}
