package setMods;
// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 3
// 2/6/2019
// MultiSetApp.java

import java.util.Scanner;

public class MultiSetApp  {

    public static void main(String args[]){ createMenu(); }
    public static ISet M1;
    public static ISet M2;
    public static boolean firsttime = true;


    public static void createMenu() {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        while(input != 4) {
            System.out.println("1. Find the Union of Two Sets\n" +
                    "2. Find the intersection of Two Sets\n" +
                    "3. Find the difference of two sets\n" +
                    "4. Exit");
            input = scan.nextInt();

            while (input < 1 || input > 4) {
                System.out.println("Invalid input, please make a selection from 1-4");
                input = scan.nextInt();
            }

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
                    return;
            }
        }
    }

    public static void makeUnion() {
        setMenu();
        setMenu();
        System.out.println("The union is: ");
        M1.union(M2);
        System.out.println(M1);
        firsttime = true;
    }
    public static void makeIntersection() {
        setMenu();
        setMenu();
        System.out.println("The intersection is: ");
        M1.intersect(M2);
        System.out.println(M1);
        firsttime = true;
    }
    public static void makeDifference() {
        setMenu();
        setMenu();
        System.out.println("The difference is: ");
        M1.difference(M2);
        System.out.println(M1);
        firsttime = true;

    }


    /**
     * Set Menu method
     * @pre - none
     * @post [Correct function call according to user's input
     * in response to printMenuString(String set)]
     */
    public static void setMenu() {
        Scanner scan = new Scanner(System.in);
        if(firsttime) System.out.println("Make set 1");
        else System.out.println("Make set 2");
        System.out.println("Enter 1 for an array implementation or 2 for a list implementation");
        int i = scan.nextInt();

        if (firsttime){
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
            finishSets(1);
            return;
        }
        if (!firsttime){
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
            finishSets(2);
        }
    }

    public static void makeArraySet(int c){
        if(c == 1) {
            M1 = new ArraySet();
            firsttime = false;
        }
        else if(c==2)
            M2 = new ArraySet();
    }
    public static void makeListSet(int c){
        if(c == 1) {
            M1 = new ListSet();
            firsttime = false;
        }
        else if(c==2)
            M2 = new ListSet();
    }

    /**
     * Create Integer array method
     * @pre - none
     * @post
     * [New Integer Array initialized and passed to makeMenu()]
     */


    /**
     * Create ArrayList method
     * @pre - none
     * @post
     * [New ArrayList initialized and passed to makeMenu()]
     */
    public static void finishSets(int setnum)
    {
        if (setnum == 1)
        {

            makeMenu(M1);
            return;
        }
        else if (setnum == 2) {

            makeMenu(M2);
            printSets();
        }
    }

    public static void printSets() {
        System.out.println("Set 1 is: ");
        System.out.println(M1);
        System.out.println("Set 2 is: ");
        System.out.println(M2);
    }

    /**
     * Data input method
     * @pre
     * [M has been initialized]
     * @post
     * [User-controlled modifications done on M] and
     * [Proper changes to M applied and printed to user]
     * @param M data structure type to be modified
     */
    public static void makeMenu(ISet M) {
        Scanner scan = new Scanner(System.in);
        String s = "";
        while(!s.equals("q")) {
            System.out.println("Enter a value to add to the set. Enter q to stop adding to the set");
            s = scan.nextLine();
            if (!s.equals("q")) {
                M.add(Integer.parseInt(s));
            }
        }
    }
}