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
        <h2>View Order History</h2>

        <div class="container">
                <table>
                    <thead>
                        <tr>
                            <th>Order ID</th>
                            <th>
                                Restaurant Name
                            </th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <c:forEach var="order" items="${sessionScope.orders}">  
                        <tr>  
                            <td><c:out value="${order.getOrderId()}"/></td> 
                            <td><c:out value="${order.getRestaurant().getRes_name()}"/></td>  
                            <td><c:out value="${order.getStatus()}"/></td>  
                            
                        </tr>  
                    </c:forEach>  
                </table>
        </div>
    </body>
</html>