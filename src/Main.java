
/*
  @author   george
  @project   Default (Template) Project
  @class  ${NAME}
  @version  1.0.0 
  @since 12.04.24 - 20.46
*/

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static char[][] board;
    static char turn;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        board = new char[3][3];
        turn = 'X';
        initializeBoard();

        System.out.println(" Game. Insert row ENTER column ENTER");
        printBoard();

        while (true) {
            System.out.println("Move player " + turn + "Insert row ENTER column ENTER:");
            int row = scan.nextInt() - 1;
            int col = scan.nextInt() - 1;

            if (board[row][col] == 'X' || board[row][col] == 'O') {
                System.out.println("This place is already occupied. Try again.");
                continue;
            }

            board[row][col] = turn;

            if (gameOver(row, col)) {
                System.out.println("GAMEOVER !!! Player " + turn + " wins!");
                break;
            }

            printBoard();
            if (turn == 'X') {
                turn = 'O';
            } else {
                turn = 'X';
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " | ");
            }
        }
        System.out.println();
    }

    static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }

    static boolean gameOver(int rMove, int cMove) {
        if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove]) {
            return true;
        }
        if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2]) {
            return true;
        }
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_') {
            return true;
        }
        return false;
    }
}
