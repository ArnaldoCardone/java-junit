package tests.entities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tests.factory.AccountFactory;

public class AccountTests {

    @Test
    public void depositShouldIncreaseBalanceWhenPositiveAmount() {
        double amount = 200.00;
        double expectedValue = 196.00;

        Account account = AccountFactory.createEmptyAccount();
        account.deposit(amount);
        //Verifica se o deposito descontou a taxa corretamente
        Assertions.assertEquals(expectedValue, account.getBalance() );
    }

    @Test
    public void depositShouldNotIncreaseBalanceWhenNegativeAmount() {
        double amount = -200.00;
        double expectedValue = 100.0;
        Account account = AccountFactory.createAccount(expectedValue);
        account.deposit(-200.00);
        //Valida se o depoisto com valor negativo não foi efetuado, mantendo o saldo inicial
        Assertions.assertEquals(expectedValue, account.getBalance() );
    }

    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {
        double amount = 200.00;
        double expectedValue = 0.0;
        Account account = AccountFactory.createAccount(amount);
        double result = account.fullWithdraw(amount);
        //Verifica se todo o saldo foi retirado e o saldo ficou zerado
        Assertions.assertTrue(expectedValue == account.getBalance());
        //Verifica se  o valor retirado é igual ao valor criado
        Assertions.assertEquals(amount, result);
    }

    @Test
    public void witdrawShouldDescreseBalanceWhenSufficientBalance(){
        double amount = 800.00;
        double expectedValue = 300.0;
        Account account = AccountFactory.createAccount(amount);
        account.withdraw(500.00);
        //Valida se o valor do saldo ficará correto após o saque
        Assertions.assertEquals(expectedValue, account.getBalance());
    }

    @Test
    public void witdrawShouldThrowExceptionWhenInsufficientBalance(){
        double amount = 300.00;
        double expectedValue = 300.0;
        Account account = AccountFactory.createAccount(amount);
        //Valida se o irá lançar a exceção
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(500.00);
        });
        //Verifica se o saldo permaneceu o mesmo
        Assertions.assertEquals(expectedValue, account.getBalance());
    }
}
