<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ItemCreateConfirm</title>
<link rel="stylesheet" href="./css/jquery.datetimepicker.css">
<link rel="stylesheet" href="./css/all.css" />
<link rel="stylesheet" href="./css/confirm.css" />
<link rel="stylesheet" href="./css/funasshi-hiko.css" />
</head>

<body>
<jsp:include page="adminHeader.jsp" />
<h1>商品追加確認画面</h1>
	<div id="contents">


		<s:form action="AdminItemCreateCompleteAction">
			<table class="vertical-list-table" border="1">
				<tr>
					<th scope="row"><s:label value="商品ID"/></th>
					<td><s:property value="productId"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="商品名"/></th>
					<td><s:property value="productName"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="商品名ふりがな"/></th>
					<td><s:property value="productNameKana"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="商品詳細"/></th>
					<td><s:property value="productDescription"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="カテゴリID"/></th>
					<td><s:property value="#session.categoryName"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="価格"/></th>
					<td><s:property value="price"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="画像"/></th>
					<td><img src="images/<s:property value="itemImageFileName"/>" width="500" height="300"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="生年月日"/></th>
					<td><s:property value="birthDate" /></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="出身地"/></th>
					<td><s:property value="birthPlace"/></td>
				</tr>
			</table>

			<div class="submit_btn_box">
			<div id=".contents-btn-set">
				<s:submit value="登録" class="submit_btn"/>
			</div>
			</div>
			<s:hidden name="productId" value="%{productId}"/>
			<s:hidden name="productName" value="%{productName}"/>
			<s:hidden name="productNameKana" value="%{productNameKana}"/>
			<s:hidden name="productDescription" value="%{productDescription}"/>
			<s:hidden name="categoryId" value="%{categoryId}"/>
			<s:hidden name="price" value="%{price}"/>
			<s:hidden name="imageFileName" value="%{imageFileName}"/>
			<s:hidden name="imageFilePath" value="%{imageFilePath}"/>
			<s:hidden name="birthDate" value="%{birthDate}"/>
			<s:hidden name="birthPlace" value="%{birthPlace}"/>

		</s:form>

	</div>
</body>
</html>