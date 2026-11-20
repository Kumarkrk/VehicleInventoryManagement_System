<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sales Report</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>

<div class="app-shell">
    <%@ include file="navbar.jsp" %>

    <main class="main-content">
        <div class="topbar">
            <div>
                <h1>Sales Report</h1>
                <p>Summary of sales activity.</p>
            </div>
        </div>

        <div class="panel">
            <h3>Sales Statistics</h3>

            <div class="table-wrap">
                <table>
                    <thead>
                        <tr>
                            <th>Sales Category</th>
                            <th>Total</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td>Total Sales</td>
                            <td>${report['Total Sales']}</td>
                        </tr>
                        <tr>
                            <td>Completed Sales</td>
                            <td>${report['Completed Sales']}</td>
                        </tr>
                        <tr>
                            <td>Total Sales Value</td>
                            <td>₹${report['Total Sales Value']}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

    </main>
</div>

</body>
</html>