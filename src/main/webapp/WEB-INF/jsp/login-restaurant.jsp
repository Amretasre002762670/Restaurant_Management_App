<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            body {
                margin: 20px;
            }
            .errors{
                padding: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Restaurant Orders Management App</h1>
        <h2>Login Restaurant Admin</h2>
        <form:form modelAttribute="restaurant" method="post">
            <table>
                <tr>
                    <td>
                        <span>Restaurant Name: </span>
                    </td>
                    <td>
                        <form:input path="res_name" size="30" /> <font color="red"><form:errors path="res_name" class="errors"/></font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Password: </span>
                    </td>
                    <td>
                        <form:password path="password" size="30" />  <font color="red"><form:errors path="password" class="errors"/></font>
                    </td>
                   
            </table>
            <input type="submit" value="Login" />
        </form:form>
        
        <div>
            <span><p>New Restaurant Admin?</p> <a href="createrestaurant.htm" >New Restaurant Admin</a></span>
        </div>
        <div>
            <span><p>New Customer?</p> <a href="createcustomer.htm" >New Customer</a></span>
        </div>
        <div>
            <span><p>Already a Customer?</p> <a href="logincustomer.htm" >Log In As Customer</a></span>
        </div>
    </body>
</html>
