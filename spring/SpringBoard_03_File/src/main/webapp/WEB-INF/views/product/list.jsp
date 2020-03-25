<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="../00_header.jsp" />
<jsp:include page="../10_nav.jsp" />
<p class="text-right">
	<a class="btn btn-outline-primary" href="/product/write">상품등록</a>
</p>
<h2>상품리스트</h2>
<table class="table table-hover">
	<thead>
		<tr>
			<th>등록번호</th>
			<th>상품명</th>
			<th>등록자</th>
			<th>조회수</th>
			<th>등록날짜</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${list ne null && list.size() != 0}">
				<c:forEach items="${list }" var="pvo">
					<tr>
						<td>${pvo.pno }</td>
						<td><a href="/product/detail?pno=${pvo.pno }">${pvo.title }</a></td>
						<td>${pvo.writer }</td>
						<td>${pvo.readcount }</td>
						<td>${pvo.modd8 }</td>
					</tr>

				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="5"><h3>등록된 상품이 없습니다.</h3></td>
				</tr>
			</c:otherwise>

		</c:choose>
	</tbody>
</table>


<script>
	let result = `<c:out value="${result}"/>`;
	if (result === "write_success") {
		alert("상품등록완료");
	}
	else if(result === "remove_success"){
		alert("상품삭제완료")
	}
	result = '';
</script>


<jsp:include page="../90_footer.jsp" />