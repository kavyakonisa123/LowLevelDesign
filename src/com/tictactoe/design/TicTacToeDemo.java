package com.tictactoe.design;

import java.util.List;
import java.util.Scanner;

import com.tictactoe.design.observer.*;

public class TicTacToeDemo {
    public static void main(String[] args) {
        Player p1 = new Player("X", 'X');
        Player p2 = new Player("O", 'O');
        int N = 3;
    	int k = 3;

        ScoreBoard scoreboard = new ScoreBoard();
        StatsBoard statsboard = new StatsBoard();
        int numberOfGames = 5;
        Scanner sc = new Scanner(System.in);


        while (numberOfGames > 0) {

        	System.out.println("Startng new game");
        	Game game = new Game(p1, p2, N, k);
            game.registerObserver(scoreboard);
            game.registerObserver(statsboard);
            game.start(sc);
            numberOfGames--;
        	
        }
        sc.close();
//        
//        List<String> steps = List.of(
//        	    "0,0", 
//        	    "1,1", 
//        	    "undo",
//        	    "redo",
//        	    "0,1",
//        	    "2,2",
//        	    "undo",
//        	    "0,2",
//        	    "1,2",
//        	    "2,0"
//        	);
//
//        for (String step : steps) {
//
//            if (step.equals("undo")) {
//                game.undo();
//                continue;
//            }
//
//            if (step.equals("redo")) {
//                game.redo();
//                continue;
//            }
//
//            // otherwise it's a move
//            String[] parts = step.split(",");
//            int row = Integer.parseInt(parts[0]);
//            int col = Integer.parseInt(parts[1]);
//
//            GameState state = game.playMove(row, col);
//
//            if (state == GameState.WIN || state == GameState.DRAW) {
//                break;
//            }
//        }

    }
}
