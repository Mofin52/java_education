package ru.avelikorechin.start;

import java.util.ArrayList;

/**
 * Class to validate stub input.
 * @author Alexander Velikorechin
 * @since 17.03.2017
 */
public class StubValidateInput extends StubInput {
    /**
     * Constructor for StubValidateInput class.
     * @param answers Array of answers to use
     */
    public StubValidateInput(String[] answers) {
        super(answers);
    }

    /**
     * Ask method for valid int values.
     * @param question to ask
     * @param range to validate answer
     * @return answer of user
     */
    @Override
    public int ask(String question, ArrayList<Integer> range) {
            int value = 0;
            try {
                value = super.ask(question, range);
            } catch (MenuOutException moe) {
                System.out.println(moe.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректные данные");
            }
            return value;
    }

}