<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="WEB-INF/jspf/header.jsp" />
<h1>Quiz Created!</h1>
<h2><%= request.getAttribute("currentQuiz") %></h2>
<jsp:include page="WEB-INF/jspf/footer.jsp" />