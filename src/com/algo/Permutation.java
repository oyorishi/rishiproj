package com.algo;

public class Permutation {
    public static void main(String[] args) {
	String str = "abc";
	int length = str.length();
	Permutation permutation = new Permutation();
	permutation.permute(str, 0, length - 1);
    }

    private void permute(String str, int l, int r) {
	if (l == r) {
	    System.out.println("string:" + str);
	} else {
	    for (int i = l; i <= r; i++) {
		System.out.println("before:i=" + i + ", l=" + l + ", str:" + str);
		str = swap(str, l, i);
		permute(str, l + 1, r);
		System.out.println("after:i=" + i + ", l=" + l + ", str:" + str);
		str = swap(str, l, i);
	    }
	}
    }

    private String swap(String str, int i, int j) {
	char[] a = str.toCharArray();
	char temp = a[i];
	a[i] = a[j];
	a[j] = temp;
	return String.valueOf(a);
    }

}
