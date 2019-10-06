package com.ganga.finances;

import jdk.jfr.StackTrace;

public class SavingsAccountYear {

    private int interestRate;
    private int balance = 0;

    public SavingsAccountYear(){
    }

    public SavingsAccountYear(int startingBalance, int interestRate){
        this.balance = startingBalance;
        this.interestRate = interestRate;
    }

    public void deposit(int amount){
        balance+=amount;
    }

    public int balance() {
        return balance;
    }

    public int startingBalance(){
        return balance;

    }public int interestRate(){
        return interestRate;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);

    }

    public int endingBalance() {
        return (balance() + balance() * interestRate/100);
    }
}
