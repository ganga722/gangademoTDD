package com.ganga.finances;

public class SavingsAccountYear {

    private int interestRate;
    private int capitalGainsAmount;
    private int startingBalance = 0;

    public SavingsAccountYear(){
    }

    public SavingsAccountYear(int startingBalance, int interestRate){
        this.startingBalance = startingBalance;
        this.interestRate = interestRate;
    }

    public SavingsAccountYear(int startingBalance, int capitalGainsAmount, int interestRate) {
        this.startingBalance = startingBalance;
        this.capitalGainsAmount = capitalGainsAmount;
        this.interestRate = interestRate;
    }

    public int balance() {
        return startingBalance;
    }

    public int startingBalance(){
        return startingBalance;

    }public int interestRate(){
        return interestRate;
    }

    public SavingsAccountYear nextYear() {
        return new SavingsAccountYear(this.endingBalance(), interestRate);

    }

    public int endingBalance() {
        return (balance() + balance() * interestRate/100);
    }

    public void withdraw(int amount) {
        startingBalance -= amount;
    }
}
