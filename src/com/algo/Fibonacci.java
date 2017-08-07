package com.algo;

public class Fibonacci {
	int[] lookUp = new int[100];

	/**
	 * takes most time
	 * @param n
	 * @return
	 */
	public int rec(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return rec(n - 1) + rec(n - 2);
	}

	/**
	 * more optimized than recursive solution
	 * @param n
	 * @return
	 */
	public int mem(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (lookUp[n] != 0) {
			return lookUp[n];
		} else {
			lookUp[n] = mem(n - 1) + mem(n - 2);
			return lookUp[n];
		}
	}

	/**
	 * Most optimized
	 * @param n
	 * @return
	 */
	public int tab(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int[] tab = new int[200];
		tab[0] = 0;
		tab[1] = 1;
		for (int i = 2; i <= n; i++) {
			tab[i] = tab[i - 1] + tab[i - 2];
		}
		return tab[n];
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		long t1 = System.nanoTime();
		int a = fibonacci.tab(40);
		long t2 = System.nanoTime();
		System.out.println((t2 - t1));
		System.out.println(a);
	}

}
