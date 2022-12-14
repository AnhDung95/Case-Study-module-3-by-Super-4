<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 05/09/2022
  Time: 5:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/client/template" var="url"/>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<!-- SECTION -->
<div class="section">
  <!-- container -->
  <div class="container">
    <!-- row -->
    <div class="row" style="height: 500px">
      <!-- Product main img -->
      <div class="col-md-6">
        <div id="book-main-img">
          <div class="book-preview">
            <img src="${book.getImg()}" alt="">
          </div>
        </div>
      </div>

      <!-- Product details -->
      <div class="col-md-6">
        <div class="book-details">
          <h2 class="product-name">${book.getName()}</h2>
          <div>
            <div class="book-rating">
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star"></i>
              <i class="fa fa-star-o"></i>
            </div>
            <a class="review-link" href="#reviews">${reviews.size()} Review(s) | Add your review</a>
          </div>
          <div>
            <h3 class="book-price">$ ${book.getPrice()} VND <del class="book-old-price">${book.getPrice() * 1.1}</del></h3>
            <span class="book-available">
                            <c:if test="${book.getQuantity() > 0}">
                              In Stock
                            </c:if>
                            <c:if test="${book.getQuantity() <= 0}">
                              <del> Sold out </del>
                            </c:if>
                        </span>
          </div>
          <form method="post" action="/cart?action=add&id=${book.id}">
            <div class="add-to-cart">
              <div class="qty-label">
                Quantity
                <div class="input-number">
                  <input type="number" name="quantity" value="1">
                  <span class="qty-up">+</span>
                  <span class="qty-down">-</span>
                </div>
              </div>
              <c:if test="${book.getQuantity() > 0}">
                <button class="add-to-cart-btn" type="submit"><i class="fa fa-shopping-cart"></i>add to cart</button>
              </c:if>
            </div>
          </form>
          <ul class="book-links">
            <li>Category:</li>
            <li><a href="/nav?action=search&keyword=${book.category}">${book.getCategory()}</a></li>
          </ul>
          <ul class="book-links">
            <li>Publishers:</li>
            <li><a href="/nav?action=search&keyword=${book.publishers}">${book.getPublishers()}</a></li>
          </ul>
          <ul class="book-links">
            <li>Describe:</li>
            <li>${book.getDescribe()}</li>
          </ul>
          <ul class="book-links">
            <li>Share:</li>
            <li><a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a></li>
            <li><a href="https://twitter.com/"><i class="fa fa-twitter"></i></a></li>
            <li><a href="https://myaccount.google.com/"><i class="fa fa-google-plus"></i></a></li>
            <li><a href="https://mail.google.com/"><i class="fa fa-envelope"></i></a></li>
          </ul>
        </div>
      </div>

      <div class="col-md-12">
        <div id="product-tab-2">
          <ul class="tab-nav">
            <li><a data-toggle="tab" href="#reviews">Reviews (${reviews.size()})</a></li>
          </ul>

          <div>

            <div id="tab1" class="tab-pane fade in">
              <div class="row">
                <!-- Rating -->
                <div class="col-md-3">
                  <div id="rating">
                    <div class="rating-avg">
                      <span>4.5</span>
                      <div class="rating-stars">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star-o"></i>
                      </div>
                    </div>
                    <ul class="rating">
                      <li>
                        <div class="rating-stars">
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star"></i>
                        </div>
                        <div class="rating-progress">
                          <div style="width: 80%;"></div>
                        </div>
                        <span class="sum">3</span>
                      </li>
                      <li>
                        <div class="rating-stars">
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star-o"></i>
                        </div>
                        <div class="rating-progress">
                          <div style="width: 60%;"></div>
                        </div>
                        <span class="sum">2</span>
                      </li>
                      <li>
                        <div class="rating-stars">
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star-o"></i>
                          <i class="fa fa-star-o"></i>
                        </div>
                        <div class="rating-progress">
                          <div></div>
                        </div>
                        <span class="sum">0</span>
                      </li>
                      <li>
                        <div class="rating-stars">
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star-o"></i>
                          <i class="fa fa-star-o"></i>
                          <i class="fa fa-star-o"></i>
                        </div>
                        <div class="rating-progress">
                          <div></div>
                        </div>
                        <span class="sum">0</span>
                      </li>
                      <li>
                        <div class="rating-stars">
                          <i class="fa fa-star"></i>
                          <i class="fa fa-star-o"></i>
                          <i class="fa fa-star-o"></i>
                          <i class="fa fa-star-o"></i>
                          <i class="fa fa-star-o"></i>
                        </div>
                        <div class="rating-progress">
                          <div></div>
                        </div>
                        <span class="sum">0</span>
                      </li>
                    </ul>
                  </div>
                </div>

                <div class="col-md-6">
                  <div id="reviews">
                    <c:forEach items="${requestScope.reviews}" var="review">
                      <ul class="reviews">
                        <li>
                          <div class="review-heading">
                            <h5 class="name">${review.accountUser}</h5>
                            <div class="review-rating">
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star"></i>
                              <i class="fa fa-star-o empty"></i>
                            </div>
                          </div>
                          <div class="review-body">
                            <p>${review.comment}</p>
                          </div>
                        </li>
                      </ul>
                    </c:forEach>
                    <ul class="reviews-pagination">
                      <li class="active">1</li>
                    </ul>
                  </div>
                </div>
                <!-- /Reviews -->

                <!-- Review Form -->
                <div class="col-md-3">
                  <div id="review-form">
                    <form class="review-form">
                      <input class="input" type="text" placeholder="Your Name">
                      <input class="input" type="email" placeholder="Your Email">
                      <textarea class="input" placeholder="Your Review"></textarea>
                      <div class="input-rating">
                        <span>Your Rating: </span>
                        <div class="stars">
                          <input id="star5" name="rating" value="5" type="radio"><label for="star5"></label>
                          <input id="star4" name="rating" value="4" type="radio"><label for="star4"></label>
                          <input id="star3" name="rating" value="3" type="radio"><label for="star3"></label>
                          <input id="star2" name="rating" value="2" type="radio"><label for="star2"></label>
                          <input id="star1" name="rating" value="1" type="radio"><label for="star1"></label>
                        </div>
                      </div>
                      <button class="primary-btn">Submit</button>
                    </form>
                  </div>
                </div>
                <!-- /Review Form -->
              </div>
            </div>
            <!-- /tab3  -->
          </div>
          <!-- /product tab content  -->
        </div>
      </div>
      <!-- /product tab -->
    </div>
    <!-- /row -->
  </div>
  <!-- /container -->
</div>

<jsp:include page="../common/footer.jsp"/>
<!-- jQuery Plugins -->
<script src="${url}/js/jquery.min.js"></script>
<script src="${url}/js/bootstrap.min.js"></script>
<script src="${url}/js/slick.min.js"></script>
<script src="${url}/js/nouislider.min.js"></script>
<script src="${url}/js/jquery.zoom.min.js"></script>
<script src="${url}/js/main.js"></script>
</body>
</html>