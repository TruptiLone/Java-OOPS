public class LoneTruptiA1 {
    public static void main(String[] args) {

        //Check for inputs are not equal two arguments and inputs are other than integers
        if (args.length != 2 || !isInteger(args[0]) || !isInteger(args[1])) {

            System.out.println("Usage java LoneTruptiA1 number 1 Number 2");
            System.out.println("\n\nProgram Completed.\n");

        } else {
            //Parsing string arguments
            int number1 = Integer.parseInt(args[0]);
            int number2 = Integer.parseInt(args[1]);

            //Instantiating object
            LoneTruptiA1 lta = new LoneTruptiA1();

            //printing results
            System.out.println("Addition : " + number1 + " + " + number2 + " = " + lta.addition(number1, number2));
            System.out.println("Subtraction : " + number1 + " - " + number2 + " = " + lta.subtraction(number1, number2));
            System.out.println("Multiplication: " + number1 + " * " + number2 + " = " + lta.multiplication(number1, number2));
            try {
                System.out.println("Division : " + number1 + " / " + number2 + " = " + lta.division(number1, number2));
            } catch (ArithmeticException e){
                System.out.println("Error in Division: Divide by zero not allowed");
            }
            try {
                System.out.println("Modules : " + number1 + " % " + number2 + " = " + lta.modulus(number1, number2));
            } catch (ArithmeticException e){
                System.out.println("Error in Modules: Divide by zero not allowed");
            }
            System.out.println("The GCD of " + number1 + " and " + number2 + " is " + lta.gcd(number1, number2));
            System.out.println();
            System.out.println("Program Completed.\n");
        }
    }

    //Method to check if inputs are Integers
    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Method for summation of two numbers
    public int addition(int number1, int number2){
        int sum = number1 + number2;
        return sum;
    }

    //Method for subtraction of two numbers
    public int subtraction(int number1, int number2){
        int sub = number1 - number2;
        return sub;
    }

    //Method for multiplication of two numbers
    public int multiplication(int number1, int number2){
        int mul = number1 * number2;
        return mul;
    }

    //Method for division of two numbers
    public int division(int number1, int number2){
        //Check if denominator is zero
        int div = number1 / number2;
        return div;
    }

    //Method for modulus operation of two numbers
    public int modulus(int number1, int number2){
        int mod = number1 % number2;
        return mod;
    }

    //Method for finding GCD of two numbers
        //1. Find smallest of input number
        //2. search for greatest common divisor starting from smallest of input number
    public int  gcd(int number1, int number2) {
        //variable to store greatest divisor of input number
        int greatest_divisor = 1;
        //var to store smallest number from input number
        int smaller_number;
        //Condition to check if input is negative Absolute values of input numbers
        if (number1 < 0){
            number1 = Math.abs(number1);
        }
        if (number2 < 0){
            number2 = Math.abs(number2);
        }

        //storing smaller number between two inputs to use that number in calculating factors
        if (number1 < number2){
            smaller_number = number1;
        } else {
            smaller_number = number2;
        }

        //looping through numbers starting from smaller_number to number that has greatest common divisor
        for(int i = smaller_number; i >= 1; i--) {
            if (number1 % i == 0 && number2 % i == 0) {
                greatest_divisor = i;
                break;
            }
        }
        return greatest_divisor;
    }
}

    //Ref: https://www.geeksforgeeks.org/integer-valueof-vs-integer-parseint-with-examples/
    //Ref : https://www.geeksforgeeks.org/command-line-arguments-in-java/
    //Ref : https://www.geeksforgeeks.org/java-program-to-handle-divide-by-zero-and-multiple-exceptions/
    //Ref : https://www.w3schools.com/java/java_type_casting.asp

    //Test cases handled:
    //Arguments of two positive integers
    //Arguments more than two inputs
    //Arguments with with no integers
    //Inputs more than 2
    //Argument with second argument 0 causing Divide by 0 for division and modulus
    //Arguments of two negative integers
    //Argument in args[1] is bigger

