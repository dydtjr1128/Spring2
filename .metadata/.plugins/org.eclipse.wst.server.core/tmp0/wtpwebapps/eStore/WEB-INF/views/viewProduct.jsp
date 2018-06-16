<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="<c:url value="/resources/js/controller.js" />"></script>
<div class="container-wrapper">
	<div class="container" ng-app="cartApp">
		<h2>Product Detail</h2>
		<p>Here is the detail information of ${product.name}!!</p>
		<div class="row" ng-controller="cartCtrl">
			<div class="col-md-8">		
				<img src="<c:url value="/resources/images/${product.imageFileName}" />" alt="image"
					style="width: 80%" />
			</div> 
			<div class="col-md-4">
				<h3>${product.name}</h3>
				<p>	<strong>Description : </strong><strong>${product.description}</strong> </p>
				<p>	<strong>Manufacturer : </strong>${product.manufacturer}</p>	
				<p>	<strong>Category : </strong>${product.category}</p>
				<p>	<strong>UnitInStock : </strong>${product.unitInStock}</p>
				<p style="font-size: 1.5em;">
					<strong>Price : </strong>											
					<strong>${product.price} 원</strong>
				</p>
				
				<br/>
				
				<c:if test="${pageContext.request.userPrincipal.name != null }"><!-- login 했을 경우만 보여주겠다.  -->
				<p>
					<a href="<c:url value="/products" />" class="btn btn-danger">Back</a>
						
						<button class="btn btn-warning btn-large" ng-click="addToCart('${product.id}')">
							<i class="fa fa-shopping-cart"></i>Order Now
						</button>
						
						<a href="<c:url value="/cart"/>" class="btn btn-info">
							<i class="fa fa-eye"></i> View Cart
						</a>
				</p>
				</c:if>
			</div>
		</div>
	</div>
</div>