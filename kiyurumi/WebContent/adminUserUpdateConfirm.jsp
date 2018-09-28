<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/funasshi-hiko.css" />
<link rel="stylesheet" href="./css/all.css" />
<link rel="stylesheet" href="./css/confirm.css" />
<title>UserUpdateConfirm</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"/>
<h1>ユーザー更新確認画面</h1>
	<div id="contents">


		<s:form action="AdminUserUpdateCompleteAction">
			<table border="1">
				<tr>
					<th scope="row"><s:label value="ID"/></th>
					<td><s:property value="id"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="ユーザーID"/></th>
					<td><s:property value="userId"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="パスワード"/></th>
					<td><s:property value="password"/></td>
				</tr>
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

			</table>

			<div class="submit_btn_box">
				<div id=".contents-btn-set">
					<s:submit value="登録" class="submit_btn"/>
				</div>
			</div>
			<s:hidden name="id" value="%{id}"/>
			<s:hidden name="userId" value="%{userId}"/>
			<s:hidden name="password" value="%{password}"/>
			<s:hidden name="familyName" value="%{familyName}"/>
			<s:hidden name="firstName" value="%{firstName}"/>
			<s:hidden name="familyNameKana" value="%{familyNameKana}"/>
			<s:hidden name="firstNameKana" value="%{firstNameKana}"/>
			<s:if test='sex.equals("男性")'>
			<s:hidden name="sex" value="0"/>
			</s:if>
			<s:if test='sex.equals("女性")'>
			<s:hidden name="sex" value="1"/>
			</s:if>
			<s:hidden name="email" value="%{email}"/>
			<s:hidden name="status" value="%{status}"/>
		</s:form>
	</div>
</body>
</html>