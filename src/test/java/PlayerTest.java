import org.example.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    public void defaultPointsOfPlayer() {
        Player player = new Player();

        assertEquals(0, player.getPoints());
    }
}
