<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="">
		<meta name="author" content="">
		
		<meta name="_csrf" content="${_csrf.token}"/>
		<meta name="_csrf_header" content="${_csrf.headerName}"/>
		
		<title><tiles:insertAttribute name="title"/>eStore</title>
		
		<!-- Bootstrap core CSS -->
		<!-- <link href="resources/css/bootstrap.min.css" rel="stylesheet"> -->
		<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
		
		<!-- Custom styles for this template -->
		<!-- <link href="resources/css/carousel.css" rel="stylesheet"> -->
		<link href="<c:url value="/resources/css/carousel.css"/>" rel="stylesheet">
		
		<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
		<!-- Font Awesome -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
		
		<!--AngularJS -->
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.10/angular.min.js"></script>
	
	</head>
	<body>
	
		<div>
			<tiles:insertAttribute name="menu"/><!-- menu라는 attribute를 집어넣겠다 -->
			<tiles:insertAttribute name="body"/><!-- body라는 attribute를 집어넣겠다 -->
			<tiles:insertAttribute name="footer"/><!-- footer라는 attribute를 집어넣겠다 -->
		</div>
		
		<!-- Bootstrap core JavaScript
	    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
		<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	</body>
</html>
