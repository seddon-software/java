<%@ page import="mvc.models.Rugby" %>
Rugby Controller

<%
	Rugby[] table = new Rugby[4];

	table[0] = new Rugby("Leicester", 21);
	table[1] = new Rugby("Ospreys", 15);
	table[2] = new Rugby("Wasps", 13);
	table[3] = new Rugby("Bath", 8);
	
	request.setAttribute("table", table);

%>
