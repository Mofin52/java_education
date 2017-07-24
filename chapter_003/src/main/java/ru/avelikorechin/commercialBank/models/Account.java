package ru.avelikorechin.commercialBank.models;

/**
 * Account model for Bank.
 * @author Alexander Velikorechin
 * @since 21.07.2017
 */
public class Account {
    /**
     * Amount of money on account.
     */
    private double value;
    /**
     * Account number.
     */
    private int requisites;

    /**
     * Constructor for Account.
     * @param requisites account number
     * @param value money to add
     */
    public Account(int requisites, double value) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Getter for value field.
     * @return amount of money on account
     */
    public double getValue() {
        return this.value;
    }

    /**
     * Setter for value on account.
     * @param value new amount of money on account
     */
    public void setValue(double value) {
        this.value = value;
    }
}