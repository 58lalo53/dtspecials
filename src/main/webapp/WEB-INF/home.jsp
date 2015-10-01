
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles.css" />
        <title>Welcome</title>
    </head>
    <body>
        <div id="wrapper">
            <div>
                <h1>Welcome to DownTown Specials</h1>
            </div>
            
                
                <c:choose>
                <c:when test="${sessionScope.user.username == null}">
                        
                    <%@include file="jspf/noLoginMenu.jspf" %>
                </c:when>
                    <c:when test="${sessionScope.buss.username != null}">
                        <%@include file="jspf/bussMenu.jspf" %>
                    </c:when>
                <c:otherwise>
                    <%@include file="jspf/loginMenu.jspf" %>
                </c:otherwise>
                </c:choose>
            <div id="content">
                <h3>Welcome <c:out value="${sessionScope.user.toString()}"/></h3>
            </div>
        </div>
        
    </body>
</html>
