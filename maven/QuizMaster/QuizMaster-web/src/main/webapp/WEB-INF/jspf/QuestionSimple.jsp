<%-- 
    Document   : QuestionSimple
    Created on : May 7, 2015, 6:35:11 PM
    Author     : John
--%>
<li><%= quest.getQuestionText() %>
    <ol>
        <%
        answers = quest.getAnswers();
        for(int j = 0; j < answers.size(); j++) {
            ans = answers.get(j);
            %>
            <li><%= ans.getAnswerText() %></li>
            <% } %>
    </ol>
</li>