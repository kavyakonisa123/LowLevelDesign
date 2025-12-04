package com.tictactoe.design;

public interface WinStrategy {
	
	public boolean checkWin(Board board, Move move, int k);

}
