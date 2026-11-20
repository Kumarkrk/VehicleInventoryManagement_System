
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Customer Management</title>
    <link rel="stylesheet"
      href="${pageContext.request.contextPath}/Views/css/style.css?v=11">
</head>

<body class="customers-page">

<div class="app-shell">

    <%@ include file="navbar.jsp" %>

    <main class="main-content">

        <div class="customers-header">
            <div>
                <p class="customers-eyebrow">CUSTOMER MANAGEMENT</p>
                <h1>Customers</h1>
                <p class="customers-subtitle">
                    View and manage your registered customers.
                </p>
            </div>

            <div class="customers-header-actions">
                <a class="btn btn-primary"
                   href="${pageContext.request.contextPath}/customers/addall">
                    + Add Customer
                </a>

                <a class="btn btn-secondary"
                   href="${pageContext.request.contextPath}/Views/customer-operations.jsp">
                    Back to Operations
                </a>
            </div>
        </div>

        <c:if test="${not empty message}">
            <div class="alert-success">${message}</div>
        </c:if>

        <section class="customers-overview">
            <div class="overview-icon">♙</div>
            <div>
                <p class="overview-label">REGISTERED CUSTOMERS</p>
                <h2><c:out value="${customers.size()}"/></h2>
                <p class="overview-description">
                    Total customer records in your system
                </p>
            </div>
        </section>

        <section class="customers-card">

            <div class="customers-card-heading">
                <div>
                    <h2>Customer Records</h2>
                    <p>Customer details and available actions</p>
                </div>
            </div>

            <div class="table-wrap">
                <table class="customers-table">
                    <thead>
                        <tr>
                            <th>Customer ID</th>
                            <th>Customer Name</th>
                            <th>Address</th>
                            <th>Mobile Number</th>
                            <th>Actions</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="customer" items="${customers}">
                            <tr>
                                <td>
                                    <span class="customer-id">
                                        #${customer.id}
                                    </span>
                                </td>

                                <td class="customer-name">
                                    <c:out value="${customer.name}"/>
                                </td>

                                <td>
                                    <c:out value="${customer.address}"/>
                                </td>

                                <td>
                                    <c:out value="${customer.mobileNo}"/>
                                </td>

                                <td>
                                    <div class="customer-actions">

                                        <a class="action-edit"
                                           href="${pageContext.request.contextPath}/customers/edit?id=${customer.id}">
                                            Edit
                                        </a>

                                        <form action="${pageContext.request.contextPath}/customers/delete"
                                              method="post"
                                              onsubmit="return confirm('Delete this customer?');">

                                            <input type="hidden"
                                                   name="id"
                                                   value="${customer.id}">

                                            <button class="action-delete"
                                                    type="submit">
                                                Delete
                                            </button>
                                        </form>

                                    </div>
                                </td>
                            </tr>
                        </c:forEach>

                        <c:if test="${empty customers}">
                            <tr>
                                <td colspan="5" class="customers-empty">
                                    No customer records found.
                                </td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>
            </div>

        </section>

    </main>
</div>

</body>
</html>
