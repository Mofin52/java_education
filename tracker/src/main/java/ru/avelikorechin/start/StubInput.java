package ru.avelikorechin.start;

import java.util.ArrayList;

/**
 * Class for automatic user input.
 * @author Alexander Velikorechin
 * @since 18.02.2017
 */
public class StubInput implements Input {
    /**
     * Array of possible answers.
     */
    private String[] answers;
    /**
     * Counter to pass through array of answers.
     */
    private int position = 0;
    /**
     * Constructor for StubInput class.
     * @param answers Array of answers to use
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }
    /**
     * Ask method.
     * @param question to ask
     * @return answer of user
     */
    public String ask(String question) {
        return this.answers[position++];
    }

    /**
     * Ask method for int values.
     * @param question to ask
     * @param range to validate answer
     * @return answer of user
     */
    public int ask(String question, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exists = false;
        for (int value : range) {
            if (key == value) {
                exists = true;
                break;
            }
        }
        if (exists) {
            return key;
        } else {
            throw new MenuOutException("Такой опции не существует");
        }
    }

    /**
     * Method asks for menu input.
     * @return selected option
     */
    public String showMenu() {
        return ask("Ваш выбор:");
    }
}
