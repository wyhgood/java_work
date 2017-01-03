package com.travel.utils;

public class Semaphore {
	private int permits;

	public Semaphore(int permits) {
		this.permits = permits;
	}

	public void acquire() {
		acquire(1);
	}

	public synchronized void acquire(int permits) {
		if (this.permits - permits >= 0) {
			this.permits -= permits;
		} else {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void release() {
		release(1);
	}

	public synchronized void release(int permits) {
		this.permits += permits;
		this.notify();
	}

}
