import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CopyKittenPlayerTest {
    @Test
    public void copycatPlayerInitialMove() {
        CopyKittenPlayer player = new CopyKittenPlayer();

        assertEquals(Move.COOPERATE, player.makeMove());
    }

    @Test
    public void copyKittenPlayerFirstMoveWithCooperatePlayer() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cooperatePlayer);

        transaction.evaluate(2);

        assertNull(transaction.winner());
    }

    @Test
    public void copyKittenPlayerFirstMoveWithCheatPlayer() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        transaction.evaluate(2);

        assertEquals(cheatPlayer, transaction.winner());
    }

    @Test
    public void copyKittenPlayerSecondMoveWithCooperatePlayer() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cooperatePlayer);

        transaction.evaluate(2);

        assertNull(transaction.winner());
    }

    @Test
    public void copyKittenPlayerSecondMoveWithCheatPlayer() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        transaction.evaluate(2);

        assertEquals(cheatPlayer, transaction.winner());
    }

    @Test
    public void transactionBetweenCopyKittenAndCooperatePlayer() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cooperatePlayer);

        transaction.evaluate(5);

        assertNull(transaction.winner());
    }

    @Test
    public void transactionBetweenCopyKittenAndCheatPlayer() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        transaction.evaluate(5);

        assertEquals(cheatPlayer, transaction.winner());
    }
}
