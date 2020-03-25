<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp" />
<jsp:include page="../10_nav.jsp" />
<h2>상품상세</h2>
<table class="table">
	<tbody>
		<tr>
			<td>등록번호</td>
			<td>${pvo.pno }</td>
		</tr>
		<tr>
			<td>상품이름</td>
			<td>${pvo.title }</td>
		</tr>
		<tr>
			<td>게시자</td>
			<td>${pvo.writer }</td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${pvo.readcount }</td>
		</tr>
		<tr>
			<td>등록일</td>
			<td>${pvo.regd8 }</td>
		</tr>
		<tr>
			<td>수정일</td>
			<td>${pvo.modd8 }</td>
		</tr>
		<tr>
			<td>상세설명</td>
			<td>${pvo.content }</td>
		</tr>
		<tr>
			<td>이미지</td>
			<td>${pvo.imgfile }</td>
		</tr>
		<tr>
			<td><a href="/product/modify?pno=${pvo.pno }"
				class="btn btn-outline-warning">수정</a></td>
			<td ><button type="button"
					class="btn btn-outline-danger" id="rm-btn">삭제</button></td>
		</tr>
	</tbody>
</table>
<form id="rm-form" action="/product/remove" method="post">
	<input type="hidden" name="pno" value="${pvo.pno }" />
</form>

<script>
	let result = `<c:out value="${result}"/>`;
	if (result === "modify_success") {
		alert("상품수정완료");
	}
	result = '';
</script>

<script>
	window.onload = function() {
		document.getElementById("rm-btn").addEventListener("click",
				function(e) {
					document.getElementById("rm-form").submit();
				});
	};
</script>
<jsp:include page="../90_footer.jsp" />