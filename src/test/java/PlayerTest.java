import org.example.Move;
import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    public void validPlayer() {
        assertDoesNotThrow(Player::new);
    }

    @Test
    public void scoreForOurPlayerCheatAndOtherPlayerCooperate() {
        Player player1 = new Player();

        player1.updateScore(Move.CHEAT, Move.COOPERATE);

        assertEquals(3, player1.getScore());
    }

    @Test
    public void scoreForOurPlayerCheatAndOtherPlayerCheat() {
        Player player1 = new Player();

        player1.updateScore(Move.CHEAT, Move.CHEAT);

        assertEquals(0, player1.getScore());
    }

    @Test
    public void scoreForOurPlayerCooperateAndOtherPlayerCooperate() {
        Player player1 = new Player();

        player1.updateScore(Move.COOPERATE, Move.COOPERATE);

        assertEquals(2, player1.getScore());
    }

    @Test
    public void scoreForOurPlayerCooperateAndOtherPlayerCheat() {
        Player player1 = new Player();

        player1.updateScore(Move.COOPERATE, Move.CHEAT);

        assertEquals(-1, player1.getScore());
    }
}
