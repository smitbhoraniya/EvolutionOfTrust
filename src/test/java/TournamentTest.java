import org.example.Tournament;
import org.example.player.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
        Tournament tournament = new Tournament(player1, player2, player3, player4, player5);

        assertThrows(Exception.class, () -> tournament.play(0));
    }

    @Test
    public void allPlayerAreSameInTournament() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CheatPlayer());
        Player player5 = spy(new CheatPlayer());
        Tournament tournament = new Tournament(player1, player2, player3, player4, player5);

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
    public void allPlayerAreNotSameInTournament() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CheatPlayer());
        Player player5 = spy(new CooperatePlayer());
        Tournament tournament = new Tournament(player1, player2, player3, player4, player5);

        assertFalse(tournament.allPlayersSame());
    }

    @Test
    public void atTheEndOfTournamentAllPlayerShouldBeSame() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CheatPlayer());
        Player player5 = spy(new CooperatePlayer());
        Tournament tournament = new Tournament(player1, player2, player3, player4, player5);

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
        Tournament tournament = new Tournament(player1, player2, player3, player4, player5, player6, player7, player8, player9, player10);

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

    @Test
    public void multipleRoundTest() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CheatPlayer());
        Player player3 = spy(new CheatPlayer());
        Player player4 = spy(new CooperatePlayer());
        Player player5 = spy(new CooperatePlayer());
        Tournament tournament = new Tournament(player1, player2, player3, player4, player5);

        List<Player> players = tournament.play(2);

        assertEquals(CheatPlayer.class, players.get(0).getClass());
        assertEquals(CheatPlayer.class, players.get(1).getClass());
        assertEquals(CheatPlayer.class, players.get(2).getClass());
        assertEquals(CheatPlayer.class, players.get(3).getClass());
        assertEquals(CheatPlayer.class, players.get(4).getClass());
        assertTrue(tournament.allPlayersSame());
        verify(player1, times(2)).gain();
        verify(player1, times(0)).invest();
        verify(player2, times(2)).gain();
        verify(player2, times(0)).invest();
        verify(player3, times(2)).gain();
        verify(player3, times(0)).invest();
        verify(player4, times(1)).gain();
        verify(player4, times(4)).invest();
        verify(player5, times(1)).gain();
        verify(player5, times(4)).invest();
    }

    @Test
    public void tournamentWithVariousPlayer() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new CooperatePlayer());
        Player player3 = spy(new CopyCatPlayer());
        Player player4 = spy(new CopyKittenPlayer());
        Player player5 = spy(new GrudgePlayer());
        Tournament tournament = new Tournament(player1, player2, player3, player4, player5);

        List<Player> firstRoundPlayers = tournament.play(1);

        assertEquals(CheatPlayer.class, firstRoundPlayers.get(0).getClass());
        assertEquals(CheatPlayer.class, firstRoundPlayers.get(1).getClass());
        assertEquals(GrudgePlayer.class, firstRoundPlayers.get(2).getClass());
        assertEquals(GrudgePlayer.class, firstRoundPlayers.get(3).getClass());
        assertEquals(CopyCatPlayer.class, firstRoundPlayers.get(4).getClass());

        List<Player> secondRoundPlayers = tournament.play(1);

        assertEquals(CheatPlayer.class, secondRoundPlayers.get(0).getClass());
        assertEquals(CheatPlayer.class, secondRoundPlayers.get(1).getClass());
        assertEquals(CheatPlayer.class, secondRoundPlayers.get(2).getClass());
        assertEquals(CheatPlayer.class, secondRoundPlayers.get(3).getClass());
        assertEquals(GrudgePlayer.class, secondRoundPlayers.get(4).getClass());

        List<Player> thirdRoundPlayers = tournament.play(1);

        assertEquals(CheatPlayer.class, thirdRoundPlayers.get(0).getClass());
        assertEquals(CheatPlayer.class, thirdRoundPlayers.get(1).getClass());
        assertEquals(CheatPlayer.class, thirdRoundPlayers.get(2).getClass());
        assertEquals(CheatPlayer.class, thirdRoundPlayers.get(3).getClass());
        assertEquals(CheatPlayer.class, thirdRoundPlayers.get(4).getClass());
    }

    @Test
    public void tournamentWithVariousPlayerTestTwo() throws Exception {
        Player player1 = spy(new CheatPlayer());
        Player player2 = spy(new DetectivePlayer());
        Player player3 = spy(new CopyCatPlayer());
        Player player4 = spy(new CopyKittenPlayer());
        Player player5 = spy(new GrudgePlayer());
        Tournament tournament = new Tournament(player1, player2, player3, player4, player5);

        List<Player> firstRoundPlayers = tournament.play(1);

        assertEquals(CheatPlayer.class, firstRoundPlayers.get(0).getClass());
        assertEquals(CheatPlayer.class, firstRoundPlayers.get(1).getClass());
        assertEquals(CopyCatPlayer.class, firstRoundPlayers.get(2).getClass());
        assertEquals(CopyCatPlayer.class, firstRoundPlayers.get(3).getClass());
        assertEquals(DetectivePlayer.class, firstRoundPlayers.get(4).getClass());

        List<Player> secondRoundPlayers = tournament.play(1);

        assertEquals(CheatPlayer.class, secondRoundPlayers.get(0).getClass());
        assertEquals(CheatPlayer.class, secondRoundPlayers.get(1).getClass());
        assertEquals(CheatPlayer.class, secondRoundPlayers.get(2).getClass());
        assertEquals(CheatPlayer.class, secondRoundPlayers.get(3).getClass());
        assertEquals(CopyCatPlayer.class, secondRoundPlayers.get(4).getClass());

        List<Player> thirdRoundPlayers = tournament.play(1);

        assertEquals(CheatPlayer.class, thirdRoundPlayers.get(0).getClass());
        assertEquals(CheatPlayer.class, thirdRoundPlayers.get(1).getClass());
        assertEquals(CheatPlayer.class, thirdRoundPlayers.get(2).getClass());
        assertEquals(CheatPlayer.class, thirdRoundPlayers.get(3).getClass());
        assertEquals(CheatPlayer.class, thirdRoundPlayers.get(4).getClass());
    }
}
