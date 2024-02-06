import org.example.*;
import org.example.player.CopyCatPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopyCatPlayerTest {
    @Test
    public void copycatPlayerInitialMove() {
        CopyCatPlayer player = new CopyCatPlayer();

        assertEquals(Move.CHEAT, player.makeMove());
    }

    @Test
    public void copycatPlayerWhenGainAndMakeMove() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();

        copyCatPlayer.gain();

        assertEquals(Move.COOPERATE, copyCatPlayer.makeMove());
    }

    @Test
    public void copycatPlayerWhenInvestAndMakeMove() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();

        copyCatPlayer.invest();

        assertEquals(Move.CHEAT, copyCatPlayer.makeMove());
    }

    @Test
    public void copycatPlayerWhenInvestAndGainAndMakeMove() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();

        copyCatPlayer.invest();

        assertEquals(Move.CHEAT, copyCatPlayer.makeMove());
    }
}
