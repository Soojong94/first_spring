<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<%
	pageContext.setAttribute("ln", "\n");
	%>
	<div class="container">
		<h2>Spring version 1.</h2>
		<div class="panel panel-default">
			<div class="panel-heading">Board</div>
			<div class="panel-body">
				<table class="table">
					<tbody>

						<tr>
							<td>제목</td>
							<td>
								<!-- 해당 게시글 제목이 나오게 --> ${vo.title}
							</td>
						</tr>
						<tr>
							<td>내용</td>
							<td>
								<!-- 해당 게시글 내용이 나오게 --> ${fn:replace(vo.content, ln, "<br>")}
							</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td>
								<!-- 해당 게시글 작성자가 나오게 -->${vo.writer}
							</td>
						</tr>
						<tr>
							<td>작성일</td>
							<td>
								<!-- 해당 게시글 작성일이 나오게 --> ${fn:split(vo.indate," ")[0]}
							</td>
						</tr>
						<td colspan="2" align="center"><a
							href="boardUpdateForm.do?idx=${vo.idx}" class="btn btn-info">수정화면</a>
							<a href="boardDelete.do?idx=${vo.idx}" class="btn btn-danger">삭제</a>
							<a href="boardList.do" class="btn btn-warning">목록</a></td>
					</tbody>
				</table>
				<form action="replyInsert.do" method="post">
					<input type="hidden" name="boardnum" value="${vo.idx}">
					<table style="width: 100%">
						<tr>
							<td style="padding: 5px;" width="150px"><input type="text"
								name="writer" class="form-control" placeholder="작성자"></td>
							<td style="padding: 5px;"><input type="text" name="content"
								class="form-control" placeholder="내용"></td>
							<td style="padding: 5px;"><button type="submit"
									class="btn btn-warning">댓글</button></td>
						</tr>
						<tr>
							<td style="padding: 5px;" width="150px">작성자</td>
							<td style="padding: 5px;" colspan="2">댓글</td>



						</tr>
						<c:forEach items="${list}" var="vo">
							<tr>
								<td style="padding: 5px;" width="150px">${vo.writer}</td>
								<td style="padding: 5px;" colspan="2">${vo.content}</td>
							</tr>
						</c:forEach>

					</table>
				</form>
			</div>
			<div class="panel-footer">스프링 게시판 - Kim</div>
		</div>
	</div>

</body>
</html>
