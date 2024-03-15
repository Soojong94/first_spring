<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

				<table class="table">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>
					<tbody id ="view">					
					</tbody>
				</table>
			</div>
			<div class="panel-footer">스프링 게시판 -Kim</div>
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		
		loadList();
		
		// HTML 문서가 전부 로딩되고 실행되는 부분
		function loadList(){
			// Server로부터 게시글 정보를 비동기로 가져오는 기능
			// 비동기로 요청하는 기능 - 요청데이터 -> JSON
			// JSON ->{key : value ,  method : function(){ }}
			$.ajax({
				url : "boardList.do", 
				type : "get",
				dataType : "json",
				success : makeView,
				err : function(){alert("error...")}
			});	
		}
		function makeView(data){
			// 서버에서 게시글 데이터 가져오기 성공 했을 때 실행되는 함수
			console.log(data);
			let list ="";
			$.each(data, function(index , obj){
				list += "<tr>";
				list += "<td>" + (index+1) + "</td>";
				list += "<td>" + obj.title + "</td>";
				list += "<td>" + obj.writer + "</td>";
				list += "<td>" + obj.indate + "</td>";
				list += "<td>" + obj.count + "</td>";
				list += "</tr>";
			});
			
			$("#view").html(list)
			
		}
		
		
	});
	
	
	
	</script>
</body>
</html>
