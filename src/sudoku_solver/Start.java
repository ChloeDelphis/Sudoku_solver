package sudoku_solver;

public class Start {

	public static void main(String[] args) {
		sudokuSolver1(Board.hardBoard);

	}

	static void sudokuSolver1(int[][] board) {

		System.out.println("Initial board :\n");

		SudokuSolver.printBoard(board);

		long beginning = System.currentTimeMillis();

		if (SudokuSolver.solveBoard(board)) {
			long end = System.currentTimeMillis();
			System.out.println("\nSudoku solved successfully in " + (end - beginning) + "ms\n");

		}

		else {

			System.out.println("Sudoku couldn't be solved");

		}

		SudokuSolver.printBoard(board);

	}

}
