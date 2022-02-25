<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ page import="com.example.appartmentsapplication.Cities" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: sid
  Date: 1/21/2022
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Apartments for rent in Albania</title>
</head>
<body style="text-align: center">
<h1> <%="Apartments for rent in Albania"%> </h1>
<br/><br/>

<form style="display: inline-block" method="get" action="${pageContext.request.contextPath}/SearchApartmentsServlet">
    Surface area : <input type="text" name="surfaceArea">
    <br/><br/>
    Monthly rent : <input type="text" name="monthlyRent">
    <br/><br/>
    City: <select name="city">
    <option value="none" selected>City</option>
    <c:forEach items="${Cities.values()}" var="city">
        <option value="${city}">${city}</option>
    </c:forEach>
    </select>
    <br/><br/>
    Search : <input type="submit" name="Search">
</form>

<br><br>
<form action="LogOutServlet" method="post" style="display: inline-block">
    <input type="submit" value="Log Out">
</form>

<table border="1" width="500" align="center">

    <tr>
        <th>Apartment Area</th>
        <th>Apartment Monthly Rent</th>
        <th>City</th>
    </tr>

    <c:forEach var="apartment" items="${apartments_list}">
        <tr>
            <td>${apartment.getSurfaceArea()}</td>
            <td>${apartment.getMonthlyRent()}</td>
            <td>${apartment.getCity()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
