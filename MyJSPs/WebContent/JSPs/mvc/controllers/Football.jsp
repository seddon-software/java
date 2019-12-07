<%@ page import="mvc.models.Football" %>
Football Controller

<%
	Football[] table = new Football[4];

	table[0] = new Football("Man Utd", 8);
	table[1] = new Football("Spurs", 5);
	table[2] = new Football("Chelsea", 4);
	table[3] = new Football("Everton", 1);
	
	request.setAttribute("table", table);

%>
