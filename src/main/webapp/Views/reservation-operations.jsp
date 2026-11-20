<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Reservation Management</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css">
</head>

<body>

<div class="app-shell">

    <%@ include file="navbar.jsp" %>

    <main class="main-content">

        <div class="topbar">
            <div>
                <h1>Reservation Management</h1>
                <p>Manage customer vehicle reservations and purchases.</p>
            </div>
        </div>

        <div class="card-grid">

            <!-- Add Reservation -->
            <a class="module-card"
               href="${pageContext.request.contextPath}/reservations/add">

                <div class="module-icon">➕</div>
                <h3>Add Reservation</h3>
                <p>Create a reservation for a customer and vehicle.</p>

            </a>

            <!-- View Reservations -->
            <a class="module-card"
               href="${pageContext.request.contextPath}/reservations/all">

                <div class="module-icon">📋</div>
                <h3>View Reservations</h3>
                <p>Display all reservation records.</p>

            </a>

            <!-- Search Reservation -->
            <a class="module-card"
               href="${pageContext.request.contextPath}/Views/search-reservation.jsp">

                <div class="module-icon">🔎</div>
                <h3>Search Reservation</h3>
                <p>Search reservation records.</p>

            </a>

            <!-- Cancel Reservation -->
            <a class="module-card"
               href="${pageContext.request.contextPath}/Views/cancel-reservation.jsp">

                <div class="module-icon">✖️</div>
                <h3>Cancel Reservation</h3>
                <p>Cancel an existing reservation.</p>

            </a>

            <!-- Reservation Report -->
            <a class="module-card"
               href="${pageContext.request.contextPath}/reservations/report">

                <div class="module-icon">📊</div>
                <h3>Reservation Report</h3>
                <p>View reservation status statistics.</p>

            </a>

            <!-- Buy Reserved Vehicle -->
            <a class="module-card"
               href="${pageContext.request.contextPath}/sales/reservation">

                <div class="module-icon">🚘</div>
                <h3>Buy Reserved Vehicle</h3>
                <p>Complete the purchase by paying the remaining due amount.</p>

            </a>

        </div>

    </main>

</div>

</body>
</html>