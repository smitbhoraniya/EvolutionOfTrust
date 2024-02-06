import org.example.player.*;
import org.example.TrustTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

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
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cooperatePlayer);

        transaction.evaluate(1);

        assertEquals(copyCatPlayer, transaction.winner());
        verify(copyCatPlayer, times(1)).gain();
        verify(cooperatePlayer, times(1)).invest();
    }

    @Test
    public void copycatPlayerFirstMoveWithCheatPlayer() {
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cheatPlayer);

        transaction.evaluate(1);

        assertNull(transaction.winner());
        verify(copyCatPlayer, times(0)).gain();
        verify(cheatPlayer, times(0)).gain();
    }

    @Test
    public void copycatPlayerSecondMoveWithCooperatePlayer() {
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cooperatePlayer);

        transaction.evaluate(2);

        assertEquals(copyCatPlayer, transaction.winner());
        verify(copyCatPlayer, times(2)).gain();
        verify(copyCatPlayer, times(1)).invest();
        verify(cooperatePlayer, times(2)).invest();
        verify(cooperatePlayer, times(1)).gain();
    }

    @Test
    public void copycatPlayerSecondMoveWithCheatPlayer() {
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cheatPlayer);

        transaction.evaluate(2);

        assertNull(transaction.winner());
        verify(copyCatPlayer, times(0)).gain();
        verify(copyCatPlayer, times(0)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(0)).gain();
    }

    @Test
    public void transactionBetweenCopycatAndCooperatePlayer() {
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cooperatePlayer);

        transaction.evaluate(5);

        assertEquals(copyCatPlayer, transaction.winner());
        verify(copyCatPlayer, times(5)).gain();
        verify(copyCatPlayer, times(4)).invest();
        verify(cooperatePlayer, times(5)).invest();
        verify(cooperatePlayer, times(4)).gain();
    }

    @Test
    public void transactionBetweenCopycatAndCheatPlayer() {
        Player copyCatPlayer = spy(new CopyCatPlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyCatPlayer, cheatPlayer);

        transaction.evaluate(5);

        assertNull(transaction.winner());
        verify(copyCatPlayer, times(0)).gain();
        verify(copyCatPlayer, times(0)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(0)).gain();
    }

    // copy kitten
    @Test
    public void copyKittenPlayerFirstMoveWithCooperatePlayer() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cooperatePlayer);

        transaction.evaluate(1);

        assertNull(transaction.winner());
        verify(copyKittenPlayer, times(1)).gain();
        verify(copyKittenPlayer, times(1)).invest();
        verify(cooperatePlayer, times(1)).invest();
        verify(cooperatePlayer, times(1)).gain();
    }

    @Test
    public void copyKittenPlayerFirstMoveWithCheatPlayer() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        transaction.evaluate(1);

        assertEquals(cheatPlayer, transaction.winner());
        verify(copyKittenPlayer, times(0)).gain();
        verify(copyKittenPlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void copyKittenPlayerSecondMoveWithCooperatePlayer() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cooperatePlayer);

        transaction.evaluate(2);

        assertNull(transaction.winner());
        verify(copyKittenPlayer, times(2)).gain();
        verify(copyKittenPlayer, times(2)).invest();
        verify(cooperatePlayer, times(2)).invest();
        verify(cooperatePlayer, times(2)).gain();
    }

    @Test
    public void copyKittenPlayerSecondMoveWithCheatPlayer() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        transaction.evaluate(2);

        assertEquals(cheatPlayer, transaction.winner());
        verify(copyKittenPlayer, times(0)).gain();
        verify(copyKittenPlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void transactionBetweenCopyKittenAndCooperatePlayer() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cooperatePlayer);

        transaction.evaluate(5);

        assertNull(transaction.winner());
        verify(copyKittenPlayer, times(5)).gain();
        verify(copyKittenPlayer, times(5)).invest();
        verify(cooperatePlayer, times(5)).invest();
        verify(cooperatePlayer, times(5)).gain();
    }

    @Test
    public void transactionBetweenCopyKittenAndCheatPlayer() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, cheatPlayer);

        transaction.evaluate(5);

        assertEquals(cheatPlayer, transaction.winner());
        verify(copyKittenPlayer, times(0)).gain();
        verify(copyKittenPlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void transactionBetweenCopyKittenAndCopyCatPlayer() {
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        Player copyCatPlayer = spy(new CopyCatPlayer());
        TrustTransaction transaction = new TrustTransaction(copyKittenPlayer, copyCatPlayer);

        transaction.evaluate(3);

        assertEquals(copyCatPlayer, transaction.winner());
        verify(copyKittenPlayer, times(1)).gain();
        verify(copyKittenPlayer, times(2)).invest();
        verify(copyCatPlayer, times(1)).invest();
        verify(copyCatPlayer, times(2)).gain();
    }

    // grudge
    @Test
    public void grudgePlayerFirstMoveWithCooperatePlayer() {
        Player grudgePlayer = spy(new GrudgePlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cooperatePlayer);

        transaction.evaluate(1);

        assertNull(transaction.winner());
        verify(grudgePlayer, times(1)).gain();
        verify(grudgePlayer, times(1)).invest();
        verify(cooperatePlayer, times(1)).invest();
        verify(cooperatePlayer, times(1)).gain();
    }

    @Test
    public void grudgePlayerFirstMoveWithCheatPlayer() {
        Player grudgePlayer = spy(new GrudgePlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cheatPlayer);

        transaction.evaluate(1);

        assertEquals(cheatPlayer, transaction.winner());
        verify(grudgePlayer, times(0)).gain();
        verify(grudgePlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void grudgePlayerSecondMoveWithCooperatePlayer() {
        Player grudgePlayer = spy(new GrudgePlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cooperatePlayer);

        transaction.evaluate(2);

        assertNull(transaction.winner());
        verify(grudgePlayer, times(2)).gain();
        verify(grudgePlayer, times(2)).invest();
        verify(cooperatePlayer, times(2)).invest();
        verify(cooperatePlayer, times(2)).gain();
    }

    @Test
    public void grudgePlayerSecondMoveWithCheatPlayer() {
        Player grudgePlayer = spy(new GrudgePlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cheatPlayer);

        transaction.evaluate(2);

        assertEquals(cheatPlayer, transaction.winner());
        verify(grudgePlayer, times(0)).gain();
        verify(grudgePlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void transactionBetweenGrudgeAndCooperatePlayer() {
        Player grudgePlayer = spy(new GrudgePlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cooperatePlayer);

        transaction.evaluate(5);

        assertNull(transaction.winner());
        verify(grudgePlayer, times(5)).gain();
        verify(grudgePlayer, times(5)).invest();
        verify(cooperatePlayer, times(5)).invest();
        verify(cooperatePlayer, times(5)).gain();
    }

    @Test
    public void transactionBetweenGrudgeAndCheatPlayer() {
        Player grudgePlayer = spy(new GrudgePlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, cheatPlayer);

        transaction.evaluate(5);

        assertEquals(cheatPlayer, transaction.winner());
        verify(grudgePlayer, times(0)).gain();
        verify(grudgePlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void transactionBetweenGrudgeAndCopyCatPlayer() {
        Player grudgePlayer = spy(new GrudgePlayer());
        Player copyCatPlayer = spy(new CopyCatPlayer());
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, copyCatPlayer);

        transaction.evaluate(3);

        assertNull(transaction.winner());
        verify(grudgePlayer, times(1)).gain();
        verify(grudgePlayer, times(1)).invest();
        verify(copyCatPlayer, times(1)).invest();
        verify(copyCatPlayer, times(1)).gain();
    }

    @Test
    public void transactionBetweenGrudgeAndCopyKittenPlayer() {
        Player grudgePlayer = spy(new GrudgePlayer());
        Player copyKittenPlayer = spy(new CopyKittenPlayer());
        TrustTransaction transaction = new TrustTransaction(grudgePlayer, copyKittenPlayer);

        transaction.evaluate(3);

        assertNull(transaction.winner());
        verify(grudgePlayer, times(3)).gain();
        verify(grudgePlayer, times(3)).invest();
        verify(copyKittenPlayer, times(3)).invest();
        verify(copyKittenPlayer, times(3)).gain();
    }

    // detective
    @Test
    public void detectivePlayerFirstMoveWithCooperatePlayer() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cooperatePlayer);

        transaction.evaluate(1);

        assertNull(transaction.winner());
        verify(detectivePlayer, times(1)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cooperatePlayer, times(1)).invest();
        verify(cooperatePlayer, times(1)).gain();
    }

    @Test
    public void detectivePlayerSecondMoveWithCooperatePlayer() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cooperatePlayer);

        transaction.evaluate(2);

        assertEquals(detectivePlayer, transaction.winner());
        verify(detectivePlayer, times(2)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cooperatePlayer, times(2)).invest();
        verify(cooperatePlayer, times(1)).gain();
    }

    @Test
    public void detectivePlayerTransactionWithCooperatePlayerAndNotGotCheated() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cooperatePlayer = spy(new CooperatePlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cooperatePlayer);

        transaction.evaluate(3);

        assertEquals(detectivePlayer, transaction.winner());
        verify(detectivePlayer, times(3)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cooperatePlayer, times(3)).invest();
        verify(cooperatePlayer, times(1)).gain();
    }

    @Test
    public void detectivePlayerFirstMoveWithCheatPlayer() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cheatPlayer);

        transaction.evaluate(1);

        assertEquals(cheatPlayer, transaction.winner());
        verify(detectivePlayer, times(0)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void detectivePlayerSecondMoveWithCheatPlayer() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cheatPlayer);

        transaction.evaluate(2);

        assertEquals(cheatPlayer, transaction.winner());
        verify(detectivePlayer, times(0)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }

    @Test
    public void detectivePlayerTransactionWithCheatPlayerAndGotCheated() {
        Player detectivePlayer = spy(new DetectivePlayer());
        Player cheatPlayer = spy(new CheatPlayer());
        TrustTransaction transaction = new TrustTransaction(detectivePlayer, cheatPlayer);

        transaction.evaluate(3);

        assertEquals(cheatPlayer, transaction.winner());
        verify(detectivePlayer, times(0)).gain();
        verify(detectivePlayer, times(1)).invest();
        verify(cheatPlayer, times(0)).invest();
        verify(cheatPlayer, times(1)).gain();
    }
}
