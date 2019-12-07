<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="/WEB-INF/functions.tld"%>

<h1>bar chart view</h1>

<body bgcolor="#FFFFC0" text="blue">

<c:if test="${not empty table}" >
 <table border="1">
  <tr><td>${table[0].name}</td><td>${f:displayAsXs(table[0].points)}</td></tr>
  <tr><td>${table[1].name}</td><td>${f:displayAsXs(table[1].points)}</td></tr>
  <tr><td>${table[2].name}</td><td>${f:displayAsXs(table[2].points)}</td></tr>
  <tr><td>${table[3].name}</td><td>${f:displayAsXs(table[3].points)}</td></tr>
 </table>
</c:if>
</body>
