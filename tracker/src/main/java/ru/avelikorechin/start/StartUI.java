package ru.avelikorechin.start;


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
        Tracker tracker = new Tracker(input);
        int answer = -1;
        do {
            if (input instanceof ConsoleInput) {
                answer = ((ConsoleInput) input).showMenu();
            } else {
                String stringAnswer = ((StubInput) input).ask("Foo question");
                answer = Integer.valueOf(stringAnswer);
            }
            tracker.performAction(answer);
        } while (answer != 0);
    }
    /**
     * Entering point.
     * @param args of main
     */
    public static void main(String[] args) {
        //Input input = new StubInput(new String[]{"create stub task"});
        Input input = new ConsoleInput();
        new StartUI(input).init();
    }
}
