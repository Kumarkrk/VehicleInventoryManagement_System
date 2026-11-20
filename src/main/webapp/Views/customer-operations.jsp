
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="app-shell">
    <%@ include file="navbar.jsp" %>
    <main class="main-content">
        <div class="topbar">
            <div>
                <h1>Customer Management</h1>
                <p>Manage customer records and reservation history.</p>
            </div>
        </div>

        <div class="card-grid">
            <a class="module-card" href="${pageContext.request.contextPath}/customers/addall">
                <div class="module-icon">➕</div>
                <h3>Add Customer</h3>
                <p>Register a new customer.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/customers/all">
                <div class="module-icon">📋</div>
                <h3>View Customers</h3>
                <p>Display all registered customers.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/Views/search-customer.jsp">
                <div class="module-icon">🔎</div>
                <h3>Search Customer</h3>
                <p>Find a customer by name, address or mobile number.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/Views/update-customer.jsp">
                <div class="module-icon">✏️</div>
                <h3>Update Customer</h3>
                <p>Select a customer from the list to edit details.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/Views/delete-customer.jsp">
                <div class="module-icon">🗑️</div>
                <h3>Delete Customer</h3>
                <p>Delete a customer using the customer ID.</p>
            </a>
            <a class="module-card" href="${pageContext.request.contextPath}/Views/reservation-list.jsp">
                <div class="module-icon">🕘</div>
                <h3>Reservation History</h3>
                <p>View reservation records.</p>
            </a>
        </div>
    </main>
</div>
</body>
</html>
