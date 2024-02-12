<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login User</title>
        <style>
            body {
                margin: 20px;
            } 
            .errors {
                padding-right: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Restaurant Orders Management App</h1>
        <h2>Login As Customer</h2>
        <form:form modelAttribute="customer" method="post">
            <table>
                <tr>
                    <td>
                        <span>User Name: </span>
                    </td>
                    <td>
                        <form:input path="customer_name" size="30" /> <font color="red"><form:errors path="customer_name" class="errors"/></font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span>Password: </span>
                    </td>
                    <td>
                        <form:password path="password" size="30" /> <font color="red"><form:errors path="password" class="errors"/></font>
                    </td>
                   
            </table>
            <input type="submit" value="Login" />
        </form:form>
        <div>
            <span><p>New Customer?</p> <a href="createcustomer.htm">Create Account</a></span>
        </div>
        <div>
            <span><p>Restaurant Admin?</p> <a href="loginrestaurant.htm" >Log In As Restaurant Admin</a></span>
        </div>
        <div>
            <span><p>New Restaurant Admin?</p> <a href="createrestaurant.htm" >Create Restaurant Admin</a></span>
        </div>
    </body>
</html>
