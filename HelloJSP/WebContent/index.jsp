<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST</title>
</head>
<body>




<p>こんにちわ！</p>
<% out.println(new java.util.Date()); %>




<%!
static int add(int a,int b){
	return a+b;
}
%>
<P>1+2=<%=add(1,2) %></P>




<%! static int countA=0; %>
<%
int countB=0;
countA++;
countB++;
%>
<p>宣言による変数 countA=<%=countA %></p>
<p>スクリプトレットによる変数 countB=<%=countB %></p>



<form method="post" action="total-out.jsp">
<input type="text" name="price">円×
<input type="text" name="count">個＋送料
<input type="text" name="delivery">円＝
<input type="submit" value="計算">
</form>


<%--
●JSP で Java を書くには、<body>タグ内に以下のようなプログラミングをします。
<%
ここに Java のプログラムを記述する。
%>

●JSP で Java をプログラミングする為に、以下のようなタグも準備されています。
<%! 宣言文; %>
変数、メソッドを宣言します。変数、メソッドの宣言の際は必ず;(セミコロン)が必要です。

<% スクリプトレット; %>
JSP のタグでは記述できない処理を Java コードを記述して自由な処理を実行する場合に使用し
ます。Java のコードのため、各コードには必ず;(セミコロン)が必要です。

<%= 式 %>
Java コードを記述しその実行結果を表示します。
void のメソッドや、変数の宣言のみを式に記述することはできません。
--%>



</body>
</html>