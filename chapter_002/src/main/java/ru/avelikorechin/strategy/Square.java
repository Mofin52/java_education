package ru.avelikorechin.strategy;

/**
 * Square implementation of Shape strategy.
 * @author Alexander Velikorechin
 * @since 26.02.2017
 */
public class Square implements Shape {
    /**
     * Method to return pseudographics.
     * @return string of pseudographics
     */
    @Override
    public String pic() {
        return "****\r\n****\r\n****\r\n****";
    }
}
