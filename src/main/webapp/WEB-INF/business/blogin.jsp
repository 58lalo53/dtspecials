<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css" />
        <title>Business Login</title>
    </head>
    <body>
        <div id="wrapper">
            <div>
                <h1>Business Login In</h1>
            </div>
            <%@include file="jspf/noLoginMenu.jspf" %>
            <div id="content">
                <div class="flash">${flash}</div>
                <table>
                <form method="post" action="blogin">
                    <tr><td>Username: </td><td><input type="text" name="username"></td><td></td></tr>
                    <tr><td>Password: </td><td><input type="password" name="password"></td><td></td></tr>
                    <tr><td></td><td><input type="submit" value="Login"></td></tr>  
                </form>
                </table>
                <a href="forgot">Forgot Password</a> | <a href="bussReg">Register Business</a>
            </div>
        </div>
    </body>
</html>