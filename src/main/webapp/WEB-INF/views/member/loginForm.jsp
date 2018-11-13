<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Signin Template for Bootstrap</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />    
    <link href="${pageContext.request.contextPath}/resources/css/signin.css" rel="stylesheet">
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <div class="container">
      <form class="form-signin" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputId" class="sr-only">아이디</label>
        <input type="text" id="inputId" name="mbrId" class="form-control" placeholder="아이디" required autofocus>
        <label for="inputPw" class="sr-only">비밀번호</label>
        <input type="password" id="inputPw" name="mbrPw" class="form-control" placeholder="비밀번호" required>
         <div class="checkbox">
          <label>
            <input type="checkbox" name="rememberMe" value="true"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
      </form>
    </div> <!-- /container -->
<script src="http://code.jquery.com/jquery-2.2.4.min.js"></script>
    
</body>
</html>
