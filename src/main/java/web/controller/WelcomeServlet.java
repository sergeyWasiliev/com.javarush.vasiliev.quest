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

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    private final GameService gameService = new GameService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String playerName = req.getParameter("playerName");
        HttpSession session = req.getSession();

        GameState gameState = new GameState();
        gameState.setPlayerName(playerName);
        gameService.resetGame(gameState);

        session.setAttribute("gameState", gameState);
        resp.sendRedirect(req.getContextPath() + "/game");
    }
}