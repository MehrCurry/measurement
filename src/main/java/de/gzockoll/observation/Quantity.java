package de.gzockoll.observation;

public interface Quantity extends Comparable<Quantity> {

	Number getValue();

	Unit getUnit();

}
