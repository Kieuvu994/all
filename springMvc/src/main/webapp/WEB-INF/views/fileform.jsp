<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Form</title>
</head>
<body>

	<form id="uploadForm">
		<input id="uploadFile" type="file" name="file" required/>
		<button id="uploadButton" type="button">UPLOAD</button>
	</form>

<script type="text/javascript">

	window.addEventListener('load', function(){
		const uploadForm = document.querySelector('#uploadForm');
		const uploadFile = document.querySelector('#uploadFile');
		const uploadButton = document.querySelector('#uploadButton');
		
		uploadButton.addEventListener('click', function(e){
			if( uploadFile.files.length > 0 ){
				requestFileUpload(uploadFile.files[0]);
			}
			e.preventDefault();
		}, true);
		
	});
	function requestFileUpload(file){
		const data = new FormData();
		data.append('file', file);
		
		const xhr = new XMLHttpRequest();
		xhr.open('POST', '/vu/api/file/upload');
		xhr.onload = function(){
			console.log( xhr.responseText);
			const json = JSON.parse(xhr.responseText);
		}
		xhr.send(data);
	}
</script>

</body>
</html>