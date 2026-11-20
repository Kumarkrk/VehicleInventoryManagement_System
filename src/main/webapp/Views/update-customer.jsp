
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="form-container">
    <h2>Update Customer</h2>
    <p class="form-description">Update the selected customer's information.</p>

    <form action="${pageContext.request.contextPath}/customers/update" method="post">
        <c:if test="${not empty error}">
    <div class="alert-danger">${error}</div>
</c:if>
        <input type="hidden" name="id" value="${customer.id}" readOnly>

        <div class="form-group">
            <label>Customer ID</label>
            <input type="text" value="${customer.id}" >
        </div>
        <div class="form-group">
            <label>Name</label>
            <input type="text" name="name" value="${customer.name}" >
        </div>
        <div class="form-group">
            <label>Address</label>
            <textarea name="address" rows="3" >${customer.address}</textarea>
        </div>
        <div class="form-group">
            <label>Mobile Number</label>
            <input type="tel" name="mobileNo" value="${customer.mobileNo}"
                   pattern="[0-9]{10}" maxlength="10" >
        </div>
        <div class="form-actions">
            <button class="btn btn-primary" type="submit">Update Customer</button>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Views/customer-operations.jsp">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
