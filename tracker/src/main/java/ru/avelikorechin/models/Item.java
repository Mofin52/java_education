package ru.avelikorechin.models;

/**
 * Common class for items in tracker.
 * @author Alexander Velikorechin
 * @since 13.02.2017
 */
public class Item {
    /**
     * Name of tracker item.
     */
    private String name;
    /**
     * Description of item.
     */
    private String description;
    /**
     * Time of creation.
     */
    private long create;
    /**
     * Unique id of item in tracker.
     */
    private String id;
    /**
     * Constructor for Item class.
     * @param name - to set up
     * @param description - to set up
     * @param create - to set up
     */

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Getter for name field.
     * @return name of item
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name field.
     * @param name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for description of item.
     * @return description of item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description of item.
     * @param description of item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for create time.
     * @return create time
     */
    public long getCreate() {
        return create;
    }

    /**
     * Setter for create time.
     * @param create to set
     */
    public void setCreate(long create) {
        this.create = create;
    }

    /**
     * Getter for unique id of item.
     * @return id of item
     */
    public String getId() {
        return this.id;
    }

    /**
     * Setter for unique id of item.
     * @param id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
