
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Customer</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="form-container">
    <h2>Search Customer</h2>
    <p class="form-description">Enter one or more details to find a customer.</p>

    <form action="${pageContext.request.contextPath}/customers/search" method="post">
        <div class="form-group">
            <label>Name</label>
            <input type="text" name="name" placeholder="Customer name">
        </div>
        <div class="form-group">
            <label>Address</label>
            <input type="text" name="address" placeholder="Customer address">
        </div>
        <div class="form-group">
            <label>Mobile Number</label>
            <input type="text" name="mobileNo" placeholder="Mobile number">
        </div>
        <div class="form-actions">
            <button class="btn btn-primary" type="submit">Search</button>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/customers/all">View All</a>
        </div>
       <script>
document.querySelector("form").addEventListener("submit", function() {
    const error = document.querySelector(".alert-danger");

    if (error) {
        error.remove();
    }
});
</script>
    </form>
</div>
</body>
</html>
