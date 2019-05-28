package cpsc2150.banking;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by kplis on 1/30/2018.
 */
public class TestMortgage {
    //to allow for rounding issues
    private final double PAY_ERROR = .01;
    private final double RATE_ERROR = .00000001;

    private final double COST1 = 150000;

    private ICustomer ICustFactory(double d, double i, int s, String n){
        return new Customer(d, i, s, n);
    }
    
    private IMortgage IMortFactory(double c, double dp, int y, ICustomer cust)
    {
        return new Mortgage(c, dp, y, cust);
    }

    //START testRate
    //START YEAR 15
    //year is 15
    //pd is 10%
    @Test
    public void testRate_dp10_y15_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .135;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y15_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .085;
        double found_rate = m.getRate();


        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y15_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .045;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y15_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .04;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y15_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .035;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }


    //year is 15
    //pd is 20%
    @Test
    public void testRate_dp20_y15_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .13;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y15_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .08;
        double found_rate = m.getRate();


        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y15_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .04;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y15_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .035;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y15_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .03;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }



    //START YEAR 20
    //year is 20
    //pd is 10%
    @Test
    public void testRate_dp10_y20_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .135;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y20_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .085;
        double found_rate = m.getRate();


        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y20_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .045;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y20_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .04;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y20_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .035;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }


    //year is 20
    //pd is 20%
    @Test
    public void testRate_dp20_y20_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .13;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y20_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .08;
        double found_rate = m.getRate();


        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y20_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .04;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y20_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .035;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y20_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .03;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }





    //START YEAR 30
    //year is 30
    //pd is 10%
    @Test
    public void testRate_dp10_y30_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .14;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y30_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .09;
        double found_rate = m.getRate();


        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y30_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .05;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y30_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .045;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp10_y30_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .04;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }


    //year is 30
    //pd is 20%
    @Test
    public void testRate_dp20_y30_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .135;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y30_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .085;
        double found_rate = m.getRate();


        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y30_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .045;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y30_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .04;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }

    @Test
    public void testRate_dp20_y30_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_rate = .035;
        double found_rate = m.getRate();

        assertTrue( abs(act_rate - found_rate)< RATE_ERROR);


    }


    /********************************************************
     *
     *
     *
     *
     * CALC PAYMENT
     *
     *
     *
     *
     *
     ********************************************************/







    //START TestCalcPay
    //START YEAR 15
    //year is 15
    //pd is 10%
    @Test
    public void testCalcPay_dp10_y15_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1752.73;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y15_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1329.40;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y15_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1032.74;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y15_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 998.58;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y15_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 965.09;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }


    //year is 15
    //pd is 20%
    @Test
    public void testCalcPay_dp20_y15_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1518.29;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y15_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1146.78;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y15_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 887.63;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y15_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 857.86;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y15_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 15;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 828.70;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }



    //START YEAR 20
    //year is 20
    //pd is 10%
    @Test
    public void testCalcPay_dp10_y20_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1629.96;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y20_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1171.56;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y20_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 854.08;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y20_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 818.07;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y20_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 782.95;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }


    //year is 20
    //pd is 20%
    @Test
    public void testCalcPay_dp20_y20_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1405.89;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y20_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1003.73;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y20_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 727.18;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y20_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 695.95;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y20_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 20;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 665.52;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }





    //START YEAR 30
    //year is 30
    //pd is 10%
    @Test
    public void testCalcPay_dp10_y30_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1599.58;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y30_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1086.24;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y30_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 724.71;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y30_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 684.03;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp10_y30_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .1;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 644.51;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }


    //year is 30
    //pd is 20%
    @Test
    public void testCalcPay_dp20_y30_s450()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 1374.49;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y30_s550()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 550 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 922.70;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y30_s650()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 650 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 608.02;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y30_s725()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 572.90;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

    @Test
    public void testCalcPay_dp20_y30_s775()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = cost * .2;
        int y = 30;

        //customer constructor
        double debt = 500;
        double inc = 50000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        double act_pay = 538.85;
        double found_pay = m.getPayment();

        assertTrue( abs(act_pay - found_pay)< PAY_ERROR);


    }

/************************************************************

 Test Loan Approved


 ************************************************************/


    //Start low rate
    //Start low down payment
    @Test
    public void testLoanApproved_rateLow_DPLow_DtoILow()
    {

        //mortgage constructor
        double cost = COST1;
        double dp = 4500;
        int y = 30;

        //customer constructor
        double debt = 100;
        double inc = 60000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);



        assertTrue( !m.loanApproved());


    }

    @Test
    public void testLoanApproved_rateLow_DPLow_DtoIHigh()
    {

        //mortgage constructor
        double cost = COST1;
        double dp = 4500;
        int y = 30;

        //customer constructor
        double debt = 2000;
        double inc = 60000;
        int score = 775 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);



        assertTrue( !m.loanApproved());


    }


    //start high downpayment
    @Test
    public void testLoanApproved_rateLow_DPHigh_DtoILow()
    {

        //mortgage constructor
        double cost = COST1;
        double dp = 30000;
        int y = 30;

        //customer constructor
        double debt = 100;
        double inc = 60000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);



        assertTrue( m.loanApproved());


    }

    @Test
    public void testLoanApproved_rateLow_DPHigh_DtoIHigh()
    {

        //mortgage constructor
        double cost = COST1;
        double dp = 30000;
        int y = 30;

        //customer constructor
        double debt = 2000;
        double inc = 60000;
        int score = 725 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);



        assertTrue( !m.loanApproved());


    }

    //Start high rate
    //Start low down payment
    @Test
    public void testLoanApproved_rateHigh_DPLow_DtoILow()
    {

        //mortgage constructor
        double cost = COST1;
        double dp = 4500;
        int y = 20;

        //customer constructor
        double debt = 100;
        double inc = 60000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);



        assertTrue( !m.loanApproved());


    }

    @Test
    public void testLoanApproved_rateHigh_DPLow_DtoIHigh()
    {

        //mortgage constructor
        double cost = COST1;
        double dp = 4500;
        int y = 20;

        //customer constructor
        double debt = 2000;
        double inc = 60000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);



        assertTrue( !m.loanApproved());


    }


    //start high downpayment
    @Test
    public void testLoanApproved_rateHigh_DPHigh_DtoILow()
    {

        //mortgage constructor
        double cost = COST1;
        double dp = 30000;
        int y = 30;

        //customer constructor
        double debt = 100;
        double inc = 60000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);



        assertTrue( !m.loanApproved());


    }

    @Test
    public void testLoanApproved_rateHigh_DPHigh_DtoIHigh()
    {

        //mortgage constructor
        double cost = COST1;
        double dp = 30000;
        int y = 30;

        //customer constructor
        double debt = 2000;
        double inc = 60000;
        int score = 450 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);



        assertTrue( !m.loanApproved());


    }

    @Test
    public void testToString_Approved()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = 30000;
        int y = 30;

        //customer constructor
        double debt = 450;
        double inc = 60000;
        int score = 710 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        String str = loanToString(COST1 - dp, m.getRate(), y, m.getPayment());
        assertTrue(m.toString().equals(str));
    }

    @Test
    public void testToString_NotApproved()
    {
        //mortgage constructor
        double cost = COST1;
        double dp = 300;
        int y = 30;

        //customer constructor
        double debt = 450;
        double inc = 60000;
        int score = 710 ;
        String name = "Billy Bob";

        ICustomer c = ICustFactory(debt, inc, score, name);
        IMortgage m = IMortFactory(cost, dp, y, c);

        String str = "Loan was not approved";
        assertTrue(m.toString().equals(str));
    }




    private String loanToString(double principal, double rate, int years, double payment )
    {
        String str = "";


            str += "Principal Amount: $" + principal + "\n";
            str += "Interest Rate: " + (rate * 100) + "%\n";
            str += "Term: " + years + " years\n";
            str += "Monthly Payment: $" + payment + "\n";


        return str;
    }

    private double abs(double x)
    {
        if(x < 0)
        {
            return x*-1;
        }
        else
        {
            return x;
        }
    }
}
