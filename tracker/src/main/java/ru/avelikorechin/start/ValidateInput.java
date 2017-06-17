package ru.avelikorechin.start;


import java.util.ArrayList;

/**
 * Class to validate user input.
 * @author Alexander Velikorechin
 * @since 17.03.2017
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Ask method for valid int values.
     * @param question to ask
     * @param range to validate answer
     * @return answer of user
    */
    @Override
    public int ask(String question, ArrayList<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println(moe.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Введите корректные данные");
            }
        } while (invalid);
        return value;
    }

}