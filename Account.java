package classes;

public class Account {
   
    private double balance;
    private String name;

    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
    
}
