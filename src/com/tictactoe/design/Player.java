package com.tictactoe.design;

public class Player {

	private final String playerId;
	private final char symbol;

	public Player(String playerId, char symbol) {
		this.playerId = playerId;
		this.symbol = symbol;
	}

	public String getPlayerId() {
		return playerId;
	}

	public char getSymbol() {
		return symbol;
	}

	@Override
	public String toString() {
		return "Player{" + "id='" + playerId + '\'' + ", symbol=" + symbol + '}';
	}

}
