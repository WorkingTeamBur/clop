package com.kjkksjc.clop;


public class ItemsRange {
	// First item number
	private int first;

	// Items count
	private int count;

    public ItemsRange() {
        this(0, 0);
    }

	public ItemsRange(int first, int count) {
		this.first = first;
		this.count = count;
	}

	public int getFirst() {
		return first;
	}

	public int getLast() {
		return getFirst() + getCount() - 1;
	}

	public int getCount() {
		return count;
	}

	public boolean contains(int index) {
		return index >= getFirst() && index <= getLast();
	}
}