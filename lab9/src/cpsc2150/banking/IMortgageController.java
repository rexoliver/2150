package cpsc2150.banking;

/**
 * This interface is the Controller that partners with IMortgageView
 *
 * Defines: View: The IMortgageView
 * Initialization ensures: View != NULL
 */

public interface IMortgageController {

    /**
     * This will handle the processing of a mortgage application
     * @pre: none
     * @post: none
     */
    void submitApplication();




}
