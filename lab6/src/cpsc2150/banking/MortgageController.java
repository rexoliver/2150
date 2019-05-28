package cpsc2150.banking;

/**
 * Created by rexroao on 4/12/19.
 */
public class MortgageController implements IMortgageController {
    public static void main(String [] args)
    {
        IMortgageView view = new MortgageView();
        IMortgageController controller = new MortgageController(view);
        view.setController(controller);
        controller.submitApplication();
}
