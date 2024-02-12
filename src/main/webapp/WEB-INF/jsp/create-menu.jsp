<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Menu</title> 
        <style>
            body {
                margin: 20px;
            }
            table {
                padding: 10px;
                margin: 10px;

            }
            table,
            table tr {
                padding: 20px;
            }
            .errors {
                padding-right: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Restaurant Order Management App</h1>
        <h2>Add New Menu</h2>
        <form:form modelAttribute="menu" method="post" >
            <table>
                <tr>
                    <td>
                        <span>Menu Name: </span>
                    </td>
                    <td>
                        <form:input path="menu_name" size="30" /> <font color="red"><form:errors path="menu_name" class="errors"/></font>
                </tr>
                
                <tr>
                    <td>
                        <span>Menu Type: </span>
                    </td>
                    <td>
                        <form:input path="menu_type" size="30" /><font color="red"><form:errors path="menu_type" class="errors"/></font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Price: </span>
                    </td>
                    <td>
                        <form:input path="menu_price" size="30" /> <font color="red"><form:errors path="menu_price" class="errors"/></font>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Add Menu" />
        </form:form>
       
    </body>
</html>