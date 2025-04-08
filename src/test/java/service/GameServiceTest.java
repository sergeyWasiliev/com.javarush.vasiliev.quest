package service;

import entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import web.dto.GameState;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    private GameService gameService;
    private GameState gameState;

    @BeforeEach
    void setUp() {
        gameService = new GameService();
        gameState = new GameState();
        gameState.setCurrentQuestion(gameService.getFirstQuestion());
    }

    @Test
    void testGetFirstQuestion() {
        Question firstQuestion = gameService.getFirstQuestion();
        assertNotNull(firstQuestion);
        assertEquals(1L, firstQuestion.getId());
        assertEquals(2, firstQuestion.getAnswers().size());
    }

    @Test
    void testProcessAnswerWin() {
        gameState.setCurrentQuestion(gameService.getFirstQuestion());
        gameService.processAnswer(1L, 2L, gameState); // Go to question 3
        gameService.processAnswer(3L, 6L, gameState); // Win

        assertNull(gameState.getCurrentQuestion());
        assertTrue(gameState.getWin());
        assertEquals(1, gameState.getGamesPlayed());
    }

    @Test
    void testProcessAnswerLose() {
        gameState.setCurrentQuestion(gameService.getFirstQuestion());
        gameService.processAnswer(1L, 1L, gameState); // Go to question 2
        gameService.processAnswer(2L, 3L, gameState); // Go to question 4
        gameService.processAnswer(4L, 7L, gameState); // Lose

        assertNull(gameState.getCurrentQuestion());
        assertFalse(gameState.getWin());
        assertEquals(1, gameState.getGamesPlayed());
    }

    @Test
    void testResetGame() {
        gameState.setCurrentQuestion(null);
        gameState.setWin(false);
        gameState.incrementGamesPlayed();

        gameService.resetGame(gameState);

        assertNotNull(gameState.getCurrentQuestion());
        assertNull(gameState.getWin());
        assertEquals(1, gameState.getGamesPlayed());
    }
}