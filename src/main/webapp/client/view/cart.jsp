<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/09/2022
  Time: 4:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Library Book</title>
</head>
<body>
<%--<jsp:include page="../common/header.jsp"/>--%>
<div class="section">
    <div class="container">
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col" class="text-uppercase header col-md-3">item</th>
                <th scope="col" class="text-uppercase header col-md-3">Name</th>
                <th scope="col" class="text-uppercase col-md-2">Quantity</th>
                <th scope="col" class="text-uppercase col-md-2">price each</th>
                <th scope="col" class="text-uppercase col-md-2">total</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <c:forEach items="${sessionScope.cart}" var="item">
                <td class="item">
                    <div class="d-flex"> <img src="${item.book.img}" alt="" height="100">
                    </div>
                </td>
                <td class="item">
                    <div class="pl-2">${item.book.name}
                        <div class="d-flex flex-column justify-content-center">
                            <div class="text-muted">${item.book.publishers}</div>
                        </div>
                    </div>
                </td>
                <td>
                    <div class="input-number">
                        <input type="number" name="qty" value="${item.quantity}">
                        <span class="qty-up">+</span>
                        <span class="qty-down">-</span>
                    </div>
                </td>
                <td class="d-flex flex-column"><span class="red">$ ${item.book.price} VND </span> <del class="cross">${item.book.price * 1.1}</del></td>
                <td class="font-weight-bold">${item.book.price * item.quantity}<div class="close"><a href="/cart?action=remove&id=${item.book.id}" class="btn btn-danger"> × Remove</a></div></td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="4"><span class="red">$ Subtotal: <fmt:formatNumber value = "${sessionScope.subtotal}"/> VND</span> </td>
            </tr>
            <tr>
                <td colspan="2"><a href="/nav?action=store">
                    <button type="button" class="left-arrow-button">Continue Shopping</button></a></td>
                <td colspan="2"><a href="/cart?action=checkout">Checkout <i class="fa fa-arrow-circle-right"></i></a></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<%--<jsp:include page="../common/footer.jsp"/>--%>
<!-- jQuery Plugins -->
<script src="${url}/js/jquery.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/slick.min.js"></script>
<script src="${url}/js/nouislider.min.js"></script>
<script src="${url}/js/jquery.zoom.min.js"></script>
<script src="${url}/js/main.js"></script>
</body>
</html>
