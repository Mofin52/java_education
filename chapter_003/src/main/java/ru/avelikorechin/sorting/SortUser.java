package ru.avelikorechin.sorting;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
/**
 * Sort user methods.
 * @author Alexander Velikorechin
 * @since 13.07.2017
 */
public class SortUser {

    /**
     * Sort user by age in ascending order.
     * @param userList incoming list
     * @return TreeSet of users sorted by age in ascending order
     */
    public Set<User> sort(List<User> userList) {
        Set<User> result = new TreeSet<User>();
        result.addAll(userList);
        return result;
    }

    /**
     * Sorts users in collection by name length in ascending order.
     * @param input raw collection
     * @return collection sorted by name length in ascending order
     */
    public List<User> sortNameLength(List<User> input) {
        input.sort(new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getName().length() - t1.getName().length();
            }
        });
        return input;
    }

    /**
     * Sort user by all fields.
     * @param input raw collection
     * @return sorted collection
     */
    public List<User> sortByAllFields(List<User> input) {
        input.sort(new Comparator<User>() {
            @Override
            public int compare(User user, User t1) {
                return user.getName().equals(t1.getName()) ? user.getAge() - t1.getAge() : user.getName().compareTo(t1.getName());
            }
        });
        return input;
    }
}
