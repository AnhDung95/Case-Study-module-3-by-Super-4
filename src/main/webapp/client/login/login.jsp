<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/8/2022
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!doctype html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <title>Login Library</title>--%>
<%--    <meta charset="utf-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>

<%--    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">--%>

<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">--%>

<%--    <link rel="stylesheet" href="css/style.css">--%>

<%--</head>--%>
<%--<%session.removeAttribute("userID");%>--%>
<%--<c:if test="${requestScope.message.length() > 0}">--%>
<%--    <script>--%>
<%--        alert("${message}");--%>
<%--    </script>--%>
<%--</c:if>--%>
<%--<body class="img js-fullheight" style="background-image: url(images/login-background.png);">--%>
<%--<section class="ftco-section">--%>
<%--    <div class="container">--%>
<%--        <div class="row justify-content-center">--%>
<%--            <div class="col-md-6 text-center mb-5">--%>
<%--                <h2 class="heading-section">Welcome To Library by G4's</h2>--%>
<%--                <h2 class="heading-section">Login</h2>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row justify-content-center">--%>
<%--            <div class="col-md-6 col-lg-4">--%>
<%--                <div class="login-wrap p-0">--%>
<%--                    <h3 class="mb-4 text-center">Type your account, please!</h3>--%>
<%--                    <form action="/login?action=login" method="post" class="signin-form">--%>
<%--                        <div class="form-group">--%>
<%--                            <input type="text" class="form-control" placeholder="Username" name="account" required>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <input id="password-field" type="password" class="form-control" placeholder="Password"--%>
<%--                                   name="password" required>--%>
<%--                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>--%>
<%--                        </div>--%>
<%--                        <div class="form-group">--%>
<%--                            <button type="submit" class="form-control btn btn-primary submit px-3">Sign In</button>--%>
<%--                        </div>--%>
<%--                        <div class="form-group d-md-flex">--%>
<%--                            <div class="w-50">--%>
<%--                                <a href="/register/regis.jsp" style="color: #fff">Create Account</a>--%>
<%--                            </div>--%>
<%--                            <div class="w-50 text-md-right">--%>
<%--                                <a href="#" style="color: #fff">Forgot Password</a>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </form>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

<%--<script src="js/jquery.min.js"></script>--%>
<%--<script src="js/popper.js"></script>--%>
<%--<script src="js/bootstrap.min.js"></script>--%>
<%--<script src="js/main.js"></script>--%>

<%--</body>--%>
<%--</html>--%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/client/login/scss/style.scss">
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <!--Made with love by Mutiullah Samim -->

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-center h-100">
        <div class="card">
            <div class="card-header">
                <div class="col-md-6 text-center mb-5">--%>
                                    <h2 class="heading-section">Welcome To Library</h2>
                                </div>
                <h3>Sign In</h3>
                <div class="d-flex justify-content-end social_icon">
                    <span><a href="https://www.facebook.com"><i class="fab fa-facebook-square"></i></a></span>
                    <span><a href="https://mail.google.com" ><i class="fab fa-google-plus-square"></i></a></span>
                    <span><a href="https://twitter.com">     <i class="fab fa-twitter-square"></i></a></span>
                </div>
            </div>
            <div class="card-body">
                <form>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-user"></i></span>
                        </div>
                        <input type="text" class="form-control" placeholder="username">

                    </div>
                    <div class="input-group form-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-key"></i></span>
                        </div>
                        <input type="password" class="form-control" placeholder="password">
                    </div>
                    <div class="row align-items-center remember">
                        <input type="checkbox">Remember Me
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Login" class="btn float-right login_btn">
                    </div>
                </form>
            </div>
            <div class="card-footer">
                <div class="d-flex justify-content-center links">
                    Don't have an account?<a href="#">Sign Up</a>
                </div>
                <div class="d-flex justify-content-center">
                    <a href="#">Forgot your password?</a>
                </div>
            </div>
        </div>
    </div>
</div>

