package com.tictactoe.design.observer;

import java.util.*;

import com.tictactoe.design.GameState;
import com.tictactoe.design.Player;

public class StatsBoard implements GameObserver {

    private Map<String, Integer> wins = new HashMap<>();
    private Map<String, Integer> losses = new HashMap<>();
    private int draws = 0;

    @Override
    public void onGameEnd(GameState state, Player winner) {

        if (state == GameState.WIN) {
            wins.put(winner.getPlayerId(), wins.getOrDefault(winner.getPlayerId(), 0) + 1);

            // mark the other player as loser
            String loser = winner.getPlayerId().equals("X") ? "O" : "X";
            losses.put(loser, losses.getOrDefault(loser, 0) + 1);
        }

        if (state == GameState.DRAW) {
            draws++;
        }

        printStats();
    }

    private void printStats() {
        System.out.println("===== Stats Board =====");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("=======================");
    }

}
