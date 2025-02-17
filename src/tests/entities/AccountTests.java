package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTests {

    @Test
    public void depositShoudIncreaseBalanceWhenPositiveAmount() {
        double amount = 200.00;
        double expectedValue = 196.00;

        Account account = AccountFactory.createEmptyAccount();
        account.deposit(amount);
        //Verifica se o deposito descontou a taxa corretamente
        Assertions.assertEquals(expectedValue, account.getBalance() );
    }

    @Test
    public void depositShoudNotIncreaseBalanceWhenNegativeAmount() {
        double amount = -200.00;
        double expectedValue = 100.0;
        Account account = AccountFactory.createAccount(expectedValue);
        account.deposit(-200.00);
        //Valida se o depoisto com valor negativo não foi efetuado, mantendo o saldo inicial
        Assertions.assertEquals(expectedValue, account.getBalance() );
    }
}
