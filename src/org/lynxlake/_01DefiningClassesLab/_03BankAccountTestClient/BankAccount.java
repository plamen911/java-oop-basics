package org.lynxlake._01DefiningClassesLab._03BankAccountTestClient;

class BankAccount {
    private int id;
    private double balance;

    void setId(int id) {
        this.id = id;
    }

    double getBalance() {
        return balance;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    void withdraw(double amount) {
        if (amount > this.balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.balance);
    }
}
