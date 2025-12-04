package com.tictactoe.design;

public class Cell {
	private Player player;
	
	
	public Cell() {
		this.player = null;
	}

	
	public Player getPlayer() {
		return player;
	}



	public void setPlayer(Player player) {
		this.player = player;
	}



	public boolean isEmpty() {
		return player == null;
		
	}
	
	 public void clear() {
	        this.player = null; // useful for undo
	    }
	
	

}
