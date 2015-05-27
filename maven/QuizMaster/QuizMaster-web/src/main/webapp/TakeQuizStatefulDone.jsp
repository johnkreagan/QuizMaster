<%@page import="java.util.Map"%>
<%@page import="edu.depaul.cdm.QuizMaster.DTODescriptor.QuizMatchDescriptor"%>
<%@page import="edu.depaul.cdm.QuizMaster.DTODescriptor.AnswerDescriptor"%>
<%@page import="java.util.List"%>
<%@page import="edu.depaul.cdm.QuizMaster.DTODescriptor.QuestionDescriptor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="WEB-INF/jspf/header.jsp" />
<%
    QuizMatchDescriptor q =  (QuizMatchDescriptor)request.getAttribute("quizMatch");
    Map<QuestionDescriptor,AnswerDescriptor> answers = q.getAnswers();
%>
<h1>Take Quiz Done</h1>
<h2>${q.name}</h2>
    <h2>Question: <%= q.getName() %></h2>
    <h3>Count =  <%= answers.size() %></h3>
    <ul>
        <c:forEach var="entry" begin="0" items="${quizMatch.getAnswers()}">
            <ol>${entry.key.getQuestionText()} - ${entry.value.answerText}</ol>
        </c:forEach> 
    </ul>

<a href="TakeQuizStateful?next=1">Next</a>
<jsp:include page="WEB-INF/jspf/footer.jsp" />