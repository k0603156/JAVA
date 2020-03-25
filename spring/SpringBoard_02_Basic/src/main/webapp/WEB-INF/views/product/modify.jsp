<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"/>
<jsp:include page="../10_nav.jsp"/>
<h2>상품상세</h2>
<form action='/product/modify' method="post">
<table class="table">
    <tbody>
      <tr>
        <td>등록번호</td>
        <td><input class="form-control" type="text" name="pno" value="${pvo.pno }" readonly/></td>
      </tr>
      <tr>
        <td>상품이름</td>
        <td><input class="form-control" type="text" name="title" value="${pvo.title }" /></td>
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
        <td><textarea class="form-control" name="content" rows="5">${pvo.content }</textarea></td>
      </tr>
       <tr>
        <td>이미지</td>
        <td><input class="form-control" type="file" name="imgfile" value="${pvo.imgfile }"/></td>
      </tr>
      <tr>
      	<td colspan="2"><button class="btn btn-outline-warning">수정완료</button></td>
      </tr>
    </tbody>
  </table>
  </form>
<jsp:include page="../90_footer.jsp"/>