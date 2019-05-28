package cpsc2150.banking;

/**
 * Holds information about their customer and allows them to apply for a loan. The actual work for the loan is handled by IMortgage
 * Defines: CreditScore: Z
 *          MonthlyDebt: R - How much they pay per moth towards other forms of debt (car payments, student loans, etc)
 *          Loan: The customer's mortgage they are applying for
 *          Income: R - Yearly income
 *          Name: Customer must have a name
 *
 * Initialization Ensures: Customer will have a Name, a CreditScore, MonthlyDebt, and Income
 * Constraints 0 <= CreditScore <= MAX_CREDIT_SCORE
 *              0 <= MonthlyDebt
 *              0 <= Income
 *
 */
public interface ICustomer {
    int MAX_CREDIT_SCORE = 850;

    /**
     *
     * @param downPayment the down payment on the loan
     * @param houseCost the cost of the house they want to buy
     * @param years the number of years they will take to repay the loan
     * @return true if the loan was approved
     * @pre 0 <= downPayment < houseCost and houseCost > 0 and IMortgage.MIN_YEARS <= y <= IMortgage.MAX_YEARS
     * @post [applyForLoan iff the loan was approved with those terms]
     */
    boolean applyForLoan(double downPayment, double houseCost, int years);

    /**
     * @pre [the customer has applied for and recieved a loan]
     * @post [getRate = interest rate of the approved loan] and 0 <= getRate <= 1
     * @return the interest rate (APR) on the customer's loan
     */
    double getRate();

    /**
     *
     * @return the monthly payment on the customer's loan
     * @pre[the customer has applied for and received a loan]
     * @post [getMonthlyPay = the monthly payment on the customer's loan] and 0<getMonthlyPay
     */
    double getMonthlyPay();

    /**
     *
     * @return the customer's monthly debt payments not including the loan
     *
     * @post getMonthlyDebtPayments = MonthlyDebt
     */
    double getMonthlyDebtPayments();

    /**
     *
     * @return the customer's yearly income
     *
     * @ensures getIncome = income
     */
    double getIncome();

    /**
     *
     * @return the customer's credit score
     * @requires this != null
     * @ensures getCreditScore = creditScore
     */
    int getCreditScore();

    /**
     *
     * @return the Customer's name
     * @post getName = Name
     */
    String getName();

    boolean appliedForLoan();


}
