package Assignment5;

// child class Motorcycle inheriting members and methods of parent Vehicle
public class Motorcycle extends Vehicle {
    private int engineDisplacement;
    private boolean isOffRoad;

    // constructor for Motorcycle
    public Motorcycle (String make, String model, int year, String fuelType, double price,int engineDisplacement, boolean isOffRoad){
        super(make,model,year,fuelType,price);
        this.engineDisplacement = engineDisplacement;
        this.isOffRoad = isOffRoad;
    }

    //tax method only can be invoked for Motorcycle
    public double calculateTax(){
        double tax;
        if(engineDisplacement < 500){
            tax = 50;
        }
        else {
            tax = 100;
        }

        if(isOffRoad){
            tax = tax * 0.50;
        }

        return tax;
    }

    //override method from parent class
    @Override
    public void printInfo(){
        System.out.println();
        System.out.println("Motorcycle Information:");
        //invoke Vehicle class method using super
        super.printInfo();
        System.out.println("Engine Displacement: "+engineDisplacement+ " cc");
        System.out.println("Is Off Road: "+isOffRoad);
        System.out.println("Tax: $"+calculateTax());
    }
}
