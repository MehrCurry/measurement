package de.gzockoll.observation;

public class NumberQuantity implements Quantity {
	private Unit unit;
	private Number value;

	public NumberQuantity(Unit unit, Number value) {
		super();
		this.unit = unit;
		this.value = value;
	}

	@Override
	public Unit getUnit() {
		return unit;
	}

	@Override
	public Number getValue() {
		return value;
	}

	@Override
	public int compareTo(Quantity o) {
		if (unit != o.getUnit())
			throw new IllegalArgumentException();
		return Double.valueOf(value.doubleValue()).compareTo(
				Double.valueOf(o.getValue().doubleValue()));
	}
}
