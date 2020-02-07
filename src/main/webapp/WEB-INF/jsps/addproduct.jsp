<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spforms"%>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Add Product</h2>
  <spforms:form action="carryproduct" method="post" modelAttribute="add" enctype="multipart/form-data">
    <div class="form-group">
      <label for="email">ProductId</label>
      <spforms:input type="productid" class="form-control" placeholder="Enter ProductId" path="productId"/>
    </div>
    <div class="form-group">
      <label for="pwd">ProductName:</label>
      <spforms:input type="productname" class="form-control" placeholder="Enter ProductName" path="productName"/>
    </div>
        <div class="form-group">
      <label for="pwd">ProductDescription:</label>
      <spforms:input type="productdescription" class="form-control" placeholder="Enter ProductDescription" path="productDescription"/>
    </div>
        <div class="form-group">
      <label for="pwd">ProductPrice:</label>
      <spforms:input type="productprice" class="form-control" placeholder="Enter ProductPrice" path="productPrice"/>
    </div>
            
      <div class="form-group">
      <spforms:input type="file" class="form-control"  path="productImage"/>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </spforms:form>
</div>

</body>
</html>
