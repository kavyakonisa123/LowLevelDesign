package com.tictactoe.design.observer;

import java.util.*;

import com.tictactoe.design.GameState;
import com.tictactoe.design.Player;

public class ScoreBoard implements GameObserver{
    private Map<String, Integer> wins = new HashMap<>();

	@Override
	public void onGameEnd(GameState state, Player winner) {
		if(state== GameState.WIN) {
			wins.put(winner.getPlayerId() , wins.getOrDefault(winner.getPlayerId(),0)+1);
		}
		printScores();
		
//		if(state== GameState.DRAW) {
//			wins.put(winner.getPlayerId()+ " " +winner.getSymbol() , wins.getOrDefault(winner.getPlayerId()+ " " +winner.getSymbol() ,0)+1);
//		}
//		printScores();
		
	}

	private void printScores() {
		System.out.println("===== Scoreboard =====");
        wins.forEach((player, count) -> 
            System.out.println("Player " + player + " wins: " + count)
        );
        System.out.println("======================");
    }
		
}

