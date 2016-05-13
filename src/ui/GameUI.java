package ui;

import exceptions.GameOverException;
import exceptions.InvalidMoveException;
import models.Board;
import models.CellVal;
import models.Game;

import java.util.Scanner;

/**
 * Created by Prayansh on 2016-05-11.
 */
public class GameUI {
    public static void main(String[] args) {
        Game g = new Game();
        System.out.print(printBoards(g));
        Scanner sc = new Scanner(System.in);
        CellVal player = CellVal.X;
        do {
            if (g.getContextBoard() == -1) {
                System.out.print("Enter Context Board: ");
                int context = sc.nextInt();
                g.setContextBoard(context);
            }
            System.out.println("Context Board: " + g.getContextBoard());
            System.out.println("Player " + player);
            System.out.println("Choose index:  ");
            int index = sc.nextInt();
            try {
                g.playMove(player, index);
            } catch (InvalidMoveException e) {
                System.out.println("Invalid Move!");
                continue;
            } catch (GameOverException e) {
                System.out.println("Game over");
                e.printStackTrace();
                break;
            }
            if (player == CellVal.X)
                player = CellVal.O;
            else
                player = CellVal.X;
            System.out.print(printBoards(g));
        } while (!g.checkWinner(player));
    }

    //fixme better implementation
    private static String printBoards(Game g) {
        Board[] boards = g.getBoards();
        String s = "";
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    s += boards[i].cellAt(k, j) + " ";
                }
                if (i != 2)
                    s += "| ";
            }
            s += "\n";
        }
        s += "------|-------|------\n";
        for (int k = 0; k < 3; k++) {
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    s += boards[i].cellAt(k, j) + " ";
                }
                if (i != 5)
                    s += "| ";
            }
            s += "\n";
        }
        s += "------|-------|------\n";
        for (int k = 0; k < 3; k++) {
            for (int i = 6; i < 9; i++) {
                for (int j = 0; j < 3; j++) {
                    s += boards[i].cellAt(k, j) + " ";
                }
                if (i != 8)
                    s += "| ";
            }
            s += "\n";
        }
        return s;
    }
}
