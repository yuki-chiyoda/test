<!doctype html>
<html lang="ja">
  
<head>
  <meta charset="UTF-8">
  <title>4eachblog 掲示板</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
  
<?php

mb_internal_encoding("utf8");
$pdo = new PDO("mysql:dbname=lessonchiyoda;host=localhost;","root","mysql");
$stmt = $pdo->query("select*from 4each_keijiban");

?>

<img class="top" src="4eachblog_logo.jpg">
  
<header>
  <ul>
    <li>トップ</li>
    <li>プロフィール</li>
    <li>4eachについて</li>
    <li>登録フォーム</li>
    <li>問い合わせ</li>
    <li>その他</li>   
  </ul>
  
</header>
  
<main>
  <div class="maincontainer">
  
    <div class="abc">
      <h1>プログラミングに役立つ掲示板</h1>
      <div class="form">
      <h2>入力フォーム</h2>
      <form method="post" action="insert.php">
        
        <div>
        <label>ハンドルネーム</label><br>
        <input type="text" class="text" size="35" name="handlename">
        </div>
        
        <div>
        <label>タイトル</label><br>
        <input type="text" class="text" size="35" name="title">
        </div>
        
        <div>
        <label>コメント</label><br>
        <textarea cols="35" rows="7" name="comments"></textarea>
        </div>
    
        <div>
        <input type="submit" class="submit" value="送信する">
        </div>
    
      </form>
      </div>
      
      <?php
      
      while($row = $stmt->fetch()){
        
      echo "<div class='kkk'>";     
      echo "<h2>".$row['title']."</h2>";
      echo "<p>".$row['comments']."</p>";
      echo "<div class='namae'>posted by ".$row['handlename']."</div>";
      echo "</div>";
      }
      ?>
                
    </div>
    
    <div class="xyz">
      <h2>人気の記事</h2>
      <ul>
        <li>PHP オススメの本</li>
        <li>PHP MyAdminの使い方</li>
        <li>今人気のエディタ　Top5</li>
        <li>HTMLの基礎</li>
      </ul>
      <h2>オススメリンク</h2>
      <ul>
        <li>インターノウス株式会社</li>
        <li>XAMPPのダウンロード</li>
        <li>Eclipseのダウンロード</li>
        <li>Bracketsのダウンロード</li>
      </ul>
      <h2>カテゴリ</h2>
      <ul>
        <li>HTML</li>
        <li>PHP</li>
        <li>MySQL</li>
        <li>JavaScript</li>
      </ul>
    </div>
  </div>
  
  </main>
  
<footer>
  copyright © internous | 4each blog is the one which provides A to Z about programing.
  </footer>
  
</body>
</html>