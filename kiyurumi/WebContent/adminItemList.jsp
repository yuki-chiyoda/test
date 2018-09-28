<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/all.css" />
<link rel="stylesheet" href="./css/home.css" />
<link rel="stylesheet" href="./css/adminList.css" />
<link rel="stylesheet" href="./css/funasshi-hiko.css" />
<title>ItemList</title>

<script type="text/javascript">
	function goAdminItemDeleteAction(){
		document.getElementById("form").action="AdminItemDeleteAction";
	}
	</script>
</head>

<body>
<jsp:include page="adminHeader.jsp" />

	<div id="contents">
		<h1>商品一覧</h1>
			<s:if test="#session.checkListErrorMessageList != null">
			   <div class="error">
			   <div class="error-message">
			       <s:iterator value="#session.checkListErrorMessageList"><s:property /><br></s:iterator>
			   </div>
			   </div>
			</s:if>
			<s:if test="productInfoDTOList==null">
				<div class="info">
				登録されている商品はありません。
				</div>
			</s:if>
			<s:else>
			<s:form id="form">

				<table border="1">
					<tr>
						<th>削除チェック</th>
						<th>ID</th>
						<th>商品画像(編集は画像をクリック)</th>
						<th>商品ID</th>
						<th>商品名</th>
						<th>商品名ふりがな</th>
						<th class="a">商品詳細</th>
						<th>カテゴリID</th>
						<th>価格</th>
						<th>生年月日</th>
						<th>出身地</th>
						<th>ステータス</th>
						<th>登録日</th>
						<th>更新日</th>
					</tr>
					<s:iterator value="productInfoDTOList">
					<tr>
						<td><s:checkbox name="checkList" value="checked" fieldValue="%{id}"/></td>
						<td><s:property value="id"/></td>
						<td><a href='<s:url action="AdminItemUpdateAction"><s:param name="id" value="%{id}"/></s:url>'>
						<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box-200" width=200px height=300px /></a></td>
						<td><s:property value="productId"/></td>
						<td><s:property value="productName"/></td>
						<td><s:property value="productNameKana"/></td>
						<td><s:property value="productDescription"/></td>
						<td><s:property value="categoryId"/></td>
						<td><s:property value="price"/></td>
						<td><s:property value="birthDate"/></td>
						<td><s:property value="birthPlace"/></td>
						<td><s:property value="status"/></td>
						<td><s:property value="registDate"/></td>
						<td><s:property value="updateDate"/></td>
					</tr>

					<s:hidden name="id" value="%{#id}"/>
					<s:hidden name="imageFilePath" value="%{#imageFilePath}"/>
					<s:hidden name="imageFileName" value="%{#imageFileName}"/>
					<s:hidden name="productId" value="%{#productId}"/>
					<s:hidden name="productNameKana" value="%{#productNameKana}"/>
					<s:hidden name="productDescription" value="%{#productDescription}"/>
					<s:hidden name="categoryId" value="%{#categoryId}"/>
					<s:hidden name="price" value="%{#price}"/>
					<s:hidden name="birthDate" value="%{#birthDate}"/>
					<s:hidden name="birthPlace" value="%{#birthPlace}"/>
					<s:hidden name="status" value="%{#status}"/>
					<s:hidden name="registDate" value="%{#registDate}"/>
					<s:hidden name="updateDate" value="%{#updateDate}"/>

					</s:iterator>
				</table>
				<div class="submit_btn_box">
				<div id=".contents-btn-set">
					<input type="submit" value="削除" id="form_0" class="submit_btn" onclick="this.form.action='AdminItemDeleteAction';"/>
				</div>
				</div>
</s:form>
			</s:else>

	</div>

</body>
</html>