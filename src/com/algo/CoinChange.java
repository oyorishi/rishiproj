package com.algo;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public int countWays(int[] cents, int m, int n) {
	if (n == 0) {
	    return 1;
	}
	if (n < 0) {
	    return 0;
	}
	if (m <= 0 && n >= 1) {
	    return 0;
	}
	return countWays(cents, m - 1, n) + countWays(cents, m, n - cents[m - 1]);
    }

    public int dpCountWays(int[] cents, int m, int n) {
	int[] dp = new int[n + 1];
	dp[0] = 1;
	for (int i = 1; i <= n; i++) {
	    dp[i] = 0;
	}
	for (int i = 0; i < m; i++) {
	    for (int j = cents[i]; j <= n; j++) {
		dp[j] = dp[j] + dp[j - cents[i]];
	    }
	}
	return dp[n];
    }

    public void isAnagram(String[] a, String[] b) {
	int alength = a.length;
	int blength = b.length;
	if (alength != blength) {
	    return;
	}
	for (int i = 0; i < alength; i++) {
	    String s1 = a[i];
	    String s2 = b[i];
	    if (s1.length() == s2.length()) {
		checkAnagram(s1, s2);
	    } else {
		checkIfCanBeAnagram(s1, s2);

	    }

	}
    }

    private void checkIfCanBeAnagram(String s1, String s2) {
	Map<Character, Integer> hashMap = new HashMap<>();
	for (int i = 0; i < s1.length(); i++) {
	    if (hashMap.containsKey(s1.charAt(i))) {

	    }
	}
    }

    private void checkAnagram(String s1, String s2) {
	// TODO Auto-generated method stub

    }

    public void whoWonTheGame(int[] arr) {
	for (int i = 0; i < arr.length; i++) {
	    if (arr[i] == 1) {
		System.out.println("Clark");
		continue;
	    }
	    String s = findWinner(arr[i], "Bruce", "Clark");
	    System.out.println(s);
	}
    }

    private String findWinner(int n, String name1, String name2) {
	if (n == 1) {
	    return name1;
	} else if ((n & (n - 1)) == 0) {
	    return findWinner(n / 2, name2, name1);
	} else {
	    int res = 0;
	    for (int i = n; i >= 1; i--) {
		if ((i & (i - 1)) == 0) {
		    res = i;
		    break;
		}
	    }
	    return findWinner(res, name2, name1);
	}
    }

    public static void main(String[] args) {
	CoinChange coinChange = new CoinChange();
	int[] s = { 2, 5, 3, 6 };
	System.out.println(coinChange.countWays(s, 4, 10));
	int[] arr = { 6, 1 };
	coinChange.whoWonTheGame(arr);
    }

}
