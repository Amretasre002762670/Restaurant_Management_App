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
        <h1 margin="10px">View Menu</h1>
        <div class="container">
            <h4>Total results: <c:out value="${sessionScope.menuList.size()}" /></h4>
            

            <form method="post" action="listcart.htm">
                <table>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>
                                Type
                            </th>
                            <th>Price</th>
                            <th>Add To Cart</th>
                        </tr>
                    </thead>
                    <c:forEach var="menu" items="${sessionScope['menuList']}">  
                        <tr>  
                            <td><c:out value="${menu.getMenu_name()}"/></td>  
                            <td><c:out value="${menu.getMenu_type()}"/></td>  
                            <td><c:out value="${menu.getMenu_price()}"/></td>  
                            <td><input type="checkbox" name="cart_items" value="${menu.getMenu_name()}" /></td>
                        </tr>  
                    </c:forEach>  
                </table>
                <div>
                    <input type="submit" value="Open Cart" />
                </div>
            </form>
            
        </div>

    </body>
</html>
