<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User" %>
<!DOCTYPE html>
<html lang="ja">
<head>
	<link  rel="stylesheet" href="css/userListstyle.css">
	<meta http-equiv="content-type" charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>ユーザー一覧</title>
</head>
<body>
    <header>
      <nav class="navbar navbar-inverse">
      	<div class="container">

          <ul class="nav navbar-nav navbar-right">
            <li class="navbar-text">${userInfo.name} さん </li>
  			<li class="dropdown">
  			  <a href=LogoutServlet class="navbar-link logout-link">ログアウト</a>
            </li>
  		  </ul>
      	</div>
      </nav>
    </header>
     <div class="navbar-header">
       <a class="navbar-brand">ユーザ一覧</a>
     </div>

    <div class="container">

      <div class="text-right">
        <a href=CreateUserServlet>新規登録</a>
      </div>


		<form class="form-searchuser" action="UserListServlet" method="post">
    	<input type="text" name="loginid" id="inputLoginId" class="form-control" placeholder="ログインID"  autofocus>
    	<input type="text" name="username" id="inputUserName" class="form-control" placeholder="ユーザID" >
    	<input type="date" name="birthfrom" id="inputBirthfrom" class="form-control" placeholder="生年月日(20180903)" >
    	～
    	<input type="date" name="birthto" id="inputBirthto" class="form-control" placeholder="生年月日(20180903)" >
		<button class="btn btn-lg btn-primary btn-block btn-searchuser" type="submit">検索</button>
        </form>
		<c:choose>

			<c:when test="${sessionScope.userInfo.loginId == 'admin'}">
			        <div class="table-responsive">
		             <table class="table table-striped">
		               <thead>
		                 <tr>
		                   <th>ログインID</th>
		                   <th>ユーザ名</th>
		                   <th>生年月日</th>
		                   <th></th>
		                 </tr>
		               </thead>
		               <tbody>
		                 <c:forEach var="user" items="${userList}" >
		                   <tr>
		                     <td>${user.loginId}</td>
		                     <td>${user.name}</td>
		                     <td>${user.birthDate}</td>
		                     <td>

		                       <a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">詳細</a>
		                       <a class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
		                       <a class="btn btn-danger" href ="UserDeleteServlet?id=${user.id}">削除</a>
		                     </td>
		                   </tr>
		                 </c:forEach>
		               </tbody>
		             </table>
		           </div>
			</c:when>

			<c:otherwise>
			        <div class="table-responsive">
		             <table class="table table-striped">
		               <thead>
		                 <tr>
		                   <th>ログインID</th>
		                   <th>ユーザ名</th>
		                   <th>生年月日</th>
		                   <th></th>
		                 </tr>
		               </thead>
		               <tbody>
		                 <c:forEach var="user" items="${userList}" >
		                   <tr>
		                     <td>${user.loginId}</td>
		                     <td>${user.name}</td>
		                     <td>${user.birthDate}</td>
		                     <td>
							<c:set var = "loginId" value="${sessionScope.userInfo.loginId}"></c:set>
		                       <c:choose>

		                       	<c:when test="${user.loginId == loginId}">
		                       		<a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">詳細</a>
		                       		<a class="btn btn-success" href="UserUpdateServlet?id=${user.id}">更新</a>
		                       	</c:when>
		                       	<c:otherwise>
		                       		<a class="btn btn-primary" href="UserDetailServlet?id=${user.id}">詳細</a>
		                       	</c:otherwise>
		                       </c:choose>

		                     </td>
		                   </tr>
		                 </c:forEach>
		               </tbody>
		             </table>
		           </div>

			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>