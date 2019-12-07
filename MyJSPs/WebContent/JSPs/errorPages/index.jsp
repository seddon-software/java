<%@ page import="java.lang.Exception" %>

<body bgcolor="#FFFFC0" text="blue">

<h1>Error Pages</h1>
<hr/>

Click on buttons to generate different types of error<p>


<form action="do-non-existent.jsp">
  <input type="submit" value="try to go to non-existing jsp" />
</form>

<form action="do-throw-and-catch-locally.jsp">
  <input type="submit" value="throw MyException, but catch locally" />
</form>

<form action="do-throw-myexception.jsp">
  <input type="submit" value="throw MyException, but catch in elsewhere" />
</form>

<form action="do-throw-with-custom-error-page.jsp">
  <input type="submit" value="throw MyException and specify the error page" />
</form>

<form action="do-throw-with-tags-in-error-page.jsp">
  <input type="submit" value="throw Exception and use a JSTL error page" />
</form>


</body>
