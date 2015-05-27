<%--
    Document   : ViewAllQuizzes
    Created on : May 5, 2015, 8:21:14 PM
    Author     : John
--%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="WEB-INF/jspf/header.jsp" />
<h1>View All Quizzes!<%= request.getAttribute("quizzes") %></h1>
        <ul>
            
      <c:forEach var="quiz" begin="0" items="${requestScope.quizzes}">
            <li>
                ${quiz.name}
                <ul>
                    <c:forEach var="question" begin="0" items="${quiz.getQuestions()}">
                        <li>${question.getQuestionText()}</li>
                        <ol>
                            <c:forEach var="answer" begin="0" items="${question.getAnswers()}">
                                <li>${answer.getAnswerText()}</li>
                            </c:forEach>
                        </ol>
                    </c:forEach>
                    
                </ul>
            </li>
        </c:forEach>     
        </ul>
<jsp:include page="WEB-INF/jspf/footer.jsp" />
