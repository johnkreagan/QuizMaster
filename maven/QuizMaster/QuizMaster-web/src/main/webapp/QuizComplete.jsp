<%@page import="edu.depaul.cdm.QuizMaster.QuizMatch"%>
<%
    QuizMatch qm = (QuizMatch)request.getAttribute("gradedQuizMatch");
%>
<jsp:include page="WEB-INF/jspf/header.jsp" />
        <h1><%= qm.getQuiz().getQuizName() %></h1>
        <h2>Score: <%= qm.getScore() %></h2>
<jsp:include page="WEB-INF/jspf/footer.jsp" />