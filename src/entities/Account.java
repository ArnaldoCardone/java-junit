package entities;

public class Account {
    private Long id;
    private Double balance;

    public static Double DEPOSITY_FEE_PERCENTAGE = 0.02;

    public Account() {
    }

    public Account(Long id, Double balance) {
        this.id = id;
        this.balance = balance;
    }
    public Long getId() {
        return id;
    }
    public Double getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void deposit(Double amount) {
        if(amount > 0) {
            this.balance += amount - (amount * DEPOSITY_FEE_PERCENTAGE);
        }
    }

    public void withdraw(Double amount) {
        if( amount > this.balance) {
            throw new IllegalArgumentException();
        }
            this.balance -= amount;

    }

    public double fullWithdraw(Double amount) {
        double aux = this.balance;
        balance = 0.0;
        return aux;
    }
}
