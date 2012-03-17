package de.gzockoll.observation;

import javax.measure.Measurable;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Mass;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.jscience.physics.amount.Amount;
import org.junit.Test;

public class JScienceTest {

	@Test
	public void test() {
		Amount<Mass> mass = Amount.valueOf(5, SI.KILOGRAM);
		System.out.println(mass);
		Measurable<Mass> m = mass;

		Measurable<Dimensionless> x = Amount.valueOf(5, Unit.ONE);
		// System.out.println(x.);
	}
}
