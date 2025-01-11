package Assignment5;

import java.util.Scanner;


public class LoneTruptiA5
{
    //common method for getting input from user till we get valid double value
    public static double getDouble(String msg, String errormsg) {
        Scanner user_input = new Scanner(System.in);
        //Looping until user enters valid input
        while (true) {
            System.out.print(msg);
            if (user_input.hasNextDouble()) {
                return user_input.nextDouble();
            } else {
                // Prompt for invalid input
                System.out.println(errormsg);
                user_input.next(); // Consume invalid input
                continue;
            }
        }
    }

    //common method for getting input from user till we get valid int value
    public static int getInt(String msg, String errormsg) {
        Scanner user_input = new Scanner(System.in);
        //Looping until user enters valid input
        while (true) {
            System.out.print(msg);
            if (user_input.hasNextDouble()) {
                return user_input.nextInt();
            } else {
                // Prompt for invalid input
                System.out.println(errormsg);
                user_input.next(); // Consume invalid input
                continue;
            }
        }
    }

    //common method for getting input from user till we get valid boolean value
    public static boolean getBoolean(String msg, String errormsg) {
        Scanner user_input = new Scanner(System.in);
        //Looping until user enters valid input
        while (true) {
            System.out.print(msg);
            if (user_input.hasNextBoolean()) {
                return user_input.nextBoolean();
            } else {
                // Prompt for invalid input
                System.out.println(errormsg);
                user_input.next(); // Consume invalid input
                continue;
            }
        }
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        // Taking inputs from the user
        System.out.println("Enter Motorcycle Details: ");

        System.out.print("Make: ");
        String makeM = userInput.nextLine();

        System.out.print("Model: ");
        String modelM = userInput.nextLine();

        int yearM = getInt("Year: ","Usage: Enter valid year input.");

        System.out.print("Fuel Type: ");
        String fuelTypeM = userInput.nextLine();

        double priceM = getDouble("Price: ","Usage: Enter valid price input.");

        int engineDisplacementM = getInt("Engine Displacement: ","Usage: Enter valid Engine Displacement input.");

        boolean isOffRoadM = getBoolean("Is Off Road (true/false): ","Usage: Enter valid true/false input.");

        System.out.println();
        System.out.println("Enter Car Details:");

        System.out.print("Make: ");
        String makeC = userInput.nextLine();


        System.out.print("Model: ");
        String modelC = userInput.nextLine();

        int yearC = getInt("Year: ","Usage: Enter valid year input.");

        System.out.print("Fuel Type: ");
        String fuelTypeC = userInput.nextLine();


        double priceC = getDouble("Price: ","Usage: Enter valid price input.");

        int numberOfDoors = getInt("Number of Doors: ","Usage: Enter valid number of doors input.");

        double trunkCapacity = getDouble("Trunk Capacity (cu ft): ","Usage: Enter valid Trunk capacity input.");

        /*Instantiating Motorcycle and Car object
        Using polymorphism to assign a
        Motorcycle instance to a Vehicle reference
         */
        Vehicle vm = new Motorcycle(makeM,modelM,yearM,fuelTypeM,priceM,engineDisplacementM,isOffRoadM);
        Vehicle vc = new Car(makeC,modelC,yearC,fuelTypeC,priceC, numberOfDoors,trunkCapacity);
        vm.printInfo();
        vc.printInfo();
        System.out.println();
        System.out.println();
        System.out.println("Program Completed");
    }
}
