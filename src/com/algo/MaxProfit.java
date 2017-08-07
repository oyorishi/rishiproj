package com.algo;

public class MaxProfit {
    public static int maxProfit(int[] price, int k) {
	int n = price.length;
	int[][] profit = new int[k + 1][n + 1];
	for (int i = 1; i <= k; i++) {
	    int prevDiff = Integer.MIN_VALUE;
	    for (int j = 1; j < n; j++) {
		prevDiff = Math.max(prevDiff, profit[i - 1][j - 1] - price[j - 1]);
		profit[i][j] = Math.max(profit[i - 1][j], price[j] + prevDiff);
	    }
	}
	return profit[k][n - 1];
    }

}
