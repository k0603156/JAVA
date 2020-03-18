<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="all">

	<div id="content">
		<div class="container">
			<div class="col-md-12">
				<div class="box">
					<h3>Product 수정</h3>
					<form action="./product" method="post">

						<input type="hidden" name="action" value="pModifySave" /> <input
							type="hidden" name="pno" value="${pdto.pno }" />
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="category">Category</label> <select
										class="form-control" id="category" name="category">
										<option value="${pdto.category }" selected>${pdto.category }</option>
										<option value="mask">마스크</option>
										<option value="hand_sanitizer">손세정제</option>
										<option value="thermomether">체온계</option>
									</select>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="pname">Product Name</label> <input type="text"
										class="form-control" id="pname" name="pname"
										value="${pdto.pname }">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="email">Writer</label> <input type="text"
										class="form-control" id="email" name="pwriter"
										value="${pdto.pwriter}" readonly>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="subject">Image File</label> <input type="file"
										class="form-control" id="imgfile" name="imgfile">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<div class="form-group">
									<label for="pcontent">Content</label>
									<textarea id="message" class="form-control" id="pcontent"
										name="pcontent" >${pdto.pcontent }</textarea>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12 text-center">
								<button type="submit" class="btn btn-primary">
									<i class="fa fa-envelope-o"></i> Modify
								</button>

							</div>
						</div>
				</div>
				<!-- /.row -->

				</form>
			</div>
		</div>
	</div>
</div>