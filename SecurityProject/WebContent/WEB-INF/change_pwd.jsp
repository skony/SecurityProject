<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Change Password</title>
</head>
<body>
	<form action="change_pwd" method="post">
		Current password: <input type="text" name="pass1">
		<br/>
		New password: <input type="password" name="pass2" />
		<br/>
		Repeat password: <input type="password" name="pass3" />
		<br/>
		<input type="submit" value="Change" />
	</form>
</body>
</html>