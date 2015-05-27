<%@page import="edu.depaul.cdm.QuizMaster.DTODescriptor.AnswerDescriptor"%>
<%@page import="java.util.List"%>
<%@page import="edu.depaul.cdm.QuizMaster.DTODescriptor.QuestionDescriptor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="WEB-INF/jspf/header.jsp" />
<%
    QuestionDescriptor q =  (QuestionDescriptor)request.getAttribute("currentQuestion");
    List<AnswerDescriptor> answers = q.getAnswers();
%>
<h1>Take Quiz Stateful2</h1>
<h2>${q.name}</h2>
<form action="TakeQuizStateful">
    <h2>Question: <%= q.getQuestionText() %></h2>
    <h3>Count =  <%= answers.size() %></h3>
        <c:forEach var="answer" begin="0" items="${currentQuestion.getAnswers()}">
              <input type="radio" name="answerID" value="${answer.id}" />${answer.answerText}<br/> 
        </c:forEach> 
              <br/>
              <input type="hidden" name="next" value="1" />
              <input type="submit" name="addAnswer" value="Submit" />
</form>
<a href="TakeQuizStateful?next=1">Next</a>
<jsp:include page="WEB-INF/jspf/footer.jsp" />