package ru.avelikorechin.bankStat;

import java.util.Random;

/**
 * Class to describe abstract bank client activity.
 * @author Alexander Velikorechin
 * @since 01.04.2017
 */
public class Client {
    /**
     * Time of coming to bank.
     */
    private int comeTime;
    /**
     * Time of leaving the bank.
     */
    private int leaveTime;
    /**
     * Utility variable to get random values.
     */
    private Random rand = new Random();

    /**
     * Constructor for clients.
     */
    public Client() {
        this.comeTime = rand.nextInt(Bank.END - Bank.START) + Bank.START;
        this.leaveTime = rand.nextInt(Bank.END - this.comeTime) + this.comeTime;
    }

    /**
     * Constructor for clients.
     * @param comeTime of client in seconds from the beginning of day
     * @param leaveTime of client in seconds from the beginning of day
     */
    public Client(int comeTime, int leaveTime) {
        this.comeTime = comeTime;
        this.leaveTime = leaveTime;
    }

    /**
     * Getter for comeTime value.
     * @return comeTime
     */
    public int getComeTime() {
        return this.comeTime;
    }

    /**
     * Getter for leaveTime value.
     * @return leaveTime
     */
    public int getLeaveTime() {
        return this.leaveTime;
    }

}
