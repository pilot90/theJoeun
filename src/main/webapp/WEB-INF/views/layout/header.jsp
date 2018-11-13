<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String ctxPath = request.getContextPath(); %>
<html>
<head>
	<link rel="stylesheet" href="<%=ctxPath%>/resources/css/bootstrap.css" />
	<link rel="stylesheet" href="<%=ctxPath%>/resources/css/custom.css" />
	<link rel="stylesheet" href="<%=ctxPath%>/resources/css/dashboard.css"/>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 	<script src="<%=ctxPath%>/resources/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/qna/list">SPRING BOARD</a>
        </div>
       <div id="navbar" class="navbar-collapse collapse">
       <c:if test="${empty login}">
          <form class="navbar-form navbar-right" action="${pageContext.request.contextPath}/member/login" method="POST">          
            <div class="form-group">
              <input type="text" placeholder="아이디" name="mbrId" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="비밀번호" name="mbrPw" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">로그인</button>
          </form>
        </c:if>
        <c:if test="${!empty login}">
        	<div class="navbar-right" style="color:#F5F5F5; padding-top:13px; padding-right:10px;">
        		<span class="user">${login.mbrName}</span>&nbsp;님
        		<a href="" style="color:#F5F5F5; padding-left:5px; padding-right:10px;"><i class="fa fa-lock"></i> 내 정보</a>
        		<a href="${pageContext.request.contextPath}/member/logout" class="btn btn-sm btn-default" style="padding-bottom:0px; padding-top:0px; padding-right:2px; padding-left:2px;">로그아웃</a>
        	</div>
        </c:if>  
        </div><!--/.navbar-collapse -->
      </div>
    </nav>
