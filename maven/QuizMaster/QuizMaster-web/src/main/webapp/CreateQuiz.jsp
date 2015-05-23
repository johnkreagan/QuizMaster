<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="WEB-INF/jspf/header.jsp" />
<h1>Create a new quiz</h1>
<form action="CreateQuiz" method="post">
    Title:<br />
    <input type="text" name="quizName" /><br />
    Type:<br/>
    <input type="radio" name="quizType" value="scored" checked="checked" /> Scored<br/>
    <input type="radio" name="quizType" value="survey" /> Survey<br/>
    <input type="submit" name="createQuizAction" value="Create" />
</form>

<jsp:include page="WEB-INF/jspf/footer.jsp" />
