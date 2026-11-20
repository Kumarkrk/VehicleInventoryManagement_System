
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cancel Reservation</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Views/css/style.css">
</head>
<body>
<div class="form-container">
    <h2>Cancel Reservation</h2>
    <p class="form-description">Enter the reservation ID to cancel it.</p>

    <form action="${pageContext.request.contextPath}/reservations/cancel"
          method="post"
          onsubmit="return confirm('Are you sure you want to cancel this reservation?');">
        <div class="form-group">
            <label>Reservation ID</label>
            <input type="number" name="id" min="1" required>
        </div>
        <div class="form-actions">
            <button class="btn btn-danger" type="submit">Cancel Reservation</button>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/reservations/all">Back</a>
        </div>
    </form>
</div>
</body>
</html>
