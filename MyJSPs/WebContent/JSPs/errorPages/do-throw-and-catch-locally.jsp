<%@ page import="errorPages.MyException" %>
<body bgcolor="#FFFFC0" text="red">
<%
	try {
		if(2 > 1) throw new MyException("Some error");
	} catch(Exception e) {
		out.print("<h1>MyException caught locally</h1>");
	}
%>
</body>



