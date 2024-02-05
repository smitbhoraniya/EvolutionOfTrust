import org.example.CheatPlayer;
import org.example.CooperatePlayer;
import org.example.Player;
import org.example.TrustTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrustTransactionTest {
    @Test
    public void transactionBetweenTwoCheatPlayers() {
        Player player1 = new CheatPlayer();
        Player player2 = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(player1, player2);

        transaction.evaluate(5);

        assertEquals(0, player1.getPoints());
        assertEquals(0, player2.getPoints());
    }

    @Test
    public void transactionBetweenTwoCooperatePlayers() {
        Player player1 = new CooperatePlayer();
        Player player2 = new CooperatePlayer();
        TrustTransaction transaction = new TrustTransaction(player1, player2);

        transaction.evaluate(5);

        assertEquals(10, player1.getPoints());
        assertEquals(10, player2.getPoints());
    }

    @Test
    public void transactionBetweenCooperatePlayersAndCheatPlayer() {
        Player player1 = new CooperatePlayer();
        Player player2 = new CheatPlayer();
        TrustTransaction transaction = new TrustTransaction(player1, player2);

        transaction.evaluate(5);

        assertEquals(-5, player1.getPoints());
        assertEquals(15, player2.getPoints());
    }
}
