package com.ganga.finances;

import org.junit.Test;

import static org.junit.Assert.*;


public class SavingsAccountYearTest {

    private SavingsAccountYear newAccount() {
        return new SavingsAccountYear(10000, 10);
    }

    @Test
    public void startingBalanceMatchesConstructor(){
        SavingsAccountYear account = newAccount();
        assertEquals(10000, account.startingBalance());
    }


    @Test
    public void interestRateMatchesConstructor(){
        SavingsAccountYear account = newAccount();
        assertEquals(10, account.interestRate());
    }


    @Test
    public void endingBalanceAppliesInterestRate(){
        SavingsAccountYear account = newAccount();
        assertEquals(11000, account.endingBalance());
    }

    @Test
    public void nextYearStartingBalanceEqualsThisYearsEndingBalance(){
        SavingsAccountYear thisYear = newAccount();
        assertEquals(thisYear.endingBalance(), thisYear.nextYear().startingBalance());
    }

    @Test
    public void nextYearsInterestRateEqualsThisYearsInterestRate(){
        SavingsAccountYear thisYear = newAccount();
        assertEquals(thisYear.interestRate(), thisYear.nextYear().interestRate());
    }

    @Test
    public void withdrawFundsOccursAtTheBeginningOfTheYear(){
        SavingsAccountYear year = newAccount();
        year.withdraw(1000);
        assertEquals(9900, year.endingBalance());
    }

    @Test
    public void principal(){
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        assertEquals(3000, year.startingPrincipal());
    }

    @Test
    public void  endingPrincipal(){
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        assertEquals(3000, year.startingPrincipal());
        year.withdraw(2000);
        assertEquals("ending principle", 1000, year.endingPrincipal());
    }

    @Test
    public void endingPrincipalNeverGoesBelowZero(){
        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
        assertEquals("starting principal", 3000, year.startingPrincipal());
        year.withdraw(2000);
        assertEquals("ending principal", 1000, year.endingPrincipal());
    }

    @Test
    public void multipleWithdrawsAYear(){
        SavingsAccountYear year = new SavingsAccountYear(10000,10);
        year.withdraw(1000);
        year.withdraw(2000);
        assertEquals(7700, year.endingBalance());
    }

//    @Test
//    public void withdrawMoreThanPrincipalIncursCapitalGains(){
//        SavingsAccountYear year = new SavingsAccountYear(10000, 7000, 10);
//        year.withdraw(3000);
//        assertEquals(7700, year.endingBalance());
//        year.withdraw(5000);
//        assertEquals(2000+ 200 - (1250), year.endingBalance());
//    }

}
