<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container-wrapper">
	<div class="container">
		<h2>Login with username and password.</h2>
		<c:if test="${not empty errorMsg }"><!-- errormsg가 있으면 출력  -->
			<div style="color:#ff0000;">
				<h3>${errorMsg}</h3>
			</div>
		</c:if>
		
		<c:if test="${not empty logoutMsg }"><!-- errormsg가 있으면 출력  -->
			<div style="color:#0000ff;">
				<h3>${logoutMsg}</h3>
			</div>
		</c:if>
		
		<form method="post" action="<c:url value="/login"/>">			
			<div class="form-group">
				<label for="username">Username:</label> 
				<input type="text" class="form-control" id="username" placeholder="Enter username" name="username" style="width:30%">
			</div>
			
			<div class="form-group">
				<label for="password">Password:</label> 
				<input type="password" class="form-control" id="password" placeholder="Enter password" name="password" style="width:30%">
			</div>
		
		
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }"/>
			
			<button type="submit" class="btn btn-primary">Submit</button>
			
		</form>		
	</div>	
</div>
<!--csrf를 막는 코드가 필요함 csrf token을 받고, 다시 보낼때 토큰값을 보내 값이 같아야 동작-->
<!-- login 시에 JSESSIONID가 바뀜 그 전까지는 계속 같음 로그인 시 form data에 id, passwd, csrf토큰이 넘어간 다는것을 네트워크 창에서 볼 수 있음-->