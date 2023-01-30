package app.mortage;

public class Mortage {

    private final String name;
    private final double annualInterestRate;
    private final double totalLoan;
    private final int loanPeriod;

    public Mortage(String name, double totalLoan, double annualInterestRate, int loanPeriod){
        this.name = name;
        this.annualInterestRate = annualInterestRate;
        this.totalLoan = totalLoan;
        this.loanPeriod = loanPeriod;
    }

    /**
     * Calculates the monthly payment amount based on a total sum, an annual interest and a period in years
     * using formula: E = U[b(1 + b)^p]/[(1 + b)^p - 1]
     * @return Sum of monthly payment
     */
    private double monthlyPayment(){
        double monthlyInterest = 1;

        // Formula assumes rate is given on a monthly basis and needs to be adjusted from yearly.
        double monthlyInterestRate = annualInterestRate/12/100;
        for(int i = 0; i < loanPeriod*12; i++){
            monthlyInterest *= (1 + monthlyInterestRate);
        }

        return totalLoan * (monthlyInterestRate * monthlyInterest) / (monthlyInterest - 1);
    }

    public void printCustomerMonthlyPayment(){
        System.out.printf("%s wants to borrow %.2f€ for a period of %d years and pay %.2f€ each month.", name, totalLoan, loanPeriod, monthlyPayment());
    }
}
