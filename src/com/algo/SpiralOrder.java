package com.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralOrder {
    public ArrayList<Integer> spiralOrder(int[][] a) {
	ArrayList<Integer> result = new ArrayList<Integer>();
	int k = 0;
	int l = 0;
	int n = a[0].length;
	int m = a.length;
	while (k < m && l < n) {
	    for (int i = l; i < n; i++) {
		result.add(a[k][i]);
	    }
	    k++;

	    for (int i = k; i < m; i++) {
		result.add(a[i][n - 1]);
	    }
	    n--;

	    if (l < n && k < m) {
		for (int i = n - 1; i >= l; i--) {
		    result.add(a[m - 1][i]);
		}
		m--;

		for (int i = m - 1; i >= k; i--) {
		    result.add(a[i][l]);
		}
		l++;
	    }

	}
	return result;
    }

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int m = (int) Math.sqrt(n);
	int[][] b = new int[m][m];
	for (int i = 0; i < n; i++) {
	    b[i / m][i % m] = sc.nextInt();
	}
	SpiralOrder spiralOrder = new SpiralOrder();
	List<Integer> rs = spiralOrder.spiralOrder(b);
	for (int i = 0; i < rs.size(); i++) {
	    System.out.print(rs.get(i) + " ");
	}

	sc.close();
    }

}
