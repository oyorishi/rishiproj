package com.algo;

public class LongestIncreasingSubsequence {
    public int lis(int[] arr) {
	int len = arr.length;
	int[] tab = new int[len];
	for (int i = 0; i < len; i++) {
	    tab[i] = 1;
	}
	for (int i = 1; i < len; i++) {
	    for (int j = 0; j < i; j++) {
		if ((arr[j] < arr[i]) && (tab[i] < tab[j] + 1)) {
		    tab[i] = tab[j] + 1;
		}
	    }
	}
	System.out.println(tab[len - 1]);
	return tab[len - 1];
    }

    public int lisRec(int[] arr) {
	int len = arr.length;
	int maxLen = Integer.MIN_VALUE;
	maxLen = lisRecUtil(arr, len, maxLen);
	System.out.println("max:" + maxLen);
	return maxLen;
    }

    public int lisRecUtil(int[] arr, int n, int maxLen) {
	if (n == 1) {
	    return 1;
	}
	int currLen = 1;
	for (int i = 0; i < n; i++) {
	    int subProbLen = lisRecUtil(arr, i, maxLen);
	    if (arr[i] < arr[n - 1]) {
		if (currLen < subProbLen + 1) {
		    currLen = subProbLen + 1;
		}
	    }
	}
	if (maxLen < currLen) {
	    maxLen = currLen;
	}
	return maxLen;
    }

    public static void main(String[] args) {
	LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
	int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60 };
	lis.lisRec(arr);

    }

}
