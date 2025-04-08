package service;

import entity.Answer;
import entity.Question;
import repository.GameRepository;
import web.dto.GameState;

public class GameService {
    private final GameRepository repository = new GameRepository();

    public Question getFirstQuestion() {
        return repository.getQuestionById(1L);
    }

    public GameState processAnswer(Long questionId, Long answerId, GameState currentState) {
        Answer answer = repository.getAnswerById(questionId, answerId);

        if (answer == null) {
            return currentState;
        }
        if (answer.isWin()) {
            currentState.setWin(true);
            currentState.setCurrentQuestion(null);
            currentState.incrementGamesPlayed();
        } else if (answer.getNextQuestionId() == null) {
            currentState.setWin(false);
            currentState.setCurrentQuestion(null);
            currentState.incrementGamesPlayed();
        } else {
            Question nextQuestion = repository.getQuestionById(answer.getNextQuestionId());
            currentState.setCurrentQuestion(nextQuestion);
        }
        return currentState;
    }

    public GameState resetGame(GameState currentState) {
        currentState.setCurrentQuestion(getFirstQuestion());
        currentState.setWin(null);
        return currentState;
    }
}