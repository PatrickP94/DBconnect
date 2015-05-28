<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Bitte melden sie sich an</h1>
<br>
<br>
<form action="j_security_check" method="post">
<input name="j_username" type="text" placeholder="Username"/>
<br>
<input name="j_password" type="password" placeholder="Passwort"/>
<button type="submit">Log in</button>	
</form>
</body>
</html>