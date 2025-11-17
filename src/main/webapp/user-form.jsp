<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dot.usermanagement.model.Users" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Form</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f4f4;
            margin: 50px;
        }
        .container {
            width: 40%;
            margin: auto;
            background: white;
            padding: 20px;
            box-shadow: 0px 0px 5px #ccc;
            border-radius: 8px;
        }
        h2 {
            text-align: center;
        }
        label {
            display: block;
            margin-top: 15px;
        }
        input[type=text], input[type=email] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .btn {
            background-color: #007bff;
            color: white;
            padding: 8px 15px;
            margin-top: 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn:hover {
            background-color: #0056b3;
        }
        a {
            display: inline-block;
            margin-top: 15px;
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>
<body>

<%
    Users user = (Users) request.getAttribute("user");
    boolean isEdit = (user != null);
%>

<div class="container">
    <h2><%= isEdit ? "Edit User" : "Add New User" %></h2>

    <form action="<%= isEdit ? "update" : "insert" %>" method="post">
        <% if (isEdit) { %>
            <input type="hidden" name="id" value="<%= user.getId() %>">
        <% } %>

        <label>Name:</label>
        <input type="text" name="name" value="<%= isEdit ? user.getName() : "" %>" required>

        <label>Email:</label>
        <input type="email" name="email" value="<%= isEdit ? user.getEmail() : "" %>" required>

        <label>Country:</label>
        <input type="text" name="country" value="<%= isEdit ? user.getCountry() : "" %>" required>

        <button type="submit" class="btn"><%= isEdit ? "Update" : "Save" %></button>
    </form>

    <a href="list">Back to List</a>
</div>

</body>
</html>
