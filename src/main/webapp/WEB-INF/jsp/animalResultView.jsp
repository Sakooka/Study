<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.VoteDAO,model.Animals" %>
<% VoteDAO vd = new VoteDAO();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どうぶつ投票結果</title>
</head>
<body>

<h1>投票結果</h1>
<% for(Animals a : vd.findAll()){%>
<%= a.getName()%>:<%= a.getVotes() %>票<br>
<% }%>
<br>
<a href=/AnimalVotes/index.jsp>TOPに戻る</a>

</body>
</html>