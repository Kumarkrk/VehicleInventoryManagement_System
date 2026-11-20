<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Vehicle</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css">
</head>

<body>

<div class="form-container">

    <h2>Update Vehicle</h2>
    <p class="form-description">Update the vehicle information.</p>

    <form action="${pageContext.request.contextPath}/vehicles/update"
          method="post">
        <c:if test="${not empty error}">
    <div class="alert-error">
        ${error}
    </div>
</c:if>

<c:if test="${not empty message}">
    <div class="alert-success">
        ${message}
    </div>
</c:if>
        <!-- Existing vehicle ID -->
        <input type="hidden" name="id" value="${vehicle.id}">

        <div class="form-group">
            <label>Brand</label>
            <input type="text" name="brand"
                   value="${vehicle.brand}" required>
        </div>

        <div class="form-group">
            <label>Model</label>
            <input type="text" name="model"
                   value="${vehicle.model}" required>
        </div>

        <div class="form-group">
            <label>Fuel Type</label>
            <select name="fuelType" required>
                <c:forEach var="fuel" items="${fuelTypes}">
                    <option value="${fuel}"
                        ${vehicle.fuelType == fuel ? 'selected' : ''}>
                        ${fuel}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Transmission Type</label>
            <select name="transType" required>
                <c:forEach var="trans" items="${transmissionTypes}">
                    <option value="${trans}"
                        ${vehicle.transType == trans ? 'selected' : ''}>
                        ${trans}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label>Manufactured Year</label>
            <input type="number" name="manufacturedYear"
                   value="${vehicle.manufacturedYear}"
                   min="1886" required>
        </div>

        <div class="form-group">
            <label>Colour</label>
            <input type="text" name="colour"
                   value="${vehicle.colour}">
        </div>

        <div class="form-group">
            <label>Price</label>
            <input type="number" name="price"
                   value="${vehicle.price}"
                   step="0.01" min="0.01" required>
        </div>

        

        <div class="form-actions">
            <button type="submit" class="btn btn-primary">
                Update Vehicle
            </button>

            <a class="btn btn-secondary"
               href="${pageContext.request.contextPath}/Views/vehicle-operations.jsp">
                Cancel
            </a>
        </div>

    </form>
</div>

</body>
</html>
