<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="JavaProHW04.entity.User" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <meta charset="UTF-8">
        <title>JavaProHW04</title>
        <style>
           <%@include file="/styles/w3.css" %>
        </style>
</head>
<body>

<% if (request.getAttribute("userList") == null) {
   out.println("<div class=\"w3-panel w3-pale-yellow w3-border\">"+
               "<h3>Warning!</h3>" +
               "<p>Not one user was added</p>" +
               "</div>");
   }
   else {
          List<User> userList = (List) request.getAttribute("userList");
          out.println("<table class=\"w3-table w3-striped w3-border\">" +
                                "<tr>" +
                                "<td><b>Name</b></td>" +
                                "<td><b>Surname</b></td>" +
                                "<td><b>Phone Number</b></td>" +
                                "</tr>");
          for (User user: userList) {
          out.println("<tr>" +
                      "<td>"+user.getName()+"</td>" +
                      "<td>"+user.getSurname()+"</td>" +
                      "<td>"+user.getPhoneNumber()+"</td>" +
                      "</tr>");
          }
          out.println("</table>");
         }
%>


<br>
    <a class="w3-button w3-green" href="/input">Go back</a>
</body>
</html>