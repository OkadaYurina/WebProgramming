<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" charset="utf-8">
	<link  rel="stylesheet" href="css/deleteUserstyle.css">
	<title>ユーザー削除確認</title>
</head>
<body>
    <header>
      <nav class="navbar navbar-inverse">
      	<div class="container">
      		<div class="navbar-header">
            <a class="navbar-brand" href="userCreate.html">ユーザー削除確認</a>
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
		ユーザー削除確認
	</h1>
	<%
	User userDate = (User)request.getAttribute("userDate");
	%>


	ログインID：<%=userDate.getLoginId()%>
	を削除してよろしいでしょうか。
		<form class="form-deleteuser" action="UserDeleteServlet" method="post">
        	<span id="reauth-email" class="reauth-email"></span>
        	<input type="hidden" name ="id" value="<%= request.getParameter("id") %>">
			<a href="UserListServlet"><input type="button"value="キャンセル"></a>
     		<button class="btn btn-lg btn-primary btn-block btn-signup" type="submit">OK</button>
        </form>


	<br>
	<br>
	<br>
	<br>
</body>
</html>

