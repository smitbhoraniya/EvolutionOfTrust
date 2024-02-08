import org.example.Tournament;
import org.example.player.CheatPlayer;
import org.example.player.CooperatePlayer;
import org.example.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TournamentTest {
    @Test
    public void lessThanFivePlayer() {
        Tournament tournament = new Tournament();

        assertThrows(Exception.class, () -> tournament.play(0));
    }

    @Test
    public void numberOfRoundEqualsZero() {
        Player player1 = new CheatPlayer();
        Player player2 = new CheatPlayer();
        Player player3 = new CheatPlayer();
        Player player4 = new CheatPlayer();
        Player player5 = new CheatPlayer();
        Tournament tournament = new Tournament();
        tournament.enroll(player1);
        tournament.enroll(player2);
        tournament.enroll(player3);
        tournament.enroll(player4);
        tournament.enroll(player5);

        assertThrows(Exception.class, () -> tournament.play(0));
    }

    @Test
    public void allPlayerAreSameInTournament() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CheatPlayer());
        Player player5 = spy(new CheatPlayer());
        Tournament tournament = new Tournament();
        tournament.enroll(player1);
        tournament.enroll(player2);
        tournament.enroll(player3);
        tournament.enroll(player4);
        tournament.enroll(player5);

        tournament.play(1);

        assertTrue(tournament.allPlayersSame());
        verify(player1, times(0)).gain();
        verify(player1, times(0)).invest();
        verify(player2, times(0)).gain();
        verify(player2, times(0)).invest();
        verify(player3, times(0)).gain();
        verify(player3, times(0)).invest();
        verify(player4, times(0)).gain();
        verify(player4, times(0)).invest();
        verify(player5, times(0)).gain();
        verify(player5, times(0)).invest();
    }

    @Test
    public void atTheEndOfTournamentAllPlayerShouldBeSame() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CheatPlayer());
        Player player5 = spy(new CooperatePlayer());
        Tournament tournament = new Tournament();
        tournament.enroll(player1);
        tournament.enroll(player2);
        tournament.enroll(player3);
        tournament.enroll(player4);
        tournament.enroll(player5);

        tournament.play(1);

        assertTrue(tournament.allPlayersSame());
        verify(player1, times(1)).gain();
        verify(player1, times(0)).invest();
        verify(player2, times(1)).gain();
        verify(player2, times(0)).invest();
        verify(player3, times(1)).gain();
        verify(player3, times(0)).invest();
        verify(player4, times(1)).gain();
        verify(player4, times(0)).invest();
        verify(player5, times(0)).gain();
        verify(player5, times(4)).invest();
    }

    @Test
    public void atTheEndOfTournamentAllPlayerShouldBeSameTest2() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CheatPlayer());
        Player player5 = spy(new CheatPlayer());
        Player player6 = spy(new CooperatePlayer());
        Player player7 = spy(new CooperatePlayer());
        Player player8 = spy(new CooperatePlayer());
        Player player9 = spy(new CooperatePlayer());
        Player player10 = spy(new CooperatePlayer());
        Tournament tournament = new Tournament();
        tournament.enroll(player1);
        tournament.enroll(player2);
        tournament.enroll(player3);
        tournament.enroll(player4);
        tournament.enroll(player5);
        tournament.enroll(player6);
        tournament.enroll(player7);
        tournament.enroll(player8);
        tournament.enroll(player9);
        tournament.enroll(player10);

        tournament.play(1);

        verify(player1, times(5)).gain();
        verify(player1, times(0)).invest();
        verify(player2, times(5)).gain();
        verify(player2, times(0)).invest();
        verify(player3, times(5)).gain();
        verify(player3, times(0)).invest();
        verify(player4, times(5)).gain();
        verify(player4, times(0)).invest();
        verify(player5, times(5)).gain();
        verify(player5, times(0)).invest();
        verify(player6, times(4)).gain();
        verify(player6, times(9)).invest();
        verify(player7, times(4)).gain();
        verify(player7, times(9)).invest();
        verify(player8, times(4)).gain();
        verify(player8, times(9)).invest();
        verify(player9, times(4)).gain();
        verify(player9, times(9)).invest();
        verify(player10, times(4)).gain();
        verify(player10, times(9)).invest();
    }
}
