<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Log In</title>
</head>
<body style="text-align: center">
<h1><%= "Log in page" %></h1>
<br/>
<h2><%= "Apartment Booking App!" %></h2>

<form action="/LogInServlet" method="post" style="display: inline-block">
    Username : <input type="text" name="username">
    <br/><br/>
    Password : <input type="password" name="password">
    <br/><br/>
    <input type="submit" value="Log In">
</form>
</body>
</html>