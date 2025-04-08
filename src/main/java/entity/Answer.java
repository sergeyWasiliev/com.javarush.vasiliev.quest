package entity;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
@Setter

public class Answer {
    private Long id;
    private String text;
    private Long nextQuestionId;
    private boolean isWin;
}