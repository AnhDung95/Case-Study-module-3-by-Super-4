<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url value="/client/template" var="url"/>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="client/template/css/bootstrap.min.css">
    <link rel="stylesheet" href="client/template/css/font-awesome.min.css">
    <link rel="stylesheet" href="client/template/css/nouislider.min.css">
    <link rel="stylesheet" href="client/template/css/slick.css">
    <link rel="stylesheet" href="client/template/css/slick-theme.css">
    <link rel="stylesheet" href="client/template/css/style.css">
<%--    <link rel="stylesheet" href="client/template/fonts/FontAwesome.otf">--%>
<%--    <link rel="stylesheet" href="client/template/fonts/fontawesome-webfont.eot">--%>
<%--    <link rel="stylesheet" href="client/template/fonts/fontawesome-webfont.svg">--%>
<%--    <link rel="stylesheet" href="client/template/fonts/fontawesome-webfont.ttf">--%>
<%--    <link rel="stylesheet" href="client/template/fonts/fontawesome-webfont.woff">--%>
<%--    <link rel="stylesheet" href="client/template/fonts/fontawesome-webfont.woff2">--%>
<%--    <link rel="stylesheet" href="client/template/fonts/slick.eot">--%>
<%--    <link rel="stylesheet" href="client/template/fonts/slick.svg">--%>
<%--    <link rel="stylesheet" href="client/template/fonts/slick.ttf">--%>
<%--    <link rel="stylesheet" href="client/template/fonts/slick.woff">--%>

    <jsp:include page="../common/head.jsp"/>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="library">
                    <div class="library-img">
                        <img src="${url}/img/sgk.jpg" alt="" width="250" height="200">
                    </div>
                    <div class="library-body">
                        <h3>Sách giáo khoa<br>Collection</h3>
                        <a href="/nav?action=textbooks" class="cta-btn">Show now <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>
            <!-- /shop -->

            <!-- shop -->
            <div class="col-md-4 col-xs-6">
                <div class="library">
                    <div class="library-img">
                        <img src="${url}/img/tt.jpg" alt="" width="250" height="200">
                    </div>
                    <div class="library-body">
                        <h3>Tiểu Thuyết<br>Collection</h3>
                        <a href="/nav?action=novel" class="cta-btn">Show now <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>

            <div class="col-md-4 col-xs-6">
                <div class="library">
                    <div class="library-img">
                        <img src="${url}/img/truyentranh.jpg" alt="" width="250" height="200">
                    </div>
                    <div class="library-body">
                        <h3>Truyện Tranh<br>Collection</h3>
                        <a href="/nav?action=comic" class="cta-btn">Show now <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>
<!


<div class="section">

    <div class="container">

        <div class="row">

            <div class="col-md-12">
                <div class="section-title">
                    <h3  class="title">New BOOK</h3>
                    <div class="section-nav">
                        <ul class="section-tab-nav tab-nav">
                            <li class="${active1}"><a href="/home">All</a></li>
                            <li class="${active2}"><a href="/home?action=textbooks">Sách Giáo Khoa</a></li>
                            <li class="${active3}"><a href="/home?action=novel">Tiểu Thuyết</a></li>
                            <li class="${active4}"><a href="/home?action=comic">Truyện Tranh</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /section title -->
            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="books-tabs">
                        <!-- tab -->
                        <div id="tab1" class="tab-pane active">
                            <div class="books-slick" data-nav="#slick-nav-1">
                                <jsp:useBean id="book" scope="request" type="java.util.List"/>
                                <c:forEach items="${book}" var="book">
                                    <!-- product -->
                                    <div class="book">
                                        <div class="book-img">
                                            <img src="${book.getImg()}" alt="">
                                            <div class="book-label">
                                                <span class="sale">-10%</span>
                                                <span class="new">NEW</span>
                                            </div>
                                        </div>
                                        <div class="book-body">
                                            <p class="book-brand">${book.getPublishers()}</p>
                                            <h3 class="book-name"><a href="/home?action=detail&id=${book.getId()}">${book.getName()}</a></h3>
                                            <h4 class="book-price">$ ${book.getPrice()} VND <del class="book-old-price">${book.getPrice() * 1.1}</del></h4>
                                            <div class="book-rating">
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
                                            <c:if test="${book.quantity > 0}">
                                                <a href="/cart?action=add&id=${book.id}">
                                                    <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></a>
                                            </c:if>
                                            <c:if test="${book.quantity <= 0}">
                                                <p>Sold out</p>
                                            </c:if>
                                        </div>
                                    </div>
                                </c:forEach>
                                <!-- /product -->
                            </div>
                            <div id="slick-nav-1" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- HOT DEAL SECTION -->
<div id="hot-deal" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="hot-deal">
                    <ul class="hot-deal-countdown">
                        <li>
                            <div>
                                <h3>02</h3>
                                <span>Days</span>
                            </div>
                        </li>
                        <li>
                            <div>
                                <h3>10</h3>
                                <span>Hours</span>
                            </div>
                        </li>
                        <li>
                            <div>
                                <h3>34</h3>
                                <span>Mins</span>
                            </div>
                        </li>
                        <li>
                            <div>
                                <h3>60</h3>
                                <span>Secs</span>
                            </div>
                        </li>
                    </ul>
                    <h2 class="text-uppercase">hot deal this week</h2>
                    <p>New Collection Up to 50% OFF</p>
                    <a class="primary-btn cta-btn" href="#">Library now</a>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /HOT DEAL SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Top selling</h3>
                    <div class="section-nav">
                        <ul class="section-tab-nav tab-nav">
                            <li class="${active1}"><a href="/home">All</a></li>
                            <li class="${active2}"><a href="/home?action=textbooks">Sách Giáo Khoa</a></li>
                            <li class="${active3}"><a href="/home?action=novel">Tiểu Thuyết</a></li>
                            <li class="${active4}"><a href="/home?action=comic">Truyện Tranh</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="book-tabs">
                        <!-- tab -->
                        <div id="tab2" class="tab-pane fade in active">
                            <div class="products-slick" data-nav="#slick-nav-2">
                                <c:forEach items="${requestScope.book}" var="book">
                                    <!-- product -->
                                    <div class="book">
                                        <div class="book-img">
                                            <img src="${book.img}" alt="">
                                            <div class="book-label">
                                                <span class="sale">-10%</span>
                                                <span class="new">NEW</span>
                                            </div>
                                        </div>
                                        <div class="book-body">
                                            <p class="book-brand">${book.publishers}</p>
                                            <h3 class="product-name"><a href="/home?action=detail&id=${book.id}">${book.name}</a></h3>
                                            <h4 class="product-price">$ ${book.price} VND
                                                <del class="product-old-price">${book.price * 1.1}</del></h4>
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
                                            <c:if test="${book.quantity > 0}">
                                                <a href="/cart?action=add&id=${book.id}">
                                                    <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i> add to cart</button></a>
                                            </c:if>
                                            <c:if test="${book.quantity <= 0}">
                                                <p>Sold out</p>
                                            </c:if>
                                        </div>
                                    </div>
                                    <!-- /product -->
                                </c:forEach>
                            </div>
                            <div id="slick-nav-2" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- /Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <h4 class="title">Top Book</h4>
                    <div class="section-nav">
                        <div id="slick-nav-3" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-3">
                    <c:forEach items="${books}" var="sgk">
                        <div>
                            <!-- product widget -->
                            <div class="book-widget">
                                <div class="book-img">
                                    <img src="${sgk.img}" alt="">
                                </div>
                                <div class="book-body">
                                    <p class="product-category">${sgk.publishers}</p>
                                    <h3 class="product-name"><a href="/home?action=detail&id=${sgk.id}">${sgk.name}</a></h3>
                                    <h4 class="product-price">$ ${sgk.price} VND <del class="product-old-price">${sgk.price * 1.1}</del></h4>
                                </div>
                            </div>
                        </div>
                        <!-- /product widget -->
                    </c:forEach>
                </div>
            </div>

            <div class="col-md-4 col-xs-6">
                <div class="section-title">
                    <h4 class="title">Top Novel</h4>
                    <div class="section-nav">
                        <div id="slick-nav-4" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-4">
                    <c:forEach begin="0" end="${novel.size()-1}"  var="novel">
                        <div>
                            <!-- product widget -->
                            <div class="product-widget">
                                <div class="novel-img">
                                    <img src="${novel.get(novel).img}" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">${novel.get(novel).publishers}</p>
                                    <h3 class="product-name"><a href="/home?action=detail&id=${novel.get(novel).id}">${novel.get(novel).name}</a></h3>
                                    <h4 class="product-price">$ ${novel.get(novel).price} VND <del class="product-old-price">${novel.get(novel).price * 1.1}</del></h4>
                                </div>
                            </div>
                            <!-- /product widget -->
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="clearfix visible-sm visible-xs"></div>

            <div class="col-md-4 col-xs-">6
                <div class="section-title">
                    <h4 class="title">Top Comic</h4>
                    <div class="section-nav">
                        <div id="slick-nav-5" class="products-slick-nav"></div>
                    </div>
                </div>

                <div class="products-widget-slick" data-nav="#slick-nav-5">
                    <c:forEach begin="0" end="${comics.size()-1}" var="i">
                        <div>
                            <!-- product widget -->
                            <div class="product-widget">
                                <div class="product-img">
                                    <img src="${comics.get(i).img}" alt="">
                                </div>
                                <div class="product-body">
                                    <p class="product-category">${comics.get(i).publishers}</p>
                                    <h3 class="product-name"><a href="/home?action=detail&id=${comics.get(i).id}">${comics.get(i).name}</a></h3>
                                    <h4 class="product-price">$ ${comics.get(i).price} VND <del class="product-old-price">${comics.get(i).price * 1.1}</del></h4>
                                </div>
                            </div>
                            <!-- /product widget -->
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->
<%--<jsp:include page="../common/footer.jsp"/>--%>
<!-- NEWSLETTER -->
<div id="newsletter" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="newsletter">
                    <p>Sign Up for the <strong>NEWSLETTER</strong></p>
                    <form>
                        <input class="input" type="email" placeholder="Enter Your Email">
                        <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                    </form>
                    <ul class="newsletter-follow">
                        <li>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /NEWSLETTER -->
<div id="newsletter" class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">
            <div class="col-md-12">
                <div class="newsletter">
                    <p>Sign Up for the <strong>NEWSLETTER</strong></p>
                    <form>
                        <input class="input" type="email" placeholder="Enter Your Email">
                        <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>
                    </form>
                    <ul class="newsletter-follow">
                        <li>
                            <a href="#"><i class="fa fa-facebook"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- FOOTER -->


<footer id="footer">
    <!-- top footer -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">About Us</h3>
                                    <p>The cheapest and most reputation store in the world. Confirmed by PuzzyCat Team</p>
                        <ul class="footer-links">
                            <li><a href="#"><i class="fa fa-map-marker"></i>Nhà số 23, Lô TT-01, Khu đô thị MonCity, P. Hàm Nghi, Hà Nội</a></li>
                            <li><a href="#"><i class="fa fa-phone"></i>0123696969</a></li>
                            <li><a href="#"><i class="fa fa-envelope-o"></i>minhhoang3011@gmail.com</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Categories</h3>
                        <ul class="footer-links">
                                          <li><a href="#">Hot deals</a></li>
                                          <li><a href="#">Laptops</a></li>
                                          <li><a href="#">Smartphones</a></li>
                                          <li><a href="#">Cameras</a></li>
                                          <li><a href="#">Accessories</a></li>
                        </ul>
                    </div>
                </div>

                <div class="clearfix visible-xs"></div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Information</h3>
                        <ul class="footer-links">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Orders and Returns</a></li>
                            <li><a href="#">Terms & Conditions</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Service</h3>
                        <ul class="footer-links">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">View Cart</a></li>
                            <li><a href="#">Wishlist</a></li>
                            <li><a href="#">Track My Order</a></li>
                            <li><a href="#">Help</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /top footer -->

    <!-- bottom footer -->
    <div id="bottom-footer" class="section">
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-12 text-center">
                    <ul class="footer-payments">
                        <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                        <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                    </ul>
                    <span class="copyright">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</span>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /bottom footer -->
</footer>
<!-- jQuery Plugins -->
<script src="client/template/js/bootstrap.min.js"></script>
<script src="client/template/js/jquery.min.js"></script>
<script src="client/template/js/jquery.zoom.min.js"></script>
<script src="client/template/js/main.js"></script>
<script src="client/template/js/nouislider.min.js"></script>
<script src="client/template/js/slick.min.js"></script>
</body>
</html>