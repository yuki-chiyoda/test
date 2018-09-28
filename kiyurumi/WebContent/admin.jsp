<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/all.css" />
<link rel="stylesheet" href="./css/funasshi-hiko.css"/>

<title>adminTop</title>

	<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url);
		$('form').submit();
	}
</script>

</head>

<body>
<jsp:include page="adminHeader.jsp"/>
<h1>管理者トップ画面</h1>
	<div id="contents">
	</div>
</body>

</html>