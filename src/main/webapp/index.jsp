<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
    .nav{color: black}
    .navbar-nav {
        display: flex;
    }
</style>
<!DOCTYPE html>
<html>
<head>

    <title>JSP - Hello World</title>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <li>
        <i class="fa fa-phone"></i>
        <span>Hotline:0979276042</span>
    </li>
    <div class="navbar-header">
        <img src="sach-anh-du-lich7-788x445.jpg" height="47px" width="47px">
        <a class="navbar-brand" href="#">Thư Viện</a>
    </div>

    <div>
        <ul class="nav navbar-nav">
            <li><a href = "#">Trang Chủ</a></li>
            <li><a href = "#">Giỏ Hàng</a></li>
            <li><a href = "#">Thời Gian Thuê Sách</a></li>
            <li><a href = "#">Lịch Sử Thuê</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    Thể Loại Sách
                    <b class="caret"></b>
                </a>

                <ul class="dropdown-menu">
                    <li><a href="#">Tu Tiên</a></li>
                    <li><a href="#">Kinh Dị</a></li>
                    <li><a href="#">Xuyên Không</a></li>
                    <li><a href="#">Manhua</a></li>
                    <li><a href="#">Tình Cảm</a></li>
                </ul>

            </li>
            <div>
                <form class = "navbar-form navbar-left" role = "search">

                    <div class = "form-group">
                        <input type = "text" class = "form-control" placeholder = "Search">
                    </div>
                    <button type = "submit" class = "btn btn-default">Search</button>

                </form>
            </div>
            <p class = "navbar-text navbar-right">
                <a href = "login.jsp" class = "navbar-link">Đăng Nhập</a>
                <a href = "#" class = "navbar-link">Đăng Ký</a>
            </p>

        </ul>

    </div>

</nav>
<div class="notify_block" style="margin:0;border-radius:0">
    <div class="info">
        <em class="fa fa-info-circle"></em>
    </div>
    <a rel="nofollow noopener" class="vpn" target="_blank" href="login.jsp"><span class="dot"><span class="ping">
        </span></span> Nhấn vào đây
    </a> để lấy lại tài khoản đăng nhập và truyện đã theo dõi
</div>
</body>
</html>