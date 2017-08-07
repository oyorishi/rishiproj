package com.algo;

import java.util.Comparator;

public class MyComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
	String XY = o1 + o2;
	String YX = o2 + o1;
	if (XY.equals(YX)) {
	    return 0;
	} else if (XY.compareTo(YX) > 0) {
	    return -1;
	} else {
	    return 0;
	}
    }

}
