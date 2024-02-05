import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CopyCatPlayerTest {
    @Test
    public void copycatPlayerInitialMove() {
        CopyCatPlayer player = new CopyCatPlayer();

        assertEquals(Move.CHEAT, player.makeMove());
    }

    @Test
    public void copycatPlayerFirstMoveWithCooperatePlayer() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cooperatePlayer);

        transaction.evaluate(1);

        assertEquals(copyCatPlayer, transaction.winner());
    }

    @Test
    public void copycatPlayerFirstMoveWithCheatPlayer() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cheatPlayer);

        transaction.evaluate(1);

        assertNull(transaction.winner());
    }

    @Test
    public void copycatPlayerSecondMoveWithCooperatePlayer() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cooperatePlayer);

        transaction.evaluate(2);

        assertEquals(copyCatPlayer, transaction.winner());
    }

    @Test
    public void copycatPlayerSecondMoveWithCheatPlayer() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cheatPlayer);

        transaction.evaluate(2);

        assertNull(transaction.winner());
    }

    @Test
    public void transactionBetweenCopycatAndCooperatePlayer() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cooperatePlayer);

        transaction.evaluate(5);

        assertEquals(copyCatPlayer, transaction.winner());
    }

    @Test
    public void transactionBetweenCopycatAndCheatPlayer() {
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cheatPlayer);

        transaction.evaluate(5);

        assertNull(transaction.winner());
    }
}
