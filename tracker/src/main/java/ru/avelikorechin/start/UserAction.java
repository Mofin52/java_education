package ru.avelikorechin.start;

/**
 * Tracker start class.
 * @author Alexander Velikorechin
 * @since 08.03.2017
 */
public interface UserAction {
    /**
     * Return class specific id.
     * @return selected option
     */
    int key();

    /**
     * Executing the selected action.
     * @param input input system
     * @param tracker tracker to perform action on
     */
    void execute(Input input, Tracker tracker);

    /**
     * Says what method is doing.
     * @return string of what method is doing
     */
    String info();
}
