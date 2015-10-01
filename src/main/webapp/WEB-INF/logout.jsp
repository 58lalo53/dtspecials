<%
    session.removeAttribute("user");
    session.invalidate();
    response.sendRedirect("home");
%>
