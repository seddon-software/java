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
             
<jsp:setProperty name="user" property="name" value="Jim Bean"/>
<jsp:setProperty name="user" property="age" value="237"/>


<html>
<head><title>Using Beans in JSPs</title></head>

<body bgcolor="#FFFFC0" text="blue">


This JSP sets Name and Age on the bean



</body>
</html>
