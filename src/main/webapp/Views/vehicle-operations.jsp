
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vehicle Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="app-shell">
    <%@ include file="navbar.jsp" %>
    <main class="main-content">
        <div class="topbar">
            <div>
                <h1>Vehicle Management</h1>
                <p>Manage vehicle inventory.</p>
            </div>
        </div>

        <div class="card-grid">
            <a class="module-card" href="${pageContext.request.contextPath}/vehicles/add">
                <div class="module-icon">➕</div>
                <h3>Add Vehicle</h3>
                <p>Add a vehicle to the inventory.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/vehicles/all">
                <div class="module-icon">🚘</div>
                <h3>View Vehicles</h3>
                <p>Display all vehicles.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/Views/search-vehicle.jsp">
                <div class="module-icon">🔎</div>
                <h3>Search Vehicle</h3>
                <p>Find vehicles by ID, brand or model.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/vehicles/all">
                <div class="module-icon">✏️</div>
                <h3>Update Vehicle</h3>
                <p>Select a vehicle from the list to edit it.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/vehicles/all">
                <div class="module-icon">🗑️</div>
                <h3>Delete Vehicle</h3>
                <p>Choose a vehicle from the inventory list.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/vehicles/report">
                <div class="module-icon">📊</div>
                <h3>Inventory Report</h3>
                <p>View vehicle inventory statistics.</p>
            </a>
        </div>
    </main>
</div>
</body>
</html>
