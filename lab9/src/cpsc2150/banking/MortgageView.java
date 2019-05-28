package cpsc2150.banking;
import java.util.*;

/**
 * Created by rexroao on 4/12/19.
 */
public class MortgageView implements IMortgageView {
    private Scanner input;
    private IMortgageController c;

  public MortgageView()
  {
    input = new Scanner(System.in);
    //controller initialized in next function?
  }

  public void setController(IMortgageController c)
  {
    c = new MortgageController();
  }

  public double getIncome()
  {
    System.out.println("How much is your yearly income?");
    double income = input.nextDouble();
    return income;
  }

  public double getHouseCost()
  {
    System.out.println("How much does the house cost?");
    double cost = input.nextDouble();
    return cost;
  }

  public double getDownPayment()
  {
    System.out.println("How much is the down payment?");
    double dpay = input.nextDouble();
    return dpay;
  }

  public int getYears()
  {
    System.out.println("How many years?");
    int years = input.nextInt();
    return years;
  }

  public double getMonthlyDebt()
  {
    System.out.println("How much are your monthly debt payments?");
    double debts = input.nextDouble();
    return debts;
  }

  public double getCreditScore()
  {
    System.out.println("What is your credit score?");
    double score = input.nextDouble();
    return score;
  }

  public String getName()
  {
    System.out.println("What's your name?");
    String name = input.nextLine();
    return name;
  }

  public void printToUser(String s)
  {
    System.out.println(s);
  }

  public void displayPayment(double p)
  {
    System.out.println("Monthly Payment: $" + p);
  }

  public void displayRate(double r)
  {
    System.out.println("Interest Rate: " + r + "%");
  }

  public void displayApproved(boolean a)
  {
    if (a == true)
    {
      System.out.println("The loan was approved.");
    }
    else
    {
      System.out.println("The loan was not approved.");
    }
  }

  public boolean getAnotherMortgage()
  {
    System.out.println("Would you like to apply for another mortgage? Y/N");
    char response = input.nextLine().charAt(0);
    if (response == 'Y' || response == 'y')
    {
      return true;
    }
    else if (response == 'N' || response == 'n')
    {
      return false;
    }
  }

  public boolean getAnotherCustomer()
  {
    System.out.println("Would you like to consider another customer? Y/N");
    char response = input.nextLine().charAt(0);
    if (response == 'Y' || response == 'y')
    {
      return true;
    }
    else if (response == 'N' || response == 'n')
    {
      return false;
    }
  }
}
