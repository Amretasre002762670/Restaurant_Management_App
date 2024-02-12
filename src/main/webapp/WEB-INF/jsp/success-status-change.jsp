<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant</title>
        <style>
             body {
                margin: 20px;
            }
        </style>
    </head>
    <body>
        <h3>Logged in as: ${sessionScope.res.getRes_name()}</h3>
        <h2>Order Status Updated Succesfully!</h2>
        <div>
            <a href="vieworder.htm">View Menu Page</a>
        </div>
    </body>
</html>