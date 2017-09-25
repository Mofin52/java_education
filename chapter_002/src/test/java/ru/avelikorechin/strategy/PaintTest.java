package ru.avelikorechin.strategy;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for paint strategy implementation.
 */
public class PaintTest {
    /**
     * Test draw square strategy.
     */
    @Test
    public void whenChooseSquareThenDrawsSquare() {
        Paint testPaint = new Paint(new Square());
        String expected = "****\r\n****\r\n****\r\n****\n";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        testPaint.draw();
        assertThat(out.toString(), is(expected));
    }

    /**
     * Test draw triangle strategy.
     */
    @Test
    public void whenChooseTriangleThenDrawsTriangle() {
        Paint testPaint = new Paint(new Triangle());
        String expected = "*\r\n**\r\n***\r\n****\n";
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        testPaint.draw();
        assertThat(out.toString(), is(expected));

    }
}
