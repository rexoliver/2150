package cpsc2150.banking;

/**
 * Created by rexroao on 4/12/19.
 */
public class MortgageController implements IMortgageController {

  private IMortgageController c;

  public MortgageController(IMortgageView c)
  {
    c = new MortgageView();
  }

  public void submitApplication()
  {
    boolean programrun = true;
    boolean newcustomer = true;
    boolean newmortgage = true;
    while (programrun == true)
    {
      while (newcustomer == true)
      {
        String name = c.getName();
        double income = c.getIncome();
        while (income <= 0)
        {
          System.out.println("Income must be greater than 0.");
          income = c.getIncome();
        }
        double debtp = c.getMonthlyDebt();
        while (debtp < 0)
        {
          System.out.println("Debt must be greater than or equal to 0.");
          debtp = c.getMonthlyDebt();
        }
        double score = c.getCreditScore();
        while (score <= 0 || score >= 850)
        {
          System.out.println("Credit Score must be greater than 0 and less than 850");
          score = c.getCreditScore();
        }
      }
      while (newmortgage == true)
      {
        double housecost = c.getHouseCost();
        while (housecost <= 0)
        {
          System.out.println("Cost must be greater than 0.");
          housecost = c.getHouseCost();
        }
        double downpay = c.getDownPayment();
        while (downpay <= 0 && downpay < housecost)
        {
          System.out.println("Down Payment must be greater than 0 and less than the cost of the house.");
          downpay = c.getDownPayment();
        }
        int years = c.getYears();
        while (years <= 0)
        {
          System.out.println("Years must be greater than 0.");
          years = c.getYears();
        }

        System.out.println("Name: " + name);
        System.out.println("Income: $" + income);
        System.out.println("Credit Score: " + score);
        System.out.println("Monthly Debt: $" + debtp);
        System.out.println("Mortgage info:");
        //not sure about these...
        // in the mortgage class
        System.out.println("Principal Amount: $" + c.getPrincipal());
        double rate = c.getRate();
        c.displayRate(rate);
        System.out.println("Term: " + years + " years");
        double mpayments = c.getPayment();
        c.displayPayment(mpayments);
        if (getAnotherMortgage() == false)
        {
          newmortgage = false;
          boolean newcustomerchoice = getAnotherCustomer();
          if (newcustomerchoice == true)
          {
            newcustomer = true;
          }
          else
          {
            programun = false;
          }
        }
        else
        {
          newmortgage = true;
          newcustomer = true;
        }
      }
    }
  }
}
