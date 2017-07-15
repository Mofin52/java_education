package ru.avelikorechin.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
}
