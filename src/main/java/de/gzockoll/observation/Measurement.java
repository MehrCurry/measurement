package de.gzockoll.observation;


public class Measurement extends Observation implements Comparable<Measurement> {
	private PhanomenonType type;
	private Quantity quantity;

	public Measurement(Subject subject, PhanomenonType type, Quantity quantity) {
		super(subject);
		this.type = type;
		this.quantity = quantity;
	}

	public Measurement(String name, PhanomenonType type, Unit unit, Number value) {
		this(new NamedSubject(name), type, new NumberQuantity(unit, value));
	}

	@Override
	public Number getValue() {
		return quantity.getValue();
	}

	public PhanomenonType getType() {
		return type;
	}

	public Quantity getQuantity() {
		return quantity;
	}

	public String getKey() {
		return subject.getName() + "." + type;
	}

	@Override
	public int compareTo(Measurement other) {
		if (type != other.type)
			throw new IllegalArgumentException("Could not compare with "
					+ other);
		return quantity.compareTo(other.quantity);
	}
}
