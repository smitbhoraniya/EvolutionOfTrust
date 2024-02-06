import org.example.Move;
import org.example.ScoreTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTrackerTest {
    @Test
    public void updateScoreForBothPlayerCheatMove() {
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.updateScores(Move.CHEAT, Move.CHEAT);

        assertEquals(0, scoreTracker.getPlayerOneScore());
        assertEquals(0, scoreTracker.getPlayerTwoScore());
    }

    @Test
    public void updateScoreForBothPlayerCooperateMove() {
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.updateScores(Move.COOPERATE, Move.COOPERATE);

        assertEquals(2, scoreTracker.getPlayerOneScore());
        assertEquals(2, scoreTracker.getPlayerTwoScore());
    }

    @Test
    public void updateScoreForOnePlayerCheatMoveAndOtherPlayerCooperateMove() {
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.updateScores(Move.CHEAT, Move.COOPERATE);

        assertEquals(3, scoreTracker.getPlayerOneScore());
        assertEquals(-1, scoreTracker.getPlayerTwoScore());
    }

    @Test
    public void updateScoreForOnePlayerCooperateMoveAndOtherPlayerCheatMove() {
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.updateScores(Move.COOPERATE, Move.CHEAT);

        assertEquals(-1, scoreTracker.getPlayerOneScore());
        assertEquals(3, scoreTracker.getPlayerTwoScore());
    }
}
