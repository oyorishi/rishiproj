package com.algo;

public class MinCostPath {
    public int min(int a, int b, int c) {
	if (a < b && a < c) {
	    return a;
	} else if (b < c) {
	    return b;
	} else {
	    return c;
	}
    }

    public int minCost(int[][] arr, int m, int n) {
	int[][] dp = new int[m + 1][n + 1];
	dp[0][0] = arr[0][0];
	for (int i = 1; i <= m; i++) {
	    dp[i][0] = dp[i - 1][0] + arr[i][0];
	}
	for (int j = 1; j <= n; j++) {
	    dp[0][j] = dp[0][j - 1] + arr[0][j];
	}
	for (int i = 1; i <= m; i++) {
	    for (int j = 1; j <= n; j++) {
		dp[i][j] = arr[i][j] + min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
	    }
	}
	return dp[m][n];
    }

    public static void main(String[] args) {
	MinCostPath minCostPath = new MinCostPath();
	int cost[][] = { { 1, 2, 3 }, 
			 { 4, 8, 2 }, 
			 { 1, 5, 3 } };
	System.out.println("minimum cost to reach (2,2) = " + minCostPath.minCost(cost, 2, 2));
    }

}
