/**
 * Created 06.02.2012
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.gzockoll.measurement;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.gzockoll.observation.Measurement;
import de.gzockoll.observation.NamedSubject;
import de.gzockoll.observation.NumberQuantity;
import de.gzockoll.observation.Observation;
import de.gzockoll.observation.Units;

/**
 * @author Guido Zockoll
 * 
 */
public class CountProcessor implements Processor {
	private static final Logger logger = LoggerFactory
			.getLogger(CountProcessor.class);

	private long scaling;

	private NamedSubject subject;

	/**
	 * Create a new CountProcessor.
	 * 
	 * @param i
	 */
	public CountProcessor(String name, long scaleing) {
		this.subject = new NamedSubject(name);
		this.scaling = scaleing;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void process(Exchange exchange) throws Exception {
		List<Exchange> result = (List<Exchange>) exchange.getIn().getBody();
		logger.debug(result == null ? "List <null>" : "Listsize "
				+ result.size());

		double value = (1.0 * result.size()) / scaling;
		Observation o = new Measurement(subject, Messwerte.DURCHSATZ,
				new NumberQuantity(Units.PER_SECOND, value));
		exchange.getIn().setBody(o);
	}
}
