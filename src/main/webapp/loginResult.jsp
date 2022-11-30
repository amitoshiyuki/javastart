<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
//セッションスコープからのユーザ情報を取得
User loginUser = (User) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ</title>
</head>
<body>
<h1>ユーザログイン</h1>
<% if(loginUser != null) {  %>
  <p>ログインに成功しました</p>
  <p>ようこそ<%= loginUser.getName() %>さん</p>
  <a href="/docoTsubu/Main">ログイン画面へ</a>
 <% } else { %>
   <p>ログインに失敗しました</p>
   <a href="/docoTsubu/">Topへ</a>
 <% } %>
</body>
</html>