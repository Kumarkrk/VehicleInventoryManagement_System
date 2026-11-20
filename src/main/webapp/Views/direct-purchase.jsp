
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Direct Purchase</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css">
</head>

<body>

<div class="form-container">

    <h2>Direct Vehicle Purchase</h2>

    <p class="form-description">
        Enter customer and vehicle details to purchase an available vehicle.
    </p>

    <!-- Get Vehicle Amount -->
    <form action="${pageContext.request.contextPath}/sales/getVehicleAmount"
          method="get">

        <div class="form-group">

            <label for="vehicleId">Vehicle ID</label>

            <input type="number"
                   id="vehicleId"
                   name="vehicleId"
                   min="1"
                   value="${vehicleId}"
                   placeholder="Enter Vehicle ID"
                   required>

        </div>

        <button class="btn btn-primary" type="submit">
            Get Vehicle Amount
        </button>

    </form>

    <!-- Complete Purchase -->
    <form action="${pageContext.request.contextPath}/sales/direct"
          method="post">

        <div class="form-group">

            <label for="customerId">Customer ID</label>

            <input type="number"
                   id="customerId"
                   name="customerId"
                   min="1"
                   placeholder="Enter Customer ID"
                   required>

        </div>

        <div class="form-group">

            <label for="purchaseVehicleId">Vehicle ID</label>

            <input type="number"
                   id="purchaseVehicleId"
                   name="vehicleId"
                   min="1"
                   value="${vehicleId}"
                   placeholder="Enter Vehicle ID"
                   required>

        </div>

        <div class="form-group">

            <label for="amount">Purchase Amount</label>

            <input type="number"
                   id="amount"
                   name="amount"
                   min="0.01"
                   step="0.01"
                   value="${vehicleAmount}"
                   placeholder="Get vehicle amount first"
                   required>

        </div>

        <div class="form-actions">

            <button class="btn btn-primary" type="submit"
                    <c:if test="${empty vehicleAmount}">disabled</c:if>>
                Complete Purchase
            </button>

            <a class="btn btn-secondary"
               href="${pageContext.request.contextPath}/sales/all">
                Cancel
            </a>

        </div>

    </form>

    <c:if test="${not empty error}">
        <p class="alert-error">${error}</p>
    </c:if>

</div>

</body>
</html>
