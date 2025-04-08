package web.dto;

import entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class GameState {

    private String playerName;
    private Question currentQuestion;
    private Boolean win;
    private int gamesPlayed;

    public void incrementGamesPlayed() {
        this.gamesPlayed++;
    }
}