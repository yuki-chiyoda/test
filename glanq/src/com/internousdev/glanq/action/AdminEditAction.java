package com.internousdev.glanq.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.MCategoryDAO;
import com.internousdev.glanq.dao.ProductInfoDAO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.internousdev.glanq.dto.PaginationDTO;
import com.internousdev.glanq.dto.ProductInfoDTO;
import com.internousdev.glanq.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class AdminEditAction extends ActionSupport implements SessionAware {
	// 情報を受け取る為の変数の定義（商品情報）
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private String categoryId;

	/// SearchItemAction追加（ページ情報）
	private int pageNo;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute() throws SQLException {
		// ステータスが１の時だけAdmin.jspを表示させる。
		String result = "errorhome";
		String token = String.valueOf(session.get("token"));
		if (token != "admin") {
			return result;
		}

		result = ERROR;

		ProductInfoDAO productInfoDao = new ProductInfoDAO();
		productInfoDtoList = productInfoDao.getProductInfoList();

		// キーが存在するか確認
		if (!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		// ★SearchItemActionから一部抜粋
		if (!(productInfoDtoList == null)) {
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO = new PaginationDTO();
			if (pageNo == 0) {
				paginationDTO = pagination.initialize(productInfoDtoList, 9);
			} else {
				paginationDTO = pagination.getPage(productInfoDtoList, 9, pageNo);
			}
			// ページ情報をsessionに格納
			session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());
			session.put("totalPageSize", paginationDTO.getTotalPageSize());// 全ページ数
			session.put("currentPageNo", paginationDTO.getCurrentPageNo());// 現在のページ数
			session.put("totalRecordSize", paginationDTO.getTotalRecordSize());// 総レコード数
			session.put("startRecordNo", paginationDTO.getStartRecordNo());// 開始のレコード数
			session.put("endRecordNo", paginationDTO.getEndRecordNo());// 終了のレコード数
			session.put("previousPage", paginationDTO.isHasPreviousPage());// 前ページが存在するか
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());// 前ページの番号
			session.put("nextPage", paginationDTO.isHasNextPage());// 次ページが存在するか
			session.put("nextPageNo", paginationDTO.getNextPageNo());// 次ページの番号
			session.put("pageNumberList", paginationDTO.getPageNumberList()); // ページ番号リスト
			session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());// 1ページ分の商品情報

		} else {
			session.put("productInfoDtoList", null);
		}
		// ★ここまで

		result = SUCCESS;

		return result;

	}

	// 商品情報のゲッターセッター.
	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<ProductInfoDTO> getProductInfoDtoList() {
		return productInfoDtoList;
	}

	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList) {
		this.productInfoDtoList = productInfoDtoList;
	}

	// SearchItemActionから追加（ページ情報）
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
