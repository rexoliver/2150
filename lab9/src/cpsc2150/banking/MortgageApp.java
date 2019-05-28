package cpsc2150.banking;

/**
 * Created by kplis on 1/23/2018.
 */
public class MortgageApp {
  public static void main(String [] args)
  {
    IMortgageView view = new MortgageView();
    IMortgageController controller = new MortgageController();
    view.setController(controller);
    controller.submitApplication();
  }

}
