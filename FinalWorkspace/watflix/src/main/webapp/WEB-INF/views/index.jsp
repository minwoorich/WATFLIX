<%@page import="kr.multi.watflix.movie.dto.MovieDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Basic need -->
<title>Open Pediatrics</title>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<link rel="profile" href="#">


<!--Google Font-->
<link rel="stylesheet"
	href='http://fonts.googleapis.com/css?family=Dosis:400,700,500|Nunito:300,400,600' />
<!-- Mobile specific meta -->
<meta name=viewport content="width=device-width, initial-scale=1">
<meta name="format-detection" content="telephone-no">

<!-- CSS files -->
<link rel="stylesheet" href="/watflix/css/plugins.css">
<link rel="stylesheet" href="/watflix/css/style.css">

<!-- 제이쿼리 라이브러리 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	//sign-up 패스워드 체크
	$(document).ready(function() {
   $("#repassword-2").keyup(function(event) {
      event.preventDefault();//페이지 새로고침 방지
      const queryData = {
         "pass": $("#password-2").val(),
         "repass": $("#repassword-2").val()
      };
      $.ajax({
         url: "/watflix/sign-up/passChk",
         type: "post",
         data: JSON.stringify(queryData),
         contentType: "application/json",
         success: function(msg) {
            if (msg === "비밀번호가 다릅니다") {
               console.log(msg);
               $("#passChkMsg").text(msg).css('color', 'red');
            } else {
               $("#passChkMsg").text(msg).css('color', 'green');
            }
         },
         error: function(xhr, status, error) {
            alert("xhr: " + xhr + "\nstatus: " + status + "\nerror: " + error);
         }
      });
   });
});

</script>
<script type="text/javascript">
	//login용
	$(document).ready(function() {
		$(".login-content button").on("click", function() {
			const queryData = {
				"email" : $("#login-email").val(),
				"pass" : $("#login-pass").val()
			}
			$.ajax({
				url : "/watflix/view/login.do",
				type : "post",
				data : JSON.stringify(queryData),
				contentType : "application/json",
				success : success_run,
				error : error_run
			});
		});
	});
	function success_run(msg) {
		if (msg == "아이디/비밀번호가 다릅니다") {
			$("#loginChkMsg").text(msg).css('color', 'red');
		} else {
			window.location.href = "/watflix/main";
		}

	}
	function error_run(obj, msg, statusmsg) {
		alert("obj : " + obj + " " + "msg : " + msg + " " + "statusmsg : "
				+ statusmsg);
	}
</script>
</head>
<body>
	<!--preloading-->
	<div id="preloader">
		<img class="logo" src="/watflix/images/logo1.png" alt="로고" width="119"
			height="58">
		<div id="status">
			<span></span> <span></span>
		</div>
	</div>
	<!--end of preloading-->
	<!--login form popup-->
	<div class="login-wrapper" id="login-content">
		<div class="login-content">
			<a href="#" class="close">x</a>
			<h3>Login</h3>

			<div class="row">
				<label for="email"> EMAIL: <input type="email" name="email"
					id="login-email" placeholder="hugh@email.com" required="required" />
				</label>
			</div>

			<div class="row">
				<!-- 비번 input태그에 추가할것pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" -->
				<label for="pass"> Password: <input type="password"
					name="pass" id="login-pass" placeholder="******"
					required="required" />
				</label>
				<div id="loginChkMsg"></div>

			</div>
			<div class="row">
				<div class="remember">
					<div>
						<input type="checkbox" name="remember" value="Remember me"><span>Remember
							me</span>
					</div>
					<a href="#">Forget password ?</a>
				</div>
			</div>
			<div class="row">
				<button type="submit">Login</button>
			</div>
			<div class="row">
				<p>Or via social</p>
				<div class="social-btn-2">
					<a class="fb" href="#"><i class="ion-social-facebook"></i>Facebook</a>
					<a class="tw" href="#"><i class="ion-social-twitter"></i>twitter</a>
				</div>
			</div>
		</div>
	</div>
	<!--end of login form popup-->
	<!--signup form popup-->
	<div class="login-wrapper" id="signup-content">
		<div class="login-content">
			<a href="#" class="close">x</a>
			<h3>sign up</h3>
			<form method="post" action="/watflix/view/register.do">
				<div class="row">
					<label for="username-2"> Username: <input type="text"
						name="last_name" id="username-2" placeholder="Hugh Jackman"
						required="required" />
					</label>
				</div>

				<div class="row">
					<label for="email-2"> your email: <input type="email"
						name="email" id="email-2" placeholder="" required="required" />
					</label>
				</div>
				<div class="row">
					<label for="password-2"> Password: <input type="password"
						name="pass" id="password-2" placeholder="" required="required" />
					</label>
				</div>
				<div class="row">
					<label for="repassword-2"> re-type Password: <input
						type="password" name="password" id="repassword-2" placeholder=""
						required="required" />
						<div id="passChkMsg"></div>
					</label>
				</div>
				<div class="row">
					<button type="submit">sign up</button>
				</div>
			</form>
		</div>
	</div>
	<!--end of signup form popup-->

	<!-- BEGIN | Header -->

	<header class="ht-header">
		<div class="container">
			<nav class="navbar navbar-default navbar-custom">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header logo">
					<div class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span>
						<div id="nav-icon1">
							<span></span> <span></span> <span></span>
						</div>
					</div>
					<a href="index_light.html"><img class="logo"
						src="/watflix/images/logo1.png" alt="" width="119" height="58"></a>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse flex-parent"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav flex-child-menu menu-left">
						<li class="hidden"><a href="#page-top"></a></li>
						<li class="dropdown first"><a
							class="btn btn-default dropdown-toggle lv1"
							data-toggle="dropdown"> Home <i class="fa fa-angle-down"
								aria-hidden="true"></i>
						</a>
							<ul class="dropdown-menu level1">
								<li><a href="index_light.html">Home 01</a></li>
							</ul></li>
						<li class="dropdown first"><a
							class="btn btn-default dropdown-toggle lv1"
							data-toggle="dropdown" data-hover="dropdown"> movies<i
								class="fa fa-angle-down" aria-hidden="true"></i>
						</a>
							<ul class="dropdown-menu level1">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">Movie grid<i
										class="ion-ios-arrow-forward"></i></a>
									</li>
							</ul></li>
						
						
						<li class="dropdown first"><a
							class="btn btn-default dropdown-toggle lv1"
							data-toggle="dropdown" data-hover="dropdown"> community <i
								class="fa fa-angle-down" aria-hidden="true"></i>
						</a>
							<ul class="dropdown-menu level1">
								<li><a href="/watflix/user/my-favorite?user_no=${sessionScope.loginuser.user_no }">user favorite
										grid</a></li>
								<li>
								<c:choose>
									<c:when test="${sessionScope.loginuser != null }">
										<a href="/watflix/user/user-profile">user profile</a></li>
									</c:when>
									<c:otherwise>
										<a class="moveToProfile">user profile</a></li>
										<script type="text/javascript">
										$(document).ready(function(){
											var moveToProfile = $(".moveToProfile");
											var loginct = $( "#login-content" );
											var loginWrap = $(".login-wrapper");
											var overlay = $(".overlay");
											moveToProfile.on('click', function(event){
										    	event.preventDefault();
										    	loginct.parents(overlay).addClass("openform");
												$(document).on('click', function(e){
												var target = $(e.target);
												if ($(target).hasClass("overlay")){
														$(target).find(loginct).each( function(){
															$(this).removeClass("openform");
														});
														setTimeout( function(){
															$(target).removeClass("openform");
														}, 350);
													}	
												});
										    });
										})
										
										</script>
									</c:otherwise>
								</c:choose>
								
								<li class="it-last"><a href="/watflix/user/my-reviewed?user_no=${sessionScope.loginuser.user_no }">user
										rate</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav flex-child-menu menu-right">
						
						<li><a href="#">Help</a></li>
						<c:choose>
							<c:when test="${sessionScope.loginuser == null}">
								<li class="loginLink"><a href="#">LOG IN</a></li>
								<li class="btn signupLink"><a href="#">sign up</a></li>
							</c:when>
							<c:otherwise>
								<li class="logout"><a href="/watflix/user/logout.do">LOG
										OUT</a></li>
							</c:otherwise>

						</c:choose>

					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</nav>

			<!-- top search form -->

			<div class="top-search">
				 <input type="text" name="search"
					placeholder="Search for a movie, TV Show or celebrity that you are looking for">
			</div>
			<script type="text/javascript">
				const input = document.querySelector('input[name="search"]');
				input
						.addEventListener(
								'keydown',
								function(event) {
									if (event.keyCode === 13) { // enter key
										const keyword = event.target.value;
										window.location.href = '/watflix/search-result?keyword='
												+ keyword;
									}
								});
			</script>
		</div>
	</header>
	<!-- END | Header -->

	<div class="slider movie-items">
		<div class="container">
			<div class="row">
				<div class="social-link">
					<p>Follow us:</p>
					<a href="#"><i class="ion-social-facebook"></i></a> <a href="#"><i
						class="ion-social-twitter"></i></a> <a href="#"><i
						class="ion-social-googleplus"></i></a> <a href="#"><i
						class="ion-social-youtube"></i></a>
				</div>
				<div class="slick-multiItemSlider">
					<!-- 제일 처음 나오는 영화 리스트 시작-->
					<c:forEach var="movie" items="${mainList}" begin="0" end="9">
						<div class="movie-item">
							<div class="mv-img">
								<a href="/watflix/movie/movie-info?movie_no=${movie.movie_no}&user_no=${sessionScope.loginuser.user_no}"><img src="${movie.movie_image}"
									alt="" width="285" height="437"></a>
							</div>
							<div class="title-in">
								<div class="cate">
									<span class="blue"><a href="#">${movie.genre }</a></span>
								</div>
								<h6>
									<a href="/watflix/movie/movie-info?movie_no=${movie.movie_no}&user_no=${sessionScope.loginuser.user_no}">${movie.movie_title}</a>
								</h6>
								<p>
									<i class="ion-android-star"></i><span>${movie.avgRating}</span>
									/5
								</p>
							</div>
						</div>
					</c:forEach>
					<!-- 제일 처음 나오는 영화 리스트 끝-->

				</div>
			</div>
		</div>
	</div>
	<div class="buster-light">
		<div class="movie-items">
			<div class="container">
				<div class="row ipad-width">
					<div class="col-md-8">
						<div class="title-hd">
							<h2>in theater</h2>
						</div>
						<div class="tabs">
							<ul class="tab-links">
								<li class="active"><a href="#tab1">#Top rated</a></li>
								<li><a href="#tab4"> #Most reviewed</a></li>
							</ul>
							<div class="tab-content">
								<div id="tab1" class="tab active">
									<div class="row">
										<div class="slick-multiItem">

											<!-- Top Rated 영화 리스트 -->
											<c:forEach var="movie" items="${topRated}">
												<div class="slide-it">
													<div class="movie-item">
														<div class="mv-img">

															<img src="${movie.movie_image}" alt="" width="185"
																height="284">
														</div>
														<div class="hvr-inner">
															<a href="/watflix/movie/movie-info?movie_no=${movie.movie_no}&user_no=${sessionScope.loginuser.user_no}"> Read more <i
																class="ion-android-arrow-dropright"></i>
															</a>
														</div>
														<div class="title-in">
															<h6>
																<a href="/watflix/movie/movie-info?movie_no=${movie.movie_no}&user_no=${sessionScope.loginuser.user_no}">${movie.movie_title}</a>
															</h6>
															<p>
																<i class="ion-android-star"></i><span>${movie.avgRating }</span>
																/5
															</p>
														</div>
													</div>
												</div>
											</c:forEach>

										</div>
									</div>
								</div>


								<div id="tab4" class="tab">
									<div class="row">
										<div class="slick-multiItem">

											<!-- Top Reviewed 영화 리스트 -->
											<c:forEach var="movie" items="${topReviewed}">
												<div class="slide-it">
													<div class="movie-item">
														<div class="mv-img">
															<img src="${movie.movie_image}" alt="" width="185"
																height="284">
														</div>
														<div class="hvr-inner">
															<a href="/watflix/movie/movie-info?movie_no=${movie.movie_no}&user_no=${sessionScope.loginuser.user_no}"> Read more <i
																class="ion-android-arrow-dropright"></i>
															</a>
														</div>
														<div class="title-in">
															<h6>
																<a href="/watflix/movie/movie-info?movie_no=${movie.movie_no}&user_no=${sessionScope.loginuser.user_no}">${movie.movie_title}</a>
															</h6>
															<p>
																<i class="ion-android-star"></i><span>${movie.avgRating}</span>
																/5
															</p>
														</div>
													</div>
												</div>
											</c:forEach>



										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
					<div class="col-md-4">
						<div class="sidebar">
							<div class="celebrities">
								<h4 class="sb-title">Spotlight Celebrities</h4>

								<!-- 배우 출력 부분 -->
								<c:forEach var="cast" items="${castList}" begin="0" end="4">
									<div class="celeb-item">
										<a><img src="${cast.casting_image}" alt=""
											width="70" height="70"></a>
										<div class="celeb-author">
											<h6>
												<a>${cast.casting_name}</a>
											</h6>
											<span>${cast.casting_job}</span>
										</div>
									</div>
								</c:forEach>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="trailers">
			<div class="container">
				<div class="row ipad-width">
					<div class="col-md-12">
						<div class="title-hd">
							<h2>in theater</h2>
						</div>
						<div class="videos">
							<div class="slider-for-2 video-ft">
								<div>
									<iframe class="item-video" src=""
										data-src="https://www.youtube.com/embed/1Q8fG0TtVAY"></iframe>
								</div>
								<div>
									<iframe class="item-video" src=""
										data-src="https://www.youtube.com/embed/w0qQkSuWOS8"></iframe>
								</div>
								<div>
									<iframe class="item-video" src=""
										data-src="https://www.youtube.com/embed/44LdLqgOpjo"></iframe>
								</div>
								<div>
									<iframe class="item-video" src=""
										data-src="https://www.youtube.com/embed/gbug3zTm3Ws"></iframe>
								</div>
								<div>
									<iframe class="item-video" src=""
										data-src="https://www.youtube.com/embed/e3Nl_TCQXuw"></iframe>
								</div>
								<div>
									<iframe class="item-video" src=""
										data-src="https://www.youtube.com/embed/NxhEZG0k9_w"></iframe>
								</div>


							</div>
							<div class="slider-nav-2 thumb-ft">
								<div class="item">
									<div class="trailer-img">
										<img src="/watflix/images/uploads/trailer7.jpg"
											alt="photo by Barn Images" width="4096" height="2737">
									</div>
									<div class="trailer-infor">
										<h4 class="desc">Wonder Woman</h4>
										<p>2:30</p>
									</div>
								</div>
								<div class="item">
									<div class="trailer-img">
										<img src="/watflix/images/uploads/trailer2.jpg"
											alt="photo by Barn Images" width="350" height="200">
									</div>
									<div class="trailer-infor">
										<h4 class="desc">Oblivion: Official Teaser Trailer</h4>
										<p>2:37</p>
									</div>
								</div>
								<div class="item">
									<div class="trailer-img">
										<img src="/watflix/images/uploads/trailer6.jpg"
											alt="photo by Joshua Earle">
									</div>
									<div class="trailer-infor">
										<h4 class="desc">Exclusive Interview: Skull Island</h4>
										<p>2:44</p>
									</div>
								</div>
								<div class="item">
									<div class="trailer-img">
										<img src="/watflix/images/uploads/trailer3.png"
											alt="photo by Alexander Dimitrov" width="100" height="56">
									</div>
									<div class="trailer-infor">
										<h4 class="desc">Logan: Director James Mangold Interview</h4>
										<p>2:43</p>
									</div>
								</div>
								<div class="item">
									<div class="trailer-img">
										<img src="/watflix/images/uploads/trailer4.png"
											alt="photo by Wojciech Szaturski" width="100" height="56">
									</div>
									<div class="trailer-infor">
										<h4 class="desc">Beauty and the Beast: Official Teaser
											Trailer 2</h4>
										<p>2: 32</p>
									</div>
								</div>
								<div class="item">
									<div class="trailer-img">
										<img src="/watflix/images/uploads/trailer5.jpg"
											alt="photo by Wojciech Szaturski" width="360" height="189">
									</div>
									<div class="trailer-infor">
										<h4 class="desc">Fast&Furious 8</h4>
										<p>3:11</p>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- latest new v1 section-->

		<!--end of latest new v1 section-->
	</div>
	<!-- footer section-->
	<footer class="ht-footer">
		<div class="container">
			<div class="flex-parent-ft">
				<div class="flex-child-ft item1">
					<a href="index.html"><img class="logo"
						src="/watflix/images/logo1.png" alt=""></a>
					<p>
						5th Avenue st, manhattan<br> New York, NY 10001
					</p>
					<p>
						Call us: <a href="#">(+01) 202 342 6789</a>
					</p>
				</div>
				<div class="flex-child-ft item2">
					<h4>Resources</h4>
					<ul>
						<li><a href="#">About</a></li>
						<li><a href="#">Blockbuster</a></li>
						<li><a href="#">Contact Us</a></li>
						<li><a href="#">Forums</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Help Center</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item3">
					<h4>Legal</h4>
					<ul>
						<li><a href="#">Terms of Use</a></li>
						<li><a href="#">Privacy Policy</a></li>
						<li><a href="#">Security</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item4">
					<h4>Account</h4>
					<ul>
						<li><a href="#">My Account</a></li>
						<li><a href="#">Watchlist</a></li>
						<li><a href="#">Collections</a></li>
						<li><a href="#">User Guide</a></li>
					</ul>
				</div>
				<div class="flex-child-ft item5">
					<h4>Newsletter</h4>
					<p>
						Subscribe to our newsletter system now <br> to get latest
						news from us.
					</p>
					<form action="#">
						<input type="text" placeholder="Enter your email...">
					</form>
					<a href="#" class="btn">Subscribe now <i
						class="ion-ios-arrow-forward"></i></a>
				</div>
			</div>
		</div>
		<div class="ft-copyright">
			<div class="ft-left">
				<p>© 2017 Blockbuster. All Rights Reserved. Designed by leehari.</p>
			</div>
			<div class="backtotop">
				<p>
					<a href="#" id="back-to-top">Back to top <i
						class="ion-ios-arrow-thin-up"></i></a>
				</p>
			</div>
		</div>
	</footer>
	<!-- end of footer section-->


	<script src="/watflix/js/jquery.js"></script>
	<script src="/watflix/js/plugins.js"></script>
	<script src="/watflix/js/plugins2.js"></script>
	<script src="/watflix/js/custom.js"></script>
</body>
</html>