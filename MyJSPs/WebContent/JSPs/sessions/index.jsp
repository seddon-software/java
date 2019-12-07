<!--
////////////////////////////////////////////////////////////
//
//    Forms - page1
//
////////////////////////////////////////////////////////////
-->


<html>
<head><title>HttpSessions</title></head>

<body bgcolor="#ccbb22" text="black">

<h1>HttpSession Object</h1>
<hr>

<form action="index">
  <input type=submit value="Submit"/><p>
  <input type="radio" name="newSession" value="3">Create New session</input><p>

  <!-- don't flush the response in case session is invalidated -->
  <jsp:include page="/sessions/myservlet" flush="false" />
</form>

</body>
</html>
