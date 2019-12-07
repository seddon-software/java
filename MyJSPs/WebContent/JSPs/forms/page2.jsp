<!--
////////////////////////////////////////////////////////////
//
//    Forms - page2
//
////////////////////////////////////////////////////////////
-->

<%@ page import="forms.ItemBean" %>

<jsp:useBean id="item"
             class="forms.ItemBean"
             scope="session">

 
</jsp:useBean>

<jsp:setProperty name="item" property="*" />

<html>
<head>
  <title>Forms: page2.jsp</title>
</head>

<body bgcolor="#FFFFC0" text="blue">

<h1>Forms</h1>
<hr>

  <h2>
  <table width="50%">
    <tr>
      <td>Item:</td>
      <td><%= item.getName() %></td>
    </tr>
    <tr>
      <td>Cost:</td>
      <td><%= item.getCost() %></td>
    </tr>
    <tr>
      <td>Quantity:</td>
      <td><%= item.getQuantity() %></td>
    </tr>
  </table>
  </h2>
<A HREF="<%= response.encodeURL("start") %>">Previous Page</A>

</body>
</html>
