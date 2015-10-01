<%-- 
    Document   : bussReg
    Created on : Jun 30, 2015, 6:10:21 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type= "text/javascript" src = "${pageContext.request.contextPath}/countries.js"></script>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css" />
        <title>Register Business</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="header"><h1>Register Your Business</h1></div>
            <%@include file="jspf/noLoginMenu.jspf"%>
            <div id="content">
                <h4>${flash}</h4>
                <p>To register your business, please fill out your business information.</p>
                <table>
                    <form method="POST" action="bussReg">
                        <tr><td>Business Name&nbsp;</td><td><input type="text" name="bname"></td></tr>
                        <tr><td>Type of Business&nbsp;</td><td><select name="type" size="1">
                                    <option value="bar">Bar</option>
                                    <option value="restaurant">Restaurant</option>
                                    <option value="club">Club</option>
                                </select></td></tr>
                        <tr><td>Street&nbsp;</td><td><input type="text" name="street"</td></tr>
                        <tr><td>City&nbsp;</td><td><input type="text" name="city"</td></tr>
                        <tr><td>Select State&nbsp;</td><td><select name="state" size="1">
                            <option value="AK">AK</option>
                            <option value="AL">AL</option>
                            <option value="AR">AR</option>
                            <option value="AZ">AZ</option>
                            <option value="CA">CA</option>
                            <option value="CO">CO</option>
                            <option value="CT">CT</option>
                            <option value="DC">DC</option>
                            <option value="DE">DE</option>
                            <option value="FL">FL</option>
                            <option value="GA">GA</option>
                            <option value="HI">HI</option>
                            <option value="IA">IA</option>
                            <option value="ID">ID</option>
                            <option value="IL">IL</option>
                            <option value="IN">IN</option>
                            <option value="KS">KS</option>
                            <option value="KY">KY</option>
                            <option value="LA">LA</option>
                            <option value="MA">MA</option>
                            <option value="MD">MD</option>
                            <option value="ME">ME</option>
                            <option value="MI">MI</option>
                            <option value="MN">MN</option>
                            <option value="MO">MO</option>
                            <option value="MS">MS</option>
                            <option value="MT">MT</option>
                            <option value="NC">NC</option>
                            <option value="ND">ND</option>
                            <option value="NE">NE</option>
                            <option value="NH">NH</option>
                            <option value="NJ">NJ</option>
                            <option value="NM">NM</option>
                            <option value="NV">NV</option>
                            <option value="NY">NY</option>
                            <option value="OH">OH</option>
                            <option value="OK">OK</option>
                            <option value="OR">OR</option>
                            <option value="PA">PA</option>
                            <option value="RI">RI</option>
                            <option value="SC">SC</option>
                            <option value="SD">SD</option>
                            <option value="TN">TN</option>
                            <option value="TX">TX</option>
                            <option value="UT">UT</option>
                            <option value="VA">VA</option>
                            <option value="VT">VT</option>
                            <option value="WA">WA</option>
                            <option value="WI">WI</option>
                            <option value="WV">WV</option>
                            <option value="WY">WY</option>
                        </select></td></tr>
                        <tr><td>Zip&nbsp;</td><td><input type="text" name="zip"/></td></tr>
                        <tr><td>Phone&nbsp;</td><td><input type="text" name="phone"/></td></tr>
                        <tr><td>Email&nbsp;</td><td><input type="email" name="email"/></td></tr>
                        <tr><td>Description&nbsp;</td><td><textarea rows="4" cols="50" name="description"></textarea></td></tr>
                        <tr><td>Username&nbsp;</td><td><input type="text" name="username"/></td></tr>
                        <tr><td>Password&nbsp;</td><td><input type="password" name="password"/></td></tr>
                        <tr><td>Confirm Password&nbsp;</td><td><input type="password" name="password2"/></td></tr>
                        <tr><td></td><td><input type="submit" value="Register"></td></tr>
                    </form>
                </table>
            </div>
        </div>
    </body>
</html>
