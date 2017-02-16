<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h4>Welcome Manager ${name} !</h4>
		<hr>
		<s:debug></s:debug>
		<hr>
		<br>
		<s:actionerror/>
		<s:actionmessage/>
		<a href="Punch_Come.punchAction?level=manager">Come Punch</a>
		<a href="Punch_Leave.punchAction?level=manager">Leave Punch</a>
	</center>
</body>
</html>