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
        List<User> userList = new ArrayList<>();
        final User user1  = new User("Alex", 20);
        final User user2  = new User("Julia", 18);
        final User user3  = new User("Panteleimon", 90);
        userList.addAll(Arrays.asList(user1, user2, user3));
        SortUser sorter = new SortUser();
        Set<User> result = sorter.sort(userList);
        assertThat(result.iterator().next(), is(user2));
    }
}