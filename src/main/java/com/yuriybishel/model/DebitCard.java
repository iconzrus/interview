package com.yuriybishel.model;

public class DebitCard extends BankCard{
    public DebitCard(double balance) {
        super(balance);
    }

    @Override
    public boolean pay(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Payment amount cannot be negative.");
        }
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public String getAvailableFundsInfo() {
        return "Available funds: " + balance;
    }
}

