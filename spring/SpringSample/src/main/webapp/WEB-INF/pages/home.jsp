<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<meta charset="UTF-8">
	<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<main>
<section class="flex">
		<c:forEach items="${contents }" var="content">
			<div class="max-w-sm rounded overflow-hidden shadow-lg">
			  <img class="w-full" src="https://tailwindcss.com/img/card-left.jpg" alt="Sunset in the mountains">
			  <div class="px-6 py-4">
			    <div class="font-bold text-xl mb-2">${content.title }</div>
			    <p class="text-gray-700 text-base">
			      ${content.body }
			    </p>
			  </div>
			  <div class="px-6 py-4">
			    <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2">#해시태그</span>
			    <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2">#해시태그</span>
			  </div>
			</div>
		</c:forEach>
</section>
</main>
</body>
</html>
