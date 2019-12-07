<!--
////////////////////////////////////////////////////////////
//
//    Forms - start
//
////////////////////////////////////////////////////////////

-->

<jsp:useBean id="item"
             class="forms.ItemBean"
             scope="session">
</jsp:useBean>


<html>
<head><title>Forms: start.jsp</title></head>

<body bgcolor="#FFFFC0" text="blue">

<h1>Forms</h1>
<hr>

<form action="<%= response.encodeURL("page2") %>" >
  <table width = "50%">
    <tr>
      <td>Name:</td>
      <td><input name="name" type="text" value= <%= item.getName() %> /><td>
    </tr>
    <tr>
      <td>Cost:</td>
      <td><input name="cost" type="text" value= <%= item.getCost() %> /></td>
    </tr>
    <tr>
      <td>Quantity:</td>
      <td><input name="quantity" type="text" value= <%= item.getQuantity() %> /></td>
    </tr>

  </table>
  <input type=submit value="Submit">
</form>

</body>
</html>
