<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<link rel="stylesheet" type="text/css" href="css/lib/bootstrap.min.css"/>
<style>

#wrap {
	background:url('img/sf-cityscape.jpg') repeat -1000px -100px;
}
.reg {
	position:relative;
	width:400px;
	margin-top:50px;
	padding-right:40px;
	border:1px solid #ccc;
	background-color:#fff;
	border-radius:4px;
	-webkit-box-shadow: 2px 2px 10px rgba(50, 50, 50, 0.30);
	-moz-box-shadow:    2px 2px 10px rgba(50, 50, 50, 0.30);
	box-shadow:         2px 2px 10px rgba(50, 50, 50, 0.30);
	
}
.reg.main {
	min-height:250px;
}
.reg.input-group h3 {
	margin-top:15px;
}
.reg form > div {
	margin-bottom:10px;
}
.reg .opt {
	width:400px;
	border-top:1px solid #999;
	padding-top:5px;
	margin:20px 0 10px 0;
	font-size:14px;
	color:#888;
}
.reg .opt > div {
	margin-bottom:10px;
}
.reg .opt input {
	height:30px;
}

.reg .w-half {
	width:198px;
}
.reg .w-1quarter {
	width:99px;
}
.reg .w-3quarter {
	width:297px;
}

.reg .submit {
	margin-top:15px;
	margin-bottom:30px;
}
.reg .submit .btn {
	margin-top:15px;
}

.reg .err-group .err-msg {
	display:inline-block;
	visibility:hidden;
}
.reg .err input {
	border:1px solid red;
}
.reg .err .err-msg {
	display:inline-block;
	visibility:visible;
}
.reg .err-msg {
	color:red;
	margin:3px 0;
	overflow:visible;
	white-space:nowrap;
	display:none;
}
.reg .err-msg b {
	width:17px;
	height:17px;
	display:inline-block;
	position:relative;
	background:url('icons.png') no-repeat 0 0;
}
.reg h3 {
	padding:0;
	margin:25px 0 10px 0;
	font-weight:normal;
	font-size:26px;
	color:#FF8C19
}


</style>
</head>
<body>
<script src="js/lib/jquery-1.10.2.min.js"></script>
<div id="wrap">
	<div id="header">
		<div class="hdr">
			<div class="topnav inline">
				<a href="#">Logo</a>
				<a href="#">Platform</a>
				<a href="#">Tools</a>
				<a href="#">Pricing</a>
			</div>
			<div class="ctls">
				<div class="sign-in inline">
					<a href="#">Sign In</a>
				</div>
				<form class="lang inline">
					<span>
						Language
					</span>
					<select>
						<option>English</option>
						<option>Portuguese</option>
						<option>Spanish</option>
					</select>
				</form>
				
				
				
			</div>
		</div>
	</div>
	<div id="body">
		<div class="main reg input-group">
			<h3>Sign up</h3>
			form:form
			<form:form method="post" commandName="register">
				<div class="err">
					<form:input class="form-control" placeholder="Email" name="email" type="email" path="email"/>
					<div class="err-msg">
						<b>&nbsp;</b> Email does not seem valid
					</div>
				</div>
				<div>
					<form:input class="form-control" placeholder="Password" type="password" name="password" path="password"/>
					<div class="err-msg">
						<b>&nbsp;</b> Please enter a valid password
					</div>
				</div>
				<div>
					<form:input class="form-control" placeholder="Confirm password" type="password" name="password" path="confirmPassword"/>
					<div class="err-msg">
						<b>&nbsp;</b> Passwords do not match
					</div>
				</div>
				<div class="submit">
					<input type="submit"class="btn lg" value="Submit"/>
				</div>
			</form:form>
		</div>
		<div class="clr"></div>
	</div>
	<div id="footer">
		<div class="ftr">
			<a href="#">About us</a>
			<a href="#">Contact</a>
			<a href="#">FAQ</a>
			<a href="#">Privacy</a>
		</div>
	</div>
</div>

<script src="js/lib/bootstrap.min.js"></script>
</body>
</html>