package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class BankingSystem {

    public static ArrayList<Account> accountList = new ArrayList<>();

    private static void createAccount() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Your Name : ");
        String name = scan.nextLine();
        System.out.println("Enter Your Deposit : ");
        int deposit = scan.nextInt();
        accountList.add(new Account(deposit, name));
    }

    public static void depositMoney() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Account Name : ");
        String name = scan.nextLine();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getName().equals(name)) {
                System.out.println("Enter Deposit Amount : ");
                int dep = scan.nextInt();
                double bal = accountList.get(i).getBalance();
                accountList.get(i).setBalance(bal + dep);
                System.out.println("Success");
                return;
            }

        }
        System.out.println("Invalid Account");
    }

    private static void withdrawMoney() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Account Name : ");
        String name = scan.nextLine();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getName().equals(name)) {
                System.out.println("Enter Withdraw Amount : ");
                int wit = scan.nextInt();
                double bal = accountList.get(i).getBalance();
                if (bal > wit) {
                    accountList.get(i).setBalance(bal - wit);
                    System.out.println("Success");
                    return;
                } else {
                    System.out.println("Account balance insufficiant");
                }

            }

        }
        System.out.println("Invalid Account");
    }

    public static double checkBalance() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Account Name : ");
        String name = scan.nextLine();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getName().equals(name)) {
                System.out.println("Account balanace : " + accountList.get(i).getBalance());
                return accountList.get(i).getBalance();
            }
        }
        System.out.println("Invalid Account");
        return -1.0;
    }

     public static double loanCal() {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter months : ");
        int months = scan.nextInt();

        System.out.println("Enter loan amount : ");
        double loan = scan.nextDouble();
        
        

        double monthlypay;
        double fullpay;

        if (months <= 36) {
            fullpay = (loan * 15) / 100;
            monthlypay = fullpay / (months * 12);

        } else if (months <= 60) {
            fullpay = (loan * 20) / 100;
            monthlypay = fullpay / (months * 12);
        } else if (months <= 84) {
            fullpay = (loan * 30) / 100;
            monthlypay = fullpay / (months * 12);
        } else {
            fullpay = (loan * 35) / 100;
            monthlypay = fullpay / (months * 12);
        }
        System.out.println("monthly payment is : " + monthlypay);
        return monthlypay;
    }

    private static void showMenu() {
        while (true) {
            System.out.println("============================BANKING SYSTEM==============================");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Loan Calculator");
            System.out.println("5. Create Account");
            System.out.println("6. Exit");
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your choice");
            int x = scan.nextInt();

            switch (x) {
                case 1:
                    depositMoney();
                    break;
                case 2:
                    withdrawMoney();
                    break;

                case 3:
                    checkBalance();
                    break;
                case 4:
                    loanCal();
                    break;

                case 5:
                    createAccount();
                    break;
//                    exit
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input! Try Again!");
                    break;
            }

        }


    }

    public static void main(String[] args) {
        showMenu();
    }

}
