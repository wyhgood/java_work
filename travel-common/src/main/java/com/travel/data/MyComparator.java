package com.travel.data;

import java.util.Comparator;

import com.travel.data.DoublePair;

public class MyComparator implements Comparator<DoublePair>{
	@Override
	public int compare(DoublePair o1, DoublePair o2) {
		if(o2.value > o1.value)return 1;
		if(o2.value < o1.value)return -1;
		return 0;
	}
}
