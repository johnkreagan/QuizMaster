<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="WEB-INF/jspf/header.jsp" />
<h1>Take Quiz Stateful</h1>
<h2>${requestScope.currentQuestion}</h2>
<a href="TakeQuizStateful?next=1">Next</a>
<jsp:include page="WEB-INF/jspf/footer.jsp" />