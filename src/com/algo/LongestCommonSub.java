package com.algo;

public class LongestCommonSub {

    /**
     * naive approach
     * 
     * @param str1
     * @param str2
     * @return
     */
    public int lcs(String str1, String str2) {
	int l1 = str1.length();
	int l2 = str2.length();
	if (l1 == 0 || l2 == 0) {
	    return 0;
	}
	int length = longestcs(str1, str2, l1 - 1, l2 - 1);
	return length;
    }

    private int longestcs(String str1, String str2, int i, int j) {
	if (i < 0 || j < 0) {
	    return 0;
	}
	if (str1.charAt(i) == str2.charAt(j)) {
	    return 1 + longestcs(str1, str2, i - 1, j - 1);
	} else {
	    return Math.max(longestcs(str1, str2, i - 1, j), longestcs(str1, str2, i, j - 1));
	}
    }

    /**
     * using tabulation
     * 
     * @param str1
     * @param str2
     * @return
     */
    private int lcs2(String str1, String str2) {
	int l1 = str1.length();
	int l2 = str2.length();
	int[][] tab = new int[l1 + 1][l2 + 1];
	for (int i = 0; i <= l1; i++) {
	    for (int j = 0; j <= l2; j++) {
		if (i == 0 || j == 0) {
		    tab[i][j] = 0;
		} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
		    tab[i][j] = 1 + tab[i - 1][j - 1];
		} else {
		    tab[i][j] = Math.max(tab[i - 1][j], tab[i][j - 1]);
		}
	    }
	}
	return tab[l1][l2];
    }

    static int[][] tab = new int[7][6];

    public int LcsMem(String s1, String s2, int m, int n) {
	if (m == 0 || n == 0)
	    return 0;
	if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
	    tab[m][n] = 1 + LcsMem(s1, s2, m - 1, n - 1);
	} else {
	    tab[m][n] = Math.max(LcsMem(s1, s2, m - 1, n), LcsMem(s1, s2, m, n - 1));
	}
	return tab[m][n];
    }

    public static void main(String[] args) {
	LongestCommonSub lc = new LongestCommonSub();
	// String str1 = "AGGYXAB";
	// String str2 = "GXTXAYB";
	// System.out.println(lc.lcs(str1, str2));
	// System.out.println(lc.lcs2(str1, str2));
	String s1 = "XYZABC";
	String s2 = "QYACD";
	int m = s1.length();
	int n = s2.length();
	int index = lc.LcsMem(s1, s2, m, n);
	System.out.println(index);
	int i = m;
	int j = n;
	char[] arr = new char[index];
	while (i > 0 && j > 0) {
	    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
		arr[index - 1] = s1.charAt(i - 1);
		i--;
		j--;
		index--;
	    } else {
		if (tab[i - 1][j] > tab[i][j - 1]) {
		    i--;
		} else {
		    j--;
		}
	    }
	}
	for (char c : arr) {
	    System.out.print(c);
	}

    }

}
