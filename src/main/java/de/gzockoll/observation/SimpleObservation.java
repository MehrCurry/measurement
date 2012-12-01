/**
 * Created 08.02.2012
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.gzockoll.observation;


/**
 * @author Guido Zockoll
 * 
 */
public class SimpleObservation extends Observation {
	private String key;
	private Number value;

	/**
	 * Create a new SimpleObservation.
	 * 
	 * @param subject
	 * @param key
	 * @param value
	 */
	public SimpleObservation(String key, Number value) {
		super(null);
		this.key = key;
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.gzockoll.prototype.camel.observation.Observation#getValue()
	 */
	@Override
	public Object getValue() {
		return value;
	}
}
