<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/funasshi-hiko.css" />
<link rel="stylesheet" href="./css/input.css" />
<link rel="stylesheet" href="./css/all.css" />
<title>UserUpdate</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"/>
<h1>ユーザー更新画面</h1>
	<div id="contents">


	<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.loginIdErrorMessageList"><s:property/><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="!#session.loginIdCheckMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.loginIdCheckMessageList"><s:property/><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="!#session.passwordErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.passwordErrorMessageList"><s:property/><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.familyNameErrorMessageList"><s:property/><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.firstNameErrorMessageList"><s:property/><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.familyNameKanaErrorMessageList"><s:property/><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.firstNameKanaErrorMessageList"><s:property/><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="!#session.emailErrorMessageList.isEmpty()">
		<div class="error">
			<div class="error-message">
				<s:iterator value="#session.emailErrorMessageList"><s:property/><br></s:iterator>
			</div>
		</div>
	</s:if>

	<s:form action="AdminUserUpdateConfirmAction">
		<table class="vertical-list-table">
				<tr>
					<th scope="row"><s:label value="ID"/></th>
					<td><s:property value="%{#session.id}"/>
						<s:hidden name="id" value="%{id}"/>
				</tr>
			<tr>
				<th scope="row"><s:label value="ユーザーID"/></th>
				<td><s:textfield name="userId" size="50" class="txt" value="%{#session.userId}"/></td>
			</tr>
			<tr>
				<th scope="row"><s:label value="パスワード"/></th>
				<td><s:textfield name="password" size="50" class="txt"/></td>
			</tr>
			<tr>
				<th scope="row"><s:label value="姓"/></th>
				<td><s:textfield name="familyName" size="50" class="txt" value="%{#session.familyName}"/></td>
			</tr>
			<tr>
				<th scope="row"><s:label value="名"/></th>
				<td><s:textfield name="firstName" size="50" class="txt" value="%{#session.firstName}"/></td>
			</tr>
			<tr>
				<th scope="row"><s:label value="姓ふりがな"/></th>
				<td><s:textfield name="familyNameKana" size="50" class="txt" value="%{#session.familyNameKana}"/></td>
			</tr>
			<tr>
				<th scope="row"><s:label value="名ふりがな"/></th>
				<td><s:textfield name="firstNameKana" size="50" class="txt" value="%{#session.firstNameKana}"/></td>
			</tr>
			<tr>
				<th scope="row"><s:label value="性別"/></th>
				<td><s:radio name="sex" list="sexList" value="%{#session.sex}"/></td>
			</tr>
			<tr>
				<th scope="row"><s:label value="メールアドレス"/></th>
				<td><s:textfield name="email" size="50" class="txt" value="%{#session.email}"/></td>
			</tr>

		</table>
		<div class="submit_btn_box">
			<div id=".contents-btn-set">
				<s:submit value="更新内容確認" class="submit_btn"/>
			</div>
		</div>
	</s:form>
	</div>
</body>
</html>