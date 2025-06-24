<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>About Us | GetPlaced.com</title>
  <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 font-sans text-gray-800">

  <!-- Navbar -->
  <header class="bg-white shadow">
    <div class="max-w-7xl mx-auto px-4 py-4 flex justify-between items-center">
      <h1 class="text-2xl font-bold text-blue-600">GetPlaced<span class="text-gray-800">.com</span></h1>
      <nav class="space-x-6 text-sm font-medium">
        <a href="index.jsp" class="hover:text-blue-600">Home</a>
        <a href="register.jsp" class="hover:text-blue-600">Register</a>
        <a href="login.jsp" class="hover:text-blue-600">Login</a>
        <a href="about.jsp" class="text-blue-600 font-semibold">About</a>
        <a href="contact.jsp" class="hover:text-blue-600">Contact</a>
      </nav>
    </div>
  </header>

  <!-- About Section -->
  <section class="py-16 bg-white">
    <div class="max-w-5xl mx-auto px-4">
      <h2 class="text-3xl font-bold text-center text-gray-800 mb-6">About GetPlaced</h2>
      <p class="text-lg text-gray-600 text-center mb-10">
        GetPlaced.com is a student-focused placement portal helping fresh graduates kickstart their careers.
        Our goal is to bridge the gap between top recruiters and talented students.
      </p>

      <div class="grid md:grid-cols-2 gap-8">
        <div>
          <h3 class="text-xl font-semibold text-blue-600 mb-2">Our Mission</h3>
          <p class="text-sm text-gray-700">
            We aim to provide easy access to career opportunities, mock interviews, resume building tools,
            and real-time application tracking to ensure every student is job-ready.
          </p>
        </div>
        <div>
          <h3 class="text-xl font-semibold text-blue-600 mb-2">Who We Serve</h3>
          <p class="text-sm text-gray-700">
            College students, fresh graduates, placement coordinators, and hiring managers
            from top IT and non-IT companies looking to tap into early talent.
          </p>
        </div>
      </div>
    </div>
  </section>

  <footer class="bg-gray-800 text-white text-sm text-center py-4 mt-10">
    © 2025 GetPlaced.com — Built for student success.
  </footer>

</body>
</html>
