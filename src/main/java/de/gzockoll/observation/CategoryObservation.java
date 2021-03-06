package de.gzockoll.observation;

import org.codehaus.jettison.json.JSONObject;

public class CategoryObservation extends Observation {
	private Phanomenon phanomenon;

	public CategoryObservation(Subject subject, Phanomenon phanomenon) {
		super(subject);
		this.phanomenon = phanomenon;
	}

	@Override
	public Object getValue() {
		return phanomenon;
	}

	@Override
	public String toJSON() {
		return new JSONObject(this, new String[] { "1", "2" }).toString();
	}
}
