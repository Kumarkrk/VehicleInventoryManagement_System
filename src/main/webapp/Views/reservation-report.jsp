
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Reservation Report</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css">
</head>

<body>

<div class="app-shell">

    <%@ include file="navbar.jsp" %>

    <main class="main-content">

        <div class="topbar">
            <div>
                <h1>Reservation Report</h1>
                <p>Reservation status summary</p>
            </div>
        </div>

        <div class="panel">

            <h3>Reservation Statistics</h3>

            <div class="table-wrap">

                <table>

                    <thead>
                        <tr>
                            <th>Reservation Category</th>
                            <th>Total Count</th>
                        </tr>
                    </thead>

                    <tbody>

                        <tr>
                            <td>Total Reservations</td>
                            <td>${report['Total Reservations']}</td>
                        </tr>

                        <tr>
                            <td>Confirmed Reservations</td>
                            <td>${report['Confirmed Reservations']}</td>
                        </tr>

                        <tr>
                            <td>Cancelled Reservations</td>
                            <td>${report['Cancelled Reservations']}</td>
                        </tr>

                        <tr>
                            <td>Completed Reservations</td>
                            <td>${report['Completed Reservations']}</td>
                        </tr>

                    </tbody>

                </table>

            </div>

        </div>

    </main>

</div>

</body>
</html>
