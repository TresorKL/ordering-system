<%-- 
    Document   : registration
    Created on : 08 May 2022, 13:43:20
    Author     : tresorkl
--%>

<%@page import="za.ac.tut.client.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration outcome</title>
    </head>
    <style>
        body{
            background-color: green;
            color:white;
            font-family: sans-serif;
        }
        
    </style>
    <body>
        <%
        Client client = (Client)session.getAttribute("currentClient");
        %>
        <h1>WELCOME AGAIN <%=client.getName()%></h1>
        <h1>YOUR ID IS: <%=client.getId()%></h1>
        <p>You live in <%=client.getAddress().getCity()%></p>
        <p>Client <a href="menu.html">here</a> to start using the system</p>
    </body>
</html>
