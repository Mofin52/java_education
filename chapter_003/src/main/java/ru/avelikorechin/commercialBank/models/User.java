package ru.avelikorechin.commercialBank.models;

/**
 * User - a client of bank.
 * @author Alexander Velikorechin
 * @since 21.07.2017
 */
public class User implements Comparable {
    /**
     * Name of bank's user.
     */
    private String name;
    /**
     * Passport series and number.
     */
    private int passport;

    /**
     * Constructor for User.
     * @param name name of bank's client
     * @param passport passport series and number of user
     */
    public User(String name, int passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Getter for passport.
     * @return passport of user
     */
    public int getPassport() {
        return this.passport;
    }


    /**
     * New equals method for User class.
     * @param o object to compare with
     * @return true if users are the same, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return passport == user.passport;
    }


    /**
     * New hashcode method for User class.
     * @return hashcode of User object
     */
    @Override
    public int hashCode() {
        final int notAMagicNumberForCobertura = 31;
        int result = name != null ? name.hashCode() : 0;
        result = notAMagicNumberForCobertura * result + passport;
        return result;
    }

    /**
     * New compareTo method based on passport.
     * @param o object to compare with.
     * @return 0 if objects are equal, 1 if current is bigger, -1 if current is smaller
     */
    @Override
    public int compareTo(Object o) {
        return this.equals((User) o) ? 0 : this.passport - ((User) o).getPassport();
    }
}