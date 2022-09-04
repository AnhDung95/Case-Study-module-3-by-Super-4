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
  <h3>EDIT BOOK</h3>
  <p><c:if test="${requestScope.checkEdit}">SỬA Thành Công !</c:if></p>
</div>

<div class="container col-md-9">
  <div class="row">
    <div class="col-md-6">
      <h3>Form EDIT BOOK </h3>
      <form action="/admin?action=edit" method="post">
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="ID" name="id" value="${requestScope.book.id}" readonly>
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="NAME" name="name" value="${requestScope.book.name}">
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="DESCRIBE" name="describe" value="${requestScope.book.describe}">
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="AUTHOR" name="author" value="${requestScope.book.author}">
        </div>
        <div class="input-group mt-3 mb-3">
          <p>Category</p>
          <select name="category">
            <c:forEach items="${requestScope.categories}" var="cate">
              <option value="${cate.id}">${cate.name}</option>
            </c:forEach>
          </select>
          <p>Publishers</p>
          <select name="publishers">
            <c:forEach items="${requestScope.publishers}" var="publishers">
              <option value="${publishers.id}">${publishers.name}</option>
            </c:forEach>
          </select>
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="QUANTITY" name="quantity" value="${requestScope.book.quantity}">
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="IMG LINK" name="imageURL" value="${requestScope.book.img}">
        </div>
        <div class="input-group mt-3 mb-3">
          <input type="text" class="form-control" placeholder="CREATE DATE" value="${requestScope.book.createDay}" disabled>
        </div>
        <input type="submit" value="EDIT BOOK" class="btn btn-success">
      </form>
    </div>
  </div>
</div>
