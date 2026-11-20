<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Buy the Vehicle</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css">
</head>

<body class="form-bg-page bg-purchase-vehicle">

<div class="app-shell">

    <%@ include file="navbar.jsp" %>

    <main class="main-content">

        <div class="topbar">
            <div>
                <h1>Buy the Vehicle</h1>
                <p>Select your preferred purchase method.</p>
            </div>
        </div>

        <div class="card-grid">

            <a class="module-card"
               href="${pageContext.request.contextPath}/Views/direct-purchase-operations.jsp">

                <div class="module-icon">➕</div>
                <h3>Purchase The Vehicle Directly Without Reservation  </h3>
                <p>Purchase an available vehicle directly.</p>

            </a>

            <a class="module-card"
               href="${pageContext.request.contextPath}/Views/reservation-operations.jsp">

                <div class="module-icon">📋</div>
                <h3>Purchase The Reserved Vehicle </h3>
                <p>Complete the purchase of a reserved vehicle.</p>

            </a>

        </div>

    </main>

</div>

</body>
</html>