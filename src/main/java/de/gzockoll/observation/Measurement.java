package de.gzockoll.observation;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;

public class Measurement extends Observation {
	private PhanomenonType type;
	private Quantity quantity;

	public Measurement(Subject subject, PhanomenonType type, Quantity quantity) {
		super(subject);
		this.type = type;
		this.quantity = quantity;
	}

	public Measurement(Subject subject, PhanomenonType type, Unit unit,
			Number value) {
		this(subject, type, new NumberQuantity(unit, value));
	}

	@Override
	public Quantity getValue() {
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

		entries.put("key", subject.getName() + "." + type);
		entries.put("value", quantity.getValue());
		entries.put("timeTaken", timeTaken);
		entries.put("unit", quantity.getUnit());

		return new JSONObject(entries).toString();
	}
}
