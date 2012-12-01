package de.gzockoll.measurement;

import static de.gzockoll.measurement.MetarMesswerte.LUFTDRUCK;
import static de.gzockoll.measurement.MetarMesswerte.SICHT;
import static de.gzockoll.measurement.MetarMesswerte.TAUPUNKT;
import static de.gzockoll.measurement.MetarMesswerte.TEMPERATUR;
import static de.gzockoll.measurement.MetarMesswerte.WIND;
import static de.gzockoll.measurement.MetarMesswerte.WINDRICHTUNG;
import static de.gzockoll.observation.Units.DEGREE;
import static de.gzockoll.observation.Units.DEGREE_CELSIUS;
import static de.gzockoll.observation.Units.HECTOPASCAL;
import static de.gzockoll.observation.Units.KILOMETER;
import static de.gzockoll.observation.Units.METER_PER_SECOND;

import java.util.ArrayList;
import java.util.List;

import net.sf.jweather.metar.Metar;
import net.sf.jweather.metar.MetarParseException;
import net.sf.jweather.metar.MetarParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.gzockoll.observation.Measurement;
import de.gzockoll.observation.Observation;

public class MetarProcessor {
	private static final Logger logger = LoggerFactory
			.getLogger(MetarProcessor.class);

	public List<Observation> extractMetarValues(String data)
			throws MetarParseException {
		Metar metar = MetarParser.parseRecord(data);
		logger.debug("Metar: " + metar);
		List<Observation> list = new ArrayList<Observation>();
		String station = metar.getStationID();
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
