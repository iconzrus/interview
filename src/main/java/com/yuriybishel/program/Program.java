package com.yuriybishel.program;

import com.yuriybishel.model.*;

public class Program {
    public static void main(String[] args) {
        // Создание экземпляров классов
        DebitCard debitCard = new DebitCard(5000);
        CreditCard creditCard = new CreditCard(2000, 10000);
        GoldCreditCard goldCreditCard = new GoldCreditCard(2000, 10000);
        PremiumDebitCard premiumDebitCard = new PremiumDebitCard(7000);

        //Проверка функций карт
        System.out.println("=== DebitCard ===");
        System.out.println(debitCard);
        debitCard.deposit(2000);
        System.out.println("After deposit: " + debitCard.getBalance());
        System.out.println("Pay 1000: " + debitCard.pay(1000));
        System.out.println(debitCard.getAvailableFundsInfo());

        System.out.println("\n=== CreditCard ===");
        System.out.println(creditCard);
        creditCard.deposit(5000);
        System.out.println("After deposit: " + creditCard.getBalance());
        System.out.println("Pay 1000: " + creditCard.pay(1000));
        System.out.println(creditCard.getAvailableFundsInfo());

        System.out.println("\n=== GoldCreditCard ===");
        System.out.println(goldCreditCard);
        goldCreditCard.deposit(100000);
        System.out.println("After deposit: " + goldCreditCard.getBalance());
        System.out.println("Pay 1000: " + goldCreditCard.pay(1000));
        System.out.println(goldCreditCard.getAvailableFundsInfo());
        System.out.println("Bonus points: " + goldCreditCard.getBonusPoints());
        System.out.println("Potential cashback: " + goldCreditCard.getPotentialCashback());

        System.out.println("\n=== PremiumDebitCard ===");
        System.out.println(premiumDebitCard);
        premiumDebitCard.deposit(5000);
        System.out.println("After deposit: " + premiumDebitCard.getBalance());
        System.out.println("Pay 1000: " + premiumDebitCard.pay(1000));
        System.out.println("Bonus points: " + premiumDebitCard.getBonusPoints());
        System.out.println("Accumulation: " + premiumDebitCard.getAccumulation());
        System.out.println(premiumDebitCard.getAvailableFundsInfo());
    }
}
