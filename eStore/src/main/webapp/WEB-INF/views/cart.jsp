<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script src="<c:url value="/resources/js/controller.js" />"></script>


<div class="container-wrapper">
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h2>Cart</h2>
				<p>All the selected products in your shopping cart</p>
			</div>
		</div>
		
				
		<section class="container" ng-app="cartApp"><!-- ng-app="cartApp"으로 로드  -->
			<div ng-controller="cartCtrl" ng-init="initCartId('${cartId }')"><!-- ng-controller생성자 수행  -->
				<a class="btn btn-warning pull-left" ng-click="clearCart()">
					<i class="fa fa-trash"></i> Clear Cart
				</a>
				<br/>
				
				<table class="table table-hover">
					<tr>
						<th>Product</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Total Price</th>
						<th width="25%">Action</th>
					</tr>
					
					<tr ng-repeat="item in cart.cartItems"><!-- loop를 돌며 cart를 출력  -->
						<td>{{item.product.name}}</td>
						<td>{{item.product.price}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
						<td>						
							<a class="btn btn-danger btn-sm" ng-click="removeFromCart(item.product.id)">
								<i class="fa fa-cart-arrow-down" style="color:white;">&nbsp;remove</i>
							</a>
							<a class="btn btn-danger btn-sm" ng-click="plusFromCart(item.product.id)">
								<i class="fa fa-plus" style="color:white;">&nbsp;plus</i>
							</a>
							<a class="btn btn-danger btn-sm" ng-click="minusFromCart(item.product.id)">
								<i class="fa fa-minus" style="color:white;">&nbsp;minus</i>
							</a>
						</td>
					</tr>
					
					
					<tr>
						<td></td>
						<td></td>
						<td>Grand Total</td>
						<td>{{calGrandTotal()}}</td>
						<td></td>
					</tr>
				</table>
				
				<a class="btn btn-info" href="<c:url value="/products"/>" class="btn btn-default">Continue Shopping</a>
				
			</div>
		</section>
		
	</div>
</div>