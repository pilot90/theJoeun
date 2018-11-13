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
	     	<h2><i class="fa fa-list" aria-hidden="true"></i> 게시판 리스트</h2>
	    	<form id="boardForm" name="boardForm" method="post">
		        <table class="table table-striped rable-hover">
		            <thead>
		                <tr>
		                    <th>번호</th>
		                    <th>제목</th>
		                    <th>작성자</th>
		                    <th>날짜</th>
		                    <th>조회수</th>
		                </tr>
		            </thead>
		            <tbody>
		                <c:forEach var="result" items="${list }" varStatus="status">
		                    <tr>
		                        <td><c:out value="${result.code }"/></td>
		                        <td><a href='view?code=${result.code}'><c:out value="${result.title }"/></a></td>
		                        <td><c:out value="${result.writer }"/></td>
		                        <td><fmt:formatDate value="${result.reg_datetime}" pattern="yyyy-MM-dd HH:mm"/></td>
		                        <td><span class="badge bg-red">${result.view_cnt}</span></td>
		                    </tr>
		                </c:forEach>
		            </tbody>
		        </table>
		        <div class="button-group pull-right">            
		            <a href='#' onClick='fn_write()' class="btn btn-primary"><i class="fa fa-pencil" aria-hidden="true"></i> 작성</a>
		        </div>
	    	</form>
	    	<!-- // 콘텐츠 부분 -->
    	</div> <!-- //.main -->
	</div> <!-- //.row -->
</div> <!-- //container-fluid -->

<!-- JavaScript ============================================= -->
<script>
	// 글 쓰기
	function fn_write(){
	    var form = document.getElementById("boardForm");
	    
	    form.method = "GET";
	    form.action = "<c:url value='/board/write'/>";
	    form.submit();
	}
	/* // 글 조회
	function fn_view(code){
	    var form = document.getElementById("boardForm");
	    form.method = "GET";
	    var url = "<c:url value='/board/view'/>";
	    url = url + "?code=" + code;
	    
	    form.action = url;    
	    form.submit(); 
	} */
</script>
<!-- //.JavaScript ============================================== -->

<%@ include file="../layout/footer.jsp" %>
