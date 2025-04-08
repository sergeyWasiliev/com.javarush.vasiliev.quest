package web.controller;

import service.GameService;
import web.dto.GameState;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    private final GameService gameService = new GameService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");
        if (gameState == null || gameState.getPlayerName() == null) {
            resp.sendRedirect(req.getContextPath() + "/welcome");
            return;
        }
        if (gameState.getCurrentQuestion() == null) {
            req.getRequestDispatcher("/WEB-INF/views/result.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");
        if (req.getParameter("restart") != null) {
            gameService.resetGame(gameState);
            resp.sendRedirect(req.getContextPath() + "/game");
            return;
        }
        try {
            Long questionId = Long.parseLong(req.getParameter("questionId"));
            Long answerId = Long.parseLong(req.getParameter("answerId"));

            gameService.processAnswer(questionId, answerId, gameState);
            resp.sendRedirect(req.getContextPath() + "/game");
        } catch (NumberFormatException e) {
            resp.sendRedirect(req.getContextPath() + "/game");
        }
    }
}