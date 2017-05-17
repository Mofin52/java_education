package ru.avelikorechin.collectionsFramework;

import org.junit.Test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Class to test CollectionSpeedTester.
 * @author Alexander Velikorechin
 * @since 17.05.2017
 */
public class CollectionsSpeedTesterTest {
    /**
     * Constant for small collection.
     */
    public static final int SMALL_COLLECCTION = 1000;
    /**
     * Constant for medium collection.
     */
    public static final int MEDIUM_COLLECCTION = 10000;
    /**
     * Constant for large collection.
     */
    public static final int LARGE_COLLECTION = 100000;
    /**
     * Constant for collections to test.
     */
    public static final int COLLECTIONS_TO_TEST = 3;
    /**
     * Constant for operations to test.
     */
    public static final int OPERATIONS_TO_TEST = 2;

    /**
     * Test on small collections.
     */
    @Test
    public void testCollectionsOfSmallSize() {
        makeTest(SMALL_COLLECCTION);
    }

    /**
     * Test on medium collections.
     */
    @Test
    public void testCollectionsOfMediumSize() {
        makeTest(MEDIUM_COLLECCTION);
    }

    /**
     * Test on large collections.
     */
    @Test
    public void testCollectionsOfLargeSize() {
        makeTest(LARGE_COLLECTION);
    }

    /**
     * Method to perform test.
     * @param size size of collection to test
     */
    public void makeTest(int size) {
        long[][] result = new long[OPERATIONS_TO_TEST][COLLECTIONS_TO_TEST];
        CollectionsSpeedTester tester = new CollectionsSpeedTester();
        LinkedList<String> linkedList = new LinkedList<String>();
        ArrayList<String> arrayList = new ArrayList<String>();
        TreeSet<String> treeSet = new TreeSet<String>();
        result[0][0] = tester.add(linkedList, "testing line 12345", size);
        result[0][1] = tester.add(arrayList, "testing line 12345", size);
        result[0][2] = tester.add(treeSet, "testing line 12345", size);
        result[1][0] = tester.delete(linkedList, size);
        result[1][1] = tester.delete(arrayList, size);
        result[1][2] = tester.delete(treeSet, size);
        representResults(result);
    }

    /**
     * Method to represent results in console.
     * @param results results of testing
     */
    public void representResults(long[][] results) {
        System.out.println(String.format("Li %sAr %sTr", "\t", "\t"));
        for (int i = 0; i < OPERATIONS_TO_TEST; i++) {
            for (int j = 0; j < COLLECTIONS_TO_TEST; j++) {
                System.out.print(results[i][j] + "\t");
            }
            System.out.println();
        }
    }
}