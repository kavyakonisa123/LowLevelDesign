package com.tictactoe.design;

import java.util.Arrays;
import java.util.List;

import com.tictactoe.design.strategy.ColumnWinStrategy;
import com.tictactoe.design.strategy.DiagonalWinStrategy;
import com.tictactoe.design.strategy.RowWinStrategy;
import com.tictactoe.design.strategy.WinStrategy;


public class RuleEngine {
	
	private final List<WinStrategy> strategies;

	public RuleEngine() {
		strategies = Arrays.asList(
				new RowWinStrategy(),
				new ColumnWinStrategy(),
				new DiagonalWinStrategy());
				
	}
	
	public GameState evaluate(Board board, Move move, int k) {
		for(WinStrategy s: strategies) {
			if(s.checkWin(board, move,k)) {
				return GameState.WIN;
			}
		}
		
		if(board.isFull()) return GameState.DRAW;
		
		
		return GameState.CONTINUE;
	}
	
	
	

}
