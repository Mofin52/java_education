package ru.avelikorechin.commercialBank;

import ru.avelikorechin.commercialBank.models.Account;
import ru.avelikorechin.commercialBank.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Realisation of Bank with Map Collection. Final task for Collections Lite module.
 * @author Alexander Velikorechin
 * @since 21.07.2017
 */
public class Bank {
    /**
     * The main collection for Bank, keeping all the info about users and their accounts.
     */
    private Map<User, List<Account>> bankDatabase = new TreeMap<User, List<Account>>();

    /**
     * Constructor to create empty bank.
     */
    public Bank() {

    }

    /**
     * Adding new User of bank services.
     *
     * @param user user to add
     */
    public void addUser(User user) {
        if (!bankDatabase.containsKey(user)) {
            bankDatabase.put(user, new ArrayList<Account>());
        }
    }

    /**
     * Deleting User from bank.
     *
     * @param user user to delete
     */
    public void deleteUser(User user) {
        bankDatabase.remove(user);
    }

    /**
     * Adding account to user.
     * If user is not found in collection, we add new User and create an Account for him.
     *
     * @param user    user which is account adding for
     * @param account account to add
     */
    public void addAccountToUser(User user, Account account) {
        if (bankDatabase.containsKey(user)) {
            List<Account> currentAccounts = bankDatabase.get(user);
            currentAccounts.add(account);
            bankDatabase.put(user, currentAccounts);
        } else {
            List<Account> newAccount = new ArrayList<Account>();
            newAccount.add(account);
            bankDatabase.put(user, new ArrayList<Account>(newAccount));
        }
    }

    /**
     * Delete one of user's account.
     *
     * @param user    user to delete account from
     * @param account account to delete
     */
    public void deleteAccountFromUser(User user, Account account) {
        List<Account> accountsOfUser = bankDatabase.get(user);
        if (accountsOfUser.contains(account)) {
            accountsOfUser.remove(account);
        }
        bankDatabase.put(user, accountsOfUser);
    }

    /**
     * Returns all of the accounts set for given user.
     *
     * @param user user whose accounts we want to get
     * @return list of accounts
     */
    public List<Account> getUserAccounts(User user) {
        List<Account> result = new ArrayList<>();
        if (bankDatabase.containsKey(user)) {
            result = bankDatabase.get(user);
        }
        return result;
    }

    /**
     * Method to transfer money from one account to another.
     * @param srcUser user sending money
     * @param srcAccount account from which money is taken
     * @param dstUser user receiving money
     * @param dstAccount account to which money is put
     * @param ammount ammount of transaction
     * @return true if operation is successful, false if account is not found or there is no needed amount of money
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double ammount) {
        List<Account> srcUserAccounts = bankDatabase.get(srcUser);
        List<Account> dstUserAccount = bankDatabase.get(dstUser);
        if (srcUserAccounts.contains(srcAccount) && dstUserAccount.contains(dstAccount) && srcAccount.getValue() >= ammount) {
            srcAccount.setValue(srcAccount.getValue() - ammount);
            dstAccount.setValue(dstAccount.getValue() + ammount);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Getter for bankDatabase.
     * @return bank database
     */
    public Map<User, List<Account>> getBankDatabase() {
        return this.bankDatabase;
    }
}