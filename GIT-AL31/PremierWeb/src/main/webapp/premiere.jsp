<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Premiere JSP - AL31 - JEE</title>
</head>
<body>
	<h1>première JSP</h1>
	<%
	List<Integer> liste = new ArrayList();
	int i = 5;
	String s = "une chaine";
	%>
	<p><i><% out.print(i); %></i></p>
	<p><%=s %></p>
</body>
</html>