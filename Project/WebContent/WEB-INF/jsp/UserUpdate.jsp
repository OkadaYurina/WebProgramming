<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>

<!DOCTYPE html>
<html lang="ja">
<head>
	<link  rel="stylesheet" href="css/userListstyle.css">
	<meta http-equiv="content-type" charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>ユーザ情報更新</title>
</head>
<body>
    <header>
      <nav class="navbar navbar-inverse">
      	<div class="container">
      		<div class="navbar-header">
            <a class="navbar-brand" href="userCreate.html">ユーザ情報更新</a>
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
	ユーザー情報更新
	</h1>
	<br>
	<font color="#ff0000">
	<c:if test="${errMsg1 != null}">
		<div class="alert alert-danger" role="alert">
		 	${errMsg1}
		</div>
	</c:if>

	<c:if test="${errMsg2 != null}">
		<div class="alert alert-danger" role="alert">
		 	${errMsg2}
		</div>
	</c:if>
	</font>
	<%

		User userDate = (User)request.getAttribute("userDate");

	%>

		<form class="form-update" action="UserUpdateServlet" method="post">
    	<span id="reauth-email" class="reauth-email"></span>
    	ログインID <%=userDate.getLoginId()%>
    	<input type="password" name="password" id="inputPassword" class="form-control" placeholder="パスワード" >
    	<input type="password" name="password2" id="inputPassword" class="form-control" placeholder="パスワード(確認)" >
    	<input type="text" name="username" id="inputUserName" class="form-control" placeholder="ユーザー名"value="<%=userDate.getName()%>" required>
    	<input type="date" name="birthday" id="inputBirthDay" class="form-control" placeholder="生年月日(20180903)"value="<%=userDate.getBirthDate()%>" required>
		<input type="hidden" name ="id" value="<%= request.getParameter("id") %>">
     	<button class="btn btn-lg btn-primary btn-block btn-signup" type="submit">ユーザ情報更新</button>
        </form>

	<br>
	<br>
	<a href="BackServlet" class="navbar-link back-link">戻る</a>
	<br>
	<br>
</body>
</html>


