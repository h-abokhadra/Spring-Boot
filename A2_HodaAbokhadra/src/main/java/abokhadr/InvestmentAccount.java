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
public class InvestmentAccount extends SavingsAccount {

    public InvestmentAccount() {

        super();
    }

    public InvestmentAccount(double interest) {

        super(interest);

    }
    
    @Override
    public void deposit(double depositAmount) {
        super.deposit(depositAmount);
        this.balance += 0.5 * depositAmount;
    }

 
}
