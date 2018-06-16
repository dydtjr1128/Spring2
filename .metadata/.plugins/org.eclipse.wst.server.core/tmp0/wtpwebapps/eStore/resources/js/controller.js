var cartApp = angular.module('cartApp', []);

// angular에 의해 controller가 만들어짐 의존성 주입으로 2가지가 들어감 scope = model, http = service
cartApp.controller("cartCtrl", function($scope, $http) {
	$scope.initCartId = function(cartId) {// scope에 initCaetId라는 function 등록
		$scope.cartId = cartId;
		$scope.refreshCart();
	};

	$scope.refreshCart = function() {
		$http.get('/eStore/api/cart/' + $scope.cartId).then(// short form
		function successCallback(response) {
			$scope.cart = response.data;// cart내용이 scope에 저장된다.
		});
	};

	$scope.clearCart = function() {

		$scope.setCsrfToken();

		$http({// long form
			method : 'DELETE',
			url : '/eStore/api/cart/' + $scope.cartId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};

	$scope.addToCart = function(productId) {

		$scope.setCsrfToken();

		$http.put('/eStore/api/cart/add/' + productId).then(
				function successCallback() {
					alert("Product successfully added to the cart!");
				}, function errorCallback() {
					alert("Adding to the cart failed")
				});
	};

	$scope.removeFromCart = function(productId) {

		$scope.setCsrfToken();

		$http({
			method : 'DELETE',
			url : '/eStore/api/cart/cartitem/' + productId
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};
	$scope.minusFromCart = function(productId) {

		$scope.setCsrfToken();

		$http({
			method : 'PUT',
			url : '/eStore/api/cart/cartitem/' + productId + '/2'
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});
	};
	$scope.plusFromCart = function(productId) {

		$scope.setCsrfToken();

		$http({
			method : 'PUT',
			url : '/eStore/api/cart/cartitem/' + productId + '/1'
		}).then(function successCallback() {
			$scope.refreshCart();
		}, function errorCallback(response) {
			console.log(response.data);
		});		
	};

	$scope.calGrandTotal = function() {
		var grandTotal = 0;

		for (var i = 0; i < $scope.cart.cartItems.length; i++) {
			grandTotal += $scope.cart.cartItems[i].totalPrice;
		}
		return grandTotal;
	};

	$scope.setCsrfToken = function() {
		var csrfToken = $("meta[name='_csrf']").attr("content");
		var csrfHeader = $("meta[name='_csrf_header']").attr("content");

		$http.defaults.headers.common[csrfHeader] = csrfToken;
	}

});
