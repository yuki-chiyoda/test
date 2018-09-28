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
<link rel="stylesheet" href="./css/complete.css" />
<meta http-equiv="refresh" content="3;URL='HomeAction'"/>
<title>決済完了</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
history.pushState(null, null, null);
$(window).on("popstate", function (event) {
    if (!event.originalEvent.state) {
        history.pushState(null, null, null);
        return;
    }
});
</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>決済完了画面</h1>
<div id="contents">
<div class="success">
決済が完了しました。
</div>
</div>
</body>
</html>