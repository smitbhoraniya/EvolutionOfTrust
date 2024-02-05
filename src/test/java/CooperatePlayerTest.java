import org.example.CooperatePlayer;
import org.example.Move;
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
}
