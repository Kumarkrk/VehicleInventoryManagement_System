
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Vehicle</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="form-container">
    <h2>Search Vehicle</h2>
    <p class="form-description">Search using vehicle ID, brand or model.</p>

    <form action="${pageContext.request.contextPath}/vehicles/search" method="post">
        <div class="form-group">
            <label>Vehicle ID</label>
            <input type="number" name="id" min="1">
        </div>
        <div class="form-group">
            <label>Brand</label>
            <input type="text" name="brand">
        </div>
        <div class="form-group">
            <label>Model</label>
            <input type="text" name="model">
        </div>
        <div class="form-actions">
            <button class="btn btn-primary" type="submit">Search</button>
             
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/vehicles/all">View All</a>
         <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Views/vehicle-operations.jsp">Back</a>
     
        </div>
        <c:if test="${not empty error}">
    <div class="alert-danger">${error}</div>
</c:if>
    </form>
</div>
</body>
</html>
