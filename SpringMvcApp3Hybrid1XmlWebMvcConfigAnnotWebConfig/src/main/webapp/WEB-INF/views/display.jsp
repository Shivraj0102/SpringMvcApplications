<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Hello World!</h2>
	<form action="add">
		<input type="text" name="n1"/> <br><br>
		<input type="text" name ="n2"/> <br><br>
		<input type="submit"/> <br><br>
	</form>
	<%-- Sum is : <%= request.getAttribute("sum") %> --%>
	Sum is : ${sum}
</body>
</html>