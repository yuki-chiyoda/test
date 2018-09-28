<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/all.css" />
<link rel="stylesheet" href="./css/confirm.css" />
<link rel="stylesheet" href="./css/funasshi-hiko.css" />
<title>ユーザー登録確認画面</title>
</head>
<body>
<jsp:include page="adminHeader.jsp" />
<h1>ユーザー登録確認画面</h1>
	<div id="contents">


		<s:form action="AdminUserCreateCompleteAction">
			<table class="vertical-list-table" border="1">

				<tr>
					<th scope="row"><s:label value="姓"/></th>
					<td><s:property value="familyName"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="名"/></th>
					<td><s:property value="firstName"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="姓ふりがな"/></th>
					<td><s:property value="familyNameKana"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="名ふりがな"/></th>
					<td><s:property value="firstNameKana"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="性別"/></th>
					<td><s:property value="sex"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="メールアドレス"/></th>
					<td><s:property value="email"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="ユーザーID"/></th>
					<td><s:property value="userId"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="パスワード"/></th>
					<td><s:property value="password"/></td>
				</tr>
			</table>
			<div class="submit_btn_box">
				<s:submit value="登録" class="submit_btn"/>
			</div>

				<s:hidden name="id" value="%{id}"/>
				<s:hidden name="loginId" value="%{loginId}"/>
				<s:hidden name="password" value="%{password}"/>
				<s:hidden name="familyName" value="%{familyName}"/>
				<s:hidden name="firstName" value="%{firstName}"/>
				<s:hidden name="familyNameKana" value="%{familyNameKana}"/>
				<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
				<s:hidden name="userId" value="%{userId}"/>
				<s:if test='sex.equals("男性")'>
				<s:hidden name="sex" value="0"/>
				</s:if>
				<s:if test='sex.equals("女性")'>
				<s:hidden name="sex" value="1"/>
				</s:if>
				<s:hidden name="email" value="%{email}"/>
				</s:form>
	</div>
</body>
</html>