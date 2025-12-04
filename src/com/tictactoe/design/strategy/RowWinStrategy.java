package com.tictactoe.design.strategy;

import com.tictactoe.design.Board;
import com.tictactoe.design.Move;
import com.tictactoe.design.Player;

public class RowWinStrategy implements WinStrategy {

	@Override
	public boolean checkWin(Board board, Move move, int k) {

		int row = move.getRow();
		Player player = move.getPlayer();

		int count = 0;
		for (int col = 0; col < board.getBoardSize(); col++) {
			Player p = board.getCell(row, col).getPlayer();
			// check the player object on each cell with current player
			if (p != null && p.getPlayerId().equals(player.getPlayerId())) {
				count++;
				if (count >= k)
					return true;
			} else {
				count = 0;
			}

		}
		return false;

	}

}
