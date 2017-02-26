package ru.avelikorechin.start;

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
     * Method shows menu for input.
     * @return input from console
     */
    String showMenu();
}
