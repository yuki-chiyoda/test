<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="./css/style.css">




		<title>ユーザー情報入力</title>
	</head>
	<body>

		<!-- ヘッダー -->
		<jsp:include page="header.jsp" />
		<div id="contents">

			<div class="lock">

					<h1>ユーザー情報入力画面</h1>


					<!-- エラーメッセージがあれば表示したい -->
					<!-- まず姓 -->
					<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- 名 -->
					<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- 姓かな -->
					<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- 名かな -->
					<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- メールアドレス -->
					<s:if test="!#session.emailErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- ログインID -->
					<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.loginIdErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>

					<!-- パスワード -->
					<s:if test="!#session.passwordErrorMessageList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>


					<!-- ログインIDが使用されている場合はエラーメッセージ表示 -->
					<s:if test="!#session.duplicateList.isEmpty()">
					<div class="error">
						<div class="error-message">
							<s:iterator value="#session.duplicateList"><s:property /><br></s:iterator>
						</div>
					</div>
					</s:if>



					<!-- ここから送信フォーム -->
		<s:form action="CreateUserConfirmAction">
				<table class="vertical-list-table">
					<tr>
						<th scope="row">姓</th>
						<td><s:textfield name="familyName" value="%{#session.familyName}" label="姓" placeholder="姓" class="txt" /></td>
					</tr>

					<tr>
						<th scope="row">名</th>
						<td><s:textfield name="firstName" value="%{#session.firstName}" label="名" placeholder="名" class="txt" /></td>
					</tr>

					<tr>
						<th scope="row">姓ふりがな</th>
						<td><s:textfield name="familyNameKana" value="%{#session.familyNameKana}" label="姓ふりがな" placeholder="姓ふりがな" class="txt" /></td>
					</tr>

					<tr>
						<th scope="row">名ふりがな</th>
						<td><s:textfield name="firstNameKana" value="%{#session.firstNameKana}" label="名ふりがな" placeholder="名ふりがな" class="txt" /></td>
					</tr>

					<tr>
						<th scope="row">性別</th>
						<td><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" label="性別" placeholder="性別" /></td>
					</tr>

					<tr>
						<th scope="row">メールアドレス</th>
						<td><s:textfield name="email" value="%{#session.email}" label="メールアドレス" placeholder="メールアドレス" class="txt" /></td>
					</tr>

					<tr>
						<th scope="row">ログインID</th>
						<td><s:textfield name="loginId" value="%{#session.createLoginId}" label="ログインID" placeholder="ログインID" class="txt" /></td>
					</tr>

					<tr>
						<th scope="row">パスワード</th>
						<td><s:password name="password" value="" label="パスワード" placeholder="パスワード" class="txt" /></td>
							<!-- Chromeでオートコンプリート無効化するためのダミー -->
							<s:password type="password" name="dummypass" style="top: -100px; left: -100px; position: fixed;" />
					</tr>

				</table>

				<div class="submit_btn_box">
					<div id=".contents-btn-set">
						<s:submit value="登録" class="submit_btn" />
					</div>
				</div>

			</s:form>


			</div>
<div id="piston"></div>
		</div>

		<s:include value="footer.jsp" />

	</body>
</html>