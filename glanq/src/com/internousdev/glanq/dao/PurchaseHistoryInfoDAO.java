package com.internousdev.glanq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.glanq.dto.PurchaseHistoryInfoDTO;
import com.internousdev.glanq.util.DBConnector;

public class PurchaseHistoryInfoDAO {

	// 履歴の中（purchaseHistoryInfoDTOList)の確認
	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryList(String loginId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();
		//

		// sqlからデータの取り出し(phi = purchase_history_info, pi = product_info, di =
		// destination_info)
		/* ○○ as ▲▲ = ○○テーブルの名前を▲▲に変更 */
		String sql = "select" + " phi.id as id," /* ID */
				+ " phi.user_id as user_id," /* ユーザーID */
				+ " phi.product_count as product_count," /* 個数 */
				+ " pi.product_id as product_id," /* 商品ID */
				+ " pi.product_name as product_name," /* 商品名 */
				+ " pi.product_name_kana as product_name_kana," /* 商品名かな */
				+ " pi.product_description as product_description," /* 商品詳細 */
				+ " pi.category_id as category_id," /* カテゴリID */
				+ " pi.price," /* 価格 */
				+ " pi.image_file_name as image_file_name," /* 画像ファイル名 */
				+ " pi.image_file_path as image_file_path," /* 画像ファイルパス */
				+ " pi.release_company," /* 販売会社名 */
				+ " pi.release_date," /* 販売年月日 */
				+ " phi.price as price," /* 値段 */
				+ " phi.regist_date as regist_date," /* 登録日 */
				+ " phi.update_date as update_date," /* 更新日 */
				+ " di.family_name as family_name," /* 姓 */
				+ " di.first_name as first_name," /* 名 */
				+ " di.family_name_kana as family_name_kana," /* 姓かな */
				+ " di.first_name_kana as first_name_kana," /* 名かな */
				+ " di.email as email," /* メールアドレス */
				+ " di.tel_number as tel_number," /* 電話番号 */
				+ " di.user_address as user_address" /* 住所 */

				/*
				 * FROM ○○ =
				 * 場所指定。(select以降に記入したデータをpurchase_history_infoのデータを持ってくる？)
				 */
				+ " FROM purchase_history_info as phi"

				/*
				 * LEFT JOIN ○○ =
				 * 左側に○○のカラム追加(product_infoのカラムをpurchase_history_infoの左に追加)
				 */
				+ " LEFT JOIN product_info as pi"

				/*
				 * ON ○○ = ▲▲ =
				 * ○○と▲▲が同じデータだったら表示する(phiのproduct_idとpiのproduct_idが同じだったら表示する
				 */
				+ " ON phi.product_id = pi.product_id"

				/* (destination_infoのカラムをproduct_infoの左側に追加) */
				+ " LEFT JOIN destination_info as di"

				/* (phiのdestination_idとdiのidが同じだったら表示する) */
				+ " ON phi.destination_id = di.id"

				/* WHERE ○○ = 条件指定。(phiのuser_idのデータがあるものを抽出) */
				+ " WHERE phi.user_id = ?"

				/*
				 * ORDER BY ○○ DESC = 番号順表示
				 * (destination_infoのregist_dateが若い順に表示する)
				 */
				+ " ORDER BY regist_date DESC";
		//

		// データベース接続
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				PurchaseHistoryInfoDTO purchaseHistoryInfoDto = new PurchaseHistoryInfoDTO();
				/* ここから */
				purchaseHistoryInfoDto.setId(resultSet.getInt("id"));
				purchaseHistoryInfoDto.setUserId(resultSet.getString("user_id"));
				purchaseHistoryInfoDto.setProductId(resultSet.getInt("product_id"));
				purchaseHistoryInfoDto.setProductCount(resultSet.getInt("product_count"));
				purchaseHistoryInfoDto.setPrice(resultSet.getInt("price"));
				purchaseHistoryInfoDto.setRegistDate(resultSet.getDate("regist_date"));
				purchaseHistoryInfoDto.setUpdateDate(resultSet.getDate("update_date"));
				purchaseHistoryInfoDto.setProductName(resultSet.getString("product_name"));
				purchaseHistoryInfoDto.setProductNameKana(resultSet.getString("product_name_kana"));
				purchaseHistoryInfoDto.setProductDescription(resultSet.getString("product_description"));
				purchaseHistoryInfoDto.setCategoryId(resultSet.getInt("category_id"));
				purchaseHistoryInfoDto.setImageFileName(resultSet.getString("image_file_name"));
				purchaseHistoryInfoDto.setImageFilePath(resultSet.getString("image_file_path"));
				purchaseHistoryInfoDto.setReleaseCompany(resultSet.getString("release_company"));
				purchaseHistoryInfoDto.setReleaseDate(resultSet.getDate("release_date"));
				purchaseHistoryInfoDto.setFamilyName(resultSet.getString("family_name"));
				purchaseHistoryInfoDto.setFirstName(resultSet.getString("first_name"));
				purchaseHistoryInfoDto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				purchaseHistoryInfoDto.setFirstNameKana(resultSet.getString("first_name_kana"));
				purchaseHistoryInfoDto.setEmail(resultSet.getString("email"));
				purchaseHistoryInfoDto.setTelNumber(resultSet.getString("tel_number"));
				purchaseHistoryInfoDto.setUserAddress(resultSet.getString("user_address"));
				/* ここまでのデータをpurchaseHistoryInfoDtoに追加？する */
				purchaseHistoryInfoDTOList.add(purchaseHistoryInfoDto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseHistoryInfoDTOList;
	}
	//

	// 管理者機能での一覧表示の為のメソッド
	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryAllList() {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();
		String sql = "select" + " phi.id as id," /* ID */
				+ " phi.user_id as user_id," /* ユーザーID */
				+ " phi.product_count as product_count," /* 個数 */
				+ " pi.product_id as product_id," /* 商品ID */
				+ " pi.product_name as product_name," /* 商品名 */
				+ " pi.product_name_kana as product_name_kana," /* 商品名かな */
				+ " pi.product_description as product_description," /* 商品詳細 */
				+ " pi.category_id as category_id," /* カテゴリID */
				+ " pi.price," /* 価格 */
				+ " pi.image_file_name as image_file_name," /* 画像ファイルパス */
				+ " pi.image_file_path as image_file_path," /* 画像ファイル名 */
				+ " pi.release_company," /* 発売会社名 */
				+ " pi.release_date," /* 発売年月日 */
				+ " phi.price as price," /* 値段 */
				+ " phi.regist_date as regist_date," /* 登録日 */
				+ " phi.update_date as update_date," /* 更新日 */
				+ " di.family_name as family_name," /* 姓 */
				+ " di.first_name as first_name," /* 姓 */
				+ " di.family_name_kana as family_name_kana," /* 姓かな */
				+ " di.first_name_kana as first_name_kana," /* 名かな */
				+ " di.email as email," /* メールアドレス */
				+ " di.tel_number as tel_number," /* 電話番号 */
				+ " di.user_address as user_address" /* 住所 */
				+ " FROM purchase_history_info as phi"// purchase_historyの省略
				+ " LEFT JOIN product_info as pi"// product_infoの省略
				+ " ON phi.product_id = pi.product_id"// product_idの一致
				+ " LEFT JOIN destination_info as di"// ここいるかな？
														// destination_infoの省略
				+ " ON phi.destination_id = di.id" + " ORDER BY regist_date DESC";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				PurchaseHistoryInfoDTO purchaseHistoryInfoDto = new PurchaseHistoryInfoDTO();
				purchaseHistoryInfoDto.setId(resultSet.getInt("id"));
				purchaseHistoryInfoDto.setUserId(resultSet.getString("user_id"));
				purchaseHistoryInfoDto.setProductId(resultSet.getInt("product_id"));
				purchaseHistoryInfoDto.setProductCount(resultSet.getInt("product_count"));
				purchaseHistoryInfoDto.setPrice(resultSet.getInt("price"));
				purchaseHistoryInfoDto.setRegistDate(resultSet.getDate("regist_date"));
				purchaseHistoryInfoDto.setUpdateDate(resultSet.getDate("update_date"));
				purchaseHistoryInfoDto.setProductName(resultSet.getString("product_name"));
				purchaseHistoryInfoDto.setProductNameKana(resultSet.getString("product_name_kana"));
				purchaseHistoryInfoDto.setProductDescription(resultSet.getString("product_description"));
				purchaseHistoryInfoDto.setCategoryId(resultSet.getInt("category_id"));
				purchaseHistoryInfoDto.setImageFileName(resultSet.getString("image_file_name"));
				purchaseHistoryInfoDto.setImageFilePath(resultSet.getString("image_file_path"));
				purchaseHistoryInfoDto.setReleaseCompany(resultSet.getString("release_company"));
				purchaseHistoryInfoDto.setReleaseDate(resultSet.getDate("release_date"));
				purchaseHistoryInfoDto.setFamilyName(resultSet.getString("family_name"));
				purchaseHistoryInfoDto.setFirstName(resultSet.getString("first_name"));
				purchaseHistoryInfoDto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				purchaseHistoryInfoDto.setFirstNameKana(resultSet.getString("first_name_kana"));
				purchaseHistoryInfoDto.setEmail(resultSet.getString("email"));
				purchaseHistoryInfoDto.setTelNumber(resultSet.getString("tel_number"));
				purchaseHistoryInfoDto.setUserAddress(resultSet.getString("user_address"));
				purchaseHistoryInfoDTOList.add(purchaseHistoryInfoDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseHistoryInfoDTOList;
	}

	// データの追加
	public int regist(String loginId, int productId, int productCount, int destinationId, int price) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		/* purchase_history_infoに()を追加 */
		String sql = "insert into purchase_history_info(user_id, product_id, product_count, price, destination_id, regist_date, update_date) values (?, ?, ?, ?, ?, now(), '0000-01-01')";
		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, productCount);
			preparedStatement.setInt(4, price);
			preparedStatement.setInt(5, destinationId);

			/* count = 更新回数 */
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
	//

	// データ削除
	public int deleteAll(String loginId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		/* purchase_history_infoのuser_idにデータがあれば削除 */
		String sql = "delete from purchase_history_info where user_id=?";
		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);

			/* count = 更新回数 */
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


	// 特定の商品IDを持つ購入履歴を全て削除
	public int deleteBasedonPid(String product_id){
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		/* purchase_history_infoのproduct_idに該当するデータがあれば削除 */
		String sql = "delete from purchase_history_info where product_id=?";
		int count = 0;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product_id);

			/* count = 更新回数 */
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
}
