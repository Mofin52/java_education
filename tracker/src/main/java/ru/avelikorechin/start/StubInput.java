package ru.avelikorechin.start;

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
}
