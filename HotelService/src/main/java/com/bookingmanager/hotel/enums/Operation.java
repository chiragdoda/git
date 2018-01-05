package com.bookingmanager.hotel.enums;

public enum Operation {
	ADD(1), REMOVE(2);
	private int value;

	private Operation(int v) {
		value = v;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
