import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(10000);
    }

    @Test
    void testAccount() {
        assertNotNull(account);
    }

    @Test
    void createAccountInit10000won() {
        assertEquals(10000, account.getBalance());
    }

    @Test
    void depositAndConfirmation() {
        account.deposit(4000);
        assertEquals(14000, account.getBalance());
    }

    @Test
    void withdrawAndConfirmation() {
        account.withdraw(4000);
        assertEquals(6000, account.getBalance());
    }

    @Test
    void applyInterestRate() {
        account.setInterestRate(5);
        account.applyInterestRate();
        assertEquals(10500, account.getBalance());
    }

    @Test
    void getInterestRateAndConfirmation() {
        assertEquals(5, account.getInterestRate());
    }

    @Test
    void setInterestRateAndConfirmation() {
        account.setInterestRate(5);
        assertEquals(5, account.getInterestRate());
    }

    @Test
    void getBalanceAfterNYearsAndConfirmation() {
        account.setInterestRate(5);
        assertEquals(10000, account.getBalanceAfterNYears(5));
    }
}