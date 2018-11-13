<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../layout/header.jsp"%>

<div class="container-fluid">
    <div class="row">
    	<%@ include file="../layout/sidebar.jsp"%>
	    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	    	<!-- 콘텐츠 부분 -->
	     	<h2><i class="fa fa-pencil-square-o text-info" aria-hidden="true"></i> 글 작성</h2>
			<form id="writeForm" name="writeForm" method="post">
				<div class="form-group">
			  		<label for="inputTitle">제목</label>
			  		<input type="text" class="form-control" name="title" id="inputTitle" placeholder="제목 입력">
				</div>
				<div class="form-group">
				    <label for="inputContent">내용</label>
				    <textarea class="form-control" style="height:300px" id="inputContent" name="content" maxlength="2048"
				     placeholder="내용 입력..."></textarea>
			  	</div>
			  	<div class="form-group">
					<label for="inputWriter">작성자</label>
					<input type="text" class="form-control" name="writer" id="inputWriter" value="${login.mbrId}" readonly="readonly">
			  	</div>
			  	<div class="button-group pull-right">
				  	<button type="submit" class="btn btn-primary"><i class="fa fa-pencil"></i> 등록</button>&nbsp;
				  	<a href='list' class="btn btn-default"><i class="fa fa-list"></i> 목록</a>
				</div>
			</form>
	 		<!-- // 콘텐츠 부분 -->
	    </div> <!-- /.main -->
	</div> <!-- //.row -->
</div> <!-- //container-fluid -->
<!-- JavaScript ============================================= -->
<script>
	// 글 쓰기
	function fn_addtoBoard(){
	    var form = document.getElementById("writeForm");
	    
	    form.action = "<c:url value='/qna/write'/>";
	    form.submit();
	}
	 
	// 목록
	function fn_cancel(){
	    var form = document.getElementById("writeForm");
	    
	    form.action = "<c:url value='/qna/boardList'/>";
	    form.submit();
	}
</script>
<!-- //.JavaScript ============================================== -->

<%@ include file="../layout/footer.jsp" %>
