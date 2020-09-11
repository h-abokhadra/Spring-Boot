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
public abstract class Account {
    //data members for Account

    protected String customerName = "Unknown";
    protected String accountNo = "000";
    protected double balance = 1000;
    protected double withdrawAmount = 0;
    protected double depositAmount = 0;
    double interest = 0;


    /**
     * no-arg constructor sets the default values for the account.
     */
    protected Account() {

    }

    protected Account(double interest) {
        
        super();
        this.interest = interest;
        this.balance +=  interest;
        
    }

    public String getAccountNo() {
        return accountNo;
    }
    //Mutator for setting the account number.
    public void setAccountNo(String checkingAccountNo) {
        this.accountNo = checkingAccountNo;
    }
    //Accessor for getting the customer name.
    public String getCustomerName() {
        return customerName;
    }
    //Mutator for setting the customer name.
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    //Accessor for getting the balance.
    public double getBalance() {
        return balance;
    }
    //Mutator for setting the balance.
    public void setBalance(double balance) {
        if (balance > 0) {
            this.balance = balance;
        } else {
            throw new IllegalArgumentException(
                    "Error: Account balance cannot be a negative value. ");
        }
    }

 

    public void deposit(double deposit) {
        if (deposit >= 0) {

            this.balance += deposit;
            this.depositAmount = deposit;
        } else {
          
            this.depositAmount = 0;
        }

    }

    public boolean withdraw(double withdrawAmount) {
        if (balance >= withdrawAmount) {
            balance -= withdrawAmount;
            this.withdrawAmount = withdrawAmount;
            return true;
        } else {
          this.withdrawAmount = 0;
          return false;
        }

    }

   

    /**
     *
     * @return interest
     */
    //Accessor for getting the interest rate.
    public double getInterestRate(){
        
        return interest;
    }

    @Override
    public String toString() {

        return accountNo + "      " + getInterestRate()
                + "      " + depositAmount + "      " + withdrawAmount
                + "      " + balance;

    }
}
