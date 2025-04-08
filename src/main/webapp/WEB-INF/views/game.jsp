<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Квест</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/game.css">
</head>
<body>
<div class="container game">
  <h1>${gameState.currentQuestion.text}</h1>

  <c:if test="${not empty gameState.currentQuestion.imageLink}">
    <img src="${pageContext.request.contextPath}/${gameState.currentQuestion.imageLink}" alt="Изображение не найдено">
  </c:if>

  <form method="post">
    <input type="hidden" name="questionId" value="${gameState.currentQuestion.id}">

    <c:forEach items="${gameState.currentQuestion.answers}" var="answer">
      <button type="submit" name="answerId" value="${answer.id}">
          ${answer.text}
      </button>
    </c:forEach>
  </form>

  <div class="stats">
    Игрок: <strong>${gameState.playerName}</strong> | Игр сыграно: <strong>${gameState.gamesPlayed}</strong>
  </div>
</div>
</body>
</html>