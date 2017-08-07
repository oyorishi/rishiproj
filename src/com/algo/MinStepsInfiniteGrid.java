package com.algo;

import java.util.ArrayList;

public class MinStepsInfiniteGrid {
    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
	int count = 0;
	if (X.size() != Y.size()) {
	    return -1;
	}
	if (X.size() == 1) {
	    return 0;
	}
	for (int i = 1; i < X.size(); i++) {
	    count += Math.max(Math.abs(Y.get(i - 1) - Y.get(i)), Math.abs(X.get(i - 1) - X.get(i)));
	}
	return count;
    }

    public static void main(String[] args) {
	ArrayList<Integer> x = new ArrayList<>();
	ArrayList<Integer> y = new ArrayList<>();
	x.add(0);
	y.add(0);

	x.add(1);
	y.add(1);

	x.add(1);
	y.add(2);
	MinStepsInfiniteGrid minStepsInfiniteGrid = new MinStepsInfiniteGrid();
	System.out.println(minStepsInfiniteGrid.coverPoints(x, y));
    }

}
