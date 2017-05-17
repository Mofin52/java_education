package ru.avelikorechin.collectionsFramework;

import java.util.Collection;

/**
 * Class to test collections speed.
 * @author Alexander Velikorechin
 * @since 17.05.2017
 */
public class CollectionsSpeedTester {
    /**
     * Calculates time of adding ammount of given strings to collection.
     * @param collection collection to test
     * @param line line to add
     * @param amount amount of collection members
     * @return time of insertion
     */
    public long add(Collection<String> collection, String line, int amount) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            collection.add(line);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }

    /**
     * Calculates time of deleting elements from collection.
     * @param collection collection to test
     * @param amount amount of members to delete
     * @return time of deletion
     */
    public long delete(Collection<String> collection, int amount) {
        long start = System.currentTimeMillis();
        String line = (String) collection.toArray()[0];
        for (int i = 0; i < amount; i++) {
            collection.remove(line);
        }
        long finish = System.currentTimeMillis();
        return finish - start;
    }
}