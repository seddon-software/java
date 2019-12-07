<body bgcolor="#FFFFC0" text="blue">
<h1>HttpListeners</h1><br>
<hr/>

<%
	request.getSession(true);
%>
<form action="do-newSession.jsp">
	<input type="submit" value="new session" />
</form>

<form action="do-addAttributeToSession.jsp">
	<input type="submit" value="add attribute to session" />
</form>

<form action="do-removeAttributeFromSession.jsp">
	<input type="submit" value="remove attribute from session" />
</form>

<form action="do-addAttributeToApplication.jsp">
	<input type="submit" value="add attribute to application" />
</form>

<form action="do-removeAttributeFromApplication.jsp">
	<input type="submit" value="remove attribute from application" />
</form>


</body>
