
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Sales</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="form-container">
    <h2>Search Sales</h2>
    <p class="form-description">Search using sale, customer or vehicle ID.</p>

    <form action="${pageContext.request.contextPath}/sales/search" method="get">
        <div class="form-group">
            <label>Sale ID</label>
            <input type="number" name="saleId" min="1">
        </div>
        <div class="form-group">
            <label>Customer ID</label>
            <input type="number" name="customerId" min="1">
        </div>
        <div class="form-group">
            <label>Vehicle ID</label>
            <input type="number" name="vehicleId" min="1">
        </div>
        <div class="form-actions">
            <button class="btn btn-primary" type="submit">Search Sales</button>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/sales/all">View All</a>
        </div>
    </form>
</div>
</body>
</html>
