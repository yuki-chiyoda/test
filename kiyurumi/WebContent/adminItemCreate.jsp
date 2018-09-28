<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>
<head>
<sx:head cache="false" />
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/input.css" />
<link rel="stylesheet" href="./css/funasshi-hiko.css" />
<link rel="stylesheet" href="./css/all.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Script-Type" content="text/javascript" >
<title>ItemCreate</title>
</head>
<body>
<jsp:include page="adminHeader.jsp" />
<h1>商品追加画面</h1>
	<div id="contents">
<div id="errorbox">
		<s:if test="!#session.productIdErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.productIdErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.productNameErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.productNameErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.productNameKanaErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.productNameKanaErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.productDescriptionErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.productDescriptionErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.priceErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.priceErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.imageFileNameErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.imageFileNameErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.itemImageFileNameErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.itemImageFileNameErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.birthDateErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.birthDateErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
		<s:if test="!#session.birthPlaceErrorMessageList.isEmpty()">
			<div class="error">
				<div class="error-message">
					<s:iterator value="#session.birthPlaceErrorMessageList"><s:property /><br></s:iterator>
				</div>
			</div>
		</s:if>
</div>
<script>
document.getElementsByName("releaseDate").value = "1970/01/01";
document.getElementsByName("dojo.releaseDate").value = "1970/01/01";
timepicker:false
</script>
		<s:form action="AdminItemCreateConfirmAction" method="post" enctype="multipart/form-data">
			<table class="vertical-list-table">
				<tr>
					<th scope="row"><s:label value="商品ID"/></th>
					<td><s:textfield name="productId" size="50" class="txt"  placeholder="商品ID" value="%{#session.productId}"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="商品名"/></th>
					<td><s:textfield name="productName" size="50" class="txt" placeholder="商品名"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="商品名ふりがな"/></th>
					<td><s:textfield name="productNameKana" size="50" class="txt"  placeholder="商品名ふりがな"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="商品詳細"/></th>
					<td><s:textarea name="productDescription" class="txt" style="margin: 0px; width:377px; height:94px;"  placeholder="商品詳細"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="カテゴリID"/></th>
					<td><s:select name="categoryId" list="%{#session.mCategoryDtoList}" listValue="categoryName" listKey="categoryId" class="cs-div" id="categoryId"/><br></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="価格"/></th>
					<td><s:textfield name="price" size="50" class="txt"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="画像ファイル"/></th>
					<td><s:file name="itemImage" label="画像ファイル" placeholder="画像ファイル" class="file"/></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="生年月日"/></th>
					<td><sx:datetimepicker name="birthDate" displayFormat="yyyy/MM/dd"/><br><span class="Description" >【XXXX/XX/XXの形式で入力してください。】</span></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="出身地"/></th>
					<td><s:textfield name="birthPlace" size="50" class="txt" placeholder="出身地"/></td>
				</tr>
			</table>
			<div class="submit_btn_box">
			<div id=".contents-btn-set">
				<s:submit value="商品追加内容確認" class="submit_btn"/>
			</div>
			</div>
		</s:form>

	</div>
</body>
</html>