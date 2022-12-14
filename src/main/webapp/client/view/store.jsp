<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<c:url value="/client/template" var="url"/>--%>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
<%--  <jsp:include page="../common/head.jsp"/>--%>
</head>
<body>
<%--<jsp:include page="../common/header.jsp"/>--%>
<!-- SECTION -->
<div class="section">
  <!-- container -->
  <div class="container">
    <!-- row -->
    <div class="row">
      <!-- ASIDE -->
      <form method="post" action="/nav?action=filter">
        <div id="aside" class="col-md-3">
          <!-- aside Widget -->
          <button type="submit" class="btn btn-danger">Filter</button>
          <div class="aside">
            <h3 class="aside-title">Categories</h3>
            <div class="checkbox-filter">
              <c:forEach begin="0" end="${categories.size()-1}" var="i">
                <div class="input-radio">
                  <input type="radio" id="category-${i}" value="${categories.get(i).name}" name="category">
                  <label for="category-${i}">
                    <span></span>
                      ${categories.get(i).name}
                  </label>
                </div>
              </c:forEach>
            </div>
          </div>
          <!-- /aside Widget -->

          <!-- aside Widget -->
          <div class="aside">
            <h3 class="aside-title">Price</h3>
            <div class="price-filter">
              <div id="price-slider"></div>
              <div class="input-number price-min">
                <input id="price-min" type="number" name="pmin">
                <span class="qty-up">+</span>
                <span class="qty-down">-</span>
              </div>
              <span>-</span>
              <div class="input-number price-max">
                <input id="price-max" type="number" name="pmax">
                <span class="qty-up">+</span>
                <span class="qty-down">-</span>
              </div>
            </div>
          </div>
          <!-- /aside Widget -->

          <!-- aside Widget -->
          <div class="aside">
            <h3 class="aside-title">Publishers</h3>
            <div class="checkbox-filter">
              <c:forEach begin="0" end="${publishers.size()-1}" var="i">
                <div class="input-radio">
                  <input type="radio" id="publishers-${i}" value="${publishers.get(i).name}" name="publishers">
                  <label for="publishers-${i}">
                    <span></span>
                      ${publishers.get(i).name}
                  </label>
                </div>
              </c:forEach>
            </div>
          </div>
          <!-- /aside Widget -->
        </div>
      </form>
      <!-- /ASIDE -->
      <!-- STORE -->
      <div id="store" class="col-md-9">
        <!-- store products -->
        <div class="row">
          <!-- product -->

          <c:forEach begin="0" end="${books.size()-1}" var="i">
            <div class="col-md-4 col-xs-6">
              <div class="product">
                <div class="product-img">
                  <img src="${books.get(i).img}" alt="">
                  <div class="product-label">
                    <span class="sale">-10%</span>
                    <span class="new">NEW</span>
                  </div>
                </div>
                <div class="product-body">
                  <p class="product-brand">${books.get(i).publishers}</p>
                  <h3 class="product-name"><a href="/home?action=detail&id=${books.get(i).id}">${books.get(i).name}</a></h3>
                  <h4 class="product-price">$ ${books.get(i).price} VND <del class="book-old-price">${books.get(i).price * 1.1}</del></h4>
                  <div class="product-rating">
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                    <i class="fa fa-star"></i>
                  </div>
                  <div class="product-btns">
                    <button class="add-to-wishlist"><i class="fa fa-heart-o"></i><span class="tooltipp">add to wishlist</span></button>
                    <button class="add-to-compare"><i class="fa fa-exchange"></i><span class="tooltipp">add to compare</span></button>
                    <button class="quick-view"><i class="fa fa-eye"></i><span class="tooltipp">quick view</span></button>
                  </div>
                </div>
                <div class="add-to-cart">
                  <c:if test="${books.get(i).quantity <= 0}">
                    <p>Sold out</p>
                  </c:if>
                  <c:if test="${books.get(i).quantity > 0}">
                    <a href="/cart?action=add&id=${books.get(i).id}">
                      <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></a>
                  </c:if>
                </div>
              </div>
            </div>
            <c:if test="${(i + 1)% 3 == 0}">
              <div class="clearfix visible-lg visible-md visible-sm visible-xs"></div>
            </c:if>
            <!-- /product -->
          </c:forEach>
        </div>
        <!-- /store products -->
        <!-- store bottom filter -->
        <span class="store-qty">Showing ${books.size()} books</span>
        <ul class="store-pagination">
          <li class="active">1</li>
        </ul>
      </div>
      <!-- /store bottom filter -->
    </div>
    <!-- /STORE -->
  </div>
  <!-- /row -->
</div>
<!-- /container -->
</div>
<!-- /SECTION -->
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
