import org.example.player.*;
import org.example.TrustTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TrustTransactionTest {
    @Test
    public void transactionBetweenTwoCheatPlayers() {
        Player player1 = new CheatPlayer();
        Player player2 = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(player1, player2);

        transaction.evaluate(5);

        assertNull(transaction.winner());
    }

    @Test
    public void transactionBetweenTwoCooperatePlayers() {
        Player player1 = new CooperatePlayer();
        Player player2 = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(player1, player2);

        transaction.evaluate(5);

        assertNull(transaction.winner());
    }

    @Test
    public void transactionBetweenCooperatePlayersAndCheatPlayer() {
        Player player1 = new CooperatePlayer();
        Player player2 = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(player1, player2);

        transaction.evaluate(5);

        assertEquals(player2, transaction.winner());
    }

    @Test
    public void transactionBetweenCheatPlayersAndCooperatePlayer() {
        Player player1 = new CheatPlayer();
        Player player2 = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(player1, player2);

        transaction.evaluate(5);

        assertEquals(player1, transaction.winner());
    }

    // copy cat
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

    // copy kitten
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

    @Test
    public void transactionBetweenCopyKittenAndCopyCatPlayer() {
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, copyCatPlayer);

        transaction.evaluate(3);

        assertEquals(copyCatPlayer, transaction.winner());
    }

    // grudge
    @Test
    public void grudgePlayerFirstMoveWithCooperatePlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cooperatePlayer);

        transaction.evaluate(1);

        assertNull(transaction.winner());
    }

    @Test
    public void grudgePlayerFirstMoveWithCheatPlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cheatPlayer);

        transaction.evaluate(1);

        assertEquals(cheatPlayer, transaction.winner());
    }

    @Test
    public void grudgePlayerSecondMoveWithCooperatePlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cooperatePlayer);

        transaction.evaluate(2);

        assertNull(transaction.winner());
    }

    @Test
    public void grudgePlayerSecondMoveWithCheatPlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cheatPlayer);

        transaction.evaluate(2);

        assertEquals(cheatPlayer, transaction.winner());
    }

    @Test
    public void transactionBetweenGrudgeAndCooperatePlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cooperatePlayer);

        transaction.evaluate(5);

        assertNull(transaction.winner());
    }

    @Test
    public void transactionBetweenGrudgeAndCheatPlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cheatPlayer);

        transaction.evaluate(5);

        assertEquals(cheatPlayer, transaction.winner());
    }

    @Test
    public void transactionBetweenGrudgeAndCopyCatPlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CopyCatPlayer copyCatPlayer = new CopyCatPlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, copyCatPlayer);

        transaction.evaluate(3);

        assertNull(transaction.winner());
    }

    @Test
    public void transactionBetweenGrudgeAndCopyKittenPlayer() {
        GrudgePlayer grudgePlayer = new GrudgePlayer();
        CopyKittenPlayer copyKittenPlayer = new CopyKittenPlayer();
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, copyKittenPlayer);

        transaction.evaluate(3);

        assertNull(transaction.winner());
    }

    // detective
    @Test
    public void detectivePlayerFirstMoveWithCooperatePlayer() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cooperatePlayer);

        transaction.evaluate(1);

        assertNull(transaction.winner());
    }

    @Test
    public void detectivePlayerSecondMoveWithCooperatePlayer() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cooperatePlayer);

        transaction.evaluate(2);

        assertEquals(detectivePlayer, transaction.winner());
    }

    @Test
    public void detectivePlayerTransactionWithCooperatePlayerAndNotGotCheated() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();
        CooperatePlayer cooperatePlayer = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cooperatePlayer);

        transaction.evaluate(3);

        assertEquals(detectivePlayer, transaction.winner());
    }

    @Test
    public void detectivePlayerFirstMoveWithCheatPlayer() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cheatPlayer);

        transaction.evaluate(1);

        assertEquals(cheatPlayer, transaction.winner());
    }

    @Test
    public void detectivePlayerSecondMoveWithCheatPlayer() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cheatPlayer);

        transaction.evaluate(2);

        assertEquals(cheatPlayer, transaction.winner());
    }

    @Test
    public void detectivePlayerTransactionWithCheatPlayerAndGotCheated() {
        DetectivePlayer detectivePlayer = new DetectivePlayer();
        CheatPlayer cheatPlayer = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cheatPlayer);

        transaction.evaluate(3);

        assertEquals(cheatPlayer, transaction.winner());
    }
}
