package setMods;
// Rex Oliver and Charles Hayes
// CPSC 2151-002 Lab 3
// 2/6/2019
// SetApp.java

import java.util.Scanner;

public class SetApp {

    public static void main(String args[]){
        setMenu();
    }
    public static ISet M1;



    /**
     * Printed Menu method
     * @pre - none
     * @post
     * [Set data printed to user]
     * @param set data of set after call to toString()
     */
    public static void printMenuString(String set) {
        System.out.println("Set is:");
        System.out.println(set);
        System.out.println("1. Add a value to the set");
        System.out.println("2. Remove a value from the set");
        System.out.println("3. Quit.");
    }

    /**
     * Set Menu method
     * @pre - none
     * @post [Correct function call according to user's input
     * in response to printMenuString(String set)]
     */
    public static void setMenu()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 1 for an array implementation or 2 for a list implementation");
        int i = scan.nextInt();
        switch (i) {
            case 1:
                doArraySet(); break;
            case 2:
                doListSet(); break;
            case 3:
                return; }
    }

    /**
     * Create Integer array method
     * @pre - none
     * @post
     * [New Integer Array initialized and passed to makeMenu()]
     */
    public static void doArraySet(){
        M1 = new ArraySet();
        makeMenu(M1);
    }

    /**
     * Create ArrayList method
     * @pre - none
     * @post
     * [New ArrayList initialized and passed to makeMenu()]
     */
    public static void doListSet()
    {
        M1 = new ListSet();
        makeMenu(M1);
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
    public static void makeMenu(ISet M)
    {
        int i= 0;
        if(i ==3)
            return;
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Add a value to the set");
        System.out.println("2. Remove a value from the set");
        System.out.println("3. Quit.");
        i = scan.nextInt();

        while(i != 3)
        {

            if(i == 1)
            {
                System.out.println("What value to add to set?");
                int j = scan.nextInt();
                if(M.contains(j))
                    System.out.println("That value is already in the set");
                else M.add(j);
            }
            if(i == 2)
            {
                int j;
                if(M.getSize() == 0){
                    System.out.println("Can't remove from an empty set!");
                }
                else {
                    System.out.println("What position should be removed from set");
                    j = scan.nextInt();
                    while(!(j >= 0 && j < M.getSize())){
                        System.out.println("That's not a valid position");
                        System.out.println("What position should be removed from set");
                        j = scan.nextInt();
                    }
                    M.removePos(j);
                }
            }
            printMenuString(M.toString());
            i = scan.nextInt();
        }
    }
}