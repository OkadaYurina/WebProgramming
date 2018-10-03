<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
	<meta http-equiv="content-type" charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link  rel="stylesheet" href="css/indexstyle.css">
	<title>ログイン画面</title>
</head>
<body>

    <header>
      <nav class="navbar navbar-inverse">
      	<div class="container">
      		<div class="navbar-header">
            <a class="navbar-brand" >ログイン画面</a>
      		</div>
      	</div>
      </nav>
    </header>
	<font color="#ff0000">
    	<div class="container">
			<c:if test="${errMsg != null}">
				<div class="alert alert-danger" role="alert">
				 	${errMsg}
				</div>
			</c:if>
		</div>
	</font>

      <div class="card card-container">
        <img id="profile-img" class="profile-img-card" src="./img/dammy_icon.png" />
        <p id="profile-name" class="profile-name-card"></p>

        <form class="form-signin" action="LoginServlet" method="post">
          <span id="reauth-email" class="reauth-email"></span>
          <input type="text" name="loginId" id="inputLoginId" class="form-control" placeholder="ログインID" required autofocus>
          <input type="password" name="password" id="inputPassword" class="form-control" placeholder="パスワード" required>
          <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">ログイン</button>
        </form>

       </div>

    </div>

</body>
</html>

