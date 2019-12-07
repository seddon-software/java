<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body bgcolor="#FFFFC0" text="blue">
<h1>text view</h1>

<c:if test="${not empty table}" >
 <table border="1">
  <tr><td>${table[0].name}</td><td>${table[0].points}</td></tr>
  <tr><td>${table[1].name}</td><td>${table[1].points}</td></tr>
  <tr><td>${table[2].name}</td><td>${table[2].points}</td></tr>
  <tr><td>${table[3].name}</td><td>${table[3].points}</td></tr>
 </table>
</c:if>
</body>
</html>
