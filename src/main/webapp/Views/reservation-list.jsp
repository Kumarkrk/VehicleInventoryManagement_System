
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Reservation List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="app-shell">
    <%@ include file="navbar.jsp" %>
    <main class="main-content">
        <div class="topbar">
            <div>
                <h1>Reservations</h1>
                <p>Customer vehicle reservation records</p>
            </div>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/reservations/add">+ Add Reservation</a>
        </div>

        <c:if test="${not empty message}">
            <div class="alert-success">${message}</div>
        </c:if>

        <div class="panel">
            <div class="table-wrap">
                <table>
                    <thead>
                    <tr>
                        <th>Reservation ID</th>
                        <th>Customer ID</th>
                        <th>Customer Name</th>
                        <th>Vehicle ID</th>
                        <th>Vehicle</th>
                        <th>Amount</th>
                        <th>Date</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="reservation" items="${reservations}">
                        <tr>
                            <td>${reservation.id}</td>
                            <td>${reservation.customerId.id}</td>
                            <td>${reservation.customerId.name}</td>
                            <td>${reservation.vehicleId.id}</td>
                            <td>${reservation.vehicleId.brand} ${reservation.vehicleId.model}</td>
                            <td>${reservation.amount}</td>
                            <td>${reservation.reservationDate}</td>
                            <td><span class="status">${reservation.reserveStatus}</span></td>
                            <td>
                                <c:if test="${reservation.reserveStatus ne 'CANCELLED' and reservation.reserveStatus ne 'COMPLETED'}">
                                    <form action="${pageContext.request.contextPath}/reservations/cancel"
                                          method="post" style="display:inline"
                                          onsubmit="return confirm('Cancel this reservation?');">
                                        <input type="hidden" name="id" value="${reservation.id}">
                                        <button class="btn btn-danger btn-small" type="submit">Cancel</button>
                                    </form>
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    <c:if test="${empty reservations}">
                        <tr><td colspan="9" class="empty-message">No reservations found.</td></tr>
                    </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</div>
</body>
</html>
