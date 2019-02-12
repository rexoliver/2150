/*
 * Extra Change This is an Example comment for git practice 
 */
package lab1;

public class Car {
    private String make;
    private String model;
    private int year;
    private int miles;
    private String color;
    /**
     *
     *  @param mk make of the car
     *  @param md model of the car
     *  @param y year of the car
     *  @param ml miles of the car
     *  @param c color of the car
     *
     *  @pre 1900 <= y <= Current Year + 1 and 0 <= ml
     *  @post make = mk and model = md and year = y and miles = ml and
    color = c
     */
    public Car(String mk, String md, int y, int ml, String c)
    {
        make = mk;
        model = md;
        year = y;
        miles = ml;
        color = c;
    }
    /**
     *
     *  @return a string representation of the car
     *  @post toString = "A [color], [year], [make] [model] with [miles]
    miles on it"
     */
    @Override
    public String toString()
    {
        String s = "A " + color + ", " + year + ", " + make + " " + model
                + " with " + miles + " miles on it";
        return s;
    }
}
