package ru.avelikorechin.start;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for user interface.
 * @author Alexander Velikorechin
 * @since 18.02.2017
 */
public class ConsoleInput implements Input {
    /**
     * Scanner of user's input.
     */
    private Scanner scanner = new Scanner(System.in);
    /**
     * Ask method.
     * @param question to ask
     * @return answer of user
     */
    public String ask(String question) {
        System.out.print(question);
        String answer = "";
        while (answer.equals("")) {
            answer = scanner.nextLine();
        }
        return answer;
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
     * Method for menu manipulation.
     * @return selected option
     */
    public int askMenu() {
        System.out.print("Ваш выбор: ");
        return scanner.nextInt();
    }

    /**
     * Show console menu.
     * @return selected option
     */
    public String showMenu() {
        String[] menu = {
                "1 - Добавить заявку",
                "2 - Найти заявку по ID",
                "3 - Найти все заявки",
                "4 - Редактировать заявку",
                "5 - Удалить заявку",
                "6 - Найти заявку по имени",
                "0 - Выйти"
        };
        System.out.println("Что вы хотите сделать?");
        for (String option : menu) {
            System.out.println(option);
        }
        String answer = "";
        while (answer.equals("")) {
            answer = this.ask("Ваш выбор: ");
        }
        return answer;
    }
}
