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
             
<jsp:setProperty name="user" property="name" value=""/>
<jsp:setProperty name="user" property="age" value="0"/>


<html>
<head><title>Using Beans in JSPs</title></head>

<body bgcolor="#FFFFC0" text="blue">


The bean is now empty



</body>
</html>
