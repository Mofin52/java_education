package ru.avelikorechin.start;

import ru.avelikorechin.models.Item;

/**
 * Tracker start class.
 * @author Alexander Velikorechin
 * @since 08.03.2017
 */
public class MenuTracker {
    /**
     * Position of new action.
     */
    private int position = 0;
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
        this.actions[position++] = new BaseAction("Выйти") {
            @Override
            public int key() {
                return EXIT;
            }

            @Override
            public void execute(Input input, Tracker tracker) {

            }
        };

        this.actions[position++] = new BaseAction("Добавить заявку") {
            @Override
            public int key() {
                return ADDITEM;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                String name = input.ask("Название заявки: ");
                String desc = input.ask("Описание: ");
                tracker.add(new Item(name, desc, System.currentTimeMillis()));
                System.out.println("Заявка добавлена");
            }
        };

        this.actions[position++] = new BaseAction("Найти заявку по ID") {
            @Override
            public int key() {
                return FINDBYID;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                if (tracker.getPosition() == 0) {
                    throw new EmptyTrackerException("В трекере нет заявок");
                }
                Item result = tracker.findById(input.ask("ID заявки: "));
                System.out.printf("ID: %s Название: %s Описание: %s Дата создания: %d%n", result.getId(), result.getName(), result.getDescription(), result.getCreate());
            }
        };
        this.actions[position++] = new BaseAction("Найти все заявки") {
            @Override
            public int key() {
                return FINDALL;
            }

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
        };
        this.actions[position++] = new BaseAction("Редактировать заявку") {
            @Override
            public int key() {
                return EDIT;
            }

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
        };
        this.actions[position++] = new BaseAction("Удалить заявку") {
            @Override
            public int key() {
                return DELETE;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                if (tracker.getPosition() == 0) {
                    throw new EmptyTrackerException("В трекере нет заявок");
                }
                tracker.delete(tracker.findById(input.ask("ID заявки для удаления: ")));
            }
        };
        this.actions[position++] = new BaseAction("Найти заявку по названию") {
            @Override
            public int key() {
                return FINDBYNAME;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                if (tracker.getPosition() == 0) {
                    throw new EmptyTrackerException("В трекере нет заявок");
                }
                Item result = tracker.findByName(input.ask("Название заявки: "));
                System.out.printf("ID: %s Название: %s Описание: %s Дата создания: %d%n", result.getId(), result.getName(), result.getDescription(), result.getCreate());
            }
        };
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
}
