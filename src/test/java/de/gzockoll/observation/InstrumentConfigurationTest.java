/**
 * Created 08.02.2012
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.gzockoll.observation;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import org.junit.Test;

import de.gzockoll.measurement.InstrumentConfiguration;

/**
 * @author Guido Zockoll
 * 
 */
public class InstrumentConfigurationTest {

	@Test
	public void testBuilder() {
		InstrumentConfiguration conf = InstrumentConfiguration.builder()
				.name("JUnit").unit("m/s").build();

		String s = conf.toString();
		assertThat(s, containsString("name=JUnit"));
		assertThat(s, containsString("unit=m/s"));
	}

}
