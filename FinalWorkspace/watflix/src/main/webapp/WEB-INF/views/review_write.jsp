<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://kit.fontawesome.com/ae9cc237fc.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#content").on("keyup", function() {
			var count = $(this).val();
			var l = count.length;
			if (l == null) {
				$("#text-count").text("0");
			} else {
				$("#text-count").text(l);
			}
		});
	});
</script>
<link rel="stylesheet" type="text/css"
	href="/watflix/css/review_write.css">
</head>
<body>
	<form class="form-horizontal style-form"
		action="/watflix/review/insert" method="post">
		<div id="review">
			<div id="review-head">
				<h3>리뷰쓰기</h3>
				<!--여기 value값만 수정해주세용 상희씌  -->
				<input type="hidden" name="movie_no" value="${movie_no}"> <input
					type="hidden" name="user_no" value="${sessionScope.loginuser.user_no }">
				<div id="review-right">
					<div id="rating">
						<select name="rating">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>

						</select>
					</div>

				</div>
				
			</div>
			<input id="review-title" name="review_title" type="text"
					placeholder="리뷰 제목을 입력하세요" maxlength="1000" />
			<div id="review-content">
				<hr />
				<div id="review-write">
					<textarea placeholder="리뷰를 입력해주세요" maxlength="1000" id="content"
						name="review_content"></textarea>
				</div>
				<div id="review-write-bottom">
					<div id="count-letter">
						<span id="text-count">0</span> <span id="total">/1000</span>
					</div>
					<button type="submit" id="btn-submit">
						<div id="btn-text">등록</div>
					</button>
				</div>
			</div>
		</div>
</body>
</html>