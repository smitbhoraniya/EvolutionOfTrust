package org.example;

import org.example.player.Player;

import java.util.*;

public class Tournament {
    private final List<Player> players;

    public Tournament(Player... players) {
        this.players = new ArrayList<>(List.of(players));
    }

    public void enroll(Player player) {
        this.players.add(player);
    }

    public List<Player> play(int numberOfRound) throws Exception {
        if (players.size() < 5) {
            throw new Exception("Player count should be greater than 5.");
        }
        if (numberOfRound < 1) {
            throw new Exception("Number of round should be greater than 0.");
        }
        for (int i = 0; i < numberOfRound; i++) {
            if (allPlayersSame()) {
                return this.players;
            }
            transactionBetweenPlayers();
            reproduceTheTopFivePlayer();
            eliminateTheLastFivePlayer();
        }
        return this.players;
    }

    public boolean allPlayersSame() {
        int count = 1;

        for (int i = 1; i < players.size(); i++) {
            if (players.getFirst().getClass() == players.get(i).getClass()) {
                count++;
            }
        }

        return count == players.size();
    }

    private void transactionBetweenPlayers() {
        for (int j = 0; j < players.size(); j++) {
            for (int k = j + 1; k < players.size(); k++) {
                TrustTransaction trustTransaction = new TrustTransaction(this.players.get(j), this.players.get(k));
                trustTransaction.evaluate(1);
            }
        }
    }

    private void reproduceTheTopFivePlayer() {
        players.sort(Comparator.comparing(Player::score));
        List<Player> playerToBeAdded = new ArrayList<>();

        for (int i = 0; i < Math.min(players.size(), 5); i++) {
            Player player = players.get(i);
            Player clonedPlayer = player.clone();
            playerToBeAdded.add(clonedPlayer);
        }

        this.players.addAll(playerToBeAdded);
    }

    private void eliminateTheLastFivePlayer() {
        players.sort(Comparator.comparing(Player::score).reversed());
        int size = players.size();
        List<Player> removedPlayers = players.subList(size - 5, size);
        this.players.removeAll(removedPlayers);
    }
}
