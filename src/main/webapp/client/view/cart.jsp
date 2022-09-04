<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/08/2022
  Time: 1:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Library Book</title>
</head>
<body>
    <h1>CART RENTAL</h1>
    <tr>
        <td colspan="4"><span class="red">$ Subtotal: <fmt:formatNumber value = "${sessionScope.subtotal}"/> VND</span> </td>
    </tr>
    <tr>
        <td colspan="2"><a href="/nav?action=store">
            <button type="button" class="left-arrow-button">Continue Shopping</button></a></td>
        <td colspan="2"><a href="/cart?action=checkout">Checkout <i class="fa fa-arrow-circle-right"></i></a></td>
    </tr>
    </form>
</div>
</body>
</html>
