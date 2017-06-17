package ru.avelikorechin.collectionsFramework;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Tests for User list converter.
 * @author Alexander Velikorechin
 * @since 17.06.2017
 */
public class UserConvertTest {
    /**
     * Test convertation of List of Users to Hash Map.
     */
    @Test
    public void whenConvertListOfUsersToMapThenReturnsCorrectResult() {
        UserConvert converter = new UserConvert();
        List<User> users = new ArrayList<>();
        final User user1 = new User(1, "Alex", "Nizhny Novgorod");
        final User user2 = new User(2, "Mike", "New York");
        final User user3 = new User(3, "Vladimir", "Moscow");
        users.add(user1);
        users.add(user2);
        users.add(user3);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(user1.getId(), user1);
        expected.put(user2.getId(), user2);
        expected.put(user3.getId(), user3);
        assertThat(converter.process(users), is(expected));
    }
}
