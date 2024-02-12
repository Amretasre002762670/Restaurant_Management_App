<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
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
            .error {
                padding-right: 10px;
            }
        </style>
    </head>
    <body>
        <h1>Restaurant Order Management App</h1>
        <h2>Create Customer</h2>
        <form:form modelAttribute="customer" method="post" >
            <table>
                <tr>
                    <td>
                        <span>Customer Name: </span>
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
                </tr>
                
                <tr>
                    <td>
                        <span>Phone Number: </span>
                    </td>
                    <td>
                        <form:input path="customer_phoneNum" size="30" /> <font color="red"><form:errors path="customer_phoneNum" class="errors"/></font>
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <span>Street Name: </span>
                    </td>
                    <td>
                        <form:input path="address.streetName" size="30" /> <font color="red"><form:errors path="address.streetName" class="errors"/></font>
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <span>Street Number: </span>
                    </td>
                    <td>
                        <form:input path="address.streetNum" size="30" /> <font color="red"><form:errors path="address.streetNum" class="errors"/></font>
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <span>City: </span>
                    </td>
                    <td>
                        <form:input path="address.city" size="30" /> <font color="red"><form:errors path="address.city" class="errors"/></font>
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <span>state: </span>
                    </td>
                    <td>
                        <form:input path="address.state" size="30" /> <font color="red"><form:errors path="address.state" class="errors"/></font>
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <span>Zipcode: </span>
                    </td>
                    <td>
                        <form:input path="address.zipcode" size="30" /> <font color="red"><form:errors path="address.zipcode" class="errors"/></font>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Add Customer" />
        </form:form>
        <div>
            <span><p>Already a User?</p> <a href="logincustomer.htm" >Log In as Customer</a></span>
        </div>
        <div>
            <span><p>Restaurant Admin?</p> <a href="loginrestaurant.htm" >Log In As Restaurant Admin</a></span>
        </div>
        <div>
            <span><p>New Restaurant Admin?</p> <a href="createrestaurant.htm" >Create Restaurant Admin</a></span>
        </div>
    </body>
</html>
