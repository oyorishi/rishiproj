package com.algo;

import java.util.HashSet;
import java.util.Set;

public class Palindrome {

    public boolean checkIsPalindrome(String str) {
	int len = str.length();
	for (int i = 0, j = len - 1; i < j; i++, j--) {
	    if (str.charAt(i) != str.charAt(j)) {
		return false;
	    }
	}
	return true;
    }

    public void findPalindrome(String str) {
	int len = str.length();
	Set<String> hashSet = new HashSet<>();
	findPalUtil(str, 0, len, hashSet);
	hashSet.forEach(System.out::println);
    }

    private void findPalUtil(String str, int start, int end, Set<String> hashSet) {
	if (start > end) {
	    return;
	}
	String str1 = str.substring(start, end);
	if (checkIsPalindrome(str1)) {
	    hashSet.add(str1);
	}
	findPalUtil(str, start, end - 1, hashSet);
	findPalUtil(str, start + 1, end, hashSet);
	findPalUtil(str, start + 1, end - 1, hashSet);
    }

    public void findLongestPalindrome(String str) {
	int length = str.length();
	String longestPal = "";
	String[][] table = new String[length][length];
	findLongestPalUtil(str, length, longestPal, table);
    }

    private void findLongestPalUtil(String str, int length, String longestPal, String[][] table) {
	for (int i = 0; i < table.length; i++) {
	    for (int j = 1; j < table.length; j++) {
		String str1 = str.substring(i, j + 1);
		
	    }

	}

    }

    public static void main(String[] args) {
	Palindrome palindrome = new Palindrome();
	// System.out.println(lengthOfLongestSubstringKDistinct("aabacbebebe",
	// 3));
	System.out.println(palindrome.checkIsPalindrome("abccba"));
	palindrome.findPalindrome("abccba");
    }

    static int lengthOfLongestSubstringKDistinct(String s, int k) {
	int u = 0;
	int n = s.length();
	int[] count = new int[26];
	for (int i = 0; i < n; i++) {
	    if (count[s.charAt(i) - 'a'] == 0) {
		u++;
	    }
	    ++count[s.charAt(i) - 'a'];
	}
	if (u < k) {
	    return -1;
	}
	int curr_start = 0;
	int curr_end = 0;
	int max_window_size = 1;
	int max_window_start = 0;
	count = new int[26];
	++count[s.charAt(0) - 'a'];
	for (int i = 1; i < n; i++) {
	    ++count[s.charAt(i) - 'a'];
	    ++curr_end;
	    while (!isValid(count, k)) {
		--count[s.charAt(curr_start) - 'a'];
		++curr_start;
	    }
	    if (curr_end - curr_start + 1 > max_window_size) {
		max_window_size = curr_end - curr_start + 1;
		max_window_start = curr_start;
	    }
	}
	return max_window_size;
    }

    static boolean isValid(int count[], int k) {
	int val = 0;
	for (int i = 0; i < 26; i++) {
	    if (count[i] > 0) {
		++val;
	    }
	}
	return (k >= val);
    }

}
