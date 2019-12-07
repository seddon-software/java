<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="myTagLibrary" prefix="powers"%>

<html>
<head>
<title>Powers of Integers</title>
</head>

<body bgcolor="#FFFFC0" text="blue">

	<table border=1 align=center>
		<tr>
			<td colspan=4>Powers of Numbers</td>
		</tr>
		<c:forEach var="i" begin="1" end="20">
		<tr>
			<td><c:out value="${i}" /></td>
			<td><powers:calculate operation="square" number="${i}" /></td>
			<td><powers:calculate operation="cube" number="${i}" /></td>
			<td><powers:calculate operation="quad" number="${i}" /></td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>
