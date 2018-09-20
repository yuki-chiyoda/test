package com.internousdev.glanq.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {
		// 他ページに飛んだあともエラーメッセージが残らないように、
		// セッションからはずす

		String result = ERROR;
		String token = String.valueOf(session.get("token"));
		if (token == "admin") {
			result = "admin";
			return result;
		}

		session.remove("loginIdErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("loginErrorMessageList");

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

}
