package ru.avelikorechin.start;

import java.util.ArrayList;

/**
 * Input interface.
 * @author Alexander Velikorechin
 * @since 18.02.2017
 */
public interface Input {
    /**
     * Ask method.
     * @param question to ask
     * @return answer of user
     */
    String ask(String question);

    /**
     * Ask method for int values.
     * @param question to ask
     * @param range to validate answer
     * @return answer of user
     */
    int ask(String question, ArrayList<Integer> range);
    /**
     * Method shows menu for input.
     * @return input from console
     */
    String showMenu();
}
