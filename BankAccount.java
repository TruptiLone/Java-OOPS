public class BankAccount {
    String accountholder;
    int balance;

    public BankAccount(String name, int amt){
        this.accountholder = name;
        this.balance = amt;

    }
    public int deposit(int amt){
        balance = balance + amt;
        return balance;

    }
    public int withdraw(int amt){
        if(amt < balance){
            balance = balance - amt;
            return balance;
        }else {
            System.out.println("Insufficient balance");
            return balance;
        }

    }
    public void display(){
        System.out.println("Your balance is : "+balance);

    }

    public static void main(String[] args) {
        BankAccount ba = new BankAccount("Trupti", 10000);
        ba.withdraw(1000);
        ba.deposit(50);
        ba.display();
    }
}
