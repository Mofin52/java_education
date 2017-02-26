package ru.avelikorechin.start;

import org.junit.Test;

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
     * Test add item.
     */
    @Test
    public void whenAddItemThenItAppearsInTracker() {
        StartUI ui = setTestUp(new String[] {"1", "Test1", "Test2"});
        ui.performAction(ui.getInput().ask("Foo"));
        final int expectedLength = 1;
        assertThat(ui.getTracker().findAll().length, is(expectedLength));
    }

    /**
     * Test find item by id.
     */
    @Test
    public void whenTryToFindItemByIdThenShowsIt() {
        final long newCreate = 123456;
        StartUI ui = setTestUp(new String[] {"1", "Test1", "Test2", "2", "000"});
        ui.performAction(ui.getInput().ask("Foo"));
        ui.getTracker().findByName("Test1").setId("000");
        ui.getTracker().findByName("Test1").setCreate(newCreate);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ui.performAction(ui.getInput().ask("Foo"));
        assertThat(out.toString(), is(String.format("ID: 000 Название: Test1 Описание: Test2 Дата создания: 123456%s", System.getProperty("line.separator"))));
    }

    /**
     * Test find all items.
     */
    @Test
    public void whenFindAllThenShowsAllItems() {
        StartUI ui = setTestUp(new String[] {"1", "Test1", "Test2", "1", "Test3", "Test4", "3"});
        ui.performAction(ui.getInput().ask("Foo"));
        ui.performAction(ui.getInput().ask("Foo"));
        ui.getTracker().findByName("Test1").setId("000");
        ui.getTracker().findByName("Test3").setId("111");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ui.performAction(ui.getInput().ask("Foo"));
        assertThat(out.toString(), is(String.format("ID: 000 Название: Test1 Описание: Test2%sID: 111 Название: Test3 Описание: Test4%s", System.getProperty("line.separator"), System.getProperty("line.separator"))));
    }

    /**
     * Test update item.
     */
    @Test
    public void whenEditItemThenUpdatesIt() {
        StartUI ui = setTestUp(new String[] {"1", "Test1", "Test2", "4", "NewTest1", "NewTest2", "000"});
        ui.performAction(ui.getInput().ask("Foo"));
        ui.getTracker().findByName("Test1").setId("000");
        ui.performAction(ui.getInput().ask("Foo"));
        assertThat(ui.getTracker().findById("000").getName(), is("NewTest1"));
    }

    /**
     * Test delete item.
     */
    @Test
    public void whenDeleteItemThenItBecomesNull() {
        StartUI ui = setTestUp(new String[] {"1", "Test1", "Test2", "1", "Test3", "Test4", "5", "000"});
        ui.performAction(ui.getInput().ask("Foo"));
        ui.performAction(ui.getInput().ask("Foo"));
        ui.getTracker().findByName("Test3").setId("000");
        ui.performAction(ui.getInput().ask("Foo"));
        assertNull(ui.getTracker().findById("000"));
    }

    /**
     * Test find item by name.
     */
    @Test
    public void whenFindItemByNameThenShowsIt() {
        final long newCreate = 123456;
        StartUI ui = setTestUp(new String[] {"1", "Test1", "Test2", "6", "Test1"});
        ui.performAction(ui.getInput().ask("Foo"));
        ui.getTracker().findByName("Test1").setId("000");
        ui.getTracker().findByName("Test1").setCreate(newCreate);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ui.performAction(ui.getInput().ask("Foo"));
        assertThat(out.toString(), is(String.format("ID: 000 Название: Test1 Описание: Test2 Дата создания: 123456%s", System.getProperty("line.separator"))));
    }

    /**
     * Test close program.
     */
    @Test
    public void whenExitThenShowsByeByeMessage() {
        final String[] actions = new String[] {"0"};
        final Input input = new StubInput(actions);
        final StartUI ui = new StartUI(input);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ui.performAction(input.ask("Foo question"));
        assertThat(out.toString(), is(String.format("Завершаем работу программы%s", System.getProperty("line.separator"))));
    }

    /**
     * Test incorrect option choice.
     */
    @Test
    public void whenTypeIncorrectOptionThenAsksForAnotherInput() {
        StartUI ui = setTestUp(new String[] {"problem"});
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ui.performAction(ui.getInput().ask("Foo"));
        assertThat(out.toString(), is(String.format("Выберите другую опцию%s", System.getProperty("line.separator"))));
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
