package repository;

import entity.Answer;
import entity.Question;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRepository {
    private static final Map<Long, Question> questions = new HashMap<>();
    private static final Map<Long, List<Answer>> answers = new HashMap<>();

    static {
        Answer answer1q1 = new Answer(1L, "Исследовать пещеру", 2L, false);
        Answer answer2q1 = new Answer(2L, "Идти по тропинке", 3L, false);

        Answer answer1q2 = new Answer(3L, "Взять старый меч", 4L, false);
        Answer answer2q2 = new Answer(4L, "Оставить меч", null, true);

        Answer answer1q3 = new Answer(5L, "Попробовать ягоды", null, false);
        Answer answer2q3 = new Answer(6L, "Идти дальше", null, true);

        Answer answer1q4 = new Answer(7L, "Атаковать дракона", null, false);
        Answer answer2q4 = new Answer(8L, "Попытаться договориться", null, true);

        answers.put(1L, List.of(answer1q1, answer2q1));
        answers.put(2L, List.of(answer1q2, answer2q2));
        answers.put(3L, List.of(answer1q3, answer2q3));
        answers.put(4L, List.of(answer1q4, answer2q4));

        questions.put(1L, new Question(1L, "Вы стоите на развилке. Слева темная пещера, справа узкая тропинка в лес. Куда пойдете?", "images/fork.jpg", answers.get(1L)));
        questions.put(2L, new Question(2L, "В пещере вы нашли древний меч. Что сделаете?", "images/sword.jpg", answers.get(2L)));
        questions.put(3L, new Question(3L, "На тропинке вы увидели куст с яркими ягодами. Ваши действия?", "images/berries.jpg", answers.get(3L)));
        questions.put(4L, new Question(4L, "Вы нашли дракона! Он спит. Как поступите?", "images/dragon.jpg", answers.get(4L)));
    }

    public Question getQuestionById(Long id) {
        return questions.get(id);
    }

    public Answer getAnswerById(Long questionId, Long answerId) {
        return answers.get(questionId).stream()
                .filter(a -> a.getId().equals(answerId))
                .findFirst()
                .orElse(null);
    }
}