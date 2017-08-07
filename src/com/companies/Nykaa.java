package com.companies;

import java.util.ArrayDeque;
import java.util.Deque;

public class Nykaa {
    public int minSteps(int source, int steps, int dest) {
	if (Math.abs(source) > dest) {
	    return Integer.MAX_VALUE;
	}
	if (source == dest) {
	    return steps;
	}
	int pos = minSteps(source + steps + 1, steps + 1, dest);
	int neg = minSteps(source - steps - 1, steps + 1, dest);
	return Math.min(pos, neg);
    }

    public int[] windowMax(int[] arr, int k) {
	Deque<Integer> deque = new ArrayDeque<>();
	int i;
	for (i = 0; i < k; i++) {
	    while (!deque.isEmpty() && arr[i] > arr[deque.getLast()]) {
		deque.removeLast();
	    }
	    deque.addLast(i);
	}
	for (; i < arr.length; i++) {
	    System.out.println("max:" + arr[deque.getFirst()]);
	    while (!deque.isEmpty() && deque.getFirst() <= i - k) {
		deque.removeFirst();
	    }
	    while (!deque.isEmpty() && arr[i] >= arr[deque.getLast()]) {
		deque.removeLast();
	    }
	    deque.addLast(i);
	}
	System.out.println("max:" + arr[deque.getFirst()]);
	return null;
    }

    public static void main(String[] args) {
	Nykaa nykaa = new Nykaa();
	System.out.println(nykaa.minSteps(0, 0, 11));
	int[] arr = { 12, 1, 78, 90, 57, 89, 56 };
	int k = 3;
	nykaa.windowMax(arr, k);
    }

}
