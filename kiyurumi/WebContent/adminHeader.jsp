<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ヘッダー</title>
	<script>


		function goAdminItemListAction(){
			document.getElementById("form").action="AdminItemListAction";
		}
		function goAdminItemCreateAction(){
			document.getElementById("form").action="AdminItemCreateAction";
		}
		function goAdminAllSelectAction(){
			document.getElementById("form").action="AdminAllSelectAction";
		}
		function goAdminUserListAction(){
			document.getElementById("form").action="AdminUserListAction";
		}
		function goAdminUserCreateAction(){
			document.getElementById("form").action="AdminUserCreateAction";
		}
		function goItemPurchaseHistoryAction(){
			document.getElementById("form").action="PurchaseHistoryAction";
		}
		function goLogoutAction(){
			document.getElementById("form").action="LogoutAction";
		}


	</script>
</head>
<body>
	<header>
		<div id="header">
			<div class="right1">
				<div id="header-title"><a href='<s:url action="AdminAction"/>'><img src="./images/logo.png" width=200px height=80px></a>
				</div>
			</div>
			<div class="left1">
				<div id="header-menu">
				<ul>
					<s:form id="form" name="form">
							<li><s:submit value="商品一覧" class="submit_btn" onclick="goAdminItemListAction();"/></li>
							<li><s:submit value="商品追加" class="submit_btn" onclick="goAdminItemCreateAction();"/></li>
							<li><s:submit value="データ確認" class="submit_btn" onclick="goAdminAllSelectAction();"/></li>
							<li><s:submit value="ユーザー一覧" class="submit_btn" onclick="goAdminUserListAction();"/></li>
							<li><s:submit value="ユーザー追加" class="submit_btn" onclick="goAdminUserCreateAction();"/></li>
							<li><s:submit value="購入者履歴情報" class="submit_btn" onclick="goItemPurchaseHistoryAction();"/></li>
								<li><s:submit value="ログアウト" class="submit_btn" onclick="goLogoutAction();"/></li>

					</s:form>
				</ul>
				</div>
			</div>
		</div>
	</header>
</body>
</html>