/*
        Name:  Hoda Abokhadra
        Assignment:  2
        Program: PROG24178
        Date:  Jan 31th 2020
    
        Description:
        Banking project provides three types of bank accounts to it's customers 
        (Checking, Savings, and Investment).
 */
package abokhadr;

/**
 *
 * @author Hoda Abokhadra
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Banking {

    // no-arg constructor sets the default values.
    public Banking() {

    }
    double balanceAmount = 0;
    boolean valid = false;
    double depositAmount = 0;
    double withdrawAmount = 0;

    // creating the main method.
    
    public static void main(String[] args) {
        
        // getting the values from the user input.
        
        CheckingAccount checkingAccount = new CheckingAccount(10);
        checkingAccount.setOverDraft(500);
        SavingsAccount savingsAccount = new SavingsAccount(20);
        InvestmentAccount investmentAccount = new InvestmentAccount(30);


        Scanner input = new Scanner(System.in);

        System.out.println("Enter customer name: ");

        String name1 = input.nextLine();
        checkingAccount.setCustomerName(name1);
        savingsAccount.setCustomerName(name1);
        investmentAccount.setCustomerName(name1);


        System.out.println("Enter checking account no: ");

        String checking = input.nextLine();

        checkingAccount.setAccountNo(checking);

        System.out.println("Enter savings account no: ");

        String savings = input.nextLine();

        savingsAccount.setAccountNo(savings);

        System.out.println("Enter investments account no: ");

        String investments = input.nextLine();

        investmentAccount.setAccountNo(investments);

        boolean valid1 = false;

        do {
            try {
                System.out.println("Enter deposit amount: ");
                double depositAmount = input.nextDouble();
                if (depositAmount < 0) {
                    System.out.println("Deposit amount should not be negative");
                    valid1 = false;
                } else {
                    checkingAccount.deposit(depositAmount);
                    savingsAccount.deposit(depositAmount);
                    investmentAccount.deposit(depositAmount);
                    valid1 = true;
                }
            } catch (InputMismatchException e) {

                System.out.println("Enter a valid number");
                valid1 = false;
                input.nextLine();

            }

        } while (!valid1);

        valid1 = false;
        do {
            System.out.println("Enter withdraw amount: ");
            try {
                double withdrawAmount = input.nextDouble();
                if (withdrawAmount < 0) {
                    System.out.println("Withdraw amount should not be negative");
                    valid1 = false;
                } else {
                    boolean validCheckingWithdraw = checkingAccount.withdraw(withdrawAmount);
                    if (validCheckingWithdraw == false) {
                        System.out.println("Negative balance. Transaction Cancelled");
                    }

                    boolean validSavingWithdraw = savingsAccount.withdraw(withdrawAmount);
                    if (validSavingWithdraw == false) {
                        System.out.println("Negative balance. Transaction Cancelled");
                    }

                    boolean validInvestementWithdraw = investmentAccount.withdraw(withdrawAmount);
                    if (validInvestementWithdraw == false) {
                        System.out.println("Negative balance. Transaction Cancelled");
                    }
                    valid1 = true;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Please enter valid withdraw amount");
                input.nextLine();

            }
        } while (!valid1);
        //Printing the data .
        System.out.println("Customer: " + name1
                + "\n============================================="
                + "\nAccNo." + "  " + "Interest" + "  " + "Deposit" + "  "
                + "Withdraw" + "  " + "NewBal."
                + "\n============================================="
                + "\n" + checkingAccount.toString() + "\n" 
                + savingsAccount.toString()
                + "\n" + investmentAccount.toString()
        );

    }

}
