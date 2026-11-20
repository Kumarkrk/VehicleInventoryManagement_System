<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sales Records</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css">
</head>

<body>

<div class="app-shell">

    <%@ include file="navbar.jsp" %>

    <main class="main-content">

        <div class="topbar">

            <div>
                <h1>Sales Records</h1>
                <p>All recorded vehicle sales.</p>
            </div>

            <a class="btn btn-primary"
               href="${pageContext.request.contextPath}/sales/direct">
                + Direct Purchase
            </a>

        </div>

        <!-- Success Message -->
        <c:if test="${not empty message}">
            <div class="alert-success">
                ${message}
            </div>
        </c:if>

        <!-- Error Message -->
        <c:if test="${not empty error}">
            <div class="alert-error">
                ${error}
            </div>
        </c:if>

        <!-- Search Sales -->
        <div class="panel">

            <h3>Search Sales</h3>

            <form action="${pageContext.request.contextPath}/sales/search"
                  method="get">

                <div class="form-group">

                    <label for="saleId">Sale ID</label>

                    <input type="number"
                           id="saleId"
                           name="saleId"
                           min="1"
                           placeholder="Enter Sale ID">

                </div>

                <div class="form-group">

                    <label for="customerId">Customer ID</label>

                    <input type="number"
                           id="customerId"
                           name="customerId"
                           min="1"
                           placeholder="Enter Customer ID">

                </div>

                <div class="form-group">

                    <label for="vehicleId">Vehicle ID</label>

                    <input type="number"
                           id="vehicleId"
                           name="vehicleId"
                           min="1"
                           placeholder="Enter Vehicle ID">

                </div>

                <div class="form-actions">

                    <button class="btn btn-primary" type="submit">
                        Search
                    </button>

                    <a class="btn btn-secondary"
                       href="${pageContext.request.contextPath}/sales/all">
                        Clear
                    </a>

                </div>

            </form>

        </div>

        <!-- Sales Table -->
        <div class="panel">

            <h3>Sales Information</h3>

            <div class="table-wrap">

                <table>

                    <thead>

                    <tr>
                        <th>Sale ID</th>
                        <th>Customer ID</th>
                        <th>Customer</th>
                        <th>Vehicle ID</th>
                        <th>Vehicle</th>
                        <th>Sale Date</th>
                        <th>Sale Status</th>
                        <th>Payment Status</th>
                    </tr>

                    </thead>

                    <tbody>

                    <c:forEach var="sale" items="${sales}">

                        <tr>

                            <td>${sale.id}</td>

                            <td>${sale.customerId.id}</td>

                            <td>${sale.customerId.name}</td>

                            <td>${sale.vehicleId.id}</td>

                            <td>
                                ${sale.vehicleId.brand}
                                ${sale.vehicleId.model}
                            </td>

                            <td>${sale.saleDate}</td>

                            <td>
                                <span class="status">
                                    ${sale.saleStatus}
                                </span>
                            </td>

                            <td>
                                <span class="status">
                                    ${sale.paymentStatus}
                                </span>
                            </td>

                        </tr>

                    </c:forEach>

                    <c:if test="${empty sales}">

                        <tr>
                            <td colspan="8" class="empty-message">
                                No sales records found.
                            </td>
                        </tr>

                    </c:if>

                    </tbody>

                </table>

            </div>

        </div>

    </main>

</div>

</body>
</html>