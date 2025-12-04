package com.tictactoe.design;

public class kInARowStrategy implements WinStrategy {

	@Override
	public boolean checkWin(Board board, Move move, int k) {

		int col = move.getCol();
		int row= move.getRow();
		Player player = move.getPlayer();


        return  checkDirection(board,player, row, col, k, 0, 1)  ||
        		checkDirection(board,player, row, col, k, 1, 0 ) ||
        		checkDirection(board,player, row, col, k, 1, 1)  ||
        		checkDirection(board,player, row, col, k, 1, -1);
    }


	private boolean checkDirection(Board board, Player player, int row, int col, int k,int dRow, int dCol) {
		int count = 1; // include the current move

        // check in + direction
        count += countCells(board, player, row, col, dRow, dCol);

        // check in - direction
        count += countCells(board, player, row, col, -dRow, -dCol);

        return count >= k;

	}

	private int countCells(Board board, Player player, int row, int col, int dRow, int dCol) {
		int count=0;
		int n = board.getBoardSize();
		row += dRow;
		col += dCol;
		
		while(row >= 0 && row < n && col >= 0 && col < n) {
            Cell cell = board.getCell(row, col);
			if(cell.getPlayer()!=null && cell.getPlayer().getPlayerId().equals(player.getPlayerId())) {
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
