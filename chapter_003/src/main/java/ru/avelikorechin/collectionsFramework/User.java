package ru.avelikorechin.collectionsFramework;

/**
 * User class.
 * @author Alexander Velikorechin
 * @since 17.06.2017
 */
public class User {
    /**
     * User id.
     */
    private int id;
    /**
     * User name.
     */
    private String name;
    /**
     * User city.
     */
    private String city;

    /**
     * Constructor for User class.
     * @param id id of user
     * @param name name of user
     * @param city city of user
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Returns id of user.
     * @return id of user
     */
    public int getId() {
        return this.id;
    }

}
