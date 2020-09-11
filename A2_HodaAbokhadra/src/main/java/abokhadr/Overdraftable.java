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
public interface Overdraftable {

    /**
     *
     * @param overdraftAmount
     * 
     */
    public void setOverDraft(double overdraftAmount);

}
