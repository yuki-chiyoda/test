package com.internousdev.glanq.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.MCategoryDAO;
import com.internousdev.glanq.dao.ProductInfoDAO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.internousdev.glanq.dto.PaginationDTO;
import com.internousdev.glanq.dto.ProductInfoDTO;
import com.internousdev.glanq.util.InputChecker;
import com.internousdev.glanq.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware {
	private String categoryId;
	private String keywords;
	private String pageNo;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute() throws SQLException {
		String result = "admin";
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		result = ERROR;
		InputChecker inputChecker = new InputChecker();

		// 検索ワードが"null"の時、空文字を挿入
		if (keywords == null) {
			keywords = "";
		}

		// 入力された情報を"InputChecker"を用いて有効であるかチェック
		keywordsErrorMessageList = inputChecker.docheck("検索ワード", keywords, 0, 6, true, true, true, true, false, true,
				true);
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();

		// カテゴリーID１が選択された時、検索は全商品の中から行われる
		// カテゴリーIDが２，３、または４が選択された時、検索はそれぞれのカテゴリーの中から行われる
		// 商品一覧ページで開いた際のカテゴリー未指定をelseで処理

		if ("1".equals(categoryId)) {
			productInfoDtoList = productInfoDAO.getProductInfoListAll(keywords.replaceAll("　", " ").split(" "));
			result = SUCCESS;
		} else if ("2".equals(categoryId) || "3".equals(categoryId) || "4".equals(categoryId)) {
			productInfoDtoList = productInfoDAO.getProductInfoListByKeywords(keywords.replaceAll("　", " ").split(" "),
					categoryId);
			result = SUCCESS;
		} else {
			productInfoDtoList = productInfoDAO.getProductInfoListAll(keywords.replaceAll("　", " ").split(" "));
			result = SUCCESS;
		}

		// iteratorメソッドを用いてリスト内のデータを順次参照し
		// 次のデータがなくなったとき空データ"null"を挿入
		Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();
		if (!(iterator.hasNext())) {
			productInfoDtoList = null;
		}
		session.put("keywordsErrorMessageList", keywordsErrorMessageList);

		// session内に"MCategoryList"が存在しない場合
		if (!session.containsKey("mCategoryList")) {

			// "mCategoryDaoList"にmCategoryDTOListの値を格納
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		// "productInfoDtoList"が"null"でない場合で次のif文へと移行し
		// "pageNo"が"nuLL"であれば1ページ目の、
		// そうでない場合は任意のページ情報を取得
		if (!(productInfoDtoList == null)) {
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO = new PaginationDTO();

			if (pageNo == null) {
				paginationDTO = pagination.initialize(productInfoDtoList, 9);
			} else {
				int pageNO = Integer.parseInt(pageNo);
				paginationDTO = pagination.getPage(productInfoDtoList, 9, (pageNO));
			}

			// sessionに各データを追加
			session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());
			session.put("totalPageSize", paginationDTO.getTotalPageSize());
			session.put("currentPageNo", paginationDTO.getCurrentPageNo());
			session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
			session.put("startRecordNo", paginationDTO.getStartRecordNo());
			session.put("endRecordNo", paginationDTO.getEndRecordNo());
			session.put("previousPage", paginationDTO.isHasPreviousPage());
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());
			session.put("nextPage", paginationDTO.isHasNextPage());
			session.put("nextPageNo", paginationDTO.getNextPageNo());
		}

		// 前述のif文において"productInfoDtoList"が"null"であった場合は
		// "productInfoDTOList"のsession内に"null"を格納
		else {
			session.put("productInfoDtoList", null);
		}
		return result;
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

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategorytoOList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public List<String> getKeywordsErrorMessageList() {
		return keywordsErrorMessageList;
	}

	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList) {
		this.keywordsErrorMessageList = keywordsErrorMessageList;
	}

	public List<ProductInfoDTO> getProductInfoDtoList() {
		return productInfoDtoList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDtoList) {
		this.productInfoDtoList = productInfoDtoList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
