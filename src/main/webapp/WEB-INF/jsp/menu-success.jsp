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
        <h2>Logged in as: ${sessionScope.res.getRes_name()}</h3>
        <div>
            <h3>Menu Added Successfully!</h3>
        </div>
        
    </body>
</html>