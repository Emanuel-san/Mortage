package app.mortage;

import app.mortage.calculator.MortageCalculator;

public class Mortage {

    private final String customerName;
    private final double annualInterestRate;
    private final double totalLoan;
    private final int loanPeriod;

    public Mortage(String name, double totalLoan, double annualInterestRate, int loanPeriod) throws IllegalArgumentException{
        if(totalLoan <= 0){
            throw new IllegalArgumentException("Loan amount can not be 0 or less");
        }
        else if(loanPeriod <= 0){
            throw new IllegalArgumentException("Period of years can not be 0 or less");
        }
        customerName = name;
        this.annualInterestRate = annualInterestRate;
        this.totalLoan = totalLoan;
        this.loanPeriod = loanPeriod;
    }
    public void printCustomerMonthlyPayment(){
        System.out.printf("%s wants to borrow %.2f€ for a period of %d years and pay %.2f€ each month.", customerName, totalLoan, loanPeriod, MortageCalculator.monthlyPayment(this));
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }
}
