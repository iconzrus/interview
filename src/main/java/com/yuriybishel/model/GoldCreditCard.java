package com.yuriybishel.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class GoldCreditCard extends CreditCard {
    private double potentialCashback = 0;
    private double bonusPoints = 0;
    private double monthlySpent = 0;
    private boolean freeMaintenance = false;

    public GoldCreditCard(double balance, double creditLimit) {
        super(balance, creditLimit);
    }

    @Override
    public boolean pay(double amount) {
        monthlySpent += amount;

        freeMaintenance = monthlySpent >= 50000; // Бесплатное обслуживание при трате свыше 50 000 в месяц.

        if (amount > 5000) {
            potentialCashback += amount * 0.05; // Потенциальный кэшбэк 5% от покупок при условии трат больше 5 000.
        }
        if (isWeekend()) {
            bonusPoints += amount * 0.02; // Удвоение бонусных баллов за покупки в выходные.
        } else {
            bonusPoints += amount * 0.01;
        }
        return super.pay(amount);
    }


    public double getPotentialCashback() {
        return potentialCashback;
    }

    public double getBonusPoints() {
        return bonusPoints;
    }

    private boolean isWeekend() {
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
    @Override
    public String getAvailableFundsInfo() {
        return super.getAvailableFundsInfo()
                + ", Monthly spent: " + monthlySpent
                + ", Potential cashback: " + potentialCashback
                + ", Bonus points: " + bonusPoints
                + ", Is Service Free: " + (freeMaintenance ? "Yes" : "No");
    }

}
