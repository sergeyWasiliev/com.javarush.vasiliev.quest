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
        // задаем состояние игры вопрос-3, ответ-6 - ПОБЕДА
        gameService.processAnswer(3L, 6L, gameState);

        assertNull(gameState.getCurrentQuestion()); //после победы текущий вопрос null
        assertTrue(gameState.getWin());  //состояние победа
        assertEquals(1, gameState.getGamesPlayed());  //количество сыгранных игр 1
    }

    @Test
    void testProcessAnswerLose() {
        // задаем состояние игры вопрос-4, ответ-7 - ПОРАЖЕНИЕ
        gameService.processAnswer(4L, 7L, gameState);

        assertNull(gameState.getCurrentQuestion());
        assertFalse(gameState.getWin());
        assertEquals(1, gameState.getGamesPlayed());
    }

    @Test
    void testResetGame() {
        //задаем состояние игры - ПОРАЖЕНИЕ
        gameState.setCurrentQuestion(null);
        gameState.setWin(false);
        gameState.incrementGamesPlayed();
        //обнуляем состояние игры
        gameService.resetGame(gameState);
        //проверяем что все обнулилось, счетчик игр сохранил значение
        assertNotNull(gameState.getCurrentQuestion());
        assertNull(gameState.getWin());
        assertEquals(1, gameState.getGamesPlayed());
    }
}