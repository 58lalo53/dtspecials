<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css" />
        <title>Register</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <h1>Register</h1>
            </div>
            <%@include file="jspf/noLoginMenu.jspf"%>
            <div id="content">
                ${flash}
                <table>
                    <form method="POST" action="register">
                        <tr><td>First Name&nbsp;</td><td><input type="text" name="fname"></td></tr>
                        <tr><td>Last Name&nbsp;</td><td><input type="text" name="lname"></td></tr>
                        <tr><td>Email&nbsp;</td><td><input type="email" name="email"></td></tr>
                        <tr><td>Phone&nbsp;</td><td><input type="text" name="phone"></td></tr>
                        <tr><td>Username&nbsp;</td><td><input type="text" name="username"></td></tr>
                        <tr><td>Password&nbsp;</td><td><input type="password" name="password"></td></tr>
                        <tr><td>Confirm Password&nbsp;</td><td><input type="password" name="password2"></td></tr>
                        <tr><td></td><td><input type="submit"></td></tr>
                    </form>
                </table>
            </div>
        </div>
    </body>
</html>
