package com.algo;

public class Stairs {
	public static int countWays1(int n) {
		if (n <= 1) {
			return n;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}
		return countWays1(n - 1) + countWays1(n - 2) + countWays1(n - 3);
	}

	public static int countWaysUtil(int steps, int hops) {
		if (steps <= 1) {
			return steps;
		}
		int res = 0;
		for (int i = 1; i <= hops && i <= steps; i++) {
			res += countWaysUtil(steps - i, hops);
		}
		return res;
	}

	static int[] dp = new int[12];

	public static int countWaysUtildp(int steps, int hops) {
		if (steps <= 1) {
			System.out.println("step1:" + steps);
			return steps;
		} else if (dp[steps] != 0) {
			System.out.println("step2:" + dp[steps]);
			return dp[steps];
		} else {
			for (int i = 1; i <= hops && i <= steps; i++) {
				System.out.println("step3: i:" + i + ":steps:" + steps + ":" + dp[steps]);
				dp[steps] += countWaysUtildp(steps - i, hops);
			}
		}
		return dp[steps];

	}

	public static int countWays(int n, int m) {

		int r = countWaysUtildp(n + 1, m); // fibonacci is ways(2) = fib(3) =
											// 2, so
		// increment by 1
		for (int i = 0; i < dp.length; i++) {
			System.out.println(dp[i]);
		}
		return r;
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(Stairs.countWays(n, 3));
	}
}
