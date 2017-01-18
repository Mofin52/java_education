package ru.avelikorechin.conditions;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.hamcrest.core.Is.is;

/**
	* Tests for Triangle class.
	* @author Alexander Velikorechin
	* @since 18.01.2017
*/

public class TriangleTest {

	/**
	* Test area method.
	*/
	@Test
	public void whenSetTriangleReturnsCorrectResult() {
		final Point firstPoint = new Point(0.0, 0.0);
		final Point secondPoint = new Point(3.0, 4.0);
		final Point thirdPoint = new Point(4.0, 3.0);
		final Triangle trian = new Triangle(firstPoint, secondPoint, thirdPoint);
		final double expect = 3.5;
		final double proximity = 0.1;
		double res = trian.area();
		assertThat(res, closeTo(expect, proximity));
	}
	/**
	* Test checkIfTriangleIsPossible method. Should return false.
	*/
	@Test
	public void whenSetIncorrectTriangleThenReturnsFalse() {
		final Point firstPoint = new Point(1.0, 1.0);
		final Point secondPoint = new Point(1.0, 1.0);
		final Point thirdPoint = new Point(1.0, 1.0);
		final Triangle trian = new Triangle(firstPoint, secondPoint, thirdPoint);
		final boolean expect = false;
		boolean res = trian.checkIfTriangleIsPossible();
		assertThat(res, is(expect));
	}

	/**
	* Test checkIfTriangleIsPossible method. Should return true.
	*/
	@Test
	public void whenSetCorrectTriangleThenReturnsTrue() {
		final Point firstPoint = new Point(0.0, 0.0);
		final Point secondPoint = new Point(3.0, 4.0);
		final Point thirdPoint = new Point(4.0, 3.0);
		final Triangle trian = new Triangle(firstPoint, secondPoint, thirdPoint);
		final boolean expect = true;
		boolean res = trian.checkIfTriangleIsPossible();
		assertThat(res, is(expect));
	}
}