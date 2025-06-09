public class Account {
    private int balance;
    private int interestRate;

    public Account(int money) {
        this.balance = money;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int money) {
        this.balance += money;
    }

    public void withdraw(int money) {
        this.balance -= money;
    }

    public void applyInterestRate() {
        this.balance += balance * (interestRate / 100);
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interest) {
        this.interestRate = interest;
    }

    public int getBalanceAfterNYears(int n) {
        for (int i = 0; i < n; i++) {
            applyInterestRate();
        }
        return balance;
    }
}
