package ru.avelikorechin.start;
import ru.avelikorechin.models.Item;

import java.util.Random;

/**
 * Tracker for items.
 * @author Alexander Velikorechin
 * @since 13.02.2017
 */
public class Tracker {
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
     * Current free position.
     */
    private int position = 0;
    /**
     * Max length of tracker.
     */
    private final int size = 100;
    /**
     * Item storage of max length.
     */
    private Item[] items = new Item[size];
    /**
     * Input type for tracker.
     */
    private Input input;
    /**
     * Constant for random object.
     */
    private static final Random RN = new Random();
    /**
     * User interface constructor for Tracker.
     * @param input type of input to use
     */
    public Tracker(Input input) {
        this.input = input;
    }
    /**
     * Default constructor for Tracker.
     */
    public Tracker() { }
    /**
     * Method to add items in tracker.
     * @param newItem - item to add
     * @return added item
     */
    public Item add(Item newItem) {
        newItem.setId(this.generateID());
        this.items[position++] = newItem;
        return newItem;
    }

    /**
     * Method to search items by id.
     * @param id of item to search
     * @return item with given id or null if nothing found
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Method to show all the elements of the tracker.
     * @return Array of already added items.
     */
    public Item[] findAll() {
        Item[] result = new Item[this.position];
        int j = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] == null) {
                continue;
            } else {
                result[j++] = this.items[i];
            }
        }
        return result;
    }

    /**
     * Method finds item and updates it.
     * @param updatedItem to add to tracker
     */
    public void update(Item updatedItem) {
        String itemID = updatedItem.getId();
        for (Item item : this.items) {
            if (item != null && item.getId().equals(itemID)) {
                item.setName(updatedItem.getName());
                item.setDescription(updatedItem.getDescription());
                break;
            }
        }
    }
    /** Method finds item and deletes it.
     * @param itemToDelete is item to be deleted
     */
    public void delete(Item itemToDelete) {
        String itemIdToDelete = itemToDelete.getId();
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(itemIdToDelete)) {
                this.items[i] = null;
                break;
            }
        }
    }

    /**
     * Method allows user to manipulate tracker methods easily.
     * @param answer number of option taken from input
     */
    public void performAction(int answer) {
        Item result;
        String name;
        String desc;
        switch (answer) {
            case ADDITEM:
                name = input.ask("Название заявки: ");
                desc = input.ask("Описание: ");
                result = add(new Item(name, desc, System.currentTimeMillis()));
                System.out.println("Заявка добавлена. Присвоен ID: " + result.getId());
            break;

            case FINDBYID:
                result = findById(input.ask("ID заявки: "));
                System.out.println("ID: " + result.getId() + " Название: " + result.getName() + " Описание: " + result.getDescription() + " Дата создания: " + result.getCreate());
            break;

            case FINDALL:
                Item[] allItems = findAll();
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
                update(updateInfo);
            break;

            case DELETE:
                delete(findById(input.ask("ID заявки для удаления: ")));
            break;

            case FINDBYNAME:
                result = findByName(input.ask("Название заявки: "));
                System.out.println("ID: " + result.getId() + " Название: " + result.getName() + " Описание: " + result.getDescription() + " Дата создания: " + result.getCreate());
            break;

            default:
                System.out.println("Недоступная опция");
        }
    }

    /** Method finds item by name and returns it.
     * @param nameToFind name of needed object
     * @return Object with given name
     */
    public Item findByName(String nameToFind) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(nameToFind)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Method to generate unique id for item.
     * @return string presentation of numeric id
     */
    private String generateID() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
