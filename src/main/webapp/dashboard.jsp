<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Dashboard | GetPlaced.com</title>
<script src="https://cdn.tailwindcss.com"></script>

</head>
<body class="bg-gray-100 font-sans leading-relaxed text-gray-800">

	<!-- Navbar -->
	<header class="bg-white shadow-md">
		<div
			class="max-w-7xl mx-auto px-4 py-4 flex justify-between items-center">
			<h1 class="text-2xl font-bold text-blue-600">
				GetPlaced<span class="text-gray-800">.com</span>
			</h1>
			<nav class="space-x-6 text-sm font-medium">
				<a href="index.jsp" class="text-gray-700 hover:text-blue-600">Home</a>
				<a href="register.jsp" class="text-gray-700 hover:text-blue-600">Register</a>
				<a href="login.jsp" class="hover:text-blue-600">Login</a>
				<a href="about.jsp" class="text-gray-700 hover:text-blue-600">About</a>
				<a href="contact.jsp" class="text-gray-700 hover:text-blue-600">Contact</a>
			</nav>
		</div>
	</header>

	<!-- Hero Section -->
	<section class="bg-blue-50 py-16">
		<div class="max-w-6xl mx-auto px-4 text-center">
			<h2 class="text-4xl font-bold text-gray-800 mb-4">
				Welcome to <span class="text-blue-600">GetPlaced.com</span>
			</h2>
			<p class="text-lg text-gray-600 mb-6">Your gateway to top campus
				placements.</p>
		</div>
	</section>

	<!-- Features Section -->
	<section class="py-12 bg-white">
		<div class="max-w-6xl mx-auto px-4 text-center">
			<h3 class="text-2xl font-bold text-gray-800 mb-8">Thank You For Believing in Us!!</h3>
			<div class="grid md:grid-cols-3 gap-6">
				<div
					class="p-6 border rounded-xl shadow-sm hover:shadow-md transition">
					<a href="toprecruiters.jsp"
						class="text-xl font-semibold text-blue-600 mb-2">Our Top
						Recruiters</a>
					<p class="text-sm text-gray-600">Partnered with leading
						companies to get you the best offers.</p>
				</div>
				<div
					class="p-6 border rounded-xl shadow-sm hover:shadow-md transition">
					<a href="skills.jsp"
						class="text-xl font-semibold text-blue-600 mb-2">Our Skill
						Support</a>
					<p class="text-sm text-gray-600">Free workshops, mock
						interviews, and career counseling.</p>
				</div>
				<div
					class="p-6 border rounded-xl shadow-sm hover:shadow-md transition">
					<a  href="trackprogress.jsp"
						class="text-xl font-semibold text-blue-600 mb-2">Track Your
						Progress</a>
					<p class="text-sm text-gray-600">Keep track of your
						applications and interview rounds.</p>
				</div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<footer class="bg-gray-800 text-white py-6 mt-10">
		<div class="max-w-6xl mx-auto px-4 text-center text-sm">© 2025
			GetPlaced.com — All rights reserved.</div>
	</footer>

</body>
</html>