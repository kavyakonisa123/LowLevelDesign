package com.tictactoe.design;

public class Board {
	private final int boardSize;

	private final Cell[][] grid;
	int count=0;
	public Board(int boardSize) {
		this.boardSize = boardSize;
		this.grid = new Cell[boardSize][boardSize];

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				grid[i][j] = new Cell();
			}
		}
	}

	public int getBoardSize() {
		return boardSize;
	}

	public Cell getCell(int row, int col) {
		return grid[row][col];

	}

	public void setCell(int row, int col, Player player) {
		grid[row][col].setPlayer(player);
		count++;
		

	}

	public boolean isCellEmpty(int row, int col) {
		return grid[row][col].isEmpty();

	}

	public void clearCell(int row, int col) {
		grid[row][col].clear();
		count--;
	}

	public void printBoard() {

		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				Player p = grid[i][j].getPlayer();
				System.out.print(p == null ? "-" : p.getSymbol());
				System.out.print(" ");
			}
			System.out.println();
		}

	}

	public boolean isFull() {
		
		return (count == (boardSize*boardSize));
	}

}
