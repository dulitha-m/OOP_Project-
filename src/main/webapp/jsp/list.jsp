<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Agent List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Agent List</h2>
    <a href="/agents/register" class="btn btn-primary mb-3">Add New Agent</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Contact</th>
            <th>Rating</th>
            <th>Specialization</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="agent" items="${agents}">
            <tr>
                <td>${agent.id}</td>
                <td>${agent.name}</td>
                <td>${agent.contact}</td>
                <td>${agent.rating}</td>
                <td>${agent.specialization}</td>
                <td>
                    <a href="/agents/view/${agent.id}" class="btn btn-sm btn-info">View</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>