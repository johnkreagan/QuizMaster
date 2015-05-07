<%-- 
    Document   : ViewAllQuizzes
    Created on : May 5, 2015, 8:21:14 PM
    Author     : John
--%>
<%@page import="edu.depaul.cdm.QuizMaster.Quiz"%>
<%@page import="java.util.List"%>
<jsp:include page="WEB-INF/jspf/header.jsp" />
        <h1>View All Quizzes!</h1>
        <ul>
            
        <%
            List<Quiz> quizzes = (List<Quiz>)request.getAttribute("quizzes");
            
            for(Quiz q : quizzes) {
            %>
            <li><%@include file="WEB-INF/jspf/QuizSimple.jsp" %></li>
            <%--<li><%@include file="WEB-INF/jspf/AnswerInputRadio.jsp" %></li>--%>
            <% } %>
        </ul>
<jsp:include page="WEB-INF/jspf/footer.jsp" />
