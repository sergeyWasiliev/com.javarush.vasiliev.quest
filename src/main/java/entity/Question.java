package entity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Getter
@Setter
public class Question {
    private Long id;
    private String text;
    private String imageLink;
    private List<Answer> answers;
}