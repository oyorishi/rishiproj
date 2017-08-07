package com.algo;

public class NQueen {
    private static final int N = 4;

    public static void main(String[] args) {
	int[][] arr = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }

	};
	if (solveNQueen(arr, 0)) {
	    System.out.println("solved");
	    for (int i = 0; i < arr.length; i++) {
		for (int j = 0; j < arr.length; j++) {
		    System.out.print(arr[i][j] + " ");
		}
		System.out.println();
	    }
	} else {
	    System.out.println("not");
	}
    }

    private static boolean solveNQueen(int[][] board, int col) {
	if (col >= N) {
	    return true;
	}
	for (int i = 0; i < N; i++) {
	    if (isSafe(board, i, col)) {
		board[i][col] = 1;
		if (solveNQueen(board, col + 1)) {
		    return true;
		}
		board[i][col] = 0;
	    }
	}
	return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
	for (int i = 0; i < col; i++) {
	    if (board[row][i] == 1) {
		return false;
	    }
	}
	for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
	    if (board[i][j] == 1) {
		return false;
	    }
	}
	for (int i = row, j = col; i < N && j >= 0; i++, j--) {
	    if (board[i][j] == 1) {
		return false;
	    }
	}
	return true;
    }

}
