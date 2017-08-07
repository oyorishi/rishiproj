package com.algo;

import java.util.ArrayList;
import java.util.Collections;

public class PrintLargest {
    public void printLargest(int[] arr) {
	ArrayList<String> list = new ArrayList<>();
	for (int i = 0; i < arr.length; i++) {
	    list.add(String.valueOf(arr[i]));
	}
	Collections.sort(list, new MyComparator());
	for (int i = 0; i < list.size(); i++) {
	    System.out.print(list.get(i));
	}
    }

    public static void main(String[] args) {
	int[] arr = { 54, 546, 548, 60 };
	PrintLargest printLargest = new PrintLargest();
	printLargest.printLargest(arr);
    }

}
