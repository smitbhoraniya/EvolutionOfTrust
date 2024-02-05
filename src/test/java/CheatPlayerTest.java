import org.example.CheatPlayer;
import org.example.Move;
import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheatPlayerTest {
    @Test
    public void cheatPlayerMakeMove() {
        CheatPlayer player = new CheatPlayer();

        Move actual = player.makeMove();
        Move expected = Move.CHEAT;
        assertEquals(expected, actual);
    }

    @Test
    public void scoreForCheatPlayerAndOtherPlayerCooperate() {
        Player player = new CheatPlayer();

        player.makeMove();
        player.updateScore(Move.COOPERATE);

        assertEquals(3, player.getPoints());
    }

    @Test
    public void scoreForCheatPlayerAndOtherPlayerCheat() {
        Player player = new CheatPlayer();

        player.makeMove();
        player.updateScore(Move.CHEAT);

        assertEquals(0, player.getPoints());
    }
}
