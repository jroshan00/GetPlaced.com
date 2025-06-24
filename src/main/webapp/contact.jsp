<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Contact | GetPlaced.com</title>
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
        <a href="about.jsp" class="hover:text-blue-600">About</a>
        <a href="contact.jsp" class="text-blue-600 font-semibold">Contact</a>
      </nav>
    </div>
  </header>

  <!-- Contact Form Section -->
  <section class="py-16 bg-white">
    <div class="max-w-4xl mx-auto px-4">
      <h2 class="text-3xl font-bold text-center text-gray-800 mb-6">Get in Touch</h2>
      <p class="text-center text-gray-600 mb-10">
        Have questions, suggestions, or just want to connect? We'd love to hear from you.
      </p>

      <form action="studentMessage" method="POST" class="space-y-6">
        <div class="grid md:grid-cols-2 gap-6">
          <input type="text" name="name" placeholder="Your Name" required class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400" />
          <input type="email" name="email" placeholder="Your Email" required class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400" />
        </div>
        <textarea name="message" rows="5" placeholder="Your Message" required class="w-full px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-400"></textarea>
        <button type="submit" class="bg-blue-600 text-white px-6 py-2 rounded-full hover:bg-blue-700 transition">
          Send Message
        </button>
      </form>
    </div>
  </section>

  <footer class="bg-gray-800 text-white text-sm text-center py-4 mt-10">
    © 2025 GetPlaced.com — Connect. Learn. Get Placed.
  </footer>

</body>
</html>
