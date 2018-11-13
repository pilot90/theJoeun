<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ include file="../layout/header.jsp" %>

<div class="container-fluid">
	<div class="row">
    	<%@ include file="../layout/sidebar.jsp"%>
    	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	    	<!-- 콘텐츠 부분 -->
	     	<h2><i class="fa fa-eye"></i> 글 보기</h2>
	     	<form name="viewForm" method="post">
	     		<input type='hidden' name='code' value='${result.code}' />
	     		<input type='hidden' name='page' value='${pdto.page}' />
	     		<input type='hidden' name='perPage' value='${pdto.perPage}' />	     		
	     	</form>
			<div class="panel panel-default">
			 	<div class="panel-heading">
			    <h3 class="panel-title">${result.title }</h3>
				</div>
				<div class="panel-body" style="min-height:200px;">
			    	<c:out value="${result.content}"/>
				</div>
				<div class="panel-footer" style="padding-top:1px; padding-bottom:1px; padding-left:10px; padding-right:10px;">
			  		<ul class="view-desc" style="padding-left:0px;">
			  			<li class="writer" style="padding-left:0px; padding-right:0px;">
			  				<span>작성자:</span>
			  				${result.writer }
			  			</li>
			  			<li class="regdate" style="padding-left:0px; padding-right:0px;">
			  				<span>작성일:</span>
			  				<fmt:formatDate value="${result.reg_datetime}" pattern="yyyy-MM-dd HH:mm" />
			  				<!-- <span>조회수 : ${result.view_cnt} </span>  -->
			  			</li>
			  		</ul>
				</div>
			</div>
			<div class="button-group pull-right">
				<c:if test="${ (!empty login) and (login.mbrId eq result.writer)}"> <!-- id값이 없다면 안 보이도록 함 -->
				<button type="button" class="btn btn-success" id="btnModify"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> 수정</button>&nbsp;
				<button type="button" class="btn btn-danger" id="btnDelete"><i class="fa fa-trash"></i> 삭제</button>&nbsp;
				</c:if>
				<button type="button" class="btn btn-default" id="btnAnswer"><i class="fa fa-reply"></i> 답글</button>&nbsp;
				<button type="button" class="btn btn-default" id="btnList"><i class="fa fa-list"></i> 목록</button>
			</div>
			<!-- // 콘텐츠 부분 -->
    	</div> <!-- //.main -->
	</div> <!-- //.row -->
</div> <!-- //container-fluid -->

<!-- JavaScript ============================================= -->
<script>
	$(function(){
		$("#btnModify").on("click", function(){
			self.location ="modify?code=${result.code}&page=${pdto.page}&perPage=${pdto.perPage}";
			// <a href="modify?code=${result.code}" class="btn">수정</a> -> 웹접근성.
		});
		
		$("#btnDelete").on("click", function(){
			var form = $("form[name=viewForm]");
			if(confirm("해당 게시글을 삭제하시겟습니까?")) {
				form.attr("action", "remove");
				form.submit();				
			}
			return;
		});
		
		$("#btnAnswer").on("click", function(){
			self.location ="answer?code=${result.code}&page=${pdto.page}&perPage=${pdto.perPage}";
		})
		
		$("#btnList").on("click", function(){
			self.location ="list?page=${pdto.page}&perPage=${pdto.perPage}";
		});
	})
</script>
<!-- //.JavaScript ============================================== -->

<%@ include file="../layout/footer.jsp" %>