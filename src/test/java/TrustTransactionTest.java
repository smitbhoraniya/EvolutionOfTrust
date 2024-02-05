import org.example.CheatPlayer;
import org.example.CooperatePlayer;
import org.example.Player;
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
}
