import org.example.*;
import org.example.player.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CopyKittenPlayerTest {
    @Test
    public void copycatPlayerInitialMove() {
        CopyKittenPlayer player = new CopyKittenPlayer();

        assertEquals(Move.COOPERATE, player.makeMove());
    }

    @Test
    public void copyKittenPlayerWhenInvestAndMakeMove() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();

        copyKittenPlayer.invest();

        assertEquals(Move.CHEAT, copyKittenPlayer.makeMove());
    }

    @Test
    public void copyKittenPlayerWhenGainAndMakeMove() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();

        copyKittenPlayer.gain();

        assertEquals(Move.COOPERATE, copyKittenPlayer.makeMove());
    }

    @Test
    public void copyKittenPlayerWhenGainAndInvestAndMakeMove() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();

        copyKittenPlayer.invest();
        copyKittenPlayer.gain();

        assertEquals(Move.COOPERATE, copyKittenPlayer.makeMove());
    }
}
