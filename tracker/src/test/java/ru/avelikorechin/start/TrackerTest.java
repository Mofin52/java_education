package ru.avelikorechin.start;
import ru.avelikorechin.models.Item;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Tests for tracker app.
 * @author Alexander Velikorechin
 * @since 13.02.2017
 */
public class TrackerTest {
    /**
     * Test tracker add.
     */
    @Test
    public void whenAddElementThenAddsItToTheFirstNullElement() {
        Tracker tracker = new Tracker();
        Item item = new Item("firstName", "firstDescription", 1L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }
    /**
     * Test tracker find by id with result.
     */
    @Test
    public void whenSearchElByIdThenReturnsCorrectResult() {
        Tracker tracker = new Tracker();
        Item item = new Item("firstName", "firstDescription", 1L);
        tracker.add(item);
        String itemId = item.getId();
        assertThat(tracker.findById(itemId), is(item));
    }
    /**
     * Test tracker find by id with no result.
     */
    @Test
    public void whenSearchElByRandomIdThenReturnsNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("firstName", "firstDescription", 1L);
        tracker.add(item);
        String itemId = item.getId();
        assertNull(tracker.findById("123456"));
    }
    /**
     * Test tracker find all.
     */
    @Test
    public void whenFindAllThenReturnsCorrectArray() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("firstName", "firstDescription", 1L);
        Item item2 = new Item("secondName", "secondDescription", 2L);
        tracker.add(item1);
        tracker.add(item2);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        assertThat(tracker.findAll(), is(expected));
    }
    /**
     * Test tracker update.
     */
    @Test
    public void whenUpdateItemThenActsCorrectly() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("firstName", "firstDescription", 1L);
        tracker.add(item1);
        item1.setName("Edited Name");
        tracker.update(item1);
        assertThat(tracker.findAll().get(0).getName(), is("Edited Name"));
    }
    /**
     * Test tracker delete.
     */
    @Test
    public void whenDeleteElementThenItBecomesNull() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("firstName", "firstDescription", 1L);
        tracker.add(item1);
        tracker.delete(item1);
        assertTrue(tracker.findAll().isEmpty());
    }
    /**
     * Test tracker find by name.
     */
    @Test
    public void whenFindElByNameThenReturnsIt() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("firstName", "firstDescription", 1L);
        Item item2 = new Item("secondName", "secondDescription", 2L);
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findByName("secondName"), is(item2));
    }
}
