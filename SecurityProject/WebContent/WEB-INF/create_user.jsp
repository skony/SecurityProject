<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create User</title>
</head>
<body>
	<form action="create_user" method="post">
		Username: <input type="text" name="username"/>
		<br/>
		Password: <input type="password" name="pass1" />
		<br/>
		Repeat password: <input type="password" name="pass2" />
		<br/>
		Role: <input type="number" name="role" min="2" max="5"/>
		<input type="submit" value="Create" />
	</form>
</body>
</html>