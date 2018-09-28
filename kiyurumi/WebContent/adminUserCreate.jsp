<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/input.css" />
<link rel="stylesheet" href="./css/funasshi-hiko.css" />
<link rel="stylesheet" href="./css/all.css" />
<title>ユーザー情報入力</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"/>
<h1>ユーザー情報入力画面</h1>
<div id="contents">
<div id="errorbox">
<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.familyNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.firstNameErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.emailErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.emailErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.userIdErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.userIdErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.loginIdCheckMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.loginIdCheckMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.userIdCheckMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.userIdCheckMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
<s:if test="!#session.passwordErrorMessageList.isEmpty()">
	<div class="error">
	<div class="error-message">
		<s:iterator value="#session.passwordErrorMessageList"><s:property /><br></s:iterator>
	</div>
	</div>
</s:if>
</div>

<s:form action="AdminUserCreateConfirmAction">
<table>
	<tr>
		<th scope="row">姓</th>
		<td><s:textfield name="familyName" size="50" value="%{#session.familyName}" label="姓" placeholder="姓" class="txt"/></td>
	</tr>
	<tr>
		<th scope="row">名</th>
		<td><s:textfield name="firstName" size="50" value="%{#session.firstName}" label="名" placeholder="名" class="txt"/></td>
	</tr>
	<tr>
		<th scope="row">姓ふりがな</th>
		<td><s:textfield name="familyNameKana" size="50" value="%{#session.familyNameKana}" label="姓ふりがな" placeholder="姓ふりがな" class="txt"/></td>
	</tr>
	<tr>
		<th scope="row">名ふりがな</th>
		<td><s:textfield name="firstNameKana" size="50" value="%{#session.firstNameKana}" label="名ふりがな" placeholder="名ふりがな" class="txt"/></td>
	</tr>
	<tr>
		<th scope="row">性別</th>
		<td><s:radio name="sex" list="%{#session.sexList}" value="%{#session.sex}" label="性別" placeholder="性別"/></td>
	</tr>
	<tr>
		<th scope="row">メールアドレス</th>
		<td><s:textfield name="email" size="50" value="%{#session.email}" label="メールアドレス" placeholder="メールアドレス" class="txt"/></td>
	</tr>
	<tr>
		<th scope="row">ユーザーID</th>
		<td><s:textfield name="userId" size="50" value="%{#session.userId}" label="ユーザーID" placeholder="ユーザーID" class="txt"/></td>

	</tr>
	<tr>
		<th scope="row">パスワード</th>
		<td><s:textfield name="password" size="50" value="" label="パスワード" placeholder="パスワード" class="txt"/></td>
	</tr>
</table>
<div class="submit_btn_box">
<s:submit value="登録" class="submit_btn"/>
</div>
</s:form>
</div>

</body>
</html>