<!doctype html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<link rel="stylesheet" type="text/css" href="css/lib/bootstrap.min.css"/>
<style>

#wrap {
	background:url('img/sf-cityscape.jpg') repeat -1000px -100px;
}
.cfm-email {
	position:relative;
	width:400px;
	min-height:180px;
	top:50px;
	
	padding-right:40px;
	border:1px solid #ccc;
	background-color:#fff;
	border-radius:4px;
	-webkit-box-shadow: 2px 2px 10px rgba(50, 50, 50, 0.30);
	-moz-box-shadow:    2px 2px 10px rgba(50, 50, 50, 0.30);
	box-shadow:         2px 2px 10px rgba(50, 50, 50, 0.30);
}
.cfm-email .msg {
	margin:0;
	font-size:16px;
}

.cfm-email form > div {
	margin-bottom:10px;
}


.cfm-email .submit {
	margin-top:15px;
}
.cfm-email .submit .btn {
	margin-top:15px;
}

.cfm-email .err-group .err-msg {
	display:inline-block;
	visibility:hidden;
}
.cfm-email .err input {
	border:1px solid red;
}
.cfm-email .err .err-msg {
	display:inline-block;
	visibility:visible;
}
.cfm-email .err-msg {
	color:red;
	margin:3px 0;
	overflow:visible;
	white-space:nowrap;
	display:none;
}
.cfm-email .err-msg b {
	width:17px;
	height:17px;
	display:inline-block;
	position:relative;
	background:url('icons.png') no-repeat 0 0;
}
.cfm-email h3 {
	padding:0;
	margin:25px 0 10px 0;
	font-weight:normal;
	font-size:26px;
	color:#FF8C19
}
.cfm-email .remember {
	color:#666;
}
.cfm-email .forgot {
	display:inline-block;
	position:relative;
	top:10px;
	margin-left:20px;
}


</style>
</head>
<body>
<script src="../js/lib/jquery-1.10.2.min.js"></script>
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
		<div class="main cfm-email input-group">
			<h3>Almost done!</h3>
			<div class="msg">
				Please check your email for our confirmation message.
				In it you'll find a link to click to complete the sign-up process.
			</div>
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