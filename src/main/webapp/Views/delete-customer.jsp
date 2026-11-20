
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="form-container">
    <h2>Delete Customer</h2>
    <p class="form-description">Enter the ID of the customer to delete.</p>

    <form action="${pageContext.request.contextPath}/customers/delete" method="post"
          onsubmit="return confirm('Are you sure you want to delete this customer?');">
        <div class="form-group">
            <label>Customer ID</label>
            <input type="number" name="id" min="1" required>
        </div>
        <div class="form-actions">
            <button class="btn btn-danger" type="submit">Delete Customer</button>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/customers/operations">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>
