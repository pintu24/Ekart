<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spform" %>
<%@ include file="header.jsp" %>
<html lang="en">
<head>
  <title>Regristation</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Register</h2>
  <spform:form action="carryuser" method="post" modelAttribute="usr">
  <div class="form-group">
      <label for="username">Username:</label>
      <spform:input type="text" class="form-control" placeholder="Enter Username" path="userName"/>
    </div>
        <div class="form-group">
      <label for="pwd">Password:</label>
      <spform:input type="password" class="form-control" id="pwd" placeholder="Enter password" path="password"/>
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <spform:input type="email" class="form-control" id="email" placeholder="Enter email" path="email"/>
    </div>
    <div class="form-group">
      <label for="Mobile.no">Mobile.no:</label>
      <spform:input type="text" class="form-control" placeholder="Enter Mobile.no" path="mobileNo"/>
    </div>
     <spform:select class="form-control" path="role">
        <spform:option value="ROLE_USER">user</spform:option>
        <spform:option value="ROLE_ADMIN">admin</spform:option>
        </spform:select>
    <button type="submit" class="btn btn-primary">SignUp</button>
  </spform:form>
</div>

</body>
</html>
