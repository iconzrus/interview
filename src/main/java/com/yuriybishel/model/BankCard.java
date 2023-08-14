package com.yuriybishel.model;

public abstract class BankCard {
    protected double balance;
    public BankCard(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount cannot be negative.");
        }
        this.balance += amount;
    }

    public abstract boolean pay(double amount);

    public double getBalance() {
        return this.balance;
    }

    public abstract String getAvailableFundsInfo();

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " balance=" + balance +
                '}';
    }
}

