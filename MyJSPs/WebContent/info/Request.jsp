<!--
////////////////////////////////////////////////////////////
//
//    RequestObject
//
////////////////////////////////////////////////////////////

-->

<html>
<head><title>The Request Object</title></head>

<body bgcolor="#FFFFC0" text="blue">

<h1>Request Object</h1>
<hr>
<h3>
  <%
    System.out.println("RequestObject");
    out.print("<p>getMethod:      " + request.getMethod());
    out.print("<p>getAuthType:    " + request.getAuthType());
    out.print("<p>getRequestURL:  " + request.getRequestURL());
    out.print("<p>getProtocol:    " + request.getProtocol());
    out.print("<p>getServletPath: " + request.getServletPath());
    out.print("<p>getPathInfo:    " + request.getPathInfo());
    out.print("<p>getLocalPort:   " + request.getLocalPort());
    out.print("<p>getLocalAddr:   " + request.getLocalAddr());
    out.print("<p>getQueryString: " + request.getQueryString());
    out.print("<p>getServerName:  " + request.getServerName());
    out.print("<p>getServerPort:  " + request.getServerPort());
    out.print("<p>getRemoteAddr:  " + request.getRemoteAddr());
    out.print("<p>getRemoteUser:  " + request.getRemoteUser());
  %>
</h3>
</body>
</html>
