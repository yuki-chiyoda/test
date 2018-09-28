package com.internousdev.kiyurumi.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.util.Map;

import com.internousdev.kiyurumi.dao.ProductInfoDAO;
import com.internousdev.kiyurumi.dto.ProductInfoDTO;
import com.internousdev.kiyurumi.dto.MCategoryDTO;

public class ProductDetailsAction extends ActionSupport implements SessionAware{
	private int productId;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private String categoryId;
	private Map<String, Object> session;

	public String execute(){
			String result = ERROR;
			ProductInfoDAO productInfoDAO = new ProductInfoDAO();
			ProductInfoDTO productInfoDTO = new ProductInfoDTO();
			productInfoDTO = productInfoDAO.getItemDetailsInfo(productId);
			session.put("id", productInfoDTO.getId());
			session.put("productId", productInfoDTO.getProductId());
			session.put("productName", productInfoDTO.getProductName());
			session.put("productNameKana", productInfoDTO.getProductNameKana());
			session.put("imageFilePath", productInfoDTO.getImageFilePath());
			session.put("imageFileName", productInfoDTO.getImageFileName());
			session.put("price", productInfoDTO.getPrice());
			session.put("birthDate", productInfoDTO.getBirthDate());
			session.put("birthPlace", productInfoDTO.getBirthPlace());
			session.put("productDescription", productInfoDTO.getProductDescription());

			//購入個数を表示する
			List<Integer> productCountList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
			session.put("productCountList",productCountList);

			//商品詳細の下にランダムで同カテゴリーの商品を表示
			//詳細を押したときに、当該カテゴリーIDとプロダクトIDをDAOに引き渡す。
			productInfoDtoList = productInfoDAO.getItemInfoRandomListByCategoryId(productInfoDTO.getCategoryId(), productInfoDTO.getProductId(), 0, 3);
			Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();
			if(!(iterator.hasNext())){
			productCountList = null;
			}
			if(!productInfoDtoList.isEmpty() || productCountList == null) {
				session.put("productInfoDtoList", productInfoDtoList);
				result = SUCCESS;
			}
			return result;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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


}
