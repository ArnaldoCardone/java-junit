package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTests {

    @Test
    public void depositShoudIncreaseBalanceWhenPositiveAmount() {
        double amount = 200.00;
        double expectedValue = 196.00;

        Account account = new Account(1L, 0.0);
        account.deposit(amount);
        //Verifica se o deposito descontou a taxa corretamente
        Assertions.assertEquals(expectedValue, account.getBalance() );
    }
}
