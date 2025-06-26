<%@page import="java.util.List"%>
<%@page import="com.infosys.servlet_simple_demo.dao.StudentDao"%>
<%@page import="com.infosys.servlet_simple_demo.entity.StudentEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>GetPlaced.com | Registered Student</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-serif min-h-screen flex flex-col">

	<!-- Header -->
	<header class="bg-white shadow-md">
		<div
			class="max-w-7xl mx-auto px-4 py-4 flex justify-between items-center">
			<h1 class="text-2xl font-bold text-blue-600">
				GetPlaced<span class="text-gray-800">.com</span>
			</h1>
			<nav class="space-x-6 text-sm font-medium">
				<a href="index.jsp" class="text-gray-700 hover:text-blue-600">Home</a>
				<a href="register.jsp" class="text-gray-700 hover:text-blue-600">Register</a>
				<a href="login.jsp" class="hover:text-blue-600">Login</a> <a
					href="about.jsp" class="text-gray-700 hover:text-blue-600">About</a>
				<a href="contact.jsp" class="text-gray-700 hover:text-blue-600">Contact</a>
			</nav>
		</div>
	</header>

	<!-- Main Content -->
	<div class="flex-grow">
		<div
			class="max-w-6xl mx-auto mt-10 p-6 bg-white rounded-2xl shadow-xl">
			<h2 class="text-xl font-semibold text-gray-700 mb-4">Registered
				Students</h2>
			<table
				class="table-auto border-collapse border border-gray-300 w-full text-sm text-center">
				<tr class="bg-gray-200 text-gray-800">
					<th class="border border-gray-300 px-4 py-2">Id</th>
					<th class="border border-gray-300 px-4 py-2">Name</th>
					<th class="border border-gray-300 px-4 py-2">Email</th>
					<th class="border border-gray-300 px-4 py-2">Phone</th>
					<th class="border border-gray-300 px-4 py-2">DOB</th>
					<th class="border border-gray-300 px-4 py-2">Gender</th>
				</tr>
				<%
				List<StudentEntity> studentList = StudentDao.getListOfStudentDao();
				for (StudentEntity student : studentList) {
				%>
				<tr class="hover:bg-gray-100">
					<td class="border border-gray-300 px-4 py-2"><%=student.getId()%></td>
					<td class="border border-gray-300 px-4 py-2"><%=student.getName()%></td>
					<td class="border border-gray-300 px-4 py-2"><%=student.getEmail()%></td>
					<td class="border border-gray-300 px-4 py-2"><%=student.getPhone()%></td>
					<td class="border border-gray-300 px-4 py-2"><%=student.getDate()%></td>
					<td class="border border-gray-300 px-4 py-2"><%=student.getGender()%></td>
				</tr>
				<%
				}
				%>
			</table>
		</div>
	</div>

	<!-- Footer -->
	<footer class="bg-gray-800 text-white text-sm text-center py-4">
		© 2025 GetPlaced.com — Connect. Learn. Get Placed. </footer>
</body>
</html>