<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.VoteDAO,model.Animals" %>
<% VoteDAO vd = new VoteDAO();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除用ページ</title>
</head>
<body>

<h1>削除用ページ</h1>

<form action="/AnimalVotes/AnimalDeleteControl" method="POST">
<% for(Animals a : vd.findAll()){%>
<%= a.getName()%><input type="radio" name=name value=<%= a.getName()%>><br>
<%} %>
<input type="submit" value="削除">
</form>

<br>
<a href=/AnimalVotes/index.jsp>TOPに戻る</a>

</body>
</html>