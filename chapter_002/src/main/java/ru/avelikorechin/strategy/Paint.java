package ru.avelikorechin.strategy;

/**
 * Class to draw a shape according to selected strategy.
 * @author Alexander Velikorechin.
 * @since 26.02.2017
 */
public class Paint {
    /**
     * Shape to be used.
     */
    private Shape shape;

    /**
     * Constructor for Paint class.
     * @param shape to assign to class field
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    /**
     * Puts pseudographics to console.
     */
    public void draw() {
        System.out.println(this.shape.pic());
    }
}
