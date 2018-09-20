package com.internousdev.glanq.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.glanq.dao.CartInfoDAO;
import com.internousdev.glanq.dao.DestinationInfoDAO;
import com.internousdev.glanq.dao.MCategoryDAO;
import com.internousdev.glanq.dao.UserInfoDAO;
import com.internousdev.glanq.dto.DestinationInfoDTO;
import com.internousdev.glanq.dto.MCategoryDTO;
import com.internousdev.glanq.dto.UserInfoDTO;
import com.internousdev.glanq.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String categoryId;
	private String loginId;
	private String password;
	private boolean savedLoginId;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> loginErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;

	private String goLocationFlg;

	public String execute() {

		String result = ERROR;
		//tokenにadminが入っていたら、admin画面へ
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		// セッションに格納したメッセージをはずす
		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("loginErrorMessageList");

		// 「ログインID保存」のチェックボックスに使う
		// trueの場合sessionに格納
		if (savedLoginId == true) {
			session.put("savedLoginId", true);
			session.put("saveId", loginId);

			// それ以外はsessionからはずす
		} else {
			session.put("savedLoginId", false);
			session.remove("saveId", loginId);
		}

		// 正規表現検証(質問の内容,値,最小文字数,最大文字数,半角数字,漢字,ひらがな,半角数字,半角記号,カタカナ,全角記号)
		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.docheck("ログインID", loginId, 1, 8, true, false, false, true, false, false,
				false);
		passwordErrorMessageList = inputChecker.docheck("パスワード", password, 1, 16, true, false, false, true, false,
				false, false);

		// ヘッダーのカテゴリーがおかしくならないようにするため必要
		if (!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDtoList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		// ユーザーが存在していて、
		if (userInfoDAO.isExistsUserInfo(loginId, password)) {

			// ログインが成功していたら、
			if (userInfoDAO.login(loginId, password) > 0) {

				// ユーザー情報を取得し、
				UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(loginId, password);
				// ユーザーID, status をセッションに格納
				session.put("loginId", userInfoDTO.getUserId());
				session.put("status", userInfoDTO.getStatus());
				int count = 0;

				String sta = String.valueOf(session.get("status"));
				// statusに1が入っていたら、管理者画面へ
				if (sta.equals("1")) {
					result = "admin";
					token = "admin";
					session.put("token", token);
					session.put("logined", 1);
					return result;
				}

				CartInfoDAO cartInfoDAO = new CartInfoDAO();

				count = cartInfoDAO.linkToLoginId(String.valueOf(session.get("tempUserId")), loginId);
				// 仮IDが発行されていたら、
				if (count > 0) {
					DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();

					try {
						List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();
						// 宛先情報を取得し、Listに格納
						destinationInfoDtoList = destinationInfoDAO.getDestinationInfo(loginId);
						Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
						// Listに格納した要素を順番に処理をし、要素がなくなったら、
						if (!(iterator.hasNext())) {
							// Listにnullを入れる(。)
							destinationInfoDtoList = null;
						}
						// セッションにListを格納
						session.put("destinationInfoDtoList", destinationInfoDtoList);

					} catch (SQLException e) {
						e.printStackTrace();
					}

					//LocationOptionAction から来ているかどうかの判定を行う。
					if (!(goLocationFlg == null)) {
						if (goLocationFlg.equals("true")) {

							String settlementToken = "canSettlement";
							session.put("settlementToken", settlementToken);

							session.put("logined", 1);
							//前回ログイン時、カートに商品を残していた場合は更新されたカート画面に戻す。
							if(!session.containsKey("cartInfoDAO")){
								result = "cart";
								return result;
						                 }
							// 確認されたら、ログイン状態に変更した上でlocationOption画面へと進ませる。
							result = "locationOption";

							return result;
						}

					}

				}
				// ログイン成功 ＆ 途中のreturnで拾われていなければ、結果はSUCCESS(ホーム画面へ)
				result = SUCCESS;
			}

			// セッションにログインフラグを格納
			session.put("logined", 1);

			// ユーザーが存在しない場合、エラーメッセージを格納
		} else {
			loginErrorMessageList.add("入力されたパスワードが異なります。");
		}

		// ログインIDとパスワード両方にエラーメッセージが入った場合、
		// エラーメッセージを格納、ログインフラグを降ろす
		if (loginIdErrorMessageList.size() != 0 || passwordErrorMessageList.size() != 0
				|| loginErrorMessageList.size() != 0) {
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("loginErrorMessageList", loginErrorMessageList);
			session.put("logined", 0);
		}

		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getSavedLoginId() {
		return savedLoginId;
	}

	public void setSavedLoginId(boolean savedLoginId) {
		this.savedLoginId = savedLoginId;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public Map<String, Object> session() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getGoLocationFlg() {
		return goLocationFlg;
	}

	public void setGoLocationFlg(String goLocationFlg) {
		this.goLocationFlg = goLocationFlg;
	}

}
