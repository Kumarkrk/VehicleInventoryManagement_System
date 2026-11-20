
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Reservation</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css">
</head>

<body>
<div class="app-shell">

    <%@ include file="navbar.jsp" %>

    <main class="main-content">

        <div class="topbar">
            <div>
                <h1>Add Reservation</h1>
                <p>Enter customer and vehicle details to reserve a vehicle.</p>
            </div>
        </div>

        <section class="panel">

            <form action="${pageContext.request.contextPath}/reservations/check"
                  method="post">

                <label>Customer ID</label>
                <input type="number" name="customerId" min="1" required>

                <label>Vehicle ID</label>
                <input type="number" name="vehicleId" min="1" required>

                <button type="submit">Check Reservation Amount</button>

            </form>

        </section>

        <%-- Display after controller retrieves the vehicle --%>
        <c:if test="${not empty vehicle}">
            <section class="panel">

                <h2>Reservation Payment Details</h2>

                <p>Vehicle: ${vehicle.brand} ${vehicle.model}</p>
                <p>Vehicle Price: ₹${vehicle.price}</p>
                <p>Minimum Reservation Amount (10%): ₹${reservationAmount}</p>

                <form action="${pageContext.request.contextPath}/reservations/add"
                      method="post">

                    <input type="hidden" name="customerId" value="${customerId}">
                    <input type="hidden" name="vehicleId" value="${vehicle.id}">

                    <label>Reservation Amount</label>
                    <input type="number" name="amount"
                           min="${reservationAmount}" max="${vehicle.price}"
                           step="0.01" required>

                    <button type="submit">Pay Reservation Amount</button>

                </form>

            </section>
        </c:if>

    </main>
</div>
</body>
</html>
