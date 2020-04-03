<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../00_header.jsp"></jsp:include>
<jsp:include page="../10_nav.jsp"></jsp:include>

<h2>상품 상세 정보</h2>
<table class="table table-bordered">
	<tr>
		<th>등록번호</th>
		<td>${pvo.pno }</td>
	</tr>
	<tr>
		<th>상품이름</th>
		<td>${pvo.title }</td>
	</tr>
	<tr>
		<th>등록자</th>
		<td>${pvo.writer }</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${pvo.readcount }</td>
	</tr>
	<tr>
		<th>상품등록일</th>
		<td>${pvo.regd8 }</td>
	</tr>
	<tr>
		<th>최종수정일</th>
		<td>${pvo.modd8 }</td>
	</tr>
	<tr>
		<th>상세설명</th>
		<td>${pvo.content }</td>
	</tr>
	<tr>
		<th>상품 이미지</th>
		<td>
		<c:choose>
			<c:when test="${!pvo.imgfile.equals('NONE') }">
				<img src="/images/${pvo.imgfile }" width="33%">
			</c:when>
			<c:otherwise>
				${pvo.imgfile }
			</c:otherwise>
		</c:choose>
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<a href="/product/list?pageNum=${cri.pageNum }&amount=${cri.amount }&type=${cri.type }&keyword=${cri.keyword }"
		 class="btn btn-outline-secondary">목록</a>
		<a href="/product/modify?pno=${pvo.pno }&pageNum=${cri.pageNum }&amount=${cri.amount }&type=${cri.type }&keyword=${cri.keyword }"
			class="btn btn-outline-warning">수정</a>
			<button type="button" class="btn btn-outline-danger" id="rmBtn">삭제</button>
		</td>
	</tr>
</table>

<form action="/product/remove" method="post" id="rmForm">
	<input type="hidden" name="pno" value="${pvo.pno }">
	<input type="hidden" name="imgfile" value="${pvo.imgfile }">
	<input type="hidden" name="pageNum" value="<c:out value='${cri.pageNum }' />">
	<input type="hidden" name="amount" value="<c:out value='${cri.amount }' />">
	<input type="hidden" name="type" value="<c:out value='${cri.type }' />">
	<input type="hidden" name="keyword" value="<c:out value='${cri.keyword }' />">
</form>
<form>
  <div class="input-group mb-3 input-group-lg">
    <div class="input-group-prepend">
      <span class="input-group-text">${pvo.writer }</span>
    </div>
    <input type="text" class="form-control" id="input-cmt">
      <div class="input-group-append">
    <button class="btn btn-success" id="submit-cmt" type="button">댓글 전송</button>
  </div>
  </div>
</form>
<ul id="list-cmt-ul" class="list-group list-group-flush">
  <li class="list-group-item">First item</li>
</ul>

<ul id="pagination-cmt" class="pagination pagination-sm  justify-content-center">

</ul>
<script src="/resources/js/comment.js"></script>
<script>
	$(function() {
		var pno = '<c:out value="${pvo.pno}"/>';
		var writer ='<c:out value="${pvo.writer}"/>';
		listComment(pno,1);
		$(document).on("click", "#rmBtn", function() {
			$("#rmForm").submit();
		});
		$(document).on("click","#pagination-cmt li a", function(e){
			e.preventDefault();
			listComment(pno,e.target.text);
		});
		$(document).on("click", "#submit-cmt",{
			pno:pno,
			writer:writer
		}, addComment);
	
		$(document).on("click","#modCmtBtn",function(e){
			e.preventDefault();
			console.log(e.target.parentElement.getElementsByClassName("cmtText").text);
			commentBtn = $(this).clone();
				commentWrapper =$(this).closest("li");
				commentCno =commentWrapper.data("cno");
			var groupCmtText =commentWrapper.find(".cmtText");
			var prevText=groupCmtText.text();
			groupCmtText.text("");
			var inTag = '<div class="input-group input-group-sm" id="modInput">';
			inTag	+='<input type="text" class="form-control" id="cmtModText" value="'+prevText
					+'">'
			      	+'<div class="input-group-append">'
		    		+'<button class="btn btn-success" id="cmtModSubmit" type="button">댓글 전송</button></div>';
			groupCmtText.html(inTag).trigger("create");
			console.log(e.target.parentElement.querySelector("#modCmtBtn"));
			commentWrapper.find("#modCmtBtn").remove();
		});
		$(document).on("click","#cmtModSubmit",function(){
			modVal = $("#cmtModText").val();
			modifyComment(modVal,commentCno);
		})
	});
	var result = '<c:out value="${result}" />';
	if (result == 'modify_ok') {
		alert("상품 수정이 완료되었습니다~!");
	}
	result = "";
</script>
<jsp:include page="../90_footer.jsp"></jsp:include>
