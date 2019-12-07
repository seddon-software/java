<body bgcolor="#FFFFC0" text="blue">

<%
  session.removeAttribute("mySessionAttribute");
  session.setAttribute("mySessionAttribute", new String("sessionValue"));
%>

session attribute added<br>

<% 
  request.getSession(true);
  String home = response.encodeURL("index.jsp");
%>
<a href ='<%= home %>'>home</a>
</body>
