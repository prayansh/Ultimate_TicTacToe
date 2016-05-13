package models;

import exceptions.GameOverException;
import exceptions.InvalidMoveException;

/**
 * Created by Prayansh on 2016-05-11.
 */
public class Game {
    private Board[] boards;
    private Board equivalent; // The board equivalent of the game
    private int contextBoard;

    public Game() {
        boards = new Board[9];
        equivalent = new Board();
        for (int i = 0; i < boards.length; i++) {
            boards[i] = new Board();
        }
        contextBoard = -1;
    }

    public Board getInContextBoard() {
        return boards[contextBoard];
    }

    public int getContextBoard() {
        return contextBoard;
    }

    /**
     * To be called for first move to decide starting context board
     */
    public void setContextBoard(int val) {
        contextBoard = val;
    }

    /**
     * Place the player at position in context board
     * update equivalent board
     * produce the next context board, if valid move
     * contextboard = -1 if free hit
     */
    public int playMove(CellVal player, int position) throws InvalidMoveException, GameOverException {
        if (boards[contextBoard].solved())
            contextBoard = -1;
        boolean valid = boards[contextBoard].setCellAt(position, player);
        if (!valid)
            throw new InvalidMoveException("Invalid Move for Player " + player.name() + ":" + position);
        contextBoard = position;
        updateBoards();
        if (checkWinner(player))
            throw new GameOverException("Player " + player.name() + " has won");
        return contextBoard;
    }

    public boolean checkWinner(CellVal player) {
        return equivalent.winner() == player;
    }

    private void updateBoards() {
        for (int i = 0; i < 9; i++) {
            if (boards[i].solved()) {
                CellVal winner = boards[i].winner();
                equivalent.setCellAt(i, winner);
            }
        }
    }

    public Board[] getBoards() {
        return boards;
    }

    public Board getEquivalent() {
        return equivalent;
    }
}
