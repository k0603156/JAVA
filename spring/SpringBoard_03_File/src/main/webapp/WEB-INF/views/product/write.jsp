<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"/>
<jsp:include page="../10_nav.jsp"/>
<h2>상품등록</h2>
<form method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="title">Title</label>
    <input type="text" class="form-control" placeholder="Title" id="title" name="title">
  </div>
  <div class="form-group">
    <label for="writer">Writer</label>
    <input type="text" class="form-control" placeholder="Writer" id="writer" name="writer">
  </div>
  <div class="form-group">
    <label for="file">Image</label>
    <input type="file" class="form-control" placeholder="File" id="imgfile" name="imgfile">
  </div>
  <div class="form-group">
    <label for="content">Content</label>
    <textarea class="form-control" placeholder="Content" id="content" name="content" rows="5"></textarea>
  </div>
  <button type="submit" class="btn btn-primary">Registration</button>
</form>

<jsp:include page="../90_footer.jsp"/>