<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Menu</title>
        <style>
            table,
            table tr {
                padding: 20px;
            }

            th {
                height: 80px;
                width: 160px;
            }

            td {
                height: 80px;
                width: 160px;
                text-align: center;
                vertical-align: middle;
            }

            body {
                margin: 20px;
            }
        </style>
    </head>
    <body>
        <h1 margin="10px">View Order History</h1>

       

        <div class="container">
            <form method = "post" action="viewordermenu.htm">
                <table>
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>Status</th>
                            <th>View Order</th>
                        </tr>
                    </thead>
                    <c:forEach var="order" items="${sessionScope.orders}">  
                        <tr>  
                            <td><c:out value="${order.getOrderId()}"/></td> 
                            <td><c:out value="${order.getStatus()}"/></td>  
                            <td><input type="radio" name="view-menu" value="${order.getOrderId()}" /></td>
                        </tr>  
                    </c:forEach>  
                </table>

                <div>
                    <input type = "submit" value="View Order Menu" />
                </div>
            </form>  
        </div>
    </body>
</html>