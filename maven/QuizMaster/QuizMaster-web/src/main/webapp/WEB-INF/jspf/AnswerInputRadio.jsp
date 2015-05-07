<%-- 
    Document   : AnswerInputRadio
    Created on : May 7, 2015, 6:38:15 PM
    Author     : John
    
Expected Variables:
Question quest;
Answer ans;
--%>
<% 
    String questionInputName = "Question_" + quest.getId();
    String answerInputID = questionInputName + "_Ans_" + ans.getId();
%>
<input type="radio" id="<%= answerInputID %>" name="<%= questionInputName %>" value="<%= ans.getId() %>" /><label for="<%= answerInputID %>" ><%= ans.getAnswerText() %></label>