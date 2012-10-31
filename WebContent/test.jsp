<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="org.exlnt.model.Question, org.exlnt.model.Answer, java.util.*" %>
<% 
	Question question = (Question) session.getAttribute("question");
	request.setAttribute("answers", question.getVariants());
%>

<form>
	<%=question.getQuestionText() %>
	<br>
	<c:forEach items="answers" var="item">
		<input type="radio" name="radioGroup" value="${item.answerId}"> ${item.text} <br>
	</c:forEach>
	
	<input type="button" value="  Answer  " onclick="onBtn1Click()">
		

</form>