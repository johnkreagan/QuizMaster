<%@page import="edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="WEB-INF/jspf/header.jsp" />
<%
    QuizDescriptor currentQuiz = (QuizDescriptor)request.getAttribute("currentQuiz");
    
%>
<h1>Quiz Created!</h1>
<h2><%= currentQuiz.getName()  %></h2>
<c:forEach var="account" begin="0" items="${currentQuiz.getQuestions()}">
      <li>
          ${account.id}
      </li>
  </c:forEach>   
<jsp:include page="WEB-INF/jspf/footer.jsp" />