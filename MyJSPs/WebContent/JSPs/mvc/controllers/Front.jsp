<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body bgcolor="#FFFFC0" text="blue">

${request}

<c:if test="${param.model == 'football'}" >
	<jsp:include page="/mvc/football" />
</c:if>
<c:if test="${param.model == 'rugby'}" >
	<jsp:include page="/mvc/rugby" />
</c:if>

<c:if test="${param.view == 'barChart'}" >
	<jsp:forward page="/mvc/barChart" />
</c:if>
<c:if test="${param.view == 'text'}" >
	<jsp:forward page="/mvc/text" />
</c:if>


</body>
