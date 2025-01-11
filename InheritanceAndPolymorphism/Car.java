package Assignment5;

// child class Car inheriting members and methods of parent Vehicle
public class Car extends Vehicle {
    private int numDoors;
    private double trunkCapacity;

    // constructor for Car has parameters specific to this class
    public Car(String make, String model, int year, String fuelType, double price,int numDoors, double trunkCapacity){
        super(make,model,year,fuelType,price);
        this.numDoors = numDoors;
        this.trunkCapacity = trunkCapacity;
    }

    //insurance calculation method only can be invoked for Car
    public double calculateInsurance(){
        double insurancePremium;
        insurancePremium = numDoors * 100 + trunkCapacity * 10;
        return insurancePremium;
    }

    //override method from parent class
    @Override
    public void printInfo(){
        System.out.println();
        System.out.println("Car Information:");
        //invoke Vehicle class method using super
        super.printInfo();
        System.out.println("Number of Doors: "+numDoors);
        System.out.println("Trunk capacity: "+trunkCapacity+ " cu ft");
        System.out.println("Insurance Premium: $"+calculateInsurance());

    }
}
