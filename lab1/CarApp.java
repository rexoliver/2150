
package lab1;
        import java.util.*;
        import java.time.*;
public class CarApp {
    public static void main(String [] args)
    {
        List<Car> myList = new ArrayList<Car>();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int option = Integer.parseInt(scanner.nextLine());
        while(option != 3)
        {
            if(option  == 1)
            {
                myList.add(getCar(scanner));
            }
            if(option == 2)
            {
                for(Car c: myList)
                {
                    System.out.println(c.toString());
                }
            }
            printMenu();
            option = Integer.parseInt(scanner.nextLine());
        }
    }
    private static void printMenu()
    {
        System.out.println("1. Add a car");
        System.out.println("2. Print the cars");
        System.out.println("3. Quit");
        System.out.println("Select your option: ");
    }
    private static Car getCar(Scanner scanner){
        Car c;
        System.out.println("What is the make of the car?");
        String make = scanner.nextLine();
        System.out.println("What is the model of the car?");
        String model = scanner.nextLine();
        System.out.println("What is the color of the car?");
        String color = scanner.nextLine();
        System.out.println("What is the year of the car?");
        int year = Integer.parseInt(scanner.nextLine());
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
//add a breakpoint in the next line
        while(year < 1900 || year > currentYear + 1)
        {
            System.out.println("Year must be greater than or equal to 1900 "
                    + "and less than or equal to next year! ");
            System.out.println("What is the year of the car");
            year = Integer.parseInt(scanner.nextLine());
        }
        System.out.println("How many miles are on the car?");
        int miles = Integer.parseInt(scanner.nextLine());
        while(miles < 0)
        {
            System.out.println("You can't have negative miles!");
            System.out.println("How many miles are on the car?");
            miles = Integer.parseInt(scanner.nextLine());
        }
        c = new Car(make, model, year, miles, color);
        return c;
    }
}