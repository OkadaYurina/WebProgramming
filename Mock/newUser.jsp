<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" charset="utf-8">
	<link  rel="stylesheet" href="newUserstyle.css">
	<title>ユーザー新規登録</title>
</head>
<body>
	<header>
			ユーザー名さん　　　<a href=login.html>ログアウト</a>
	</header>
	<br>
	<br>
	<h1>
	ユーザー新規登録
	</h1>
	<ul>
	<form action="method="post">
		<li class="userid">
			<label for="userid">ユーザーID　</label>
			<input type="text" id="userid" name="user_id">
		</li>
	<br>
		<li class="pass">
			<label for="pass">パスワード　</label>
			<input type="text" id="pass" name="user_pass">
		</li>
	<br>
		<li class="pass">
			<label for="pass">パスワード(確認)　</label>
			<input type="text" id="pass" name="user_pass">
		</li>
	<br>
		<li class="username">
			<label for="username">ユーザー名　</label>
			<input type="text" id="username" name="user_pass">
		</li>
	<br>
		<li class="userbirthday">
			<label for="userbirthday">生年月日　</label>
			<input type="text" id="birthday" name="user_birthday">
		</li>
	<br>
		<div class="button">
  			<button type="submit">登録</button>
		</div>
	</ul>
	<br>
	<a href=userList.html>戻る</a>
	<br>
	<br>
</body>
</html>



