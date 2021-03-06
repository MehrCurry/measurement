/**
 * Created 08.02.2012
 * This code is copyright (c) 2004 PAYONE Gmbh & Co. KG.
 */
package de.gzockoll.measurement;

import de.gzockoll.observation.Measurement;
import de.gzockoll.observation.Observation;
import de.gzockoll.observation.PhanomenonType;
import de.gzockoll.observation.Quantity;
import de.gzockoll.observation.Subject;

/**
 * @author Guido Zockoll
 * 
 */
public enum MetarMesswerte implements PhanomenonType {
    TEMPERATUR, LUFTDRUCK, TAUPUNKT, SICHT, WIND, WINDRICHTUNG;

    public Observation observation(Subject subject, Quantity quantity) {
        return new Measurement(subject, this, quantity);
    }
}
