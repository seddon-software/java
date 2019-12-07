<%--
////////////////////////////////////////////////////////////
//
//    Using Beans in JSPs
//
////////////////////////////////////////////////////////////
--%>

<jsp:useBean id="user"
             class="beans.MyBean"
             scope="session" />
<html>
<head><title>Using Beans in JSPs</title></head>

<body bgcolor="#FFFFC0" text="blue">

This JSP retrieves info from the bean <P>


Your name is <%= user.getName() %> <BR>
Your age is <%= user.getAge()  %> <BR>



</body>
</html>
