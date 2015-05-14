<%@page import="edu.depaul.cdm.QuizMaster.Quiz"%>
<%@page import="java.util.List"%>
<%
Quiz activeQuiz = (Quiz)request.getAttribute("activeQuiz");

request.setAttribute("Quiz.QuizSimple.JSP", activeQuiz);
%>
<jsp:include page="WEB-INF/jspf/header.jsp" />
        <h1><%= activeQuiz.getQuizName() %></h1>
        <form action="TakeQuiz" method="POST">
            <%@include file="WEB-INF/jspf/QuizSimple.jsp" %>
            <input type="submit" name="submitQuiz" value="Submit" />
        </form>
<jsp:include page="WEB-INF/jspf/footer.jsp" />