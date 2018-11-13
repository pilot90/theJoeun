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
	    <div class="col-sm-6 col-sm-offset-3 col-md-6 col-md-offset-3 main">
	    	<!-- 콘텐츠 부분 -->
	     	<h2><i class="fa fa-pencil-square-o text-info" aria-hidden="true"></i> 회원 가입</h2>
			<form id="joinForm" name="joinForm" method="post">
				<div class="form-group">
			  		<label for="inputId">아이디</label>
			  		<input type="text" class="form-control" name="mbrId" id="inputId" placeholder="아이디 입력">
			  		<button type="button" id="confirmBtn">중복체크</button>
				</div>
				<!-- 아이디 중복 경고창 -->
				<div class="alert alert-danger" id="alert-dangerId" style="margin-bottom:5px;">이미 사용중인 아이디입니다.</div>
				<!-- //.아이디 중복 경고창 -->
				<div class="form-group">
			  		<label for="inputPw">비밀번호</label>
			  		<input type="password" class="form-control" name="mbrPw" id="inputPw" placeholder="비밀번호 입력">
				</div>
				<div class="form-group">
			  		<label for="inputPwConfirm">비밀번호 확인</label>
			  		<input type="password" class="form-control" name="mbrPwCheck" id="inputPwConfirm" placeholder="비밀번호 확인">
				</div>
				<!-- 비밀번호 불일치 경고창 -->
				<div class="alert alert-danger" id="alert-dangerPw" style="margin-bottom:5px;">비밀번호가 일치하지 않습니다.</div>
				<!-- //.비밀번호 불일치 경고창 -->
			  	<div class="form-group">
					<label for="inputName">이름</label>
					<input type="text" class="form-control" name="mbrName" id="inputName" placeholder="이름 입력">
			  	</div>
			  	<div class="button-group pull-right">
				  	<button type="submit" class="btn btn-primary" id="submit"><i class="fa fa-pencil"></i> 등록</button>&nbsp;
				  	<a href='${pageContext.request.contextPath}/board/list.do' class="btn btn-default"><i class="fa fa-list"></i> 취소</a>
				</div>
			</form>
	 		<!-- // 콘텐츠 부분 -->
	    </div> <!-- /.main -->
	</div> <!-- //.row -->
</div> <!-- //container-fluid -->

<!-- JavaScript ============================================= -->
<script>
	$(function(){
		// 아이디, 비밀번호 경고창 숨김
		$("#alert-dangerId").hide();
		$("#alert-dangerPw").hide();
		
		// 아이디 검사
		$(document).ready(function(){
			$("#confirmBtn").click(function(){
				var mbrId = $("#inputId").val();
				if(mbrId == "") {
					alert("아이디를 입력하세요.")
					$("#inputId").focus();
					return;
				} else if((mbrId < "0" || mbrId > "9") && (mbrId < "A" || mbrId > "Z") && (mbrId < "a" || mbrId > "z")) {
					alert("한글 및 특수문자는 사용할 수 없습니다.");
					$("#inputId").focus();
					return;
				} else {
					$.ajax({
						url : "${pageContext.request.contextPath}/member/duplicate/" + mbrId,
						type : "POST",
						success : function(data){
							// 아이디 중복 체크
							if(data == "DUPLICATED") { // 아이디 중복인 경우
								$("#alert-dangerId").show();
								$("#inputId").focus();
								$("#submit").attr("disabled", "disabled");
							} else { // 사용가능한 경우
								$("#alert-dangerId").hide();
								$("#submit").removeAttr("disabled");
							}
						}
					});
				}
			});
		});
		
		// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
		$("input").keyup(function(){
			var pw1 = $("#inputPw").val();
			var pw2 = $("#inputPwConfirm").val();
			if(pw1 != "" && pw2 != "") {
				if(pw1 != pw2) { // 비밀번호 불일치하는 경우
					$("#alert-dangerPw").show();
					$("#submit").attr("disabled", "disabled");
				} else { // 비밀번호 일치하는 경우
					$("#alert-dangerPw").hide();
					$("#submit").removeAttr("disabled");
				}
			}
		});
	});
</script>
<!-- //.JavaScript ============================================== -->

<%@ include file="../layout/footer.jsp" %>
