<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
        <style>
            body {
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <h3>Logged in as: ${sessionScope.customer.getCustomer_name()}</h3>
        <div>
            <h4><a href="${pageContext.request.contextPath}/logout" target="_top">Logout</a>
            </h4>
        </div>
        <a href="/searchrestaurant.htm" target="contents">Search Restaurant</a><br>
        <a href="/orderhistory.htm" target="contents">Order History</a><br>
       
    </body>
</html>