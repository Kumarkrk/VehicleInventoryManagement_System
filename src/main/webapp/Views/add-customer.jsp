
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Customer</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/Views/css/style.css?v=2">
</head>

<body >

    <div class="form-container">

        <h2>Add New Customer</h2>

        <p class="form-description">
            Enter the customer's information.
        </p>

        <c:if test="${not empty errorMessage}">
            <div class="alert-error">
                <c:out value="${errorMessage}"/>
            </div>
        </c:if>

        <form action="${pageContext.request.contextPath}/customers/add"
              method="post">

            <div class="form-group">
                <label>Customer Name</label>
                <input type="text" name="name"
                       maxlength="100" required>
            </div>

            <div class="form-group">
                <label>Address</label>
                <textarea name="address" rows="3" required></textarea>
            </div>

            <div class="form-group">
                <label>Mobile Number</label>
                <input type="tel" name="mobileNo"
                       pattern="[0-9]{10}"
                       maxlength="10"
                       placeholder="10-digit mobile number"
                       required>
            </div>

            <div class="form-actions">
                <button class="btn btn-primary" type="submit">
                    Save Customer
                </button>

                <a class="btn btn-secondary"
                   href="${pageContext.request.contextPath}/Views/customer-operations.jsp">
                    Cancel
                </a>
            </div>

        </form>

    </div>

</body>
</html>
