<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>GetPlaced.com | Registration</title>
    
  	<!-- Tailwind CSS -->
  	<script src="https://cdn.tailwindcss.com"></script>
  	
</head>
<body class="bg-gray-100 font-serif">
	<header class="bg-white shadow-md">
    	<div class="max-w-7xl mx-auto px-4 py-4 flex justify-between items-center">
      		<h1 class="text-2xl font-bold text-blue-600">GetPlaced<span class="text-gray-800">.com</span></h1>
		      <nav class="space-x-6 text-sm font-medium">
		        <a href="index.jsp" class="text-gray-700 hover:text-blue-600">Home</a>
		        <a href="register.jsp" class="text-gray-700 hover:text-blue-600">Register</a>
		        <a href="login.jsp" class="hover:text-blue-600">Login</a>
		        <a href="about.jsp" class="text-gray-700 hover:text-blue-600">About</a>
		        <a href="contact.jsp" class="text-gray-700 hover:text-blue-600">Contact</a>
		      </nav>
    	</div>
  	</header>
    <div class="max-w-xl mx-auto mt-10 p-8 bg-white rounded-2xl shadow-xl">
        <h2 class="text-red-600 text-lg font-bold mb-4">
            Note: This registration form is for fresher candidates only
        </h2>

        <form action="registerStudent" method="post" class="space-y-5">
            <h1 class="text-2xl font-bold text-center text-gray-700 mb-4">Student Registration Form</h1>

            <div>
                <label for="id" class="block text-sm font-semibold text-gray-700">Student ID</label>
                <input type="text" id="id" name="id" placeholder="Enter ID" required
                       class="w-full mt-1 px-4 py-2 border rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-400">
            </div>

            <div>
                <label for="name" class="block text-sm font-semibold text-gray-700">Student Name</label>
                <input type="text" id="name" name="name" placeholder="Enter Name" required
                       class="w-full mt-1 px-4 py-2 border rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-400">
            </div>

            <div>
                <label for="email" class="block text-sm font-semibold text-gray-700">Email</label>
                <input type="email" id="email" name="email" placeholder="example@gmail.com" required
                       class="w-full mt-1 px-4 py-2 border rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-400">
            </div>

            <div>
                <label for="password" class="block text-sm font-semibold text-gray-700">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter password" required
                       class="w-full mt-1 px-4 py-2 border rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-400">
            </div>

            <div>
                <label for="phone" class="block text-sm font-semibold text-gray-700">Phone</label>
                <input type="tel" id="phone" name="phone" placeholder="Enter phone number" required
                       class="w-full mt-1 px-4 py-2 border rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-400">
            </div>

            <div>
                <label for="dob" class="block text-sm font-semibold text-gray-700">Date of Birth</label>
                <input type="date" id="dob" name="date" required
                       class="w-full mt-1 px-4 py-2 border rounded-lg shadow-sm focus:outline-none focus:ring-2 focus:ring-blue-400">
            </div>

            <div>
                <span class="block text-sm font-semibold text-gray-700 mb-1">Gender</span>
                <div class="flex items-center space-x-6">
                    <label class="flex items-center">
                        <input type="radio" name="gender" value="male" required class="mr-2">
                        Male
                    </label>
                    <label class="flex items-center">
                        <input type="radio" name="gender" value="female" class="mr-2">
                        Female
                    </label>
                </div>
            </div>

            <div class="text-center">
                <button type="submit"
                        class="mt-4 bg-blue-600 hover:bg-blue-700 text-white font-bold py-2 px-6 rounded-full transition duration-300 shadow-md"
                        value="register">
                    Register
                </button>
            </div>
        </form>
    </div>
 	<footer class="bg-gray-800 text-white text-sm text-center py-4 mt-10">
    © 2025 GetPlaced.com — Connect. Learn. Get Placed.
  	</footer>
</body>
</html>
