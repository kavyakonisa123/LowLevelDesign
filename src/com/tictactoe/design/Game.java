package com.tictactoe.design;

import java.util.Scanner;

public class Game {

	private int N;
	private int k;
	private final Player[] players;
	private final RuleEngine ruleEngine;
	private final Board board;

	private int currentPlayerIndex = 0;

	public Game(Player p1, Player p2, int N, int k) {
		this.players = new Player[] { p1, p2 };
		this.ruleEngine = new RuleEngine();
		this.N=N;
		this.board = new Board(N);
		this.k=k;
	}

	public Player getCurrentPlayer() {
		return players[currentPlayerIndex];
	}

	public void switchTurn() {
		currentPlayerIndex = (currentPlayerIndex + 1) % 2;
	}

	public void start() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			board.printBoard();
			Player current = getCurrentPlayer();
			System.out.println("Player " + current.getPlayerId() + "'s turn");
			
			System.out.print("Enter row: ");
            int row = sc.nextInt();

            System.out.print("Enter col: ");
            int col = sc.nextInt();

            if (row < 0 || row >= N || col < 0 || col >= N) {
                System.out.println("Invalid input, try again.");
                continue;
            }


			if (board.isCellEmpty(row, col)) {
				Move move = new Move(current, row, col);

				board.setCell(row, col, current);

				GameState state = ruleEngine.evaluate(board, move, k);

				if (state == GameState.WIN) {
					board.printBoard();
					System.out.println("Player " + current.getPlayerId() + " wins!");
					break;

				} else if (state == GameState.DRAW) {
					board.printBoard();
					System.out.println("Oops ... Its a Draw!");
					break;
				}
				switchTurn();
			} else {
				System.out.println("Cell already occupied. Try again.");
			}

		}
		sc.close();
	}
}
