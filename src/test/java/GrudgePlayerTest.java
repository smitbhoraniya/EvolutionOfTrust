import org.example.*;
import org.example.player.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrudgePlayerTest {
    @Test
    public void grudgePlayerInitialMove() {
        GrudgePlayer player = new GrudgePlayer();

        assertEquals(Move.COOPERATE, player.makeMove());
    }

    @Test
    public void grudgePlayerWhenInvestAndMakeMove() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        grudgePlayer.invest();

        assertEquals(Move.CHEAT, grudgePlayer.makeMove());
    }

    @Test
    public void grudgePlayerWhenGainAndMakeMove() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        grudgePlayer.gain();

        assertEquals(Move.COOPERATE, grudgePlayer.makeMove());
    }

    @Test
    public void grudgePlayerWhenGainAndInvestAndMakeMove() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        grudgePlayer.gain();
        grudgePlayer.invest();

        assertEquals(Move.CHEAT, grudgePlayer.makeMove());
    }

    @Test
    public void expecteTheCheatEveryTimeAfterGrudgePlayerGotCheated() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        assertEquals(Move.COOPERATE, grudgePlayer.makeMove());
        grudgePlayer.invest();

        assertEquals(Move.CHEAT, grudgePlayer.makeMove());
        assertEquals(Move.CHEAT, grudgePlayer.makeMove());
    }

    @Test
    public void expecteTheCooperateEveryTimeIfGrudgePlayerNotGotCheated() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();

        assertEquals(Move.COOPERATE, grudgePlayer.makeMove());
        assertEquals(Move.COOPERATE, grudgePlayer.makeMove());
        assertEquals(Move.COOPERATE, grudgePlayer.makeMove());
    }
}
