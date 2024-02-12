<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant</title>
        <style>
            body {
                margin: 10px;
            }
        </style>
    </head>
    <body>
        <h3>Logged in as: ${sessionScope.res.getRes_name()}</h3>
        <div>
            <h4><a href="${pageContext.request.contextPath}/logout" target="_top">Logout</a>
            </h4>
        </div>
        
        <a href="viewmenu.htm" target="contents">View Menu</a><br>
        <a href="addmenu.htm" target="contents">Add a New Menu</a><br>
        <a href="vieworder.htm" target="contents">View Orders</a><br>
        
       
    </body>
</html>