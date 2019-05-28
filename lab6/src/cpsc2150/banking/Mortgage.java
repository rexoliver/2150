package cpsc2150.banking;
/*
 * Rex Oliver and Charles Hayes
 * CPSC 2150 Lab 6 Section 002
 * Mortgage.java
 */


public class Mortgage extends AbsMortgage implements IMortgage {

    /**
     * @invariant house_cost > 0
     * @invariant down_payment > 0
     * @invariant 0 <= getRate() <= 1
     * @invariant 0 < customer.getMonthlyDebtPayment()/
     *                customer.getMonthlyPay()
     * @invariant 0 < getPrincipal()
     * @invariant 0 <= getPercentDown() < 1
     * @invariant num_years > 0
     *
     * Correspondence Payment = getPayment()
     * Correspondence Rate = getRate()
     * Correspondence Customer = customer
     * Correspondence DebtToIncomeRatio =
     *                customer.getMonthlyDebtPayment()/
     *                customer.getMonthlyPay()
     * Correspondence Principal = getPrincipal()
     * Correspondence NumberOfPayments = num_years * 12
     * Correspondence PercentDown = getPercentDown()
     */
    private double house_cost;
    private double down_payment;
    private int num_years;
    private ICustomer customer;
    /**
     * @pre
     * @post
     * @param house_cost
     * @param down_payment
     * @param num_years
     * @param C
     */
    public Mortgage(double house_cost, double down_payment, int num_years, ICustomer C){
        // this is defining the private variables
        this.house_cost = house_cost;
        this.down_payment = down_payment;
        this.num_years = num_years;
        // ICustomer created to later access customers information
        this.customer = C;
    }

    /**
     * @pre none
     * @post getPercentDown() = down_payment/house_cost
     * @return down_payment / house_cost
     */
    private double getPercentDown() { return down_payment/house_cost;}

    public boolean loanApproved(){
        // condition that says:
        // loan will be rejected if( APR >= 10% OR Percent Down < 3.5% OR
        //                           Debt To Income Ratio is greater than 40%)
        if(getRate() >= RATETOOHIGH || down_payment/house_cost < MIN_PERCENT_DOWN
                || (customer.getMonthlyDebtPayments() + getPayment())/(customer.getIncome()/12) >= DTOITOOHIGH || getYears() < MIN_YEARS)
            return false;
        else return true;
    }
    public double getPayment(){
        // Equation: (monthly interest rate + principal)
        //          /(1-(1+monthly interest rate)^(total number of payments))
        return ((getRate()/12) * getPrincipal())/
                (1-Math.pow((1+(getRate()/12)),(-12 * num_years)));
    }
    public double getRate(){
        // establishes what the credit score is
        int credit_score = customer.getCreditScore();
        // initial rate in variable
        double start_rate = BASERATE;
        // Decisions below decide whether to add APR or not
        if(getYears() < MAX_YEARS)
            start_rate+=GOODRATEADD;
        else start_rate+=NORMALRATEADD;
        if(getPercentDown() < PREFERRED_PERCENT_DOWN)
            start_rate+=GOODRATEADD;
        if(credit_score < BADCREDIT)
            start_rate+=VERYBADRATEADD;
        else if(credit_score >= BADCREDIT && credit_score < FAIRCREDIT)
            start_rate+=BADRATEADD;
        else if(credit_score >= FAIRCREDIT && credit_score < GOODCREDIT)
            start_rate+=NORMALRATEADD;
        else if(credit_score >= GOODCREDIT && credit_score < GREATCREDIT)
            start_rate+=GOODRATEADD;
        // returns the final APR
        return start_rate;
    }
    public double getPrincipal(){return house_cost - down_payment;}
    public int getYears(){ return num_years; }
}
