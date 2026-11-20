<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Reservation Purchase</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css">
</head>

<body>

<div class="form-container">

    <h2>Complete Reservation Purchase</h2>

    <p class="form-description">
        Pay the remaining balance for your reserved vehicle.
    </p>

    <!-- Step 1: Retrieve Reservation Details -->
    <form action="${pageContext.request.contextPath}/reservations/getReserveAmount"
          method="post">

        <div class="form-group">

            <label for="reservationId">Reservation ID</label>

            <input type="number"
                   id="reservationId"
                   name="reservationId"
                   min="1"
                   value="${reservationId}"
                   placeholder="Enter Reservation ID"
                   required>

        </div>

        <button class="btn btn-primary" type="submit">
            Get Reservation Details
        </button>

    </form>

    <!-- Step 2: Display Reservation Details -->
    <c:if test="${not empty reservationId}">

        <section class="panel">

            <h3>Vehicle Payment Details</h3>

            <div class="form-group">

                <label>Vehicle Price</label>

                <input type="text"
                       value="₹${vehiclePrice}"
                       readonly>

            </div>

            <div class="form-group">

                <label>Reserved Amount Already Paid</label>

                <input type="text"
                       value="₹${reservedAmount}"
                       readonly>

            </div>

            <div class="form-group">

                <label>Remaining Due Amount</label>

                <input type="text"
                       value="₹${remainingAmount}"
                       readonly>

            </div>

            <!-- Step 3: Submit Remaining Payment -->
            <form action="${pageContext.request.contextPath}/sales/reservation"
                  method="post">

                <input type="hidden"
                       name="reservationId"
                       value="${reservationId}">

                <div class="form-group">

                    <label for="amount">
                        Enter Remaining Payment Amount
                    </label>

                    <input type="number"
                           id="amount"
                           name="amount"
                           min="0.01"
                           step="0.01"
                           placeholder="Enter ₹${remainingAmount}"
                           required>

                </div>

                <div class="form-actions">

                    <button class="btn btn-primary" type="submit">
                        Complete Purchase
                    </button>

                    <a class="btn btn-secondary"
                       href="${pageContext.request.contextPath}/sales/all">
                        Cancel
                    </a>

                </div>

            </form>

        </section>

    </c:if>

    <c:if test="${not empty error}">
        <p class="alert-error">${error}</p>
    </c:if>

    <c:if test="${not empty message}">
        <p class="alert-success">${message}</p>
    </c:if>

</div>

</body>
</html>