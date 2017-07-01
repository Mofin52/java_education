package ru.avelikorechin.start;
import ru.avelikorechin.models.Item;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

/**
 * Tracker for items.
 * @author Alexander Velikorechin
 * @since 13.02.2017
 */
public class Tracker {

    /**
     * Current free position.
     */
    private int position = 0;
    /**
     * Item storage of max length.
     */
    private ArrayList<Item> items = new ArrayList<>();
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
        this.items.add(position++, newItem);
        return newItem;
    }

    /**
     * Method to search items by id.
     * @param id of item to search
     * @return item with given id or null if nothing found
     */
    public Item findById(String id) {
        Item result = new Item("something", "new", 0L);
        result.setId(id);
        return items.contains(result) ? items.get(items.indexOf(result)) : null;
    }

    /**
     * Method to show all the elements of the tracker.
     * @return Array of already added items.
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        result.addAll(this.items);
        result.removeIf(Predicate.isEqual(null));
        return result;
    }

    /**
     * Method finds item and updates it.
     * @param updatedItem to add to tracker
     */
    public void update(Item updatedItem) {
        Item goalItem = this.items.contains(updatedItem) ? this.items.get(this.items.indexOf(updatedItem)) : null;
        if (goalItem.getClass() != null) {
            goalItem.setName(updatedItem.getName());
            goalItem.setDescription(updatedItem.getDescription());
        } else {
            throw new NullPointerException("Такой заявки не существует");
        }
    }
    /** Method finds item and deletes it.
     * @param itemToDelete is item to be deleted
     */
    public void delete(Item itemToDelete) {
        this.items.remove(this.items.indexOf(itemToDelete));
    }

    /** Method finds item by name and returns it.
     * @param nameToFind name of needed object
     * @return Item with given name
     */
    public Item findByName(String nameToFind) {
        Object[] searchRes = this.items.stream().filter(item -> item.getName() == nameToFind).toArray();
        return searchRes.length > 0 ? (Item) searchRes[0] : null;
    }

    /**
     * Getter for position value.
     * @return current position
     */
    public int getPosition() {
        return this.position;
    }

    /**
     * Method to generate unique id for item.
     * @return string presentation of numeric id
     */
    private String generateID() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}