
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reports</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="app-shell">
    <%@ include file="navbar.jsp" %>
    <main class="main-content">
        <div class="topbar">
            <div>
                <h1>Reports</h1>
                <p>Review inventory, reservation and sales performance.</p>
            </div>
        </div>

        <div class="card-grid">
            <a class="module-card" href="${pageContext.request.contextPath}/vehicles/report">
                <div class="module-icon">🚘</div>
                <h3>Inventory Report</h3>
                <p>Total, available, reserved and sold vehicles.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/reservations/report">
                <div class="module-icon">📅</div>
                <h3>Reservation Report</h3>
                <p>Total, confirmed, cancelled and completed reservations.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/sales/report">
                <div class="module-icon">💰</div>
                <h3>Sales Report</h3>
                <p>Total sales, completed sales and sales value.</p>
            </a>
        </div>
    </main>
</div>
</body>
</html>
