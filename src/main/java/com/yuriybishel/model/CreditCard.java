package com.yuriybishel.model;

public class CreditCard extends BankCard {
    private double creditLimit;
    private double creditUsed;

    public CreditCard(double balance, double creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
        this.creditUsed = 0;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getCreditUsed() {
        return creditUsed;
    }

    public void setCreditUsed(double creditUsed) {
        this.creditUsed = creditUsed;
    }

    @Override
    public void deposit(double amount) {
        if (creditUsed > 0) {
            double toRepay = Math.min(creditUsed, amount);
            creditUsed -= toRepay;
            amount -= toRepay;
        }
        balance += amount;
    }

    @Override
    public boolean pay(double amount) {
        if (balance + (creditLimit - creditUsed) < amount) {
            throw new IllegalArgumentException("Not enough funds available.");
        }

        if (balance >= amount) {
            balance -= amount;
        } else {
            double creditNeeded = amount - balance;
            if (creditLimit - creditUsed >= creditNeeded) {
                creditUsed += creditNeeded;
                balance = 0;
                return true;
            }
        }
        return true;
    }

    @Override
    public String getAvailableFundsInfo() {
        return "Own funds: " + balance + ", Credit funds: " + (creditLimit - creditUsed);
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditLimit=" + creditLimit +
                ", creditUsed=" + creditUsed +
                ", balance=" + balance +
                '}';
    }
}