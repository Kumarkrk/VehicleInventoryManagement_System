
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Direct Purchase Operations</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css">
</head>

<body>
<div class="app-shell">

    <%@ include file="navbar.jsp" %>

    <main class="main-content">

        <div class="topbar">
            <div>
                <h1>Direct Purchase Operations</h1>
                <p>Purchase an available vehicle without a reservation.</p>
            </div>
        </div>

        <div class="card-grid">

            <a class="module-card"
               href="${pageContext.request.contextPath}/Views/direct-purchase.jsp">

                <div class="module-icon">🚘</div>
                <h3>Buy Vehicle Directly</h3>
                <p>Enter customer and vehicle IDs, view the full vehicle price and complete the purchase.</p>

            </a>

        </div>

    </main>
</div>
</body>
</html>
