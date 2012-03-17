package de.gzockoll.measurement;

public class NumberRange<T extends Number> implements Range {
	private T start;
	private T end;

	public NumberRange(T start, T end) {
		super();
		this.start = start;
		this.end = end;
	}

	public T getStart() {
		return start;
	}

	public T getEnd() {
		return end;
	}
}
