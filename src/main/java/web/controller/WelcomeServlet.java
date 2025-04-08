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
    int numberDoGet=0;
    int numberDoPost=0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet WelcomeServlet run - " + ++numberDoGet);
        req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("doPost WelcomeServlet run - " + ++numberDoPost);
        String playerName = req.getParameter("playerName");
        HttpSession session = req.getSession();
        GameState gameState = (GameState) session.getAttribute("gameState");

        if (gameState == null) {
            gameState = new GameState();
            session.setAttribute("gameState", gameState);
        }
        gameState.setPlayerName(playerName);
        new GameService().resetGame(gameState);
        resp.sendRedirect(req.getContextPath() + "/game");
    }
}