package com.algo;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

	public static int listSum(List<Integer> list) {
		int sum = 0;
		sum = listSumUtil(list, list.size() - 1, sum);
		System.out.println(sum);
		return sum;
	}

	public static int listSumUtil(List<Integer> list, int idx, int sum) {
		if (idx < 0) {
			return sum;
		}
		return listSumUtil(list, idx - 1, sum + list.get(idx));
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		Recursion.listSum(list);
	}

}
