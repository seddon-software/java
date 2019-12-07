<body bgcolor="#FFFFC0" text="blue">

<h1>Cookies</h1>
<hr>
  <form action="cookies.jsp">
    <input type=submit value="Submit"/><p>
  </form>

  <h2>Hit submit to create several cookies</h2><p>
  Use your browsers tools to inspect cookies

  <%
    Cookie cookie = null;

    cookie = new Cookie("ABC", "111111");
    cookie.setMaxAge(120);
    response.addCookie(cookie);

    cookie = new Cookie("DEF", "222222");
    cookie.setMaxAge(120);
    response.addCookie(cookie);

    cookie = new Cookie("HIJ", "333333");
    cookie.setMaxAge(120);
    response.addCookie(cookie);

    cookie = new Cookie("KLM", "444444");
    cookie.setMaxAge(120);
    response.addCookie(cookie);
  %>

</body>
</html>
