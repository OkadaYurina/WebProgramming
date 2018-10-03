
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" charset="utf-8">
	<link  rel="stylesheet" href="userListstyle.css">
	<title>ユーザー一覧</title>
</head>
<body>
	<header>
			ユーザー名さん　　　<a href=login.html>ログアウト</a>
	</header>
	<br>
	<br>
	<h1>
	ユーザー一覧
	</h1>
	<br>
	<div class="regist">
		<a href=newUser.html>新規登録</a>
	</div>
	<br>
	<ul>
	<form action="" method="post">
		<li class="userid">
			<label for="userid">ログインID　</label>
			<input type="text" id="userid" name="user_id">
		</li>
		<li class="pass">
			<label for="pass">ユーザー名　</label>
			<input type="text" id="pass" name="user_pass">
		</li>
		<li class="pass">
    		<label for="bday">生年月日</label>
    		<input type="date" id="birthday" name="birthday">～<input type="date" id="birthday" name="birthday">
		</li>
	</ul>
	<br>
		<div class="button">
  			<button type="search">検索</button>
		</div>
	</form>
	<br>
	<br>
<hr>
<br>
<table border="1" align="center">
	<tr>
		<th>ログインID</th>
		<th>ユーザー名</th>
		<th>生年月日</th>
		<th>　　　　　</th>

	</tr>
	<tr>
		<td>id0001</td>
		<td>田中太郎</td>
		<td>1989年04月26日</td>
		<td><div class="detbutton">
  			<input type="button" onclick="location.href='newUserDetails.html'"value="詳細" style=color:#FFF;background:#668ad8>
		</div>
		<div class="updbutton">
  			<input type="button" onclick="location.href='updateUser.html'"value="更新" style=color:#FFF;background:#008000>
		</div>
		<div class="delbutton">
  			<input type="button" onclick="location.href='deleteUser.html'"value="削除" style=color:#FFF;background:#ea5550>
		</div>

	</tr>
	<tr>
		<td>id0002</td>
		<td>佐藤二郎</td>
		<td>2001年11月12日</td>
		<td><div class="detbutton">
  			<input type="button" onclick="location.href='newUserDetails.html'"value="詳細" style=color:#FFF;background:#668ad8>
		</div>
		<div class="updbutton">
  			<input type="button" onclick="location.href='updateUser.html'"value="更新" style=color:#FFF;background:#008000>
		</div>
		<div class="delbutton">
  			<input type="button" onclick="location.href='deleteUser.html'"value="削除" style=color:#FFF;background:#ea5550>
		</div>

	<tr>
		<td>id0003</td>
		<td>佐川真司</td>
		<td>2000年01月01日</td>
		<td><div class="detbutton">
  			<input type="button" onclick="location.href='newUserDetails.html'"value="詳細" style=color:#FFF;background:#668ad8>
		</div>
		<div class="updbutton">
  			<input type="button" onclick="location.href='updateUser.html'"value="更新" style=color:#FFF;background:#008000>
		</div>
		<div class="delbutton">
  			<input type="button" onclick="location.href='deleteUser.html'"value="削除" style=color:#FFF;background:#ea5550>
		</div>
	</tr>
<table>
<br>
</body>
</html>
</body>
</html>
