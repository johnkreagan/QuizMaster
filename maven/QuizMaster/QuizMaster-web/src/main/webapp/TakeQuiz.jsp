<%@page import="edu.depaul.cdm.QuizMaster.Quiz"%>
<%@page import="java.util.List"%>
<%
Quiz activeQuiz;

activeQuiz = q;


%>
<jsp:include page="WEB-INF/jspf/header.jsp" />
        <h1><%= activeQuiz.getQuizName() %></h1>
        <form action="/TakeQuiz" method="POST">
            <ul>
            <%
                List<Quiz> quizzes = (List<Quiz>)request.getAttribute("quizzes");

                for(Quiz q : quizzes) {
                %>
                <li><%@include file="WEB-INF/jspf/QuizSimple.jsp" %></li>
                <% } %>
            </ul>
        </form>
<jsp:include page="WEB-INF/jspf/footer.jsp" />