package ru.avelikorechin.loops;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
	* Tests for Counter class.
	* @author Alexander Velikorechin
	* @since 20.01.2017
*/

public class PaintTest {
	/**
		* Test piramid method.
	*/
	@Test
	public void whenSet5ThenReturns5RowPyramid() {
		final int h = 5;
		final Paint pir = new Paint();
		final String expect = "    ^\n   ^ ^\n  ^ ^ ^\n ^ ^ ^ ^\n^ ^ ^ ^ ^\n";
		String res = pir.piramid(h);
		assertThat(res, is(expect));
	}
}