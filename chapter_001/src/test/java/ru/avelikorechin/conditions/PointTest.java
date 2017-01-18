package ru.avelikorechin.conditions;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
	* Tests for Point class.
	* @author Alexander Velikorechin
	* @since 18.01.2017
*/

public class PointTest {
	/**
	* Test distanceTo().
	*/
	@Test
	public void whenAddTwoPointsThenReturnsCorrectResult() {
		final Point firstPoint = new Point(2.0, 3.0);
		final Point secondPoint = new Point(6.0, 7.0);
		final double expect = 5.65;
		final double proximity = 0.01;
		double res = firstPoint.distanceTo(secondPoint);
		assertThat(res, closeTo(expect, proximity));

	}

}