import org.example.Move;
import org.example.player.DetectivePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetectivePlayerTest {
    @Test
    public void detectivePlayerInitialMove() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();

        assertEquals(Move.COOPERATE, detectivePlayer.makeMove());
    }

    @Test
    public void detectivePlayerSecondMove() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();

        assertEquals(Move.COOPERATE, detectivePlayer.makeMove());
        assertEquals(Move.CHEAT, detectivePlayer.makeMove());
    }

    @Test
    public void detectivePlayerWhenGainAndMakeMove() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();

        assertEquals(Move.COOPERATE, detectivePlayer.makeMove());
        assertEquals(Move.CHEAT, detectivePlayer.makeMove());
        assertEquals(Move.CHEAT, detectivePlayer.makeMove());
        assertEquals(Move.CHEAT, detectivePlayer.makeMove());
    }

    @Test
    public void inTwoMovesGetCheatedAndThanActLikeCopyCat() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();

        detectivePlayer.invest();

        assertEquals(Move.COOPERATE, detectivePlayer.makeMove());
        assertEquals(Move.CHEAT, detectivePlayer.makeMove());
        detectivePlayer.invest();
        assertEquals(Move.CHEAT, detectivePlayer.makeMove());
        detectivePlayer.gain();
        assertEquals(Move.COOPERATE, detectivePlayer.makeMove());
    }
}
