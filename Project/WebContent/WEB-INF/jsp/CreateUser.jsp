<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta http-equiv="content-type" charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link  rel="stylesheet" href="css/indexstyle.css">
	<title>ユーザ新規登録</title>
</head>
<body>
    <header>
      <nav class="navbar navbar-inverse">
      	<div class="container">
      		<div class="navbar-header">
            <a class="navbar-brand" >ユーザ新規登録</a>
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
	ユーザー新規登録
	</h1>

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
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		String loginId = request.getParameter("loginId");
		String username = request.getParameter("username");
		String birthday = request.getParameter("birthday");
	%>

	<form class="form-signup" action="CreateUserServlet" method="post">
    	<span id="reauth-email" class="reauth-email"></span>
    	<input type="text" name="loginId" id="inputLoginId" class="form-control" placeholder="ログインID" value="${loginId}" required autofocus>
    	<input type="password" name="password" id="inputPassword" class="form-control" placeholder="パスワード" required>
    	<input type="password" name="password2" id="inputPassword" class="form-control" placeholder="パスワード(確認)" required>
    	<input type="text" name="username" id="inputUserName" class="form-control" placeholder="ユーザー名" value="${username}" required>
    	<input type="date" name="birthday" id="inputBirthDay" class="form-control" placeholder="生年月日(20180903)" value="${birthday}" required>


     	<button class="btn btn-lg btn-primary btn-block btn-signup" type="submit">新規登録</button>
        </form>

	<br>
	<a href="BackServlet" class="navbar-link back-link">戻る</a>
	<br>
	<br>
</body>
</html>



