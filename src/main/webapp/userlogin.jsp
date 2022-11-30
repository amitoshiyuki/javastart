<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="bean.LoginUserBean" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>

<form action="./LoginUserServlet" method="post">
	<p>
		ユーザID：<input type="text" name="userid" required>
		パスワード：<input type="password" name="userpw" required>
	</p>
	
	<input type="submit" value="ログイン">
	
</form>

<!-- ログイン失敗時の処理 -->
<%
	LoginUserBean userinfo = (LoginUserBean)request.getAttribute("result");
	if(userinfo != null) {
		if(userinfo.getLogin_user_flg() == 1){
%>
			IDまたはパスワードに不備があります
<%
		}
	}
%>

</body>
</html>