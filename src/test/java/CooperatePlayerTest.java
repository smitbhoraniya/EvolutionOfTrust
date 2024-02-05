import org.example.CooperatePlayer;
import org.example.Move;
import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CooperatePlayerTest {
    @Test
    public void cooperatePlayerMakeMove() {
        CooperatePlayer player = new CooperatePlayer();

        Move actual = player.makeMove();
        Move expected = Move.COOPERATE;
        assertEquals(expected, actual);
    }

    @Test
    public void scoreForCooperatePlayerAndOtherPlayerCooperate() {
        Player player = new CooperatePlayer();

        player.makeMove();
        player.updateScore(Move.COOPERATE);

        assertEquals(2, player.getPoints());
    }

    @Test
    public void scoreForCooperatePlayerAndOtherPlayerCheat() {
        Player player = new CooperatePlayer();

        player.makeMove();
        player.updateScore(Move.CHEAT);

        assertEquals(-1, player.getPoints());
    }
}
