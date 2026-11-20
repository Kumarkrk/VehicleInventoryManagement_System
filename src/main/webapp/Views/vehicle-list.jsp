
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vehicle Inventory</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="app-shell">
    <%@ include file="navbar.jsp" %>
    <main class="main-content">
        <div class="topbar">
            <div>
                <h1>Vehicle Inventory</h1>
                <p>All vehicles registered in the system</p>
            </div>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/vehicles/add">+ Add Vehicle</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/Views/vehicle-operations.jsp">Back to vehicle operations</a>
      
        </div>

        <div class="panel">
            <div class="table-wrap">
                <table>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Brand</th>
                        <th>Model</th>
                        <th>Fuel</th>
                        <th>Transmission</th>
                        <th>Year</th>
                        <th>Colour</th>
                        <th>Price</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="vehicle" items="${vehicles}">
                        <tr>
                            <td>${vehicle.id}</td>
                            <td>${vehicle.brand}</td>
                            <td>${vehicle.model}</td>
                            <td>${vehicle.fuelType}</td>
                            <td>${vehicle.transType}</td>
                            <td>${vehicle.manufacturedYear}</td>
                            <td>${vehicle.colour}</td>
                            <td>${vehicle.price}</td>
                            <td><span class="status">${vehicle.vehicleStatus}</span></td>
                            <td>
                                
                                <a class="btn btn-danger btn-small" href="${pageContext.request.contextPath}/vehicles/edit/${vehicle.id}">
                                                     Edit
                                                    </a>          
                                <a class="btn btn-danger btn-small"
                                   href="${pageContext.request.contextPath}/vehicles/delete/${vehicle.id}"
                                   onclick="return confirm('Delete this vehicle?');">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty vehicles}">
                        <tr><td colspan="10" class="empty-message">No vehicles found.</td></tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</div>
</body>
</html>
