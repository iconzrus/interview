package com.yuriybishel.model;

public class PremiumDebitCard extends DebitCard {
    private double bonusPoints = 0;
    private double accumulation = 0;

    public PremiumDebitCard(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        accumulation += amount * 0.00005; // Накопление в размере 0.005% от суммы пополнений.
    }

    @Override
    public boolean pay(double amount) {
        if (amount > 10000) {
            amount *= 0.98; // Скидка 2% на все покупки свыше 10 000.
        }
        if (super.pay(amount)) {
            bonusPoints += amount * 0.01; // Бонусные баллы в размере 1% от покупок.
            return true;
        }
        return false;
    }

    public double getBonusPoints() {
        return bonusPoints;
    }

    public double getAccumulation() {
        return accumulation;
    }

    @Override
    public String getAvailableFundsInfo() {
        return super.getAvailableFundsInfo() + ", Bonus points: " + bonusPoints + ", Accumulation: " + accumulation;
    }
}
