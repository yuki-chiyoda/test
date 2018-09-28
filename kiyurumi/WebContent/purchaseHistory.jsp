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
<title>商品購入履歴</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>商品購入履歴画面</h1>
<div id="contents">

<s:if test="#session.purchaseHistoryInfoDtoList.size()>0">
<table class="horizontal-list-table" border="1">
<thead>
	<tr>
			<th><s:label value="商品名"/></th>
			<th><s:label value="ふりがな"/></th>
			<th><s:label value="商品画像"/></th>
			<th><s:label value="値段"/></th>
			<th><s:label value="出身地"/></th>
			<th><s:label value="生年月日"/></th>
			<th><s:label value="レンタル日数"/></th>
			<th><s:label value="合計金額"/></th>


	</tr>
<tbody>
<s:iterator value="#session.purchaseHistoryInfoDtoList">
	<tr>
		<td><s:property value="productName"/></td>
		<td><s:property value="productNameKana"/></td>
		<td><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="50px" height="50px"/></td>
		<td><s:property value="price"/>円</td>
		<td><s:property value="birthPlace"/></td>
		<td><s:property value="birthDate"/></td>
		<td><s:property value="productCount"/></td>
		<td><s:property value="subtotal"/>円</td>


	</tr>
</s:iterator>
</tbody>
</table>
<br>
<div class="submit_btn_box">
<div id=".contents-btn-set">
<s:form action="DeletePurchaseHistoryAction">
	<s:submit value="削除" class="submit_btn" />
</s:form>
</div>
</div>
</s:if>
<s:else>
<div class="info">
商品購入履歴情報はありません。
</div>
</s:else>
</div>
</body>
</html>