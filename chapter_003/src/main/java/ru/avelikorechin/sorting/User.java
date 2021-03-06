package ru.avelikorechin.sorting;

/**
 * User model.
 */
public class User implements Comparable {
    /**
     * Field for user name.
     */
    private String name;
    /**
     * Field for user age.
     */
    private int age;

    /**
     * Constructor for User class.
     * @param name name of user
     * @param age age of user
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Getter for age.
     * @return age of User.
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Getter for name.
     * @return name of User
     */
    public String getName() {
        return this.name;
    }

    /**
     * Compare objects base on age.
     * @param o object to compare with
     * @return the bigger object
     */
    @Override
    public int compareTo(Object o) {
        return this.getAge() - ((User) o).getAge();
    }
}
