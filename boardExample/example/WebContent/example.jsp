<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:set var="vatName" value="varvalue"/>
var:<c:out value="${vatName}"/>
<c:remove var="vatName"/>
var:<c:out value="${vatName}"/>
<c:catch var="error">
<%=2/0 %>
</c:catch>
<br/>
<c:out value="${error}"/>
<hr/>

</body>
</html>