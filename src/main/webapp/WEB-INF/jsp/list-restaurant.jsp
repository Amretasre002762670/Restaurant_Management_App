<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Restaurants</title>
        <style>
            table,
            table tr {
                border: 1px solid #cccccc;
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

            .button {
                margin: 20px;
            }
        </style>
    </head>
    <body>
        <h2>Search Restaurants</h2>

        
        <div class="container">
            <form method="post" action="listmenu.htm">
                <h4>Total results: <c:out value="${sessionScope['res-list'].size()}" /></h4>
                <table>
                    <thead>
                        <tr>
                            <th style="width:100px">Restaurant Name</th>
                            <th style="width:100px">Restuarant Address </th>
                            <th style="width:100px">Restaurant Street Address</th>
                            <th style="width:100px">Restaurant Number</th>
                            <th style="width:100px">Choose to view menu</th>
                        </tr>
                    </thead>
                    <c:forEach var="res" items="${sessionScope['res-list']}">  
                        <tr>  
                            <td style="width:100px"><c:out value="${res.getRes_name()}"/></td>  
                            <td style="width:100px"><c:out value="${res.getAddress().getCity()}"/></td>  
                            <td style="width:100px"><c:out value="${res.getAddress().getStreetName()}"/></td>  
                            <td style="width:100px"><c:out value="${res.getRes_phoneNum()}"/></td>  
                            <td style="width:100px">
                                <input type="radio" name="res_id" value="${res.getRes_id()}" />
                                
                            </td>
                        </tr>  
                    </c:forEach>  
                </table>
                <div class="button">
                    <input type="submit" value="Look Menu" />
                </div>
               
            </form>
            
        </div>
    

    </body>
</html>
