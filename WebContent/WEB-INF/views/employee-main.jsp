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
		<h4>Welcome Employee ${name} !</h4>
		<hr>
		<s:debug></s:debug>
		<hr>
		<br>
		<table>
			<thead>
				<tr>
					<td>To Do</td>
					<td>Result</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<a href="Punch_Come.punchAction?level=employee">Come Punch</a>
						<a href="Punch_Leave.punchAction?level=employee">Leave Punch</a>
					</td>
					<td>
						<s:actionerror/>
						<s:actionmessage/>
					</td>
				</tr>
				
				<tr>
					<td><a href="Application">Application</a></td>
					<td>
						<s:fielderror/>
						<s:actionmessage/>
					</td>
				</tr>				
			</tbody>		
		</table>
		
	</center>
</body>
</html>