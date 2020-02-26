package com.pickurapps;

import java.util.Scanner;

public class Game {
    public static char turn = 'X';
    public static char[][] board = { {'_', '_', '_'}, {'_', '_', '_'}, {'_', '_', '_'} };
    public static int row, col;
    public static Scanner scanner = new Scanner(System.in);

    // prints the board (nicely formatted)
    public static void printBoard() {
        for (int i = 0; i < 3; i++){
            System.out.println();
            for (int j = 0; j < 3; j++){
                if (j == 0)
                    System.out.print("| ");
                System.out.print(board[i][j] + " | ");
            }
        }
    }

    // check if the game is over or there is a winner
    public static boolean gameOver(int rMove, int cMove) {
        if (board[0][cMove] == board[1][cMove]
                && board[0][cMove] == board[2][cMove])
            return true;
        if (board[rMove][0] == board[rMove][1]
                && board[rMove][0] == board[rMove][2])
            return true;

        if (board[0][0] == board[1][1] && board[0][0] == board[2][2]
                && board[1][1] != '_')
            return true;
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0]
                && board[1][1] != '_')
            return true;
        return false;
    }


    // check if there is a place left in the board
    public static boolean placesLeftInBoard() {
        for (int i = 0 ; i < 3; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                if (board[i][j] == '_')
                    return true;
            }
        }
        return false;
    }

    // simulate playing the game
    public static void play(){
        boolean playing = true;
        printBoard();
        System.out.println();
        while (playing){
            if (placesLeftInBoard()) {
                boolean wrongPlace = true;
                while (wrongPlace) {
                    System.out.println("It's " + turn + " turn");
                    System.out.println("Enter a row");
                    row = scanner.nextInt() - 1;
                    System.out.println("Enter a column");
                    col = scanner.nextInt() - 1;
                    if (board[row][col] == '_'){
                        board[row][col] = turn;
                        wrongPlace = false;
                    } else {
                        System.out.println("Wrong place");
                        printBoard();
                        System.out.println();
                    }
                }

                if (gameOver(row, col)){
                    playing = false;
                    System.out.println("Game over! Player " + turn + " wins!");
                }
                printBoard();
                System.out.println();
                if (turn == 'X')
                    turn = 'O';
                else
                    turn = 'X';
            } else {
                playing = false;
                System.out.println("Game over! It's a tie");
            }
        }
    }
}
