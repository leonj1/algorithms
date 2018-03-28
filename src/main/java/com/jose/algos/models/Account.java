package com.jose.algos.models;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2018
 **/
public class Account {
    private String name;
    private float balance;
    private int numPayments;
    private float interestPaid;
    private float interestRate;

    public Account(String name, float balance, float interestRate) {
        this.name = name;
        this.balance = balance;
        this.interestRate = interestRate/365/100;
        this.numPayments = 0;
        this.interestPaid = 0.0f;
    }

    public float payment(float amount) {
        this.numPayments++;
        if (amount > this.balance) {
            this.balance = 0;
            return amount - balance;
        }
        this.balance -= amount;
        return 0;
    }

    public void calculateInterest() {
        for (int i = 0; i< 30; i++) {
            float interest = this.balance * this.interestRate;
            this.interestPaid += interest;
            this.balance += interest;
        }
    }

    public float balance() {
        return this.balance;
    }

    public int numPayments() {
        return numPayments;
    }

    public float interestPaid() {
        return interestPaid;
    }

    public String name() {
        return this.name;
    }
}
