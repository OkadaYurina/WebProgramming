<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=”UTF-8”>
<title>入力内容表示</title>
</head>
<body>
<p>名前：<c:out value="${param.name}" /></p>
<p>性別：<c:out value="${param.gender}" /></p>
</body>
</html>