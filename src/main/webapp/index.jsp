<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<h1>入力</h1>
<form action="/webtest/Login" method="post">
ユーザ名:<input type="text" name="name"><br>
パスワード:<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>

</body>
</html>