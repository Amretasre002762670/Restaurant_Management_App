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

            body {
                margin: 20px;
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
            .status-change-container {
                padding: 20px;
            }
            .status-change-buttons {
                padding: 20px;
            }
            .status-change-submit {
                padding: 20px;
            }
        </style>
    </head>
    <body>
        <h1 margin="10px">View Menu</h1>
        <div class="container">

            <h4>Total Items: <c:out value="${requestScope['menuList'].size()}" /></h4>
            <form method="post" action="changestatus.htm" >
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
                    <c:forEach var="menu" items="${requestScope['menuList']}">  
                        <tr>  
                            <td><c:out value="${menu.getMenu_name()}"/></td>  
                            <td><c:out value="${menu.getMenu_type()}"/></td>  
                            <td><c:out value="${menu.getMenu_price()}"/></td>  
                        </tr>  
                    </c:forEach>  
                </table>
                <div class="status-change-container">
                    <h5>Change Order Status</h5>
                    <div>
                        Current Status of the order is  <h4><c:out value="${sessionScope.currentStatus}"/></h4>
                    </div>
                    <div class="status-change-buttons">
                        <span>
                            <input type="radio" name="order-status" value="preparing food" />
                            <label>Preparing food</label>
                        </span>

                        <span>
                            <input type="radio" name="order-status" value="food ready" />
                            <label>Food Ready</label>
                        </span>

                    </div>

                    <div class="status-change-submit">
                        <input type="submit" value="Change Status" />
                    </div>
                </div>
            </form>
            <div>
                <a href="vieworder.htm">View Orders Page</a>
            </div>
            
            
        </div>

    </body>
</html>
