<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/09/2022
  Time: 4:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:url value="/admin/common" var="url"/>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <%--  <jsp:include page="${url}/head.jsp"/>--%>
</head>
<body>
<%--<jsp:include page="${url}/header.jsp"/>--%>
<div class="container-fluid">
  <h3>All Books</h3>
  <p>Thông tin tất cả sản phẩm hiện có được hiển thị ở đây !!</p>
</div>

<div class="container-fluid col-md-12">
  <div class="table-responsive">
    <table class="table table-bordered table-sm" id="table">
      <tr>
        <td> ID</td>
        <td> NAME</td>
        <td> DESCRIBE</td>
        <td> AUTHOR</td>
        <td> CATEGORY</td>
        <td> PUBLISHERS</td>
        <td> QUANTITY</td>
        <td> CREATE DAY</td>
        <td> IMAGE</td>
      </tr>
      <c:forEach var="book" items="${requestScope.books}">
        <tr>
          <td>${book.id}</td>
          <td>${book.name}</td>
          <td>${book.describe}</td>
          <td>${book.author}</td>
          <td>${book.category}</td>
          <td>${book.publishers}</td>
          <td>${book.quantity}</td>
          <td>${book.createDay}</td>
          <td><img src="${book.img}" style="height: 100px"></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
<!--    display user-->
<div class="container-fluid">
  <h3>All Users</h3>
  <p>Thông tin tất cả tài khoản hiện có được hiển thị ở đây !!</p>
</div>
<div class="container-fluid col-md-12">
  <div class="table-responsive">

    <table class="table table-bordered table-sm">
      <tr>
        <td>ID</td>
        <td>ACCOUNT</td>
        <td>FIRSTNAME</td>
        <td>LASTNAME</td>
        <td>ADDRESS</td>
        <td>PHONE</td>
        <td>EMAIL</td>
        <td>ROLE</td>
        <td>STATUS</td>
      </tr>
      <c:forEach var="user" items="${requestScope.users}">
        <tr>
          <td>${user.id}</td>
          <td>${user.account}</td>
          <td>${user.firstName}</td>
          <td>${user.lastName}</td>
          <td>${user.address}</td>
          <td>${user.phone}</td>
          <td>${user.email}</td>
          <td>${user.role}</td>
          <td>${user.status}</td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>

</body>
</html>
