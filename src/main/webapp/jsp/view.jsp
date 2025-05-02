<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>View Agent</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2>Agent Details</h2>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">${agent.name}</h5>
            <p class="card-text"><strong>ID:</strong> ${agent.id}</p>
            <p class="card-text"><strong>Contact:</strong> ${agent.contact}</p>
            <p class="card-text"><strong>Rating:</strong> ${agent.rating}</p>
            <p class="card-text"><strong>Specialization:</strong> ${agent.specialization}</p>
            <a href="/agents/list" class="btn btn-primary">Back to List</a>
        </div>
    </div>
</div>
</body>
</html>