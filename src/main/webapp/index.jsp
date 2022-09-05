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
    .footer__title{
        display: flex;
        justify-content: space-between;
    }
    .syJk0q{
        display: block;
    }
    .EWPRwa span {
        text-align: center;
        margin-top:20px;
    }
    .Footer span{
         text-align: center;
    }
    .Footer{
        margin-top:40px;
    }

</style>
<!DOCTYPE html>
<html>
<head>
    <nav class="navbar navbar-inverse navbar-default navbar-fixed-top" role="navigation">
        <li>
            <i class="fa fa-phone" style="margin-left: 1300px"></i>
            <span>Hotline:0979276042</span>
        </li>
        <div class="navbar-header">
            <img src="sach-anh-du-lich7-788x445.jpg" height="47px" width="47px">
            <a class="navbar-brand" href="#">Thư Viện</a>
        </div>

        <div>
            <ul class="nav navbar-nav">
                <li><a href = "#">Trang Chủ</a></li>
                <li><a href = "/client/view/cart.jsp">Giỏ Hàng</a></li>
                <li><a href = "#">Thời Gian Thuê Sách</a></li>
                <li><a href = "#">Lịch Sử Thuê</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        Thể Loại Sách
                        <b class="caret"></b>
                    </a>

                    <ul class="dropdown-menu">
                        <li><a href="#">Ẩm thực - Nấu ăn</a></li>
                        <li><a href="#">Cổ Tích - Thần Thoại</a></li>
                        <li><a href="#">Công Nghệ Thông Tin</a></li>
                        <li><a href="#">Học Ngoại Ngữ</a></li>
                        <li><a href="#">Khoa Học - Kỹ Thuật</a></li>
                        <li><a href="#">Kiếm Hiệp - Tiên Hiệp</a></li>
                        <li><a href="#">Marketing - Bán hàng</a></li>
                        <li><a href="#">Kiến Trúc - Xây Dựng</a></li>
                        <li><a href="#">Kinh Tế - Quản Lý</a></li>
                        <li><a href="#">Lịch Sử - Chính Trị</a></li>
                        <li><a href="#">Nông - Lâm - Ngư</a></li>
                        <li><a href="#">Phiêu Lưu - Mạo Hiểm</a></li>
                        <li><a href="#">Tài Liệu Học Tập</a></li>
                        <li><a href="#">Tâm Lý - Kỹ Năng Sống</a></li>
                        <li><a href="#">Tiểu Thuyết Phương Tây</a></li>
                        <li><a href="#">Trinh Thám - Hình Sự</a></li>
                        <li><a href="#">Truyện Ngắn - Ngôn Tình</a></li>
                        <li><a href="#">Tử Vi - Phong Thủy</a></li>
                        <li><a href="#">Y Học - Sức Khỏe</a></li>
                        <li><a href="#">Thể Thao - Nghệ Thuật</a></li>
                        <li><a href="#">Tiểu Thuyết Trung Quốc</a></li>
                        <li><a href="#">Truyện Cười - Tiếu Lâm</a></li>
                        <li><a href="#">Truyên Teen - Tuổi Học Trò</a></li>
                        <li><a href="#">Văn Hóa - Tôn Giáo</a></li>
                        <li><a href="#">Văn Học Việt Nam</a></li>
                        <li><a href="#">Truyện Tranh</a></li>
                        <li><a href="#">Truyện Ma - Truyện Kinh Dị</a></li>
                        <li><a href="#">Triết Học</a></li>
                        <li><a href="#">Khác</a></li>
                    </ul>

                </li>
                <div>
                    <form class = "navbar-form navbar-left" action="/menu" role = "search"  method="get">
<input name="action" value="search" hidden>
                        <div class = "form-group">
                            <input type = "text" name="search"  class = "form-control" placeholder = "Search">
                        </div>
                        <button type = "submit"  class = "btn btn-default">Search</button>

                    </form>
                </div>
                <p class = "navbar-text navbar-right">
                    <a href = "login.jsp" class = "navbar-link">Đăng Nhập</a>
                    <a href = "sign-up.jsp" class = "navbar-link">Đăng Ký</a>
                </p>

            </ul>

        </div>

    </nav>

</head>
<body>

<form style="margin-top: 100px">
    <div class="notify_block" style="margin-left: 556px;border-radius:0">
        <div class="info">
            <em class="fa fa-info-circle"></em>
        </div>
        <a rel="nofollow noopener" class="vpn" target="_blank" href="login.jsp">
        <span class="dot">
            <span class="ping">
        </span>
        </span> Nhấn vào đây
        </a> để lấy lại tài khoản đăng nhập và truyện đã theo dõi
    </div>
    <div class="main_home"style="margin-left: 150px"><div class="text-center"><h1>Thư Viện Miễn Phí</h1><div class="row"><div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2 mg-t-15">
        <div class="fs-20 fw-300">
            <p>
                <strong><font color="0000FF">Nhà sách miễn phí</font>
                </strong>
                được xây dựng nhằm chia sẻ sách  miễn phí cho những ai khó khăn, chưa có điều kiện mua sách.<br>
                Nếu <strong> Bạn có điều kiện, Hãy mua sách giấy để ủng hộ Tác giả và Nhà xuất bản.
            </strong>
            </p>
        </div>
    </div>
    </div>
    </div>
        <div class="mg-tb-30"style="margin-left: 94px"><div class="line"></div></div><div class="row"><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Ẩm thực - Nấu ăn</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Cổ Tích - Thần Thoại</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Công Nghệ Thông Tin</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Học Ngoại Ngữ</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Hồi Ký - Tuỳ Bút</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
             <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Khác</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Khoa Học - Kỹ Thuật</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Kiếm Hiệp - Tiên Hiệp</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Kiến Trúc - Xây Dựng</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Kinh Tế - Quản Lý</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Lịch Sử - Chính Trị</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Marketing - Bán hàng</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Nông - Lâm - Ngư</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Phiêu Lưu - Mạo Hiểm</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Tài Liệu Học Tập</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Tâm Lý - Kỹ Năng Sống</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Thể Thao - Nghệ Thuật</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Thư Viện Pháp Luật</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Tiểu Thuyết Phương Tây</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Tiểu Thuyết Trung Quốc</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Triết Học</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Trinh Thám - Hình Sự</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Truyện Cười - Tiếu Lâm</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Truyện Ma - Truyện Kinh Dị</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Truyện Ngắn - Ngôn Tình</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Truyên Teen - Tuổi Học Trò</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Truyện Tranh</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Tử Vi - Phong Thủy</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Văn Hóa - Tôn Giáo</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Văn Học Việt Nam</a></div></div><div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 mg-tb-7"><div class="item_folder">
            <a href=""style="margin-left: 94px"><i class="fa fa-folder-open"></i>Y Học - Sức Khỏe</a></div></div></div></div>
</form>
<div class="footer__title" style="border-top: 1px solid red" >
    <a class="syJk0q"> © 2022 Thư Viện. Tất cả các quyền được bảo lưu. Quốc gia &amp; Khu vực:</a>
    <span class="syJk0q">Singapore|Indonesia|Đài Loan|Thái Lan|Malaysia|Việt Nam|PhiLippines|Brazil|Mexico|Colombia|Chile|Polan|Argentina</span>
</div>
<div class="EWPRwa row">

            <span class="col-lg-3">Chính sách bảo mật</span>
            <span class="col-lg-3">Quy chế hoạt động</span>
            <span class="col-lg-3">Chính sách vận chuyển</span>
            <span class="col-lg-3">CHÍNH SÁCH TRẢ HÀNG VÀ HOÀN TIỀN</span>
</div>
<div class="Footer row">
   <span class="col-lg-12"> Công ty Fatasic Four</span>
    <span class="col-lg-12">Địa chỉ: Tầng 2-5-6, Tòa nhà CodeGym, số CT01-23 khu MonCity, Phường Bắc Từ Liêm, Quận Ba Đình, Thành phố Hà Nội, Việt Nam. Tổng đài hỗ trợ: 0964002838 - Email: imbakito1604@gmail.com</span>
    <span class="col-lg-12">Chịu Trách Nhiệm Quản Lý Nội Dung: Phạm Minh Hoàng  - Điện thoại liên hệ: 0964002838  (ext 4678)</span>
    <span class="col-lg-12">Mã số doanh nghiệp: 0106773786 do Sở Kế hoạch & Đầu tư TP Hà Nội cấp lần đầu ngày 10/02/2015</span>
    <span class="col-lg-12">© 2015 - Bản quyền thuộc về Công ty TNHH Fantasic Four</span>
</div>
</body>
</html>