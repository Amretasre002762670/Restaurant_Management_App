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
        </style>
    </head>
    <body>
        <h1>Restaurant Orders Management App</h1>
        <h2>Login Restaurant Admin</h2>
    

        <form method="post" action="searchrestaurant.htm">
            <table>

                <tr>
                    <td>
                        <span>Search: </span>
                    </td>
                    <td>
                        <input name="search-text" type="text" size="30" /> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="search-type" value="res-name" /> 
                        <label>Restaurant Name</label>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Search Restaurant" />
        </form>
        
    </body>
</html>
