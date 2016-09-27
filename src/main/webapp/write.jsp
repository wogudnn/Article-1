<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="writeForm" method="post" action="./doWrite.jsp">
	
		<table style="margin: auto;">
			<tr>
				<td>제목 :</td>
				<td><input type="text" name="subject" style="width: 500px;"/></td>
			</tr>
			<tr>
				<td style="">내용 :</td>
				<td><textarea rows="20" cols="100" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<input type="submit" value="저장"/>
				</td>
			</tr>
		</table>
		 
		 
	</form>
</body>
</html>