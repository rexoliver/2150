package cpsc2150.banking;

public abstract class AbsMortgage implements IMortgage {

    /**
     *
     * @return the string representation of this loan details, or a notice that the loan was not approved
     * @requires this != null and [interestRate and payment have been calculated]
     * @ensures [toString = The string value of the loan, or "Loan was not approved"]
     */
    @Override
    public String toString()
    {
        String str = "";
        if(loanApproved())
        {
            str += "Principal Amount: $" + getPrincipal() + "\n";
            str += "Interest Rate: " + (getRate() * 100) + "%\n";
            str += "Term: " + getYears() + " years\n";
            str += "Monthly Payment: $" + getPayment() + "\n";
        }
        else
        {
            str += "Loan was not approved";
        }
        return str;
    }
}
