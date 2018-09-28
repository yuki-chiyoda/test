<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/all.css" />
<link rel="stylesheet" href="./css/adminAllSelect.css" />
<link rel="stylesheet" href="./css/funasshi-hiko.css" />

<title>ユーザー確認画面</title>
</head>
<body>
<jsp:include page="adminHeader.jsp" />
<h1>ユーザー確認画面</h1>
<div id="contents">


	<div id="main">
			<p id="p">カートデータ</p>
		<div>
			<table border="1">
			<tr>
				<th>ID</th>
				<th>ユーザーID</th>
				<th>仮ログインID</th>
				<th>商品ID</th>
				<th>レンタル日数</th>
				<th>金額</th>
				<th>登録日</th>
				<th>更新日</th>



		</tr>
		<s:iterator value="cartList">
		<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="userId"/></td>
				<td><s:property value="tempUserId"/></td>
				<td><s:property value="productId"/></td>
				<td><s:property value="productCount"/><span>日間</span></td>
				<td><s:property value="price"/><span>円</span></td>
				<td><s:property value="registDate"/></td>
				<td><s:property value="updateDate"/></td>

			</tr>
			</s:iterator>

			</table>
		<p>宛先情報データ</p>

		<div>
			<table border="1">
			<tr>
				<th>ID</th>
				<th>ユーザーID</th>
				<th>姓</th>
				<th>名</th>
				<th>姓かな</th>
				<th>名かな</th>
				<th>メールアドレス</th>
				<th>電話番号</th>
				<th>住所</th>
				<th>登録日</th>
				<th>更新日</th>



		</tr>
		<s:iterator value="destinationList">
		<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="userId"/></td>
				<td><s:property value="familyName"/></td>
				<td><s:property value="firstName"/></td>
				<td><s:property value="familyNameKana"/></td>
				<td><s:property value="firstNameKana"/></td>
				<td><s:property value="email"/></td>
				<td><s:property value="telNumber"/></td>
				<td><s:property value="userAddress"/></td>
				<td><s:property value="registDate"/></td>
				<td><s:property value="updateDate"/></td>

			</tr>
			</s:iterator>

			</table>

			<p>カテゴリーデータ</p>

		<div>
			<table border="1">
			<tr>
				<th>ID</th>
				<th>カテゴリID</th>
				<th>カテゴリ名</th>
				<th>カテゴリ詳細</th>
				<th>登録日</th>
				<th>更新日</th>



		</tr>
		<s:iterator value="mCategoryList">
		<tr>
				<td><s:property value="id"/></td>
				<td><s:property value="categoryId"/></td>
				<td><s:property value="categoryName"/></td>
				<td><s:property value="categoryDescription"/></td>
				<td><s:property value="insertDate"/></td>
				<td><s:property value="updateDate"/></td>

			</tr>
			</s:iterator>

			</table>
		</div>
	</div>
</div>
</div>
</div>

</body>
</html>