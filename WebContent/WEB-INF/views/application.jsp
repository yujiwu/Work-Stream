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
		<h4>Application</h4>
		<s:debug></s:debug>
		<hr>
		<br>
		<s:form action="processApp" method="post">
			<table>
				<tr>
					<td>User: </td>
					<td>${session.name}</td>
				</tr>
				<s:textfield name="attendId" label="Attend ID"></s:textfield>
				<s:select name="attendTypeId" label="Type"
				 	list="attendTypes" listKey="attendTypeId"
				 	listValue="name"/>
				<s:textarea name="reason" label="Reason"></s:textarea>
				<tr>
					<td>
						<s:submit value="Submit" theme="simple"/>
						<s:reset value="Clear" theme="simple"/>
					</td>
				</tr>
			</table>
		</s:form>
	</center>
</body>
</html>