package Assignment5;

//super or parent class representing vehicle
public class Vehicle {
    private String make;
    private String model;
    private int year;
    private String fuelType;
    private double price;

    //constructor for Vehicle with explicit parameters
    public Vehicle(String make, String model, int year, String fuelType, double price){
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.price = price;
    }

    // display vehicle information
    public void printInfo(){
        System.out.println("Vehicle Information:");
        System.out.println("Make: "+make);
        System.out.println("Model: "+model);
        System.out.println("Year: "+year);
        System.out.println("Fuel Type: "+fuelType);
        System.out.println("Price: $"+price);
    }
}

//References : https://www.geeksforgeeks.org/overriding-in-java/
//https://www.geeksforgeeks.org/scanner-class-in-java/
