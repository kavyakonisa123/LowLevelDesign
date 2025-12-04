package com.tictactoe.design;

public class TicTacToeDemo {
    public static void main(String[] args) {
        Player p1 = new Player("X", 'X');
        Player p2 = new Player("O", 'O');
        int N = 5;
    	int k = 3;

        Game game = new Game(p1, p2,N,k);
        game.start();
    }
}
