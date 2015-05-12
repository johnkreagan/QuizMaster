<%-- 
    Document   : QuizSimple
    Created on : May 7, 2015, 5:49:28 PM
    Author     : John
--%>
<%@page import="edu.depaul.cdm.QuizMaster.Quiz"%>
<%@page import="edu.depaul.cdm.QuizMaster.Answer"%>
<%@page import="java.util.List"%>
<%@page import="edu.depaul.cdm.QuizMaster.Question"%>
<%
    Quiz quizSimpleQuiz = (Quiz)request.getAttribute("Quiz.QuizSimple.JSP");
%>
<div>
    <h3><%= quizSimpleQuiz.getId() %> - <%= quizSimpleQuiz.getQuizName() %></h3>
    <ul>
        <% 
        List<Question> questions = quizSimpleQuiz.getQuestions();
        Question quest;
        List<Answer> answers;
        Answer ans;
        for(int i = 0; i < questions.size(); i++) { 
            quest = questions.get(i);
        %>
            <%@include file="QuestionSimple.jsp" %>
        <% } %>  
    </ul>

</div>
