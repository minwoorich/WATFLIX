<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if IE 7]>
<html class="ie ie7 no-js" lang="en-US">
<![endif]-->
<!--[if IE 8]>
<html class="ie ie8 no-js" lang="en-US">
<![endif]-->
<!--[if !(IE 7) | !(IE 8)  ]><!-->
<html lang="en" class="no-js">
<head>
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
<script type="text/javascript">
	//sign-up 패스워드 체크
	$(document).ready(function() {
		$("#repassword-2").on("keyup", function() {
			const queryData = {
				"pass" : $("#password-2").val(),
				"repass" : $("#repassword-2").val()
			}
			$.ajax({
				url : "/watflix/sign-up/passChk",
				type : "post",
				data : JSON.stringify(queryData),
				contentType : "application/json",
				success : success_run,
				error : error_run
			});
		});
	});
	function success_run(msg) {
		if (msg == "비밀번호가 다릅니다") {
			$("#passChkMsg").text(msg).css('color', 'red');
		} else {
			$("#passChkMsg").text(msg).css('color', 'green');
		}

	}
	function error_run(obj, msg, statusmsg) {
		alert("obj : " + obj + " " + "msg : " + msg + " " + "statusmsg : "
				+ statusmsg);
	}
</script>
<script type="text/javascript">
	//로그인 용
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
		alert(msg);
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
					name="pass" id="login-pass" placeholder="******" required="required" />
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
						name="username" id="username-2" placeholder="Hugh Jackman"
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
						<div id="passChkMsg">></div>
					</label>
				</div>
				<div class="row">
					<button type="submit">sign up</button>
				</div>
			</form>
		</div>
	</div>
	<!--end of signup form popup-->

	<div class="landing-hero">
		<img src="/watflix/images/logo1.png" alt="Logo">
		<div class="row landing-hero-text">
			<h2>MOST COMPLETED</h2>
			<h2 class="text-yellow">FILM REVIEW &middot; MOVIE DATABASE</h2>
			<h2>HTML TEMPLATE</h2>
		</div>
		<a href="" class="redbtn" id="discover-now">DISCOVER NOW</a>
	</div>
	<div class="landing-version">
		<div class="container">
			<div class="col-md-6">
				<img src="/watflix/images/uploads/landing-dark-version.png"
					alt="Dark Version">
				<h2>DARK VERSION</h2>
				<a href="index.html" target="blank_" class="redbtn">SEE DEMO</a>
			</div>
			<div class="col-md-6">
				<img src="/watflix/images/uploads/landing-light-version.png"
					alt="Light Version">
				<h2>LIGHT VERSION</h2>
				<a href="index_light.html" target="blank_" class="redbtn">SEE
					DEMO</a>
			</div>
		</div>
	</div>
	<!-- footer v3 section-->
	<div class="ft-copyright-landing">
		<p>© 2017 Blockbuster. All Rights Reserved. Designed by haintheme.</p>
	</div>
	<!-- end of footer v3 section-->

	<script src="/watflix/js/jquery.js"></script>
	<script src="/watflix/js/plugins.js"></script>
	<script src="/watflix/js/plugins2.js"></script>
	<script src="/watflix/js/custom.js"></script>
</body>
</html>