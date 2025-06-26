<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int i=0;
	while(i<10){
		System.out.println(i);
%>

<h4 style="color:gray"><%= i %></h4>

<% i++;} %>


<%!
	public int factorial(int n){
		int fact=1;
		for(int i=1;i<=n;i++){
			fact=fact*i;
		}
		return fact;
	}
%>

<h4 style="color:gray"><%= factorial(5) %></h4>

</body>
</html>