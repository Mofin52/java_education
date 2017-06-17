package ru.avelikorechin.start;
import ru.avelikorechin.models.Item;

import java.util.ArrayList;
import java.util.Random;

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
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item == null) {
                continue;
            } else {
                result.add(item);
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
        boolean noSuchElement = true;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(itemID)) {
                item.setName(updatedItem.getName());
                item.setDescription(updatedItem.getDescription());
                noSuchElement = false;
                break;
            }
        }
        if (noSuchElement) {
            throw new NullPointerException("Такой заявки не существует");
        }
    }
    /** Method finds item and deletes it.
     * @param itemToDelete is item to be deleted
     */
    public void delete(Item itemToDelete) {
        String itemIdToDelete = itemToDelete.getId();
        for (int i = 0; i < this.position; i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(itemIdToDelete)) {
                this.items.remove(i);
                break;
            }
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
