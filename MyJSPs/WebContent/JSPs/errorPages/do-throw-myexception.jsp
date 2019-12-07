<%@ page import="errorPages.MyException" %>
<body bgcolor="#FFFFC0" text="blue">
<%
	if(2 > 1) throw new MyException("Some error");
%>
</body>

