package com.yuriybishel.model;

public abstract class BankCard {
    protected double balance;
    public BankCard(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
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
                "balance=" + balance +
                '}';
    }
}

