<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title></title>
<style type="text/css">
#phong{
	width: 60%;
	border: solid blue 3px;
	padding: 100px;
	float: left;
	margin: 25px 50px 175px 100px /*canh le  */
}

#methorform {
	width: 30%;
	background: #e8e8e8;
	float: left;
	padding: 10px;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
}
</style>
</head>
<body>



	<h1>Home</h1>
	<p></p>
	<table>
		<tr>
			<th>id</th>
			<th>name</th>
			<th>position</th>
			<th>team_pk</th>

		</tr>
		<c:forEach items="${players}" var="project">
			<tr>
				<td>${project.pk}</td>
				<td>${project.name}</td>
				<td>${project.position}</td>
				<td>${project.team_pk}</td>
			</tr>
		</c:forEach>
	</table>
<a>Add Player</a>
		<form action="${pageContext.request.contextPath}/player"
			method="get" >
		<a>name_____</a><input type="text" name="name"><br>
		<a>position__</a><input type="text" name="position"><br>
		<a>team_pk__</a><input type="text" name="team_pk"><br>
		<input type="submit" value="add">
		</form>
	<div>
		<ol>
			<c:forEach items="${teams}" var="project">

				<li>${project.name}[${project.pk}]</li>

			</c:forEach>
		</ol>
		<a>Add Team</a>
		<form action="${pageContext.request.contextPath}/team"
			method="get" >
		<input type="text" name="team">
			<input type="submit" value="add">
		</form>
	</div>



</body>
</html>