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
}
