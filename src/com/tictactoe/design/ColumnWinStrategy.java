package com.tictactoe.design;

public class ColumnWinStrategy implements WinStrategy {

	@Override
	public boolean checkWin(Board board, Move move, int k) {

		int col = move.getCol();
		Player player = move.getPlayer();

		int count = 0;
		for (int row = 0; row < board.getBoardSize(); row++) {
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
