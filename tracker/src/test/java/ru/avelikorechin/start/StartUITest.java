package ru.avelikorechin.start;

import com.google.common.base.Joiner;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import ru.avelikorechin.models.Item;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Class for testing StartUI.
 * @author Alexander Velikorechin
 * @since 24.02.2017
 */
public class StartUITest {
    /**
     * Constant to use for create date for items.
     */
    public static final long CUSTOMCREATE = 123456L;
    /**
     * Test add item.
     */
    @Test
    public void whenAddItemThenItAppearsInTracker() {
        StartUI ui = setTestUp(new String[] {"1", "Test1", "Test2", "0"});
        ui.init();
        final int expectedLength = 1;
        assertThat(ui.getLinkToTracker().findAll().length, is(expectedLength));
    }

    /**
     * Test find item by id.
     */
    @Test
    public void whenTryToFindItemByIdThenShowsIt() {
        StartUI ui = setTestUp(new String[] {"2", "000", "0"});
        ui.getLinkToTracker().add(new Item("Test1", "Test2", CUSTOMCREATE));
        ui.getLinkToTracker().findByName("Test1").setId("000");
        String expected = Joiner.on(" ").join(
                "ID: 000",
                "Название: Test1",
                "Описание: Test2",
                "Дата создания: 123456" + System.getProperty("line.separator"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ui.init();
        assertThat(out.toString(), CoreMatchers.containsString(expected));
    }

    /**
     * Test find all items.
     */
    @Test
    public void whenFindAllThenShowsAllItems() {
        StartUI ui = setTestUp(new String[] {"3", "0"});
        ui.getLinkToTracker().add(new Item("Test1", "Test2", CUSTOMCREATE));
        ui.getLinkToTracker().add(new Item("Test3", "Test4", CUSTOMCREATE));
        ui.getLinkToTracker().findByName("Test1").setId("000");
        ui.getLinkToTracker().findByName("Test3").setId("111");
        String expected = Joiner.on(" ").join(
                "ID: 000",
                "Название: Test1",
                "Описание: Test2" + System.getProperty("line.separator") + "ID: 111",
                "Название: Test3",
                "Описание: Test4" + System.getProperty("line.separator"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ui.init();
        assertThat(out.toString(), CoreMatchers.containsString(expected));
    }

    /**
     * Test update item.
     */
    @Test
    public void whenEditItemThenUpdatesIt() {
        StartUI ui = setTestUp(new String[] {"4", "NewTest1", "NewTest2", "000", "0"});
        ui.getLinkToTracker().add(new Item("Test1", "Test2", CUSTOMCREATE));
        ui.getLinkToTracker().findByName("Test1").setId("000");
        ui.init();
        assertThat(ui.getLinkToTracker().findById("000").getName(), is("NewTest1"));
    }

    /**
     * Test delete item.
     */
    @Test
    public void whenDeleteItemThenItBecomesNull() {
        StartUI ui = setTestUp(new String[] {"5", "000", "0"});
        ui.getLinkToTracker().add(new Item("Test1", "Test2", CUSTOMCREATE));
        ui.getLinkToTracker().add(new Item("Test3", "Test4", CUSTOMCREATE));
        ui.getLinkToTracker().findByName("Test3").setId("000");
        ui.init();
        assertNull(ui.getLinkToTracker().findById("000"));
    }

    /**
     * Test find item by name.
     */
    @Test
    public void whenFindItemByNameThenShowsIt() {
        StartUI ui = setTestUp(new String[] {"6", "Test1", "0"});
        ui.getLinkToTracker().add(new Item("Test1", "Test2", CUSTOMCREATE));
        ui.getLinkToTracker().findByName("Test1").setId("000");
        String expected = Joiner.on(" ").join(
                "ID: 000",
                "Название: Test1",
                "Описание: Test2",
                "Дата создания: 123456" + System.getProperty("line.separator"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ui.init();
        assertThat(out.toString(), CoreMatchers.containsString(expected));
    }

    /**
     * Method creates everything we need for tests.
     * @param answers what actions will be made by StupInput class
     * @return ui set to make tests
     */
    private StartUI setTestUp(String[] answers) {
        final String[] actions = answers;
        final Input input = new StubInput(actions);
        final StartUI ui = new StartUI(input);
        return ui;
    }

}
