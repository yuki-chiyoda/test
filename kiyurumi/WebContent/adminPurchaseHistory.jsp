<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/all.css" />
<link rel="stylesheet" href="./css/adminList.css" />
<link rel="stylesheet" href="./css/funasshi-hiko.css" />
<title>商品購入履歴</title>
</head>
<body>
<jsp:include page="adminHeader.jsp" />
<h1>商品購入履歴画面</h1>
<div id="contents">

<s:if test="#session.purchaseHistoryInfoDtoList.size()>0">
<table class="horizontal-list-table" border="1">
<thead>
<tr>
	<th><s:label value="ID"/></th>
	<th><s:label value="ユーザーID"/></th>
	<th><s:label value="商品ID"/></th>
	<th><s:label value="商品画像"/></th>
	<th><s:label value="レンタル日数"/></th>
	<th><s:label value="合計金額"/></th>
	<th><s:label value="宛先情報ID"/></th>
	<th><s:label value="登録日"/></th>
	<th><s:label value="更新日"/></th>
</tr>
<tbody>
<s:iterator value="#session.purchaseHistoryInfoDtoList">
<tr>
	<td><s:property value="id"/></td>
	<td><s:property value="userId"/></td>
	<td><s:property value="productId"/></td>
	<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="50px" height="50px"/></td>
	<td><s:property value="productCount"/>日間</td>
	<td><s:property value="subtotal"/>円</td>
	<td><s:property value="destinationId"/></td>
	<td><s:property value="registDate"/></td>
	<td><s:property value="updateDate"/></td>
</tr>
</s:iterator>
</tbody>
</table>
</s:if>
<s:else>
<div class="info">
商品購入履歴情報はありません。
</div>
</s:else>
</div>
</body>
</html>