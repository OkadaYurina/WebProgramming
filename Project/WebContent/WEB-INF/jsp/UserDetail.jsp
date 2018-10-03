<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" charset="utf-8">
	<link  rel="stylesheet" href="css/newUserDetailsstyle.css">
	<title>ユーザー情報詳細参照</title>
</head>
<body>
    <header>
      <nav class="navbar navbar-inverse">
      	<div class="container">
      		<div class="navbar-header">
            <a class="navbar-brand">ユーザー情報詳細参照</a>
      		</div>

          <ul class="nav navbar-nav navbar-right">
            <li class="navbar-text">${userInfo.name} さん </li>
  			<li class="dropdown">
  			  <a href="LogoutServlet" class="navbar-link logout-link">ログアウト</a>
            </li>
  		  </ul>
      	</div>
      </nav>
    </header>
	<br>
	<br>
	<h1>
		ユーザー情報詳細参照
	</h1>

	<table border="0" align="center">
		<%
			User userDate = (User)request.getAttribute("userDate");
		%>
		<tr>
			<td>ログインID</td>
			<td>　　　　　　</td>
			<td><%=userDate.getLoginId()%></td>
		</tr>
		<tr>
			<td>ユーザー名</td>
			<td>　　　　　　</td>
			<td><%=userDate.getName()%></td>
		</tr>
		<tr>
			<td>生年月日</td>
			<td>　　　　　　</td>
			<td><%=userDate.getBirthDate()%></td>
		</tr>
		<tr>
			<td>登録日時</td>
			<td>　　　　　　</td>
			<td><%=userDate.getCreateDate()%></td>
		</tr>
		<tr>
			<td>更新日時</td>
			<td>　　　　　　</td>
			<td><%=userDate.getUpdateDate()%></td>
		</tr>


	</table>
</div>
	<a href="BackServlet" class="navbar-link back-link">戻る</a>
	<br>
	<br>
</body>
</html>

