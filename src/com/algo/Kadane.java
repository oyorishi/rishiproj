package com.algo;

public class Kadane {
	public static void oneDim(int[] arr) {
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		for (int i = 0; i < arr.length; i++) {
			maxEndingHere = maxEndingHere + arr[i];
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			}
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		System.out.println(maxSoFar);
	}
	
	public static void oneDimAllNeg(int[] arr) {
		int maxSum = arr[0];
		int currSum = arr[0];
		int start = 0, end = 0;
		for (int i = 1; i < arr.length; i++) {
			int currVal = arr[i];
			if(currSum < 0) {
				
			} else {
				if(currVal < 0) {
					
				} else {
					
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { -3, -2, -1, -11, -4, -8 };
		Kadane.oneDim(arr);

	}

}
