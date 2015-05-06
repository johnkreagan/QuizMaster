<%-- 
    Document   : ViewAllQuizzes
    Created on : May 5, 2015, 8:21:14 PM
    Author     : John
--%>

<%@page import="edu.depaul.cdm.QuizMaster.Quiz"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World from JSP!</h1>
        <ul>
            
        <%
            List<Quiz> quizzes = (List<Quiz>)request.getAttribute("quizzes");
            
            for(Quiz q : quizzes) {
            
            %>
            <li><%= q.getId() %> - <%= q.getQuizName() %></li>
            <% } %>
        </ul>
    </body>
</html>
