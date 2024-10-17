package com.example.sodukugame;

public class SudokuGame {
    private int[][] board; // 9x9 Sudoku board

    public SudokuGame() {
        // Initialize the board with zeros (or a predefined puzzle)
        board = new int[9][9];
        generatePuzzle(); // You can generate a puzzle here
    }

    public void generatePuzzle() {
        // Example puzzle (0 represents empty cells)
        board = new int[][] {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
    }

    public boolean isValidMove(int row, int col, int num) {
        // Check if the number exists in the row, column, or 3x3 sub-grid
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[boxRowStart + i][boxColStart + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGameComplete() {
        // Check if all cells are filled and valid
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return false; // If any cell is empty, game is not complete
                }
            }
        }
        return true;
    }

    public void updateBoard(int row, int col, int value) {
        // Update the board with user input
        board[row][col] = value;
    }
}
