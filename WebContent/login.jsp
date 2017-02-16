<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login</title>
	
	<!-- Bootstrap -->
    <link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<center>
	<s:debug></s:debug>
	<hr>
		<s:form action="login" method="post">
			<s:actionerror/>
			<s:textfield name="name" label="Name" cssStyle="form-control"></s:textfield>
			<s:textfield name="password" label="Password" cssStyle="form-control"></s:textfield>
			<s:submit value="Login"></s:submit>		
		</s:form>
	</center>
</body>
</html>