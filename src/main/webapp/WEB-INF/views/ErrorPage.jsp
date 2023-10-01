<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/bootstrap/fontawesome/css/all.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/bootstrap/css/style.css"/>">
<script src="<c:url value="/resources/bootstrap/js/jquery-3.6.4.min.js" />"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
<meta charset="UTF-8">
<title>Lỗi</title>
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center vh-100">
		<div class="text-center align center jus">
			<a href="${pageContext.request.contextPath}">
			    <i class="fa-solid fa-house"></i>trình wed bị lỗi
			</a>
		</div>
	</div>
</body>
</html>