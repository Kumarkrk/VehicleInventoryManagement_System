<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Vehicle Inventory Report</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>

<div class="app-shell">
    <%@ include file="navbar.jsp" %>

    <main class="main-content">
        <div class="topbar">
            <div>
                <h1>Vehicle Inventory Report</h1>
                <p>Summary of vehicle inventory status</p>
            </div>
        </div>

        <div class="panel">
            <h3>Vehicle Inventory Statistics</h3>

            <div class="table-wrap">
                <table>
                    <thead>
                        <tr>
                            <th>Vehicle Category</th>
                            <th>Total Count</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td>Total Vehicles</td>
                            <td>${vehicles['Total Vehicles']}</td>
                        </tr>
                        <tr>
                            <td>Available Vehicles</td>
                            <td>${vehicles['Available Vehicles']}</td>
                        </tr>
                        <tr>
                            <td>Reserved Vehicles</td>
                            <td>${vehicles['Reserved Vehicles']}</td>
                        </tr>
                        <tr>
                            <td>Sold Vehicles</td>
                            <td>${vehicles['Sold Vehicles']}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </main>
</div>

</body>
</html>