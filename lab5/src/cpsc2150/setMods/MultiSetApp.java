package setMods;
// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 5
// 3/1/19
// MultiSetApp.java

import java.util.Scanner;

public class MultiSetApp  {
    /**
     * @invariant M1 an instance of a class, not interface ISet
     * @invariant M2 an instance of a class, not interface ISet
     */

    public static void main(String args[]){ createMenu(); }
    public static ISet<Integer> M1;
    public static ISet<Integer> M2;
    public static boolean firsttime = true;

    /**
     * @pre - none
     * @post [a menu is displayed] and [user’s entry is processed]
     */
    public static void createMenu() {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        while(input != 5) {
            System.out.println("1. Find the Union of Two Sets\n" +
                    "2. Find the intersection of Two Sets\n" +
                    "3. Find the difference of two sets\n" +
                    "4. See if two sets are equal\n"+
                    "5. Exit");
            //Get input from user
            input = scan.nextInt();

            //Keep getting input from user if user-input not within menu options
            while (input < 1 || input > 5) {
                System.out.println("Invalid input, please make a selection from 1-5");
                input = scan.nextInt();
            }

            //Perform set operation according to input
            switch (input) {
                case 1:
                    makeUnion();
                    break;

                case 2:
                    makeIntersection();
                    break;

                case 3:
                    makeDifference();
                    break;

                case 4:
                    makeEquals();
                    break;
                case 5:
                    return;
            }
        }
    }

    /**
     * @pre - none
     * @post [union set is made between M1 and M2]
     */
    public static void makeUnion() {
        //Create first set
        setMenu();
        //Create second set
        setMenu();
        System.out.println("The union is: ");
        //Perform union of two sets
        M1.union(M2);
        System.out.println(M1);
        //Reset sets
        firsttime = true;
    }

    public static void makeEquals() {
        //Create first set
        setMenu();
        //Create second set
        setMenu();
        //Perform union of two sets
        boolean setsEqual = M1.equals(M2);
        if(setsEqual)
            System.out.println("The sets are equal!");
        else System.out.println("The sets are not equal!");
        //Reset sets
        firsttime = true;
    }

    /**
     * @pre - none
     * @post [intersection set is made between M1 and M2]
     */
    public static void makeIntersection() {
        //Create first set
        setMenu();
        //Create second set
        setMenu();
        System.out.println("The intersection is: ");
        //Perform intersection of two sets
        M1.intersect(M2);
        System.out.println(M1);
        //Reset sets
        firsttime = true;
    }

    /**
     * @pre - none
     * @post [difference set is made between M1 and M2]
     */
    public static void makeDifference() {
        //Create first set
        setMenu();
        //Create second set
        setMenu();
        System.out.println("The difference is: ");
        //Perform difference of two sets
        M1.difference(M2);
        System.out.println(M1);
        //Reset sets
        firsttime = true;

    }


    /**
     * Set Menu method
     * @pre - none
     * @post [correct function call according to user's input,
     * in response to printed menu]
     */
    public static void setMenu() {
        Scanner scan = new Scanner(System.in);
        if(firsttime) System.out.println("Make set 1");
        else System.out.println("Make set 2");
        System.out.println("Enter 1 for an array implementation or 2 for a list implementation");
        //Get input from user
        int i = scan.nextInt();

        //If first set hasn’t been made...
        if (firsttime){
        //Create set with user’s desired structure
            switch (i) {
                case 1: {
                    makeArraySet(1);
                    break;
                }
                case 2: {
                    makeListSet(1);
                    break;
                }
                case 3: {
                    return;
                }
            }
            //Get data entries from user
            finishSets(1);
            return;
        }
        //If first set has been made...
        if (!firsttime){
        //Create set with user’s desired structure
            switch (i) {
                case 1: {
                    makeArraySet(2);
                    break;
                }
                case 2: {
                    makeListSet(2);
                    break;
                }
                case 3: {
                    return;
                }
            }
            //Get data entries from user
            finishSets(2);
        }
    }


    /**
     * @pre - none
     * @post [an ISet is initialized with ArraySet]
     * @param c the number set being made
     */
    public static void makeArraySet(int c){
        //If first set hasn’t been made...
        if(c == 1) {
            //Make first set an ArraySet
            M1 = new ArraySet<Integer>();
            //First set has been made
            firsttime = false;
        }
        //If first set has been made...
        else if(c==2)
            //Make second set an ArraySet
            M2 = new ArraySet<Integer>();
    }

    /**
     * @pre - none
     * @post [an ISet is initialized with ListSet]
     * @param c the number set being made
     */
    public static void makeListSet(int c){
        //If first set hasn’t been made...
        if(c == 1) {
            //Make first set a ListSet
            M1 = new ListSet<Integer>();
            //First set has been made
            firsttime = false;
        }
        //If first set has been made...
        else if(c==2)
            //Make second set a ListSet
            M2 = new ListSet<Integer>();
    }

    /**
     * @pre [M1 has been initialized]
     * @post [ISet contains user-inputted ints]
     * @param setnum the number set being inputted
     */
    public static void finishSets(int setnum)
    {
        //If first set is being inputted...
        if (setnum == 1)
        {

            //Add user’s entries to set
            makeMenu(M1);
            return;
        }

        //If second set is being inputted...
        else if (setnum == 2) {

            //Add user’s entries to set
            makeMenu(M2);
            //Display both sets M1 and M2
            printSets();
        }
    }


    /**
     * @pre [M1 and M2 have been initialized] and [finishSets() has
     * been performed on M1 and M2]
     * @post [Final M1 and M2 displayed to the user]
     */

    public static void printSets() {
        System.out.println("Set 1 is: ");
        //Display set M1
        System.out.println(M1);
        System.out.println("Set 2 is: ");
        //Display set M2
        System.out.println(M2);
    }

    /**
     * @pre [M has been initialized]
     * @post  [User-controlled modifications done on M] and
     * [Proper changes to M applied and printed to user]
     * @param M ISet to be modified
     */
    public static void makeMenu(ISet<Integer> M) {
        Scanner scan = new Scanner(System.in);
        String s = "";
        //While the user wants to keep inputting ints...
        while(!s.equals("q")) {
            System.out.println("Enter a value to add to the set. Enter q to stop adding to the set");
            //Get value from user
            s = scan.nextLine();
            //If user does not want to quit data entries...
            if (!s.equals("q")) {
                //Add value s to set
                M.add(Integer.parseInt(s));
            }
        }
    }
}
