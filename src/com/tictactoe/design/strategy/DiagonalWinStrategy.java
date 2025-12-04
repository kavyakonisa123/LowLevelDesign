package com.tictactoe.design.strategy;

import com.tictactoe.design.Board;
import com.tictactoe.design.Move;
import com.tictactoe.design.Player;

public class DiagonalWinStrategy  implements WinStrategy {

	@Override
	public boolean checkWin(Board board, Move move, int k) {

		int col = move.getCol();
		int row= move.getRow();
		Player player = move.getPlayer();

		// Check MAIN diagonal (\ direction)
        if (checkMainDiagonal(board, player, row, col, k)) {
            return true;
        }

        // Check ANTI diagonal (/ direction)
        if (checkAntiDiagonal(board, player, row, col, k)) {
            return true;
        }

        return false;
    }

	private boolean checkMainDiagonal(Board board, Player player, int row, int col, int k) {
		int count = 1; // include the current move

        // go up-left (-1, -1)
        count += countDirection(board, player, row, col, -1, -1);

        // go down-right (+1, +1)
        count += countDirection(board, player, row, col, +1, +1);

        return count >= k;
	}

	private boolean checkAntiDiagonal(Board board, Player player, int row, int col, int k) {
		int count = 1; // include the current move

        // go up-right (-1, +1)
        count += countDirection(board, player, row, col, -1, +1);

        // go down-left (+1, -1)
        count += countDirection(board, player, row, col, +1, -1);

        return count >= k;

	}

	private int countDirection(Board board, Player player, int row, int col, int dRow, int dCol) {
		int count=0;
		int n = board.getBoardSize();
		row += dRow;
		col += dCol;
		
		while(row >= 0 && row < n && col >= 0 && col < n) {
			Player p =  board.getCell(row, col).getPlayer();
			if(p!=null && p.getPlayerId().equals(player.getPlayerId())) {
				count++;
			}
			else {
				break;
			}
			
			row +=dRow;
			col +=dCol;
			
		}
		
		return count;
		
	}
	
}
	