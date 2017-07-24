package ru.avelikorechin.commercialBank;

import org.junit.Test;
import ru.avelikorechin.commercialBank.models.Account;
import ru.avelikorechin.commercialBank.models.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * Tests for Bank class.
 * @author Alexander Velikorechin
 * @since 23.07.2017
 */

public class BankTest {
    /**
     * User 1.
     */
    private final User first = new User("Alexander", 999888777);

    /**
     * User 2.
     */
    private final User second = new User("Mark", 000000000);

    /**
     * Account for User 1.
     */
    private final Account firstUserAccount = new Account(123456, 1000.00);

    /**
     * Account for User 2.
     */
    private final Account secondUserAccount = new Account(654321, 50.00);

    /**
     * Test addUser.
     */
    @Test
    public void whenAddUserThenItAppearsInBankMap() {
        Bank bank = prepareBank();
        final int expectedSize = 3;
        bank.addUser(new User("Alexander", 1));
        assertThat(bank.getBankDatabase().size(), is(expectedSize));
    }

    /**
     * Test addUser with duplicate instance of user.
     */
    @Test
    public void whenAddUserWithSamePassportThenItDoesNotAppearsInBankMap() {
        Bank bank = prepareBank();
        final User clone = new User("Alexander", 999888777);
        final int expectedSize = 2;
        bank.addUser(clone);
        assertThat(bank.getBankDatabase().size(), is(expectedSize));
    }
    /**
     * Test deleteUser.
     */
    @Test
    public void whenDeleteUserThenItIsRemovedInBankMap() {
        Bank bank = prepareBank();
        bank.deleteUser(first);
        assertThat(bank.getBankDatabase().size(), is(1));
    }

    /**
     * Test addAccountToUser for existing user.
     */
    @Test
    public void whenAddAccountToUserThenAccountsIsAddingCorrectly() {
        Bank bank = prepareBank();
        final Account anotherAccount = new Account(1, 0);
        final int expectedAccountsNumber = 2;
        bank.addAccountToUser(first, anotherAccount);
        assertThat(bank.getUserAccounts(first).size(), is(expectedAccountsNumber));
    }

    /**
     * Test addAccountToUser for user that does not exists.
     */
    @Test
    public void whenAddAccountToNewUserThenAccountIsAddingCorrectly() {
        Bank bank = prepareBank();
        final Account anotherAccount = new Account(0, 1);
        final User inexistingUser = new User("Don", 1);
        final int expectedSize = 3;
        bank.addAccountToUser(inexistingUser, anotherAccount);
        assertThat(bank.getBankDatabase().size(), is(expectedSize));
    }

    /**
     * Test deleteAccountFromUser.
     */
    @Test
    public void whenDeletingAccountFromUserThenItRemovesCorrectly() {
        Bank bank = prepareBank();
        bank.deleteAccountFromUser(first, firstUserAccount);
        assertThat(bank.getUserAccounts(first).size(), is(0));
    }

    /**
     * Test transferMoney from one user to another.
     */
    @Test
    public void whenSendMoneyFromOneUserToAnotherThenReturnsTrue() {
        Bank bank = prepareBank();
        final double amount = 10.00;
        final double moneyOnSrcAccountAfterOperation = 990.00;
        final double moneyOnDstAccountAfterOperation = 60.00;
        assertTrue(bank.transferMoney(first, firstUserAccount, second, secondUserAccount, amount));
        assertThat(bank.getUserAccounts(first).get(0).getValue(), is(moneyOnSrcAccountAfterOperation));
        assertThat(bank.getUserAccounts(second).get(0).getValue(), is(moneyOnDstAccountAfterOperation));
    }

    /**
     * Test transferMoney between user's accounts.
     */
    @Test
    public void whenSendMoneyBetweenOneUsersAccountsThenReturnsTrue() {
        Bank bank = prepareBank();
        final double amount = 10.00;
        final Account secondAccountForFirstUser = new Account(1093, 0.0);
        final double moneyOnSrcAccountAfterOperation = 990.00;
        final double moneyOnDstAccountAfterOperation = 10.00;
        bank.addAccountToUser(first, secondAccountForFirstUser);
        assertTrue(bank.transferMoney(first, firstUserAccount, first, secondAccountForFirstUser, amount));
        assertThat(bank.getUserAccounts(first).get(0).getValue(), is(moneyOnSrcAccountAfterOperation));
        assertThat(bank.getUserAccounts(first).get(1).getValue(), is(moneyOnDstAccountAfterOperation));
    }

    /**
     * Test transferMoney from user that doesn't exist.
     */
    @Test
    public void whenSendMoneyFromAccountThatDoesntExistsThenReturnsFalse() {
        Bank bank = prepareBank();
        final double amount = 10.00;
        final Account unregisteredAccount = new Account(0, 100.0);
        assertFalse(bank.transferMoney(first, unregisteredAccount, second, secondUserAccount, amount));
    }

    /**
     * Test transferMoney to user that doesn't exist.
     */
    @Test
    public void whenSendMoneyToAccountThatDoesntExistsThenReturnsFalse() {
        Bank bank = prepareBank();
        final double amount = 10.00;
        final Account unregisteredAccount = new Account(0, 100.0);
        assertFalse(bank.transferMoney(first, firstUserAccount, second, unregisteredAccount, amount));
    }

    /**
     * Test transferMoney from account that have not enough money for transaction.
     */
    @Test
    public void whenSendMoneyFromAccountWhereNotEnoughMoneyThenReturnsFalse() {
        Bank bank = prepareBank();
        final double amount = 10000.00;
        assertFalse(bank.transferMoney(first, firstUserAccount, second, secondUserAccount, amount));
    }

    /**
     * Test transferMoney from account that have exact ammount of money needed for transaction.
     */
    @Test
    public void whenSendAllTheMoneyFromOneAccountToAnotherThenReturnsTrue() {
        Bank bank = prepareBank();
        assertTrue(bank.transferMoney(first, firstUserAccount, second, secondUserAccount, firstUserAccount.getValue()));
    }

    /**
     * Utility method to prepare Bank object with 2 Users and 2 Accounts.
     * @return Bank object for testing
     */
    public Bank prepareBank() {
        Bank bank = new Bank();
        bank.addAccountToUser(first, firstUserAccount);
        bank.addAccountToUser(second, secondUserAccount);
        return bank;
    }
}
