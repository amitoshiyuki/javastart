<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
    
<%@ page import="bean.LoginUserBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインOK画面</title>
</head>
<body>
<%
	LoginUserBean login_user = (LoginUserBean)session.getAttribute("result_user");
	
	if (login_user == null){
%>
	<br>
	<P>ログイン情報なし</P>
	<br>
<%	} else { %>
	<P>ユーザID：<%= login_user.getLogin_user_id() %></P>
	<P>ユーザ名：<%= login_user.getLogin_user_name() %></P>

	<% } %>
</body>
</html>