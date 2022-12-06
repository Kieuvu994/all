<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Sample</title>
<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script type="text/javascript">
	$.doService = function(opt) {
		$('#result').html('실행중');
		if (opt == 'POST') {
			var formdata = $("form[name=formdata1]").serializeArray();
			$
					.ajax({
						type : opt,
						url : "http://localhost:8080/samplerestful-server/restful/glue/restful-service/",
						data : formdata,
						success : function(msg) {
							$('#result').html(JSON.stringify(msg));
						}
					});
		} else if (opt == 'PUT') {
			var formdata = $("form[name=formdata2]").serializeArray();
			$
					.ajax({
						type : opt,
						url : "http://localhost:8080/samplerestful-server/restful/glue/restful-service/",
						data : formdata,
						success : function(msg) {
							$('#result').html(JSON.stringify(msg));
						}
					});
		} else if (opt == 'GET') {
			var data = $("#getvalue").val();
			$
					.ajax({
						type : opt,
						url : "http://localhost:8080/samplerestful-server/restful/glue/restful-service/data/"
								+ data,
						success : function(msg) {
							$('#result').html(JSON.stringify(msg));
						}
					});
		} else if (opt == 'DELETE') {
			var data = $("#deletevalue").val();
			$
					.ajax({
						type : opt,
						url : "http://localhost:8080/samplerestful-server/restful/glue/restful-service/data/"
								+ data,
						success : function(msg) {
							$('#result').html(JSON.stringify(msg));
						}
					});
		}
	}
</script>
</head>
<body>
	RESTFUL TEST
	<br />
	<br /> GET
	<br /> URL:http://localhost:<%=request.getLocalPort()%><%=request.getContextPath()%>/restful/glue/
	restful-service/data/
	<input type='text' value='10' id='getvalue'>
	<br />
	<br /> DELETE
	<br /> URL:http://localhost:<%=request.getLocalPort()%><%=request.getContextPath()%>/restful/glue/
	restful-service/data/
	<input type='text' value='9999' id='deletevalue'>
	<br />
	<br /> POST DATA(INSERT)
	<form id='formdata1' name='formdata1'>
		param1(empno):<input type='text' value='9999' id='param1'
			name='param1'> param2(ename):<input type='text'
			value='ename_test' id='param2' name='param2'> param3(sal):<input
			type='text' value='800' id='param3' name='param3'>
		param4(deptno):<input type='text' value='10' id='param4' name='param4'>
	</form>
	<br />
	<br /> PUT DATA(UPDATE)
	<form id='formdata2' name='formdata2'>
		param1(sal):<input type='text' value='900' id='param1' name='param1'>
		param2(ename):<input type='text' value='ename_test' id='param2'
			name='param2'> param3(empno):<input type='text' value='9999'
			id='param3' name='param3'>
	</form>
	<br />
	<br />
	<input type='button' value='GET' onclick="$.doService('GET')">
	<input type='button' value='DELETE' onclick="$.doService('DELETE')">
	<input type='button' value='POST' onclick="$.doService('POST')">
	<input type='button' value='PUT' onclick="$.doService('PUT')">
	<br />
	<br /> 실행결과
	<br />
	<div id="result"
		style="border-color: #a4a4a4; border-width: 1px; border-style: solid;">
	</div>
</body>
</html>