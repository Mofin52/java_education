package ru.avelikorechin.start;

import ru.avelikorechin.models.Item;

/**
 * Tracker start class.
 * @author Alexander Velikorechin
 * @since 08.03.2017
 */
public class MenuTracker {
    /**
     * Constant for exit.
     */
    public static final int EXIT = 0;
    /**
     * Constant for add method.
     */
    public static final int ADDITEM = 1;
    /**
     * Constant for add findById method.
     */
    public static final int FINDBYID = 2;
    /**
     * Constant for findAll method.
     */
    public static final int FINDALL = 3;
    /**
     * Constant for update method.
     */
    public static final int EDIT = 4;
    /**
     * Constant for delete method.
     */
    public static final int DELETE = 5;
    /**
     * Constant for findByName method.
     */
    public static final int FINDBYNAME = 6;
    /**
     * Constant for tracker size method.
     */
    public static final int TRACKERSIZE = 7;
    /**
     * Class input system.
     */
    private Input input;
    /**
     * Class tracker object.
     */
    private Tracker tracker;
    /**
     * Available actions.
     */
    private UserAction[] actions = new UserAction[TRACKERSIZE];
    /**
     * Constructor for MenuTracker class.
     * @param input to use
     * @param tracker to manipulate
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Fills class actions field with available options.
     */
    public void fillActions() {
        this.actions[EXIT] = new Exit();
        this.actions[ADDITEM] = new AddItem();
        this.actions[FINDBYID] = new FindById();
        this.actions[FINDALL] = new FindAll();
        this.actions[EDIT] = new Edit();
        this.actions[DELETE] = new Delete();
        this.actions[FINDBYNAME] = new FindByName();
    }

    /**
     * Method performs action selected by user.
     * @param key is option selected by user
     */
    public void performAction(int key) {
        try {
            this.actions[key].execute(this.input, this.tracker);
        } catch (EmptyTrackerException ete) {
            System.out.println(ete.getMessage());
        } catch (NullPointerException npe) {
            System.out.println("Такой заявки не существует");
        }
    }

    /**
     * Method shows menu.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Returns possible user answers for menu.
     * @return int array of possible answers
     */
    public int[] getPossibleMenuRange() {
        int[] result = new int[TRACKERSIZE];
        for (int i = 0; i < TRACKERSIZE; i++) {
            result[i] = i;
        }
        return result;
    }

    /**
     * Class to invoke add method.
     */
    private class AddItem implements UserAction {

        /**
         * Return class specific id.
         * @return selected option
         */
        @Override
        public int key() {
            return ADDITEM;
        }

        /**
         * Executing the selected action.
         * @param input   input system
         * @param tracker tracker to perform action on
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Название заявки: ");
            String desc = input.ask("Описание: ");
            tracker.add(new Item(name, desc, System.currentTimeMillis()));
            System.out.println("Заявка добавлена");
        }

        /**
         * Says what method is doing.
         * @return string of what method is doing
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавить заявку");
        }
    }

    /**
     * Class to invoke findById method.
     */
    private class FindById implements UserAction {

        /**
         * Return class specific id.
         * @return selected option
         */
        @Override
        public int key() {
            return FINDBYID;
        }

        /**
         * Executing the selected action.
         * @param input   input system
         * @param tracker tracker to perform action on
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.getPosition() == 0) {
                throw new EmptyTrackerException("В трекере нет заявок");
            }
            Item result = tracker.findById(input.ask("ID заявки: "));
            System.out.printf("ID: %s Название: %s Описание: %s Дата создания: %d%n", result.getId(), result.getName(), result.getDescription(), result.getCreate());
        }

        /**
         * Says what method is doing.
         * @return string of what method is doing
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявку по ID");        }
    }

    /**
     * Class to invoke findAll method.
     */
    private class FindAll implements UserAction {

        /**
         * Return class specific id.
         * @return selected option
         */
        @Override
        public int key() {
            return FINDALL;
        }

        /**
         * Executing the selected action.
         * @param input   input system
         * @param tracker tracker to perform action on
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.getPosition() == 0) {
                throw new EmptyTrackerException("В трекере нет заявок");
            }
            Item[] allItems = tracker.findAll();
            for (Item item : allItems) {
                if (item != null) {
                    System.out.printf("ID: %s Название: %s Описание: %s%n", item.getId(), item.getName(), item.getDescription());
                }
            }
        }

        /**
         * Says what method is doing.
         * @return string of what method is doing
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Найти все заявки");
        }
    }

    /**
     * Class to invoke edit method.
     */
    private class Edit implements UserAction {

        /**
         * Return class specific id.
         * @return selected option
         */
        @Override
        public int key() {
            return EDIT;
        }

        /**
         * Executing the selected action.
         * @param input   input system
         * @param tracker tracker to perform action on
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.getPosition() == 0) {
                throw new EmptyTrackerException("В трекере нет заявок");
            }
            String name = input.ask("Новое имя: ");
            String desc = input.ask("Новое описание: ");
            Item updateInfo = new Item(name, desc, System.currentTimeMillis());
            updateInfo.setId(input.ask("ID, для которого выполняем обновление: "));
            tracker.update(updateInfo);
        }

        /**
         * Says what method is doing.
         * @return string of what method is doing
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Редактировать заявку");
        }
    }

    /**
     * Class to invoke delete method.
     */
    private class Delete implements UserAction {

        /**
         * Return class specific id.
         * @return selected option
         */
        @Override
        public int key() {
            return DELETE;
        }

        /**
         * Executing the selected action.
         * @param input   input system
         * @param tracker tracker to perform action on
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.getPosition() == 0) {
                throw new EmptyTrackerException("В трекере нет заявок");
            }
            tracker.delete(tracker.findById(input.ask("ID заявки для удаления: ")));

        }

        /**
         * Says what method is doing.
         *
         * @return string of what method is doing
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку");
        }
    }

    /**
     * Class to invoke findByName method.
     */
    private class FindByName implements UserAction {

        /**
         * Return class specific id.
         * @return selected option
         */
        @Override
        public int key() {
            return FINDBYNAME;
        }

        /**
         * Executing the selected action.
         * @param input   input system
         * @param tracker tracker to perform action on
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            if (tracker.getPosition() == 0) {
                throw new EmptyTrackerException("В трекере нет заявок");
            }
            Item result = tracker.findByName(input.ask("Название заявки: "));
            System.out.printf("ID: %s Название: %s Описание: %s Дата создания: %d%n", result.getId(), result.getName(), result.getDescription(), result.getCreate());
        }

        /**
         * Says what method is doing.
         * @return string of what method is doing
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Найти заявку по названию");
        }
    }

    /**
     * Class to invoke exit option.
     */
    private class Exit implements UserAction {
        /**
         * Return class specific id.
         *
         * @return selected option
         */
        @Override
        public int key() {
            return EXIT;
        }

        /**
         * Executing the selected action.
         *
         * @param input   input system
         * @param tracker tracker to perform action on
         */
        @Override
        public void execute(Input input, Tracker tracker) {

        }

        /**
         * Says what method is doing.
         *
         * @return string of what method is doing
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Выйти");
        }
    }
}
