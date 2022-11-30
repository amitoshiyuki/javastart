<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<p>ようこそ< value="${userId}" />さん</p>
<p>パス< value="${pass}" /></p>
<p>名前< value="${name}" /></p>
<a href="/webtest/LoginServlet">トップ</a>

</body>
</html>