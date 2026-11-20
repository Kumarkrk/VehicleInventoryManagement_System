<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Inventory Management System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="app-shell">
    <%@ include file="navbar.jsp" %>

    <main class="main-content">
        <div class="topbar">
            <div>
                <h1>Dashboard</h1>
                <p>Vehicle Inventory Management System</p>
            </div>
        </div>

	       <section class="dashboard-welcome">
	    <h2>Welcome to AutoManage</h2>
	    <p>
	        Manage customers, vehicles, reservations, sales and reports
	        from one place.
	    </p>
	</section>

        <div class="card-grid">
            <a class="module-card" href="${pageContext.request.contextPath}/Views/customer-operations.jsp">
                <div class="module-icon">👥</div>
                <h3>Customer Management</h3>
                <p>Add, view, search, update and delete customer records.</p>
            </a>

            <a class="module-card" href="${pageContext.request.contextPath}/Views/vehicle-operations.jsp">
                <div class="module-icon">🚘</div>
                <h3>Vehicle Management</h3>
                <p>Manage vehicle inventory and vehicle information.</p>
            </a>

            <a class="module-card" href="${pageContext.request.contextPath}/Views/reservation-operations.jsp">
                <div class="module-icon">📅</div>
                <h3>Reservation Management</h3>
                <p>Create, search, view and cancel reservations.</p>
            </a>
             <a class="module-card" href="${pageContext.request.contextPath}/Views/vehicle-purchase.jsp">
                <div class="module-icon">📅</div>
                <h3>Purchase Vehicle</h3>
                <p>Buy the Vehicle	 </p>
            </a>

            <a class="module-card" href="${pageContext.request.contextPath}/Views/report-operations.jsp">
                <div class="module-icon">📊</div>
                <h3>Report Generation</h3>
                <p>View inventory, reservation and sales reports.</p>
            </a>
        </div>
    </main>
</div>
</body>
</html>
