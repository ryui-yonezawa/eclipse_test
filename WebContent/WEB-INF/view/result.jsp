<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アクセス回数</title>
</head>
<body>
	<p>リクエスト：<%=request.getAttribute("request_access") %>回</p><br>
	<p>セッション：<%=session.getAttribute("session_access") %>回</p><br>
	<p>アプリケーション：<%=application.getAttribute("application_access") %>回</p><br>
	<a href="/ScopeSample/Reload">リロード！</a>

</body>
</html>