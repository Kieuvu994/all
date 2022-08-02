<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/team/updateForm"
			method="post" 
			>
			<a></a><input type="hidden" id="pk" name="pk" value="${pk}" >
		<a>name_____</a><input type="text" name="name"><br>
		<input type="submit" value="update">
		</form>
</body>
</html>