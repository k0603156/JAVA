<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"/>
<jsp:include page="../10_nav.jsp"/>
<p class="text-right">
	<a class="btn btn-outline-primary" href="/product/write">상품등록</a>
</p>
<script>
	let result = `<c:out value="${result}"/>`;
	if(result === "write_success"){
		alert("상품등록완료");	
	}
	result = '';
</script>
<jsp:include page="../90_footer.jsp"/>