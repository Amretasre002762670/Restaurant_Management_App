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
            h4 {
                text-align: center;
            }
            .order-button {
                text-align: center;
            }
            body {
                margin: 20px;
            }
        </style>
    </head>
    <body>
        <h1 margin="10px">View Cart</h1>
        <div class="container">
            <h4>From: <c:out value="${sessionScope.res.getRes_name()}" /></h4>
            <h4>Located at: <c:out value="${sessionScope.res.getRes_name()}" /></h4>
            <h4>Total Items in Cart: <c:out value="${sessionScope.cart.size()}" /></h4>

          
            <form method="post" action="viewcart.htm">
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>
                                Type
                            </th>
                            <th>Price</th>
                            
                        </tr>
                    </thead>
                    <c:forEach var="menu" items="${sessionScope['cart']}">  
                        <tr>  
                            <td><c:out value="${menu.getMenu_name()}"/></td>  
                            <td><c:out value="${menu.getMenu_type()}"/></td>  
                            <td><c:out value="${menu.getMenu_price()}"/></td>  
                            
                        </tr>  
                    </c:forEach>  
                </table>
                <div>
                    <h4>Total Price: <c:out value="${requestScope.total}" /></h4>
                </div>
                <div>
                    <input type="submit" value="Place Order" class="order-button"/>
                </div>
            </form>
            
        </div>

    </body>
</html>
