<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Текстовый квест</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/welcome.css">

</head>
<body>
<div class="container welcome">
  <h1>Добро пожаловать в текстовый квест <br> "Путь героя"!</h1>
  <p>Вы - отважный искатель приключений, стоящий на пороге великого путешествия.
    Впереди вас ждут опасности, загадки и важные решения, которые определят вашу судьбу.
    Будьте осторожны в своих выборах - от них зависит, станете ли вы легендой или
    каните в безвестности...</p>

  <form method="post">
    <label for="playerName">Введите ваше имя:</label>
    <input type="text" id="playerName" name="playerName" required
           placeholder="Имя героя" autocomplete="off" autofocus>
    <button type="submit">Начать приключение →</button>
  </form>
</div>
</body>
</html>