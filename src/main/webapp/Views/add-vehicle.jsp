
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Vehicle</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="form-container">
    <h2>Add New Vehicle</h2>
    <p class="form-description">Enter the vehicle details to add it to inventory.</p>

    <form action="${pageContext.request.contextPath}/vehicles/save" method="post">
        <div class="form-group">
            <label>Brand</label>
            <input type="text" name="brand" required>
        </div>
        <div class="form-group">
            <label>Model</label>
            <input type="text" name="model" required>
        </div>
        <div class="form-group">
            <label>Fuel Type</label>
            <select name="fuelType" required>
                <option value="">Select fuel type</option>
                <c:forEach var="fuel" items="${fuelTypes}">
                    <option value="${fuel}">${fuel}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Transmission</label>
            <select name="transType" required>
                <option value="">Select transmission</option>
                <c:forEach var="transmission" items="${transmissionTypes}">
                    <option value="${transmission}">${transmission}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Manufactured Year</label>
            <input type="number" name="manufacturedYear" min="1886" required>
        </div>
        <div class="form-group">
            <label>Colour</label>
            <input type="text" name="colour" required>
        </div>
        <div class="form-group">
            <label>Price</label>
            <input type="number" name="price" min="0.01" step="0.01" required>
        </div>
        
        <div class="form-actions">
            <button class="btn btn-primary" type="submit">Save Vehicle</button>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Views/vehicle-operations.jsp">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
