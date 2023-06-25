package sudoku_solver;

import java.util.Iterator;

// This is a "brutforce approach" for solving a sudoku

public class SudokuSolver1 {

	private static final int GRID_SIZE = 9;

	protected static void printBoard(int[][] board) {

		for (int row = 0; row < GRID_SIZE; row++) {

			if (row % 3 == 0 && row != 0) {

				System.out.println("-----------");

			}

			for (int col = 0; col < GRID_SIZE; col++) {

				if (col % 3 == 0 && col != 0) {

					System.out.print("|");

				}

				System.out.print(board[row][col]);

			}

			System.out.println();

		}

	}

	// Checks if the number already exists in row

	protected static boolean isInRow(int[][] board, int number, int row) {

		for (int i = 0; i < GRID_SIZE; i++) {

			if (board[row][i] == number) {

				return true;

			}

		}

		return false;

	}

	// Checks if the number already exists in column

	protected static boolean isInCol(int[][] board, int number, int col) {

		for (int i = 0; i < GRID_SIZE; i++) {

			if (board[i][col] == number) {

				return true;

			}

		}

		return false;

	}

	// Checks if the number already exists in the 3X3 square

	protected static boolean isInSquare(int[][] board, int number, int row, int col) {

		// There are 9 squares on the board

		// We check to which square the number belongs

		int squareFirstRow = row - row % 3;

		int squareFirstCol = col - col % 3;

		for (int i = squareFirstRow; i < squareFirstRow + 3; i++) {

			for (int j = squareFirstCol; j < squareFirstCol + 3; j++) {

				if (board[i][j] == number) {

					return true;

				}

			}

		}

		return false;

	}

	protected static boolean isValidPlacement(int[][] board, int number, int row, int col) {

		if (!isInRow(board, number, row) && !isInCol(board, number, col) && !isInSquare(board, number, row, col)) {

			return true;

		}

		return false;

	}

	protected static boolean solveBoard(int[][] board) {

		for (int row = 0; row < GRID_SIZE; row++) {

			for (int col = 0; col < GRID_SIZE; col++) {

				if (board[row][col] == 0) {

					for (int numberToTry = 1; numberToTry <= GRID_SIZE; numberToTry++) {

						if (isValidPlacement(board, numberToTry, row, col)) {

							board[row][col] = numberToTry;

							// We call recursively again the method solveBoard

							if (solveBoard(board)) {

								return true;

							} else {

								// If the board doesn't solve, we go backwards
								// and replace the number with 0

								board[row][col] = 0;

							}

						}

					}

					return false;

				}

			}

		}

		return true;

	}

}
