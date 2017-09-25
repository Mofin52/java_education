package ru.avelikorechin.bankStat;


import ru.avelikorechin.bankStat.utils.ArrayUtils;

/**
 * Class to describe abstract bank daily activity.
 * @author Alexander Velikorechin
 * @since 01.04.2017
 */
public class Bank {
    /**
     * Number of clients visited bank today.
     */
    private int numberOfClients;
    /**
     * Array to keep data of all of the clients.
     */
    private Client[] dailyClients;
    /**
     * Array to keep data of all of the clients come and leave time.
     */
    private double[] comeAndLeaveTimeData;
    /**
     * Constant of when bank starts work in seconds from beginning of day.
     */
    public static final int START = 28800;
    /**
     * Constant of when bank ends work in seconds from beginning of day.
     */
    public static final int END = 72000;
    /**
     * Misc value to mark leavedate in comeAndLeaveTimeData array.
     */
    private final double leaveMark = 0.000001;

    /**
     * Constructor for Bank class.
     * @param numberOfClients how many clients bank serves
     */
    public Bank(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }

    /**
     * Fills array of daily clients.
     */
    private void fillDailyClients() {
        for (int i = 0; i < numberOfClients; i++) {
            dailyClients[i] = new Client();
        }
    }

    /**
     * Counts stat of daily bank work.
     * @return array of maximum client count and time
     */
    public double[] countsDailyStat() {
        prepareData();
        int currentCounter = 0;
        double[] maxClients = {currentCounter, START};
        for (int i = 0; i < comeAndLeaveTimeData.length; i++) {
            if ((this.comeAndLeaveTimeData[i] - (int) this.comeAndLeaveTimeData[i]) == 0) {
                currentCounter++;
                if (currentCounter > maxClients[0]) {
                    maxClients[0] = currentCounter;
                    maxClients[1] = comeAndLeaveTimeData[i];
                }
            } else {
                currentCounter--;
            }
        }
        return maxClients;
    }

    /**
     * Converts time in seconds to normal time and prints it.
     * @param stat stat array to convert
     */
    public void representStat(double[] stat) {
        final int sixtyInSeconds = 3600;
        final int sixty = 60;
        int time = (int) stat[1];
        int clients = (int) stat[0];
        int hours = time / sixtyInSeconds;
        int minutes = time % sixtyInSeconds / sixty;
        int seconds = time % sixty;
        System.out.print(String.format("Наибольшее число клиентов - %d в %02d:%02d:%02d", clients, hours, minutes, seconds));
    }

    /**
     * Method fills arrays needed for analysis.
     */
    private void prepareData() {
        double[] comeList = getClientComeTime(this.dailyClients);
        double[] leaveList = getClientLeaveTime(this.dailyClients);
        comeList = ArrayUtils.bubbleSort(comeList);
        leaveList = ArrayUtils.bubbleSort(leaveList);
        this.comeAndLeaveTimeData = ArrayUtils.joinArrays(comeList, leaveList);
    }

    /**
     * Maker array of time when clients come.
     * @param clientList list to analyze
     * @return array of come times
     */
    private double[] getClientComeTime(Client[] clientList) {
        double[] result = new double[this.numberOfClients];
        for (int i = 0; i < this.numberOfClients; i++) {
            result[i] = clientList[i].getComeTime();
        }
        return result;
    }

    /**
     * Maker array of time when clients leave.
     * @param clientList list to analyze
     * @return array of leave times
     */
    private double[] getClientLeaveTime(Client[] clientList) {
        double[] result = new double[this.numberOfClients];
        for (int i = 0; i < this.numberOfClients; i++) {
            result[i] = clientList[i].getLeaveTime() + this.leaveMark;
        }
        return result;
    }

    /**
     * Setter for inner dailyClientsField.
     * @param dataToSet set of clients for bank
     */
    public void setDailyClients(Client[] dataToSet) {
        this.dailyClients = dataToSet;
    }
}
