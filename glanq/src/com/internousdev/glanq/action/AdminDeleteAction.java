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

public class AdminDeleteAction extends ActionSupport implements SessionAware {

	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private int price;
	private String categoryId;
	private String keywords;
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

		session.remove("checkListErrorMessageList");

		ProductInfoDAO productInfoDao = new ProductInfoDAO();
		productInfoDtoList = productInfoDao.getProductInfoList();

		// session内にmCategoryListが無いか確認
		if (!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		if (!(productInfoDtoList == null)) {
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO = new PaginationDTO();
			if (pageNo == 0) { // pageNoが0の場合1ページ目
				paginationDTO = pagination.initialize(productInfoDtoList, 9);
			} else { // そうでない場合、任意のページ
				paginationDTO = pagination.getPage(productInfoDtoList, 9, pageNo);
			}
			session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage()); // ページ情報の取得
			session.put("totalPageSize", paginationDTO.getTotalPageSize());
			session.put("currentPageNo", paginationDTO.getCurrentPageNo());
			session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
			session.put("startRecordNo", paginationDTO.getStartRecordNo());
			session.put("endRecordNo", paginationDTO.getEndRecordNo());
			session.put("previousPage", paginationDTO.isHasPreviousPage());
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());
			session.put("nextPage", paginationDTO.isHasNextPage());
			session.put("nextPageNo", paginationDTO.getNextPageNo());
			session.put("pageNumberList", paginationDTO.getPageNumberList());
			session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());

		} else { // そうでない場合、productInfoDAOにnull格納
			session.put("productInfoDtoList", null);
		}
		result = SUCCESS;
		return result;
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

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public List<ProductInfoDTO> getProductInfoDtoList() {
		return productInfoDtoList;
	}

	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList) {
		this.productInfoDtoList = productInfoDtoList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
}