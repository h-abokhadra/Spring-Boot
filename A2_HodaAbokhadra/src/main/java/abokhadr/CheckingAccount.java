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
public class CheckingAccount extends Account implements Overdraftable {
    
    double overDraftAmount;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(double interest) {
        super(interest);
        overDraftAmount=500;
    }


    
    @Override
    public boolean withdraw(double withdrawAmount) {
         if (balance >= withdrawAmount) {
            balance -= withdrawAmount;
            this.withdrawAmount = withdrawAmount;
            return true;
        }
        if ((balance -  withdrawAmount) >= -1 * overDraftAmount) {
            balance = balance - withdrawAmount;
            overDraftAmount = overDraftAmount + (balance - withdrawAmount);
            return true;
        }
       else {
          this.withdrawAmount = 0;
          return false;
        }
    }

    @Override
    public void setOverDraft(double overdraftAmount) {
        this.overDraftAmount = overdraftAmount;
    }

   


}
