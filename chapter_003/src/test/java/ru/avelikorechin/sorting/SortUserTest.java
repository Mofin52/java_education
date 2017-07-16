package ru.avelikorechin.sorting;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Tests for SortUser class.
 */
public class SortUserTest {
    /**
     * Test sort by age.
     */
    @Test
    public void whenSortUsersByAgeThenReturnsTheYoungestFirst() {
        List<User> userList = prepareCollection();
        SortUser sorter = new SortUser();
        Set<User> result = sorter.sort(userList);
        assertThat(result.iterator().next().getName(), is("Julia"));
    }

    /**
     * Test sort by name length.
     */
    @Test
    public void whenSortUsersByNameLengthThenReturnsTheUserWithShortestNameFirst() {
        List<User> userList = prepareCollection();
        SortUser sorter = new SortUser();
        List<User> result = sorter.sortNameLength(userList);
        assertThat(result.iterator().next().getName(), is("Julia"));
    }

    /**
     * Test sort by both fields.
     */
    @Test
    public void whenSortUsersByAllFieldLengthThenReturnsTheYoungerUsersWithSameNamesFirst() {
        List<User> userList = prepareCollection();
        final int expectedAge = 78;
        SortUser sorter = new SortUser();
        List<User> result = sorter.sortByAllFields(userList);
        assertThat(result.get(2).getAge(), is(expectedAge));
    }

    /**
     * Method to prepare collection for test.
     * @return collection for test with 4 users
     */
    public List<User> prepareCollection() {
        List<User> userList = new ArrayList<User>();
        final User user1  = new User("Harold", 20);
        final User user2  = new User("Julia", 18);
        final User user3  = new User("Panteleimon", 90);
        final User user4 = new User("Panteleimon", 78);
        userList.addAll(Arrays.asList(user1, user2, user3, user4));
        return userList;
    }
}