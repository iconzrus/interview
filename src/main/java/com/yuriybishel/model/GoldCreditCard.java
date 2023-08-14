package com.yuriybishel.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class GoldCreditCard extends CreditCard {
    private double potentialCashback = 0;
    private double bonusPoints = 0;
    private double monthlySpent = 0;
    private boolean freeMaintenance = false;
    private LocalDate cachedDate;
    private boolean isWeekendCachedResult;

    public GoldCreditCard(double balance, double creditLimit) {
        super(balance, creditLimit);
    }

    @Override
    public boolean pay(double amount) {
        updateMonthlySpent(amount);
        updatePotentialCashback(amount);
        updateBonusPoints(amount);
        return super.pay(amount);
    }

    private void updateMonthlySpent(double amount) {
        monthlySpent += amount;
        freeMaintenance = monthlySpent >= 50000; // Бесплатное обслуживание при трате свыше 50 000 в месяц.
    }

    private void updatePotentialCashback(double amount) {
        if (amount > 5000) {
            potentialCashback += amount * 0.05; // Потенциальный кэшбэк 5% от покупок при условии трат больше 5 000.
        }
    }

    private void updateBonusPoints(double amount) {
        if (isWeekend()) {
            bonusPoints += amount * 0.02; // Удвоение бонусных баллов за покупки в выходные.
        } else {
            bonusPoints += amount * 0.01;
        }
    }

    private boolean isWeekend() {
        LocalDate today = LocalDate.now();
        if (cachedDate == null || !cachedDate.equals(today)) {
            cachedDate = today;
            DayOfWeek dayOfWeek = today.getDayOfWeek();
            isWeekendCachedResult = dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
        }
        return isWeekendCachedResult;
    }

    public double getPotentialCashback() {
        return potentialCashback;
    }

    public double getBonusPoints() {
        return bonusPoints;
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
