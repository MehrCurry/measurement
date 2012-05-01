package de.gzockoll.observation;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;

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
	public Quantity getValue() {
		return quantity;
	}

	public PhanomenonType getType() {
		return type;
	}

	public Quantity getQuantity() {
		return quantity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.gzockoll.prototype.camel.observation.Observation#toJSON()
	 */
	@Override
	public String toJSON() {
		Map<String, Object> entries = new HashMap<String, Object>();

		entries.put("key", getKey());
		entries.put("value", quantity.getValue());
		entries.put("timeTaken", timeTaken);
		entries.put("unit", quantity.getUnit());

		return new JSONObject(entries).toString();
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
