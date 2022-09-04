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
  <jsp:include page="${url}/head.jsp"/>
</head>
<body>
<jsp:include page="${url}/header.jsp"/>

<div class="container-fluid">
  <h3>All User</h3>
  <p>Thông tin tất cả tài khoản hiện có được hiển thị ở đây !!</p>
</div>
<c:if test="${requestScope.checkActive == true}">
  <p>Kích hoạt active tài khoản thành công !!</p>
</c:if>
<c:if test="${requestScope.checkBlock == true}">
  <p>Đã block tài khoản thành công !!</p>
</c:if>
<c:if test="${requestScope.checkDelUser}">
  <h1 class="danger"> Xóa tài khoản người dùng thành công  !!!</h1>
</c:if>
<c:if test="${requestScope.checkEditUser}">
  <h1 class="danger"> Sửa tài khoản người dùng thành công  !!!</h1>
</c:if>
<div class="container-fluid">
  <c:if test="${requestScope.checkDelUser == true}">
    <h3> DELETE PRODUCT SUCCESSFUL </h3>
  </c:if>
  <c:if test="${requestScope.checkDelUser == false}">
    <h3> DELETE PRODUCT FAILURE </h3>
  </c:if>
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
        <td colspan="2">Button</td>
      </tr>
      <c:forEach var="users" items="${requestScope.users}">
        <tr>
          <td>${users.id}</td>
          <td>${users.account}</td>
          <td>${users.firstName}</td>
          <td>${users.lastName}</td>
          <td>${users.address}</td>
          <td>${users.phone}</td>
          <td>${users.email}</td>
          <td>${users.birthDate}</td>
          <td>${users.role}</td>
          <td>${users.status}</td>
          <td><a href="/admin?action=blocked&id=${users.id}" class="btn btn-warning">Blocked</a></td>
          <td><a href="/admin?action=active&id=${users.id}" class="btn btn-info">Active</a></td>
          <td><a href="/admin?action=deleteUser&id=${users.id}" class="btn btn-info">Delete</a></td>
          <td><a href="/admin?action=editUser&id=${users.id}" class="btn btn-info">Edit</a></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>

<div class="container-fluid">
  <h3> ADD USER</h3>
  <p>Thêm người dùng mới - Sửa thông tin người dùng ở đây !!</p>
</div>

<div class="container col-md-9">
  <div class="row">
    <div class="col-md-6">
      <h3>Form ADD USER </h3>
      <form action="/admin?action=addUser" method="post">
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="ID" name="id" disabled>
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="ACCOUNT" name="account">
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="PASSWORD" name="password">
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="FIRSTNAME" name="firstName">
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="LASTNAME" name="lastName">
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="ADDRESS" name="address">
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="PHONE" name="phone">
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="EMAIL" name="email">
        </div>
        <input type="submit" value="ADD USER">
      </form>
    </div>
  </div>
</div>
</body>
</html>

