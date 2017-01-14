package ru.avelikorechin;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
	* Test for Calculate class.
	* @author Alexander Velikorechin
	* @since 14.01.2017
*/

public class CalculateTest {
	/**
	* Test add.
	*/
	@Test
	public void whenExecuteMainThenPrintToConsole() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Calculate.main(null);
        assertThat(out.toString(), is(String.format("Hello, World!%s", System.getProperty("line.separator"))));
    }

}