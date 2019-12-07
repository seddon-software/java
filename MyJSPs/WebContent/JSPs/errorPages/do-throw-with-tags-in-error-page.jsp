<%@ page errorPage="MyErrorPageWithTags.jsp" %>
<%@ page import="errorPages.MyException" %>
<body bgcolor="#FFFFC0" text="red">
<%
	if(2 > 1) throw new MyException("Some error");
%>
</body>



