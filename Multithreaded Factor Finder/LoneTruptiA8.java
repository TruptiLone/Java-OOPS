import java.util.Scanner;
//Reference : https://www.javatpoint.com/java-join-method
public class LoneTruptiA8 {
    public static void main(String[] args) throws InterruptedException{
        int number;         //Variable to store input number whose factors to calculate
        int threads;        //variable to store number of threads
        int rangeSize;      //store range size

        number = getInt("Enter a number to find its factors: ","Usage : Input valid integer");
        threads = getInt("Enter the number of threads to use: ","Usage : Input valid integer");

        // Declaring array to store reference variables. These variables can be used to call join method.
        Factorize[] refvariable = new Factorize[threads];

        //Calculate range for each thread
        rangeSize = (int) Math.ceil((double) number/threads);

        //Iterate through number of threads and define range for each thread
        for (int i = 0; i<threads; i++){
            // Defining range for Threads
            int start = (i * rangeSize)+1;
            int end= Math.min(number, ((start + rangeSize) -1));

            //Object is created based on number of threads
            Factorize factorize = new Factorize(number,start,end);
            // store reference variable into array
            refvariable[i] = factorize;
            //Setting custom name for thread
            factorize.setName("thread "+(i+1));
            //Calling thread start method to start child threads
            factorize.start();
        }
        //Main thread calling join method on child threads, main thread will wait for child thread to complete execution
        for (int i = 0; i < refvariable.length; i++) {
           refvariable[i].join();
        }
        System.out.println("\nProgram Completed!");
    }
    //common method for getting input from user till we get valid double value
    public static int getInt(String msg, String errormsg) {
        Scanner user_input = new Scanner(System.in);
        //Looping until user enters valid input
        while (true) {
            System.out.print(msg);
            if (user_input.hasNextInt()) {
                return user_input.nextInt();
            } else {
                // Prompt for invalid input
                System.out.println(errormsg);
                user_input.next(); // Consume invalid input
                continue;
            }
        }
    }
}

class Factorize extends Thread{
    int number;
    int start, end;

    //Constructor taking input of number of threads and ranges
    public Factorize(int number, int start, int end){
        this.number = number;
        this.start = start;
        this.end = end;
    }
    //Run method is where we add job for thread to perform
    @Override
    public void run(){
        System.out.println("starting "+getName()+" for range: "+start+" to "+end);
        for(long i = start; i<= end; i++){
            if(number % i  == 0){
                System.out.println("factor "+i+" found by "+getName());
            }
            try {
                //small delay between iteration for asynchronous execution
                Thread.sleep(100);
            } catch (InterruptedException e) {
              //  throw new RuntimeException(e);
            }
        }

    }
}

