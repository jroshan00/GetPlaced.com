<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Logout | GetPlaced.com</title>
</head>
<body>

<%
    // Get the current session without creating a new one
    HttpSession sessions = request.getSession(false);

    // If session exists, invalidate it
    if (sessions != null) {
        sessions.invalidate();
    }

    // Redirect to login page after logout
    response.sendRedirect("login.jsp");
%>

</body>
</html>