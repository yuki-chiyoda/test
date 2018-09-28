package com.internousdev.kiyurumi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.kiyurumi.dto.ProductInfoDTO;
import com.internousdev.kiyurumi.util.DBConnector;

public class ProductInfoDAO {

	//管理者用商品ID重複チェック メソッド名「checkProductId」木村//
	public int checkProductId(int productId){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="select count(*) as count from product_info where product_id=?";

		int count = 0;
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
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

	//管理者用商品商品名重複チェック メソッド名「checkProductName」木村//
	public int checkProductName(String productName){

		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="select count(*) as count from product_info where product_name=?";

		int count = 0;
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
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

//	管理者画面商品IDのMAX取得　木村
	public int checkProductIdMAX(){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="SELECT MAX(product_id) FROM product_info";

		int max = 0;

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setProductId(resultSet.getInt("MAX(product_id)"));
				max = dto.getProductId();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return max;
	}

	//管理者用商品一覧 メソッド名「itemAllList」//
	public List<ProductInfoDTO> itemAllList(){

		List<ProductInfoDTO> productInfoDTOList=new ArrayList<ProductInfoDTO>();
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();

		String sql="SELECT * FROM product_info";
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			ResultSet resultSet=preparedStatement.executeQuery();
			while(resultSet.next()){
				ProductInfoDTO dto=new ProductInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setProductId(resultSet.getInt("product_id"));
				dto.setProductName(resultSet.getString("product_name"));
				dto.setProductNameKana(resultSet.getString("product_name_kana"));
				dto.setProductDescription(resultSet.getString("product_description"));
				dto.setCategoryId(resultSet.getInt("category_id"));
				dto.setPrice(resultSet.getInt("price"));
				dto.setImageFilePath(resultSet.getString("image_file_path"));
				dto.setImageFileName(resultSet.getString("image_file_name"));
				dto.setBirthDate(resultSet.getString("birth_date"));
				dto.setBirthPlace(resultSet.getString("birth_place"));
				dto.setStatus(resultSet.getInt("status"));
				dto.setRegistDate(resultSet.getDate("regist_date"));
				dto.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDTOList.add(dto);
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDTOList;
	}

	//管理者用商品追加 メソッド名「itemCreate」//
	public int itemCreate(int productId,String productName,String productNameKana,String productDescription,int categoryId,int price,String imageFilePath,String imageFileName,String birthDate,String birthPlace,int status){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql=
				"INSERT INTO product_info(product_id,product_name,product_name_kana,product_description,category_id,price,image_file_path,image_file_name,birth_date,birth_place,status,regist_date) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,now())";
		int count=0;

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,productId);
			preparedStatement.setString(2,productName);
			preparedStatement.setString(3,productNameKana);
			preparedStatement.setString(4,productDescription);
			preparedStatement.setInt(5,categoryId);
			preparedStatement.setInt(6,price);
			preparedStatement.setString(7,imageFilePath);
			preparedStatement.setString(8,imageFileName);
			preparedStatement.setString(9,birthDate);
			preparedStatement.setString(10,birthPlace);
			preparedStatement.setInt(11,status);

			count=preparedStatement.executeUpdate();
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

	//管理者用商品更新 メソッド名「itemUpdate」 紐付けは「id」で//
	public int itemUpdate(String productName,String productNameKana,String productDescription,int categoryId,int price,
			String imageFilePath,String imageFileName,String birthDate,String birthPlace,int id){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql=
				"UPDATE product_info SET product_name=?,product_name_kana=?,product_description=?,category_id=?,price=?,image_file_path=?,image_file_name=?,birth_date=?,birth_place=?,update_date=now() WHERE id=?";

		PreparedStatement preparedStatement;
		int count=0;
		try{
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,productName);
			preparedStatement.setString(2,productNameKana);
			preparedStatement.setString(3,productDescription);
			preparedStatement.setInt(4,categoryId);
			preparedStatement.setInt(5,price);
			preparedStatement.setString(6,imageFilePath);
			preparedStatement.setString(7,imageFileName);
			preparedStatement.setString(8,birthDate);
			preparedStatement.setString(9,birthPlace);
			preparedStatement.setInt(10,id);
			count=preparedStatement.executeUpdate();
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

	//管理者用商品更新用1件取得メソッド名「itemDetail」 紐付けは「id」で//
	public ProductInfoDTO itemDetail(int id){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql=
				"SELECT * FROM product_info WHERE id=?";
		ProductInfoDTO productInfoDTO=new ProductInfoDTO();
		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()){
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setBirthDate(resultSet.getString("birth_date"));
				productInfoDTO.setBirthPlace(resultSet.getString("birth_place"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDTO;
	}

	//管理者用商品削除 メソッド名「itemDelete」 紐付けは「id」で//
	public int itemDelete(int id){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql=
				"DELETE FROM product_info WHERE id=?";
		PreparedStatement preparedStatement;
		int result=0;
		try{
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			result=preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	//商品一覧画面
	//商品一覧表示・塚澤。
	public List<ProductInfoDTO> getItemInfoList() {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductInfoDTO productInfoDto = new ProductInfoDTO();
				productInfoDto.setId(resultSet.getInt("id"));
				productInfoDto.setProductId(resultSet.getInt("product_id"));
				productInfoDto.setProductName(resultSet.getString("product_name"));
				productInfoDto.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDto.setProductDescription(resultSet.getString("product_description"));
				productInfoDto.setCategoryId(resultSet.getInt("category_id"));
				productInfoDto.setPrice(resultSet.getInt("price"));
				productInfoDto.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDto.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDto.setBirthDate(resultSet.getString("birth_date"));
				productInfoDto.setBirthPlace(resultSet.getString("birth_place"));
				productInfoDto.setStatus(resultSet.getInt("status"));
				productInfoDto.setUpdateDate(resultSet.getDate("regist_date"));
				productInfoDto.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	//商品詳細画面//
	//商品詳細を読み込む。塚澤//
	public ProductInfoDTO getItemDetailsInfo(int productId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		String sql = "select * from product_info where product_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();
			/*一つしか情報を持ってこないため、今回はwhileを使わない。
			 また、リストも作る必要がない。*/
			if (resultSet.next()) {
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setBirthDate(resultSet.getString("birth_date"));
				productInfoDTO.setBirthPlace(resultSet.getString("birth_place"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setUpdateDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDTO;
	}

	//商品詳細画面
	//下部にランダムで同じカテゴリーの別商品を3つまで反映。塚澤//
	public List<ProductInfoDTO> getItemInfoRandomListByCategoryId(int categoryId, int productId,
		int limitOffset, int limitRowCount) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
		//カテゴリーID以外はアクションからもらった値ではないプロダクトIDを持ってくる
		String sql = "select * from product_info where category_id=? and product_id not in(?) "
				+ "order by rand() limit ?,?";
		try{
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, productId);
			ps.setInt(3, limitOffset);
			ps.setInt(4, limitRowCount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(rs.getInt("id"));
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setBirthDate(rs.getString("birth_date"));
				productInfoDTO.setBirthPlace(rs.getString("birth_place"));
				productInfoDTO.setStatus(rs.getInt("status"));
				productInfoDTO.setRegistDate(rs.getDate("regist_date"));
				productInfoDTO.setUpdateDate(rs.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	//カテゴリー「全国」
	//キーワード検索。塚澤//
	public List<ProductInfoDTO> getProductInfoListAll(String[] keywordsList) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where";
		boolean initializeFlag = true;
		for (String keyword : keywordsList) {
			if (initializeFlag) {
				sql += " (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%' or birth_place like '%"+ keyword + "%')";
				initializeFlag = false;
			} else {
				sql += " or (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%' or birth_place like '%"+ keyword + "%')";
			}
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setBirthDate(resultSet.getString("birth_date"));
				productInfoDTO.setBirthPlace(resultSet.getString("birth_place"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setUpdateDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

	//カテゴリー「全国」以外
	//キーワード検索。塚澤。//
	public List<ProductInfoDTO> getProductInfoListByKeywords(String[] keywordsList, String categoryId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
		String sql = "select * from product_info where";
		int initializeFlag = 1;
		for (String keyword : keywordsList) {
			if (initializeFlag==1) {
				sql += " category_id=" + categoryId + " and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%' or birth_place like '%"+ keyword + "%')";
				initializeFlag++;
			} else if(initializeFlag >= 2) {
				sql += " or"+" category_id=" + categoryId +" and (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%' or birth_place like '%"+ keyword + "%')";
			}
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setBirthDate(resultSet.getString("birth_date"));
				productInfoDTO.setBirthPlace(resultSet.getString("birth_place"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setUpdateDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productInfoDtoList;
	}

}
