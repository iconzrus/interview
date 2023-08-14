package com.yuriybishel.program;

import com.yuriybishel.model.BankCard;
import com.yuriybishel.model.CreditCard;
import com.yuriybishel.model.DebitCard;
import com.yuriybishel.model.GoldCreditCard;

public class Program {
    public static void main(String[] args) {
        BankCard x = new DebitCard(20000);
        x.pay(5000);
        System.out.println(x);
        x.deposit(15000);
        System.out.println(x);


        BankCard z = new GoldCreditCard(500000, 100000);
        z.pay(45000);
        System.out.println(z);
        z.pay(5000);
        String availableFundsInfo = z.getAvailableFundsInfo();
        System.out.println(availableFundsInfo);
    }
    }