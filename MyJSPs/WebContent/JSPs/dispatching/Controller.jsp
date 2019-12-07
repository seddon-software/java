<!--
////////////////////////////////////////////////////////////
//
//    Calling JSPs and Servlets
//
////////////////////////////////////////////////////////////
-->

<html>
<head><title>Call servlets and JSPs</title></head>

<body bgcolor="#FFFFC0" text="blue">


<h1> This is the Controller</h1>
... attempting to call servlet1 ...
<jsp:include page="/dispatching/servlets/page1" flush="true" />

<h1> This is the Controller</h1>
... attempting to call JSP1 ...
<jsp:include page="/dispatching/JSPs/page1" flush="true" />


<h1> This is the Controller</h1>
... attempting to call JSP2 ...
<jsp:include page="/dispatching/JSPs/page2" flush="true" />


</body>
</html>
