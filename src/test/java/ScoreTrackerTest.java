import org.example.Move;
import org.example.ScoreTracker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTrackerTest {
    @Test
    public void updateScoreForBothPlayerCheatMove() {
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.update(Move.CHEAT, Move.CHEAT);

        assertEquals(0, scoreTracker.winner());
    }

    @Test
    public void updateScoreForBothPlayerCooperateMove() {
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.update(Move.COOPERATE, Move.COOPERATE);

        assertEquals(0, scoreTracker.winner());
    }

    @Test
    public void updateScoreForOnePlayerCheatMoveAndOtherPlayerCooperateMove() {
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.update(Move.CHEAT, Move.COOPERATE);

        assertEquals(1, scoreTracker.winner());
    }

    @Test
    public void updateScoreForOnePlayerCooperateMoveAndOtherPlayerCheatMove() {
        ScoreTracker scoreTracker = new ScoreTracker();

        scoreTracker.update(Move.COOPERATE, Move.CHEAT);

        assertEquals(-1, scoreTracker.winner());
    }
}
