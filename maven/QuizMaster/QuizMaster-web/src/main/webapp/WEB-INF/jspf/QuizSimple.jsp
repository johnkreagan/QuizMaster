<%-- 
    Document   : QuizSimple
    Created on : May 7, 2015, 5:49:28 PM
    Author     : John
--%>
<%@page import="java.util.List"%>
<%
    Object quizSimpleQuiz = request.getAttribute("Quiz.QuizSimple.JSP");
%>
<div>
    <h3><%= quizSimpleQuiz.getId() %> - <%= quizSimpleQuiz.getQuizName() %></h3>
    <ul>
        <% 
        List questions = quizSimpleQuiz.getQuestions();
        Object quest;
        for(int i = 0; i < questions.size(); i++) { 
            quest = questions.get(i);
        %>
            <%@include file="QuestionSimple.jsp" %>
        <% } %>  
    </ul>

</div>
