/**
 * Created 08.02.2012
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.gzockoll.observation;

/**
 * @author Guido Zockoll
 * 
 */
public class NamedSubject implements Subject {
	private String name;

	/**
	 * Create a new NamedSubject.
	 * 
	 * @param name
	 */
	public NamedSubject(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}
