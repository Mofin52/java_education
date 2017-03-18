package ru.avelikorechin.start;

/**
 * Class to validate user input.
 * @author Alexander Velikorechin
 * @since 18.03.2017
 */
public abstract class BaseAction implements UserAction {
    /**
     * Name of action for menu.
     */
    private String name;

    /**
     * Constructor.
     * @param name name of action
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     * Method returns action key.
     * @return key of action
     */
    public abstract int key();

    /**
     * Method executes selected action.
     * @param input input system
     * @param tracker tracker to perform action on
     */
    public abstract void execute(Input input, Tracker tracker);

    /**
     * Returns name of action for menu.
     * @return name of action
     */
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }
}
