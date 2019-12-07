<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="tagsExpressionLanguage.Person"%>

<h1>Expression Language</h1>

<jsp:useBean id="john" scope="page" class="tagsExpressionLanguage.Person">
	<jsp:setProperty name="john" property="firstName" value="John" />
	<jsp:setProperty name="john" property="lastName" value="Smith" />
	<jsp:setProperty name="john" property="age" value="42" />
</jsp:useBean>

<jsp:useBean id="bridget" scope="page" class="tagsExpressionLanguage.Person">
	<jsp:setProperty name="bridget" property="firstName" value="Bridget" />
	<jsp:setProperty name="bridget" property="lastName" value="Jones" />
	<jsp:setProperty name="bridget" property="age" value="27" />
</jsp:useBean>



<em>John</em>
<br>
First Name:
<c:out value="${john.firstName}" />
<br>
Last Name:
<c:out value="${john.lastName}" />
<br>
Age
<c:out value="${john.age}" />
<br>
<hr />

<c:if test="${bridget.age < john.age}">
	${bridget.firstName} ${bridget.lastName} is younger than 
    ${john.firstName} ${john.lastName} 
</c:if>

<hr />


<%
	pageContext.setAttribute("var1", "this is a page attribute");
	request.setAttribute("var2", "this is a request attribute");
	session.setAttribute("var3", "this is a session attribute");
	application.setAttribute("var4", "this is a application attribute");
%>

var1 = <c:out value="${var1}" /><br>
var2 = <c:out value="${var2}" /><br>
var3 = <c:out value="${var3}" /><br>
var4 = <c:out value="${var4}" /><br>
<hr/>


<%
	Person[] p = new Person[2];
	p[0] = new Person();
	p[0].setFirstName("John");
	p[0].setLastName("Smith");
	p[0].setAge(42);
	p[1] = new Person();
	p[1].setFirstName("Briget");
	p[1].setLastName("Jones");
	p[1].setAge(27);
	request.setAttribute("people", p);
%>

<c:out value="${people[0].firstName}" /><br>
<c:out value="${people[0].lastName}" /><br>
<c:out value="${people[0].age}" /><p>

<c:out value="${people[1].firstName}" /><br>
<c:out value="${people[1].lastName}" /><br>
<c:out value="${people[1].age}" /><p>
