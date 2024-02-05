import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GrudgePlayerTest {
    @Test
    public void copycatPlayerInitialMove() {
        GrudgePlayer player = new GrudgePlayer();

        assertEquals(Move.COOPERATE, player.makeMove());
    }

    @Test
    public void copycatPlayerFirstMoveWithCooperatePlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cooperatePlayer);

        transaction.evaluate(1);

        assertNull(transaction.winner());
    }

    @Test
    public void copycatPlayerFirstMoveWithCheatPlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cheatPlayer);

        transaction.evaluate(1);

        assertEquals(cheatPlayer, transaction.winner());
    }

    @Test
    public void copycatPlayerSecondMoveWithCooperatePlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cooperatePlayer);

        transaction.evaluate(2);

        assertNull(transaction.winner());
    }

    @Test
    public void copycatPlayerSecondMoveWithCheatPlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cheatPlayer);

        transaction.evaluate(2);

        assertEquals(cheatPlayer, transaction.winner());
    }

    @Test
    public void transactionBetweenCopycatAndCooperatePlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cooperatePlayer);

        transaction.evaluate(5);

        assertNull(transaction.winner());
    }

    @Test
    public void transactionBetweenCopycatAndCheatPlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cheatPlayer);

        transaction.evaluate(5);

        assertEquals(cheatPlayer, transaction.winner());
    }
}
