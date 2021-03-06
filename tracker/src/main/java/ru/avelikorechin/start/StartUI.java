package ru.avelikorechin.start;

import java.util.ArrayList;

/**
 * Tracker start class.
 * @author Alexander Velikorechin
 * @since 13.02.2017
 */
public class StartUI {
    /**
     * Input type for UI.
     */
    private Input input;
    /**
     * Link to tracker we're working with.
     */
    private Tracker linkToTracker = new Tracker(this.input);
    /**
     * Constructor for StartUI.
     * @param input type of input
     */
    public StartUI(Input input) {
        this.input = input;
    }
    /**
     * Initialization for StartUI.
     */
    public void init() {
        Tracker tracker = this.linkToTracker;
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        ArrayList<Integer> range = menu.getPossibleMenuRange();
        int answer;
        do {
            menu.show();
            answer = input.ask("Ваш выбор: ", range);
            menu.performAction(answer);
        } while (answer != 0);
    }

    /**
     * Entering point.
     * @param args of main
     */
    public static void main(String[] args) {
        //Input input = new StubInput(new String[]{"create stub task"});
        Input input = new ValidateInput();
        new StartUI(input).init();
    }

    /**
     * Method to return inner tracker field.
     * @return link to tracker used in session
     */
    public Tracker getLinkToTracker() {
        return this.linkToTracker;
    }
}
