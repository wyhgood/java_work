package com.travel.utils;

import java.util.TreeSet;

public class SegmentNumPool {
	private static TreeSet<Integer> numSet = new TreeSet<Integer>();
	private static Object lock = new Object();
	static {
		for (int i = 1; i < 50; i++) {
			numSet.add(i);
		}
	}

	public static int getNum() {
		while (true) {
			synchronized (lock) {
				if (!numSet.isEmpty()) {
					int num = numSet.first();
					numSet.remove(num);
					return num;
				} else {
					try {
						// 释放锁并阻塞
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void returnNum(int num) {
		synchronized (lock) {
			if (num < 50) {
				numSet.add(num);
				lock.notify();
			}
		}
	}
}
