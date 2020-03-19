<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="all">

	<div id="content">

		<div class="container">

			<div class="col-md-12" id="basket">

				<div class="box">

					<form method="post" action="checkout1.html">

						<h1>User List</h1>
						<p class="text-muted">You Can destroy user here.</p>
						<div class="table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th colspan="2">Email</th>
										<th>Nickname</th>
										<th colspan="2">Delete</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${objList }" var="mdto">
									<tr>
						
											<td  colspan="2"><a href="#">${mdto.email}</a></td>
											<td>${mdto.nickname }</td>
											<td><a href="./member?action=deleteUser&email=${mdto.email}"><i class="fa fa-trash-o"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>

						</div>
						<!-- /.table-responsive -->

						<div class="box-footer">
							<div class="pull-left">
								<a href="category.html" class="btn btn-default"><i
									class="fa fa-chevron-left"></i> Continue shopping</a>
							</div>
							<div class="pull-right">
								<button class="btn btn-default">
									<i class="fa fa-refresh"></i> Update basket
								</button>
								<button type="submit" class="btn btn-primary">
									Proceed to checkout <i class="fa fa-chevron-right"></i>
								</button>
							</div>
						</div>

					</form>

				</div>
				<!-- /.box -->



			</div>
			<!-- /.col-md-9 -->

		</div>
	</div>