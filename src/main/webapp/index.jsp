<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.VoteDAO,model.Animals" %>
<% VoteDAO vd = new VoteDAO();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どうぶつ投票</title>
</head>
<body>

<h1>投票ページ</h1><br>

<form action="/AnimalVotes/AnimalIncrementControl" method="POST">
<% for(Animals a : vd.findAll()){%>
<%= a.getName()%><input type="radio" name=name value=<%= a.getName()%>><br>
<%} %>
<input type="submit" value="投票">
</form>

<br>
<form action="/AnimalVotes/AnimalIncrementControl" method="GET">
新しい動物を追加:<input type="text" name=name><br>
<input type="submit" value="追加">
</form>

<br>
<a href="/AnimalVotes/AnimalDeleteControl">削除用ページへ移動</a>

</body>
</html>