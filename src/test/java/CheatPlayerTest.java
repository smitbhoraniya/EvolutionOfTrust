import org.example.CheatPlayer;
import org.example.Move;
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
}
