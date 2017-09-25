package ru.avelikorechin.bankStat;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class to test abstract bank daily activity.
 * @author Alexander Velikorechin
 * @since 02.04.2017
 */
public class BankTest {
    /**
     * Array of clients.
     */
    private final Client[] dataToSet = {
            new Client(28800, 28900),
            new Client(28850, 28950),
            new Client(30000, 40000),
            new Client(41000, 42000),
            new Client(43000, 44000)
    };
    /**
     * Number of clients to serve.
     */
    private final int numberOfClients = 5;

    /**
     * Test count bank daily stat.
     */
    @Test
    public void whenTryCountClientsReturnsCorrectStat() {
        Bank sber = setTestUp(numberOfClients, dataToSet);
        double[] result = sber.countsDailyStat();
        final double expectedCount = 2;
        final double expectedTime = 28850;
        assertThat(result[0], is(expectedCount));
        assertThat(result[1], is(expectedTime));
    }

    /**
     * Test representation of info.
     */
    @Test
    public void whenTryToSeeResultPrintsCorrectString() {
        Bank sber = setTestUp(numberOfClients, dataToSet);
        double[] result = sber.countsDailyStat();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        sber.representStat(result);
        String expectedString = "Наибольшее число клиентов - 2 в 08:00:50";
        assertThat(out.toString(), is(expectedString));
    }

    /**
     * Setting test variables.
     * @param numberOfClients how many clients bank serves per day
     * @param dataToSet info about clients come and leave time
     * @return bank to test methods
     */
    public Bank setTestUp(int numberOfClients, Client[] dataToSet) {
        Bank testBank = new Bank(numberOfClients);
        testBank.setDailyClients(dataToSet);
        return testBank;
    }
}

