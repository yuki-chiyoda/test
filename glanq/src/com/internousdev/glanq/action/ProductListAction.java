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

public class ProductListAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private Pagination pagination = new Pagination();
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private String categoryId;
	// private String keywords;
	private String pageNo = "1"; // 念のため。

	public String execute() throws SQLException {
		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		// 管理者ログイン状態の対策
		if (session.containsKey("status")) {
			if ((session.get("status")).equals("1")) {
				session.clear();
			}
		}

		// すべての商品情報を取得。
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		List<ProductInfoDTO> productInfoListAll = productInfoDAO.getProductInfoList();
		session.put("productInfoListAll", productInfoListAll); // 予備（未使用）

		// ページ情報を取得。上で得た商品情報productInfoListAllを利用。1ページあたりの表示数9に設定。
		int pageSize = 9;
		PaginationDTO paginationDTO = pagination.initialize(productInfoListAll, pageSize);
		session.put("totalPageSize", paginationDTO.getTotalPageSize());
		session.put("currentPageNo", paginationDTO.getCurrentPageNo());
		session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
		session.put("startRecordNo", paginationDTO.getStartRecordNo());
		session.put("endRecordNo", paginationDTO.getEndRecordNo());
		session.put("pageNumberList", paginationDTO.getPageNumberList());
		session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage()); // これが大事。
		session.put("hasNextPage", paginationDTO.isHasNextPage());
		session.put("hasPreviousPage", paginationDTO.isHasPreviousPage());
		session.put("nextPageNo", paginationDTO.getNextPageNo());
		session.put("previousPageNo", paginationDTO.getPreviousPageNo());

		// セッション mCategoryDtoList はヘッダーにて用いているので、無い場合は必要。（mCategoryList??）
		if (!session.containsKey("mCategoryDtoList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		// セッションlogined はヘッダーにて用いているので、無い場合は非ログイン状態として0を入れる。
		if (!session.containsKey("logined")) {
			session.put("logined", 0);
		}

		result = SUCCESS;

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	// public String getKeywords() {
	// return keywords;
	// }
	//
	// public void setKeywords(String keywords) {
	// this.keywords = keywords;
	// }

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
}
