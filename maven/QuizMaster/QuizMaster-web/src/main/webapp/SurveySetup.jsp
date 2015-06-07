

<%@page import="edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor.QuizType"%>
<%@page import="edu.depaul.cdm.QuizMaster.DTODescriptor.QuizDescriptor"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
    QuizDescriptor q = (QuizDescriptor)request.getAttribute("currentQuiz");
%>
<jsp:include page="WEB-INF/jspf/header.jsp" />
<h1>Add Questions</h1>
<h2><%= q.getType().toString() %></h2>
<form action="CreateQuiz" method="post">
    Range 1:<br />
    <input type="text" name="range_1_text" /><br />
    Low Value: <input type="hidden" name="range_1_low" value="0" /><br/>
    High Value: <input type="text" name="range_1_high" value="" /><br/>
    <br/><br/>

    Range 2:<br />
    <input type="text" name="range_2_text" /><br />
    Low Value: <input type="text" name="range_2_low" value="" /><br/>
    High Value: <input type="text" name="range_2_high" value="" /><br/>
    <br/><br/>
    
    Range 3:<br />
    <input type="text" name="range_3_text" /><br />
    Low Value: <input type="text" name="range_3_low" value="" /><br/>
    High Value: <input type="text" name="range_3_high" value="" /><br/>
    <br/><br/>
    
    Range 4:<br />
    <input type="text" name="range_4_text" /><br />
    Low Value: <input type="text" name="range_4_low" value="0" /><br/>
    High Value: <%= q.getQuestions().size() %><input type="hidden" name="range_4_high" value="<%= q.getQuestions().size() %>" /><br/>
    <br/><br/>

    <input type="hidden" name="createQuizAction" value="AddSurveyRanges" />
    <input type="submit" name="submit" value="Submit and Complete" />
</form>
<br/>
<jsp:include page="WEB-INF/jspf/footer.jsp" />
