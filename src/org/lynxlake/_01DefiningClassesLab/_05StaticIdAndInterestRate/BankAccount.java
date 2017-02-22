package org.lynxlake._01DefiningClassesLab._05StaticIdAndInterestRate;

class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;
    private static double currentInterestRate = DEFAULT_INTEREST;
    private static int bankAccountCount;

    private int id;
    private double balance;

    BankAccount() {
        this.id = ++bankAccountCount;
    }

    static void setInterest(double interest) {
        currentInterestRate = interest;
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

    int getId() {
        return this.id;
    }

    double getInterest(int years) {
        return this.balance * currentInterestRate * years;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
