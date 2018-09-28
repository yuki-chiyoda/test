<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/all.css" />
<link rel="stylesheet" href="./css/funasshi-gun.css" />
<link rel="stylesheet" href="./css/confirm.css" />
<title>パスワード再設定確認</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>パスワード再設定確認画面</h1>
<div id="contents">

<s:form action="ResetPasswordCompleteAction">
<table border="1">
<tr>
	<th scope="row"><s:label value="ユーザーID"/></th>
	<td><s:property value="#session.loginId"/></td>
</tr>
<tr>
	<th scope="row"><s:label value="新規パスワード"/></th>
	<td><s:property value="#session.concealedPassword"/></td>
</tr>
</table>
	<div class="submit_btn_box">
		<s:submit value="再設定" class="submit_btn" />
	</div>

</s:form>
	</div>
</body>
</html>