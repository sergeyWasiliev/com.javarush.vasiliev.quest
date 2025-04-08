<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Результат</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/result.css">
</head>
<body>
<div class="container result">
  <div class="result-message <c:if test='${gameState.win}'>win</c:if><c:if test='${not gameState.win}'>lose</c:if>">
    <c:choose>
      <c:when test="${gameState.win}">
        🏆 Поздравляем, ${gameState.playerName}! Вы победили! 🏆
      </c:when>
      <c:otherwise>
        💀 К сожалению, ${gameState.playerName}, вы проиграли. 💀
      </c:otherwise>
    </c:choose>
  </div>

  <form method="post">
    <button type="submit" name="restart" value="true" class="restart-btn">
      🎮 Играть снова
    </button>
  </form>

  <p class="games-count">Всего игр сыграно: <strong>${gameState.gamesPlayed}</strong></p>
</div>
</body>
</html>