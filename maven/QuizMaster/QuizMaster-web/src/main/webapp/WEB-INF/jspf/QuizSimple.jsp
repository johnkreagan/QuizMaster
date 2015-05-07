<%-- 
    Document   : QuizSimple
    Created on : May 7, 2015, 5:49:28 PM
    Author     : John
--%>
<%@page import="edu.depaul.cdm.QuizMaster.Answer"%>
<%@page import="java.util.List"%>
<%@page import="edu.depaul.cdm.QuizMaster.Question"%>
<div>
    <h3><%= q.getId() %> - <%= q.getQuizName() %></h3>
    <ul>
        <% 
        List<Question> questions = q.getQuestions();
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
