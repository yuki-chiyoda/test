<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/all.css" />
<link rel="stylesheet" href="./css/confirm.css" />
<link rel="stylesheet" href="./css/product.css" />
<link rel="stylesheet" href="./css/funasshi-gun.css" />
<title>商品詳細</title>
</head>
<body>
<jsp:include page="header.jsp" />
<h1>商品詳細画面</h1>
<div id="contents">



	<s:form action="AddCartAction">
	<div class="box">

	<div class="2column-container">
	<div class="right">
		<img src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>' class="item-image-box-320"/><br>
	</div>
	<div class="left">
	<table class="vertical-list-table-mini" border="1">
		<tr>
		<th scope="row"><s:label value="商品名"/></th>
		<td><s:property value="%{#session.productName}"/></td>
		</tr>
		<tr>
		<th scope="row"><s:label value="商品名ふりがな"/></th>
		<td><s:property value="%{#session.productNameKana}"/></td>
		</tr>
		<tr>
		<th scope="row"><s:label value="値段"/></th>
		<td><s:property value="%{#session.price}"/>円</td>
		</tr>
		<tr>
		<th scope="row"><s:label value="レンタル日数"/></th>
		<td><s:select name="productCount" list="%{#session.productCountList}"/>日間</td>
		</tr>
		<tr>
		<th scope="row"><s:label value="出身地"/></th>
		<td><s:property value="%{#session.birthPlace}"/></td>
		</tr>
		<tr>
		<th scope="row"><s:label value="生年月日"/></th>
		<td><s:property value="%{#session.birthDate}"/></td>
		</tr>
		<tr>
		<th scope="row"><s:label value="商品詳細情報"/></th>
		<td><s:property value="%{#session.productDescription}"/></td>
		</tr>
		</table>
	</div>
	</div>
	<s:hidden name="productId" value="%{#session.productId}"/>
	<s:hidden name="productName" value="%{#session.productName}"/>
	<s:hidden name="productNameKana" value="%{#session.productNameKana}"/>
	<s:hidden name="imageFilePath" value="%{#session.imageFilePath}"/>
	<s:hidden name="imageFileName" value="%{#session.imageFileName}"/>
	<s:hidden name="price" value="%{#session.price}"/>
	<s:hidden name="birthPlace" value="%{#session.birthPlace}"/>
	<s:hidden name="birthDate" value="%{#session.birthDate}"/>
	<s:hidden name="productDescription" value="%{#session.productDescription}"/>
	</div>

<div class="botton">
	<s:token/>
	<s:submit value="カートに追加" class="submit_btn"/>

</div>

	</s:form>

<div class="box2">
<div class="product-details-recomｍend-box">
<s:iterator value="#session.productInfoDtoList">
		<div class="recommend-box">
		<a href='<s:url action="ProductDetailsAction">
		<s:param name="productId" value="%{productId}"/>
		</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box-100"/></a><br>
		<s:property value="productName" /><br>
		</div>
</s:iterator>
</div>
</div>

</div>

</body>
</html>