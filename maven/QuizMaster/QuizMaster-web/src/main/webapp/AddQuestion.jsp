<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="WEB-INF/jspf/header.jsp" />
<h1>Add Questions</h1>
<form action="CreateQuiz" method="post">
    Question Text:<br />
    <input type="text" name="questionText" /><br />
    Answer 1:<br/>
    <input type="text" name="answerText_0" /><br />
    Answer 2:<br/>
    <input type="text" name="answerText_1" /><br />
    Answer 3:<br/>
    <input type="text" name="answerText_2" /><br />
    Answer 4:<br/>
    <input type="text" name="answerText_3" /><br />
    <input type="submit" name="createQuizAction" value="Add Question" />
</form>
<br/>
<a href="CreateQuiz?createQuizAction=Done">Finish</a>
<jsp:include page="WEB-INF/jspf/footer.jsp" />
