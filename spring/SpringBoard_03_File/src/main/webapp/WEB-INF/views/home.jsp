<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="00_header.jsp"/>
<jsp:include page="10_nav.jsp"/>
	<div class="jumbotron">
	  <h1>Welcome</h1>
	  <p>Bootstrap is the most popular HTML, CSS...</p>
	  <p>현재시간  ${serverTime }</p>
	</div>
<jsp:include page="90_footer.jsp"/>