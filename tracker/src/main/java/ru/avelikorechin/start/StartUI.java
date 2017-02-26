package ru.avelikorechin.start;


import ru.avelikorechin.models.Item;

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
     * Tracker for current StartUI.
     */
    private Tracker tracker = new Tracker(input);
    /**
     * Constant for exit.
     */
    public static final String EXIT = "0";
    /**
     * Constant for add method.
     */
    public static final String ADDITEM = "1";
    /**
     * Constant for add findById method.
     */
    public static final String FINDBYID = "2";
    /**
     * Constant for findAll method.
     */
    public static final String FINDALL = "3";
    /**
     * Constant for update method.
     */
    public static final String EDIT = "4";
    /**
     * Constant for delete method.
     */
    public static final String DELETE = "5";
    /**
     * Constant for findByName method.
     */
    public static final String FINDBYNAME = "6";
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
        String answer = "";
        do {
            answer = input.showMenu();
            performAction(answer);
        } while (!answer.equals("0"));
    }

    /**
     * Method allows user to manipulate tracker methods easily.
     * @param answer number of option taken from input
     */
    public void performAction(String answer) {
        Item result;
        String name;
        String desc;
        switch (answer) {
            case ADDITEM:
                name = input.ask("Название заявки: ");
                desc = input.ask("Описание: ");
                result = this.tracker.add(new Item(name, desc, System.currentTimeMillis()));
                System.out.println("Заявка добавлена. Присвоен ID: " + result.getId());
                break;

            case FINDBYID:
                result = this.tracker.findById(input.ask("ID заявки: "));
                System.out.println("ID: " + result.getId() + " Название: " + result.getName() + " Описание: " + result.getDescription() + " Дата создания: " + result.getCreate());
                break;

            case FINDALL:
                Item[] allItems = this.tracker.findAll();
                for (Item item : allItems) {
                    if (item != null) {
                        System.out.println("ID: " + item.getId() + " Название: " + item.getName() + " Описание: " + item.getDescription());
                    }
                }
                break;

            case EDIT:
                name = input.ask("Новое имя: ");
                desc = input.ask("Новое описание: ");
                Item updateInfo = new Item(name, desc, System.currentTimeMillis());
                updateInfo.setId(input.ask("ID, для которого выполняем обновление: "));
                this.tracker.update(updateInfo);
                break;

            case DELETE:
                this.tracker.delete(this.tracker.findById(input.ask("ID заявки для удаления: ")));
                break;

            case FINDBYNAME:
                result = this.tracker.findByName(input.ask("Название заявки: "));
                System.out.println("ID: " + result.getId() + " Название: " + result.getName() + " Описание: " + result.getDescription() + " Дата создания: " + result.getCreate());
                break;

            case EXIT:
                System.out.println("Завершаем работу программы");
                break;

            default:
                System.out.println("Выберите другую опцию");
        }
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

    /**
     * Method to return inner tracker.
     * @return tracker of current ui
     */
    public Tracker getTracker() {
        return this.tracker;
    }

    /**
     * Method to return inner input field.
     * @return input of object
     */
    public Input getInput() {
        return this.input;
    }
}
