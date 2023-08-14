package com.yuriybishel.model;

public class DebitCard extends BankCard{
    public DebitCard(double balance) {
        super(balance);
    }

    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String getAvailableFundsInfo() {
        return "Available funds: " + balance;
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "balance=" + balance +
                '}';
    }
}

