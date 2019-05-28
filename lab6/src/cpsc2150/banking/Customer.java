package cpsc2150.banking;

/**
 * Created by kplis on 1/23/2018.
 *
 * @Invariants name != "" and
 *              monthlyDeptPayments >= 0 and
 *              income >= 0 and
 *              0<= creditScore <= 850
 */
public class Customer extends AbsCustomer implements ICustomer {
    private String name;



    private double monthlyDebtPayments;
    private double income;
    private int creditScore;



    /**
     *
     * @param debt the customer's monthly debt payments
     * @param inc the customer's yearly income
     * @param score the customers credit score
     * @param n the customers name
     * @requires debt >= 0 and inc >= 0 and 0 <= score <= MAX_CREDIT_SCORE and n != ""
     * @ensures monthlyDebtPayments = debt and income = inc and creditScore = score and name = n
     */
    Customer( double debt, double inc, int score, String n)
    {

        monthlyDebtPayments = debt;
        income = inc;
        creditScore = score;
        name = n;


    }


    /**
     *
     * @param downPayment the down payment on the loan
     * @param houseCost the cost of the house they want to buy
     * @param years the number of years they will take to repay the loan
     * @return true if the loan was approved
     * @requires 0 <= downPayment < houseCost and houseCost > 0 and y in (15, 20, 25, 30)
     * @ensures [applyForLoan iff the loan was approved with those terms]
     */
    public boolean applyForLoan(double downPayment, double houseCost, int years)
    {
        loan = new Mortgage(houseCost, downPayment, years, this);
        return loan.loanApproved();

    }

    /**
     * @requires [the customer has applied for and recieved a loan]
     * @ensures [getRate = interest rate of the approved loan] and 0 <= getRate <= 1
     * @return the interest rate on the customer's loan
     */
    public double getRate()
    {
        return loan.getRate();
    }

    /**
     *
     * @return the monthly payment on the customer's loan
     * @requires [the customer has applied for and received a loan]
     * @ensures [getMonthlyPay = the monthly payment on the customer's loan] and 0<getMonthlyPay
     */
    public double getMonthlyPay()
    {
        return loan.getPayment();
    }

    /**
     *
     * @return the customer's monthly debt payments not including the loan
     * @requires this != null
     * @ensures getMonthlyDebtPayments = monthlyDebtPayments
     */
    public double getMonthlyDebtPayments()
    {
        return monthlyDebtPayments;
    }

    /**
     *
     * @return the customer's yearly income
     * @requires this != null
     * @ensures getIncome = income
     */
    public double getIncome()
    {
        return income;
    }

    /**
     *
     * @return the customer's credit score
     * @requires this != null
     * @ensures getCreditScore = creditScore
     */
    public int getCreditScore()
    {
        return creditScore;
    }


    /**
     *
     * @return a string representation of the customer including loan details
     * @requires this != null
     * @ensures [toString is a string representation of the customer]
     */

    public String getName(){
        return name;
    }

    public boolean appliedForLoan()
    {
        if(loan != null)
        {
            return true;
        }
        return false;
    }


}
