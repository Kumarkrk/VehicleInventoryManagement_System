
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="sidebar">
    <div class="brand">VehicleInventory Management System</div>

    <div class="nav-heading">Main</div>
    <a class="nav-link" href="${pageContext.request.contextPath}/Views/dashboard.jsp">
        Dashboard
    </a>

    <div class="nav-heading">Management</div>
    <a class="nav-link"
       href="${pageContext.request.contextPath}/Views/customer-operations.jsp">
        Customer Management
    </a>
    <a class="nav-link"
       href="${pageContext.request.contextPath}/Views/vehicle-operations.jsp">
        Vehicle Management
    </a>
    <a class="nav-link"
       href="${pageContext.request.contextPath}/Views/vehicle-purchase.jsp">
        Purchase The Vehicle
    </a>
    <a class="nav-link"
       href="${pageContext.request.contextPath}/Views/report-operations.jsp">
        Report Generation
    </a>
</div>
