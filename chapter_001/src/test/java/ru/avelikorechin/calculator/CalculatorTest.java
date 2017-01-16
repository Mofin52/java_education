package ru.avelikorechin.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
	* Test for Calculator class.
	* @author Alexander Velikorechin
	* @since 15.01.2017
*/

public class CalculatorTest {
	/**
	* Test add.
	*/
	@Test
	public void whenAddOneToOneThenResultIsTwo() {
		double first = 1.0;
		double second = 1.0;
		final double expect = 2.0;
		Calculator calc = new Calculator();
		calc.add(first, second);
		double res  = calc.getResult();
		assertThat(res, is(expect));
	}

	/**
	* Test substract.
	*/
	@Test
	public void whenSubstractOneFromTwoThenResultIsOne() {
		double first = 2.0;
		double second = 1.0;
		final double expect = 1.0;
		Calculator calc = new Calculator();
		calc.substract(first, second);
		double res  = calc.getResult();
		assertThat(res, is(expect));
	}

	/**
	* Test multiply.
	*/
	@Test
	public void whenMultiplyTwoOnTwoThenResultIsFour() {
		double first = 2.0;
		double second = 2.0;
		final double expect = 4; //result of 2 multiplied by 2
		Calculator calc = new Calculator();
		calc.multiply(first, second);
		double res  = calc.getResult();
		assertThat(res, is(expect));
	}

	/**
	* Test divide.
	*/
	@Test
	public void whenDivideTwoOnTwoThenResultIsOne() {
		double first = 2.0;
		double second = 2.0;
		final double expect = 1.0;
		Calculator calc = new Calculator();
		calc.div(first, second);
		double res  = calc.getResult();
		assertThat(res, is(expect));
	}

}