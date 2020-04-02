<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<h2 class="float-left">Q&A<a href="/qna/write" class="btn btn-outline-primary">Q&A등록</a></h2>
<div class="float-right form-group">
<form class="form-inline" action="/qna/list">
<select class="form-control" name="type">
	<option value="TCW">검색범위</option>
	<option value="T">제목</option>
	<option value="W">작성자</option>
	<option value="C">내용</option>
	<option value="TW">제목or작성자</option>
	<option value="TC">제목or내용</option>
	<option value="CW">작성자or내용</option>
</select>
  <input type="text" class="form-control" placeholder="Search" name="keyword">
  <input type="hidden" name="pageNum" value="1">
  <input type="hidden" name="amount" value="<c:out value='${qgno.cri.amount }' />">
  <div class="input-group-append">
    <button class="btn btn-success" type="submit">검색</button>
  </div>
  </form>
</div>
<table class="table table-bordered table-hover">
	<thead>
		<tr>
			<th>등록번호</th>
			<th>제목</th>
			<th>등록자</th>
			<th>조회수</th>
			<th>등록날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${list ne null && list.size() != 0 }">
				<c:forEach items="${list }" var="qvo">
				<tr>
					<td>${qvo.qno }</td>
					<td><a href="/qna/detail?qno=${qvo.qno }&pageNum=${qgvo.cri.pageNum }&amount=${qgno.cri.amount }&type=${qgno.cri.type }&keyword=${qgno.cri.keyword }">${qvo.title }</a></td>
					<td>${qvo.writer }</td>
					<td>${qvo.readcount }</td>
					<td>${qvo.modd8 }</td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr><td colspan="5"><h3>등록된 Q&A가 없습니다</h3></td></tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>
 <ul class="pagination">
 <c:if test="${qgno.prev }">
  <li class="page-item"><a class="page-link"
   href="/qna/list?pageNum=${qgno.startPage-1 }&amount=${qgno.cri.amount}&type=${qgno.cri.type }&keyword=${qgno.cri.keyword }">Prev</a></li>
  </c:if>
  <c:forEach var="i" begin="${qgno.startPage }" end="${qgno.endPage }">
  <li class="page-item ${qgno.cri.pageNum == i ? 'active' : '' }"><a class="page-link"
   href="/qna/list?pageNum=${i }&amount=${qgno.cri.amount}&type=${qgno.cri.type }&keyword=${qgno.cri.keyword }">${i }</a></li>
  </c:forEach>
 <c:if test="${qgno.next }"> 
  <li class="page-item"><a class="page-link"
   href="/qna/list?pageNum=${qgno.endPage+1 }&amount=${qgno.cri.amount}&type=${qgno.cri.type }&keyword=${qgno.cri.keyword }">Next</a></li>
  </c:if>
</ul>
<script>
$(function(){
	let sform = $(".form-inline");
	$(".form-inline button").on("click",function(e){
		console.log("check1");
		e.preventDefault();
		console.log("check2 : "+ sform.find("input[name='keyword']").val());
		if(!sform.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요!");
			return false;
		}
		sform.submit();
	});
});
</script>
<script>
	let result = '<c:out value="${result}" />';
	if (result == 'write_ok') {
		alert("상품 등록이 완료되었습니다~!");
	}else if (result == 'remove_ok') {
		alert("상품 삭제 완료되었습니다~!");
	} 
	result = "";
</script>
<jsp:include page="../90_footer.jsp"></jsp:include>
