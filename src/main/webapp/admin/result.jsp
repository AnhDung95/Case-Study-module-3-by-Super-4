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
    <p>Kết quả tìm kiếm: </p>
</div>

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
                <td colspan="2">Your choice</td>
            </tr>
            <c:forEach var="books" items="${book}">
                <tr>
                    <td>${books.id}</td>
                    <td>${books.name}</td>
                    <td>${books.describe}</td>
                    <td>${books.author}</td>
                    <td>${books.category}</td>
                    <td>${books.publishers}</td>
                    <td>${books.quantity}</td>
                    <td>${books.createDay}</td>
                    <td><img src="${books.img}" style="height: 100px"></td>
                    <td><a href="/menu?action=search&name=${books.name}" class="btn btn-warning">Search</a></td>
<%--                    <td><a href="/admin?action=showFormEdit&id=${books.id}" class="btn btn-info">Edit</a></td>--%>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>
