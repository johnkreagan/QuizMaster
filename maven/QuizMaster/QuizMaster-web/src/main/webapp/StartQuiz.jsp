<%@page import="edu.depaul.cdm.QuizMaster.Player"%>
<%@page import="edu.depaul.cdm.QuizMaster.Quiz"%>
<%@page import="java.util.List"%>
<%
            List<Quiz> quizzes = (List<Quiz>)request.getAttribute("quizzes");
            List<Player> players = (List<Player>)request.getAttribute("players");

%>
<jsp:include page="WEB-INF/jspf/header.jsp" />
        <h1>Start A Quiz</h1>
        <form action="StartQuiz" method="POST">
            Quiz: <select name="quizID">
                <%
                for(Quiz q : quizzes) {
                    %>
                    <option value="<%= q.getId() %>"><%= q.getQuizName() %></option>
                    <%
                }
                %>
            </select><br/>
            Player: <select name="playerID">
                <%
                for(Player p : players) {
                    %>
                    <option value="<%= p.getId() %>"><%= p.getName() %></option>
                    <%
                }
                %>
            </select><br/>
            <input type="submit" name="startQuiz" value="Begin" />
        </form>
<jsp:include page="WEB-INF/jspf/footer.jsp" />
</html>
