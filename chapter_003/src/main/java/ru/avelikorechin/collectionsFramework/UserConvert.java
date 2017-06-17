package ru.avelikorechin.collectionsFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Converter of User class.
 * @author Alexander Velikorechin
 * @since 17.06.2017
 */
public class UserConvert {

    /**
     * Converts list of Users to HashMap.
     * @param list list of users
     * @return HashMap Collection of users
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User currentUser = iterator.next();
            result.put(currentUser.getId(), currentUser);
        }
        return result;
    }
}
