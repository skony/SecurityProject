<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(session.getAttribute("login") == null || session.getAttribute("login") == "error"){ %>
	<form name="submitForm" method="POST" action="home">
    	<input type="hidden" name="param1" value="param1Value">
    	<A HREF="javascript:document.submitForm.submit()">Login</A>
	</form>
	<% } else {%>
	<form name="submitForm2" method="POST" action="logout">
    	<input type="hidden" name="param1" value="param1Value">
    	<A HREF="javascript:document.submitForm2.submit()">Logout</A>
	</form>
	<br/>
	<form name="submitForm3" method="GET" action="change_pwd">
    	<input type="hidden" name="param1" value="param1Value">
    	<A HREF="javascript:document.submitForm3.submit()">Change password</A>
	</form>
		<%if(session.getAttribute("login") == "admin"){ %>
		<form name="submitForm4" method="GET" action="create_user">
	    	<input type="hidden" name="param1" value="param1Value">
	    	<A HREF="javascript:document.submitForm4.submit()">Create user</A>
		</form>
		<form name="submitForm5" method="GET" action="delete_user">
	    	<input type="hidden" name="param1" value="param1Value">
	    	<A HREF="javascript:document.submitForm5.submit()">Delete user</A>
		</form>
		<% } %>
	<% } %>
</body>
</html>