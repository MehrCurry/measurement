/**
 * Created 13.02.2012
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.gzockoll.measurement;

import java.awt.Color;

public final class ColoredRange {
	private Range range;
	private Color rgba;

	public static ColoredRange create(Color c, Number n, Number m) {
		return new ColoredRange(c, new NumberRange(n, m));
	}

	/**
	 * Create a new ColoredRange.
	 * 
	 * @param range
	 * @param rgba
	 */
	private ColoredRange(Color rgba, Range range) {
		super();
		this.range = range;
		this.rgba = rgba;
	}

}