package com.tictactoe.design;

import java.util.*;

import com.tictactoe.design.observer.GameObserver;

public class Game {

	private int N;
	private int k;
	private final Player[] players;
	private final RuleEngine ruleEngine;
	private final Board board;
	private Stack<Move> undoStack = new Stack<>();
	private Stack<Move> redoStack = new Stack<>();
	private List<GameObserver> observers = new ArrayList<>();


	private int currentPlayerIndex = 0;

	public Game(Player p1, Player p2, int N, int k) {
		this.players = new Player[] { p1, p2 };
		this.ruleEngine = new RuleEngine();
		this.N=N;
		this.board = new Board(N);
		this.k=k;
	}
	
	public void registerObserver(GameObserver observer) {
	    observers.add(observer);
	}

	public void notifyObservers(GameState state, Player winner) {
	    for (GameObserver obs : observers) {
	        obs.onGameEnd(state, winner);
	    }
	}


	public Player getCurrentPlayer() {
		return players[currentPlayerIndex];
	}

	public void switchTurn() {
		currentPlayerIndex = (currentPlayerIndex + 1) % 2;
	}
	

	public void start(Scanner sc) {

		while (true) {
			board.printBoard();
			Player current = getCurrentPlayer();
			System.out.println("Player " + current.getPlayerId() + "'s turn");
			
			System.out.print("Enter row: ");
			 if (!sc.hasNextInt()) return;  
            int row = sc.nextInt();

            System.out.print("Enter col: ");
            if (!sc.hasNextInt()) return;  
            int col = sc.nextInt();

            if (row < 0 || row >= N || col < 0 || col >= N) {
                System.out.println("Invalid input, try again.");
                continue;
            }


			if (board.isCellEmpty(row, col)) {
				Move move = new Move(current, row, col);

				board.setCell(row, col, current);
				undoStack.push(move);
				redoStack.clear(); 


				GameState state = ruleEngine.evaluate(board, move, k);

				if (state == GameState.WIN) {
					board.printBoard();
					System.out.println("Player " + current.getPlayerId() + " wins!");
				    notifyObservers(GameState.WIN, current);
					break;

				} else if (state == GameState.DRAW) {
					board.printBoard();
					System.out.println("Oops ... Its a Draw!");
				    notifyObservers(GameState.DRAW, current);
					break;
				}
				switchTurn();
			} else {
				System.out.println("Cell already occupied. Try again.");
			}

		}
	}
	
	
	public GameState playMove(int row, int col) {

			Player current = getCurrentPlayer();
			System.out.println("Player " + current.getPlayerId() + "'s turn");
			

            if (row < 0 || row >= N || col < 0 || col >= N) {
                System.out.println("Invalid input, try again.");
                return GameState.CONTINUE;
            }


			if (board.isCellEmpty(row, col)) {
				Move move = new Move(current, row, col);

				board.setCell(row, col, current);
				undoStack.push(move);
				redoStack.clear(); 


				GameState state = ruleEngine.evaluate(board, move, k);
			    board.printBoard();


				if (state == GameState.WIN) {
					System.out.println("Player " + current.getPlayerId() + " wins!");
				    notifyObservers(GameState.WIN, current);

				} else if (state == GameState.DRAW) {
					System.out.println("Oops ... Its a Draw!");
				    notifyObservers(GameState.DRAW, current);

				}
				else switchTurn();
				
				return state;
			} else {
				System.out.println("Cell already occupied. Try again.");
		        return GameState.CONTINUE;

			}

		}

	
	public void undo() {
	    if (undoStack.isEmpty()) {
	        System.out.println("Nothing to undo.");
	        return;
	    }

	    Move lastMove = undoStack.pop();
	    board.clearCell(lastMove.getRow(), lastMove.getCol());
	    redoStack.push(lastMove);

	    switchTurn(); // reverse turn
	}
	
	public void redo() {
	    if (redoStack.isEmpty()) {
	        System.out.println("Nothing to redo.");
	        return;
	    }

	    Move move = redoStack.pop();
	    board.setCell(move.getRow(), move.getCol(), move.getPlayer());
	    undoStack.push(move);

	    switchTurn();
	}

}
