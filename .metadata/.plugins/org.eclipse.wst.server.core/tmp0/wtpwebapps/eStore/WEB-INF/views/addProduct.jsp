<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-wrapper">

	<div class="container">
		<h1>Add Product</h1>
		<p class="lead">Fill the below information to add a product:</p>
		<sf:form
			action="${pageContext.request.contextPath }/admin/productInventory/addProduct?${_csrf.parameterName}=${_csrf.token}"
			method="post" modelAttribute="product" enctype="multipart/form-data">


			<div class="form-group">
				<label for="name">Name</label>
				<sf:input path="name" id="name" class="form-control" />
				<sf:errors path="name" cssStyle="#ff0000;" />
			</div>

			<div class="form-group">
				<label for="category">Category: </label>
				<sf:radiobutton path="category" id="category" value="컴퓨터" />
				컴퓨터
				<sf:radiobutton path="category" id="category" value="가전" />
				가전
				<sf:radiobutton path="category" id="category" value="잡화" />
				잡화
			</div>

			<div class="form-group">
				<label for="description">Description: </label>
				<sf:textarea path="description" id="description"
					class="form-control" />
			</div>

			<div class="form-group">
				<label for="price">Price: </label>
				<sf:input path="price" id="price" class="form-control" />
				<sf:errors path="price" cssStyle="#ff0000;" />
			</div>

			<div class="form-group">
				<label for="unitInStock">unitInStock: </label>
				<sf:input path="unitInStock" id="unitInStock" class="form-control" />
				<sf:errors path="unitInStock" cssStyle="#ff0000;" />
			</div>

			<div class="form-group">
				<label for="manufacturer">manufacturer: </label>
				<sf:input path="manufacturer" id="manufacturer" class="form-control" />
				<sf:errors path="manufacturer" cssStyle="#ff0000;" />
			</div>
			<div class="form-group">
				<label for="productImage">Upload Picture: </label>
				<sf:input path="productImage" id="productImage" type="file" class="form-control" />				
			</div>

			<input type="submit" value="submit" class="btn btn-default">
			<a href="<c:url value="/admin/productInventory"/>"
				class="btn btn-default">Cancel</a>

		</sf:form>
		<br />
	</div>
</div>