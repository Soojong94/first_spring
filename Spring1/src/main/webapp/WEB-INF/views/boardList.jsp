<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<h2>Spring version 1.</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Board</div>
			<div class="panel-body">
				<table class="table talbe-hover">
					<thead>
						<tr class="warning">
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach items="${list}" var="vo" varStatus="i">
							<tr>
								<td>${i.count}</td>
								<td>${vo.title}</td>
								<td>${vo.writer}</td>
								<td>${vo.indate}</td>
								<td>${vo.count}</td>
							</tr>
						</c:forEach>

					</tbody>

				</table>
			</div>
			<div class="panel-footer">스프링 게시판 -Kim</div>
		</div>
	</div>

</body>
</html>
