<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function writeFormSubmit() {
	/* 	alert('버튼을 클릭했습니다!'); */
		/*  var subject = document.writeForm.subject.value;
		alert(subject); */
		var subject = document.getElementById("subject");
		if(subject.value==""){
			alert("제목을 적어주세요!");
			subject.focus();
			return;
		}
		
		var content = document.getElementById("content");
		if(content.value==""){
			alert("내용을 적어주세요!");
			content.focus();
			return;
		}
		
		var form = document.getElementById("writeForm");
		form.method="post";
		form.action="/Article/doWrite";
		form.submit;
	}
</script>
</head>
<body>
	<form id="writeForm" name="writeForm" >
	
		<table style="margin: auto;">
			<tr>
				<td>제목 :</td>
				<td><input  type="text" id="subject" name="subject" style="width: 500px;"/></td>
			</tr>
			<tr>
				<td style="">내용 :</td>
				<td><textarea rows="20" cols="100" id="content" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<input type="button" value="저장" onclick="writeFormSubmit()"/>
				</td>
			</tr>
		</table>
		 
		 
	</form>
</body>
</html>