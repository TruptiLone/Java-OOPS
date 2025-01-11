import java.util.Scanner;

public class LoneTruptiBankAccount {
    // Private data fields
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private double annualInterestRate;

    // Constructor initializing all data fields
    LoneTruptiBankAccount(String accountNumber, String accountHolderName, double balance, double annualInterestRate){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    //method that accepts a double amount and adds it to the balance
    public double deposit(double amount){
        balance = balance + amount;
        System.out.println("Amount deposited successfully. New balance: $" +balance);
        return balance;
    }

    //method that accepts a double amount and withdraws this amount from balance
    //returns -1 if amount is larger than balance
    public double withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient funds. Current balance is $"+balance+ ". Please enter an amount <= to $"+balance);
            return -1;
        }else {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully. Remaining balance: $" +balance);
            return balance;
        }

    }

    //method that calculates interest
    public double calculateInterest() {
        double interest = (balance * annualInterestRate) / 100 * 1;
        balance += interest;
        System.out.println("Interest added. New balance: $" + balance);
        return balance;
    }

    //checks balance
    public double checkBalance(){
        System.out.println("Current balance: " + balance);
        return balance;
    }

    //displays account details
    public void displayAccountDetails(){
        System.out.println("Account Number : "+accountNumber);
        System.out.println("Account Holder Name : "+accountHolderName);
        System.out.println("Balance : "+balance);
        System.out.println("Account Interest Rate : "+annualInterestRate+"%");

    }

    public void display(){
        System.out.println("\nChoose an operation:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Calculate Interest");
        System.out.println("5. Display Account Details");
        System.out.println("6. Exit");
    }

    //common method for getting input from user till we get valid double value
    public static double getDouble(String msg, String errormsg) {
        Scanner user_input = new Scanner(System.in);
        //Looping until user enters valid input
        while (true) {
            System.out.println(msg);
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

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Account Number:");
        String accountNumber = userInput.nextLine();
        System.out.println("Enter Account Holders Name:");
        String accountHolder = userInput.nextLine();

        double balance=0;
        double annualInterestRate = 0;
        balance = getDouble("Enter Initial Balance:","Usage : Input should be valid $ amount");
        annualInterestRate = getDouble("Enter annual interest rate:","Usage : Input should be valid Interest Rate");

        LoneTruptiBankAccount account = new LoneTruptiBankAccount(accountNumber,accountHolder,balance,annualInterestRate);
        int choice;
        do{
            do {
                account.display();
                if (userInput.hasNextInt()) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 6.");
                    userInput.next(); // Clear the invalid input
                    continue;
                }
            } while (true);

            choice = userInput.nextInt();

            switch (choice) {
                case 1:
                    account.checkBalance();
                    break;
                case 2:
                    double depositAmount = getDouble("Enter deposit amount: ","Usage : Input should be valid $ amount");
                    account.deposit(depositAmount);
                    break;
                case 3:
                    while (true){
                        double funds = getDouble("Enter withdrawal amount: ","Usage : Input should be valid $ amount");
                        double remainingBalance = account.withdraw(funds);
                        if(remainingBalance == -1) continue;
                        break;
                    }
                    break;
                case 4:
                    account.calculateInterest();
                    break;
                case 5:
                    account.displayAccountDetails();
                    break;
                case 6:
                    System.out.println("Exiting Program");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }while (choice!=6);

        userInput.close();
    }
}

//Ref : https://www.w3schools.com/java/java_user_input.asp
// Ref : https://www.geeksforgeeks.org/double-parsedouble-method-in-java-with-examples/
