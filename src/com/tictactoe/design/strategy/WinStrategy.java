package com.tictactoe.design.strategy;

import com.tictactoe.design.Board;
import com.tictactoe.design.Move;

public interface WinStrategy {
	
	public boolean checkWin(Board board, Move move, int k);

}
