<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="WEB-INF/jspf/header.jsp" />
<%@page import="java.util.List"%>
        <h1>Start A Quiz</h1>
        <form action="StartQuiz" method="POST">
            Quiz: <select name="quizID">
                <c:forEach var="quiz" begin="0" items="${requestScope.quizzes}">
                    <li>
                        <option value="${quiz.id}">${quiz.name}</option>
                    </li>
                </c:forEach> 
            </select><br/>
            Player: <select name="playerID">
                <c:forEach var="player" begin="0" items="${requestScope.players}">
                    <li>
                        <option value="${player.id}">${player.name}</option>
                    </li>
                </c:forEach> 
            </select><br/>
            Multi-Page(Stateful):<input type="radio" name="quizFormat" value="stateful" checked="checked" /><br/>
            Single-Page(Stateless):<input type="radio" name="quizFormat" value="stateless" /><br/>
            <input type="submit" name="startQuiz" value="Begin" />
        </form>
<jsp:include page="WEB-INF/jspf/footer.jsp" />
