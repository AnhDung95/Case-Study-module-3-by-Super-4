<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 8/29/2022
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500&display=swap');
        *{
            box-sizing:border-box;
        }
        body{
            font-family:'Montserrat',sans-serif;
            font-size:17px;
        }
        #wrapper{
            display:flex;
            jusstify-content:center;
            algin-items:center;
            min-height:80vh;
        }
        form{
            border:1px solid #dadce0;
            border-radius: 5px;
            padding: 30px;
        }
        h3{
            text-align: center;
            font-size: 24px;
            font-weight: 500;
        }
        .form-group{
            margin-bottom: 15px;
        }
        input{
            height: 50px;
            width: 300px;
            outline: none;
            border: 1px solid #dadce0;
            padding: 10px;
            border-radius: 5px;
            font-size: inherit;
            color: #202124;
        }
        label{
            position: absolute;
            padding: 0px 5px;
            left: 29px;
            top: 27%;
            pointer-events: none;
            transform: translateY(-50%);
            background: #fff;
            transition: all 0.3s ease-in-out;
        }
        .form-group input:focus{
            border:2px solid #1a73e8;
        }
        .form-group input:focus + label,form-group input:valid+label{
            top:0px;
            font-size:13px;
            font-weight: 500;
            color: black;
        }
        input#btn-login{
            background: #1a73e8;
            color: #ffffff;
        }
        input#btn-login:hover {
            opacity: 0.85;
        }
    </style>
    <div id="wrapper">
        <form  action="/auth?action=login" method="post">
            <h3>Đăng nhập</h3>
            <div class="form-group">
                <input type="text" name="account" required>
                <label name="account"></label>
            </div>
            <div class="form-group">
                <input type="password" name="password" required>
                <label name="password"></label>
            </div>
            <input type="submit" value="Đăng nhập" id="btn-login">
        </form>
    </div>
</body>
</html>
