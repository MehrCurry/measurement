package de.gzockoll.measurement;

import static de.gzockoll.measurement.MetarMesswerte.*;
import static de.gzockoll.observation.Units.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import net.sf.jweather.metar.Metar;
import net.sf.jweather.metar.MetarParseException;
import net.sf.jweather.metar.MetarParser;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.gzockoll.observation.Measurement;
import de.gzockoll.observation.NamedSubject;
import de.gzockoll.observation.Observation;
import de.gzockoll.observation.Subject;

public class MetarProcessor implements Processor {
	private static final Logger logger = LoggerFactory
			.getLogger(MetarProcessor.class);

	@Override
	public void process(Exchange ex) throws Exception {
		String data = IOUtils.toString((InputStream) ex.getIn().getBody());
		logger.debug("Data: " + data);
		List<Observation> list = extractMetarValues(data);
		ex.getOut().setBody(list);
	}

	private List<Observation> extractMetarValues(String data)
			throws MetarParseException {
		Metar metar = MetarParser.parseRecord(data);
		logger.debug("Metar: " + metar);
		List<Observation> list = new ArrayList<Observation>();
		Subject station = new NamedSubject(metar.getStationID());
		list.add(new Measurement(station, TEMPERATUR, DEGREE_CELSIUS, metar
				.getTemperatureMostPreciseInCelsius()));
		list.add(new Measurement(station, LUFTDRUCK, HECTOPASCAL, metar
				.getPressureInHectoPascals()));
		list.add(new Measurement(station, WIND, METER_PER_SECOND, metar
				.getWindSpeedInMPS()));
		list.add(new Measurement(station, WINDRICHTUNG, DEGREE, metar
				.getWindDirection()));

		list.add(new Measurement(station, TAUPUNKT, DEGREE_CELSIUS, metar
				.getDewPointPreciseInCelsius()));
		list.add(new Measurement(station, SICHT, KILOMETER, metar
				.getVisibilityInKilometers()));
		return list;
	}
}
