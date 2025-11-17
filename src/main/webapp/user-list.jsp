<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.dot.usermanagement.model.Users" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f4f4;
            margin: 30px;
        }
        h2 {
            text-align: center;
        }
        table {
            width: 70%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0px 0px 5px #ccc;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
        a {
            text-decoration: none;
            color: #007bff;
        }
        a:hover {
            text-decoration: underline;
        }
        .btn {
            background-color: #007bff;
            color: white;
            padding: 6px 12px;
            border-radius: 4px;
            text-decoration: none;
        }
        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <h2>User Management System</h2>
    <div style="text-align:center;">
        <a href="new" class="btn">Add New User</a>
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <%
            List<Users> listUser = (List<Users>) request.getAttribute("listuser");
            if (listUser != null && !listUser.isEmpty()) {
                for (Users user : listUser) {
        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getName() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getCountry() %></td>
            <td>
                <a href="edit?id=<%= user.getId() %>">Edit</a> |
                <a href="delete?id=<%= user.getId() %>" 
                   onclick="return confirm('Are you sure you want to delete this user?');">Delete</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5" style="text-align:center;">No users found</td>
        </tr>
        <% } %>
    </table>

</body>
</html>
