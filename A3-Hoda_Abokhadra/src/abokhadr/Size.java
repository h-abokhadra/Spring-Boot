/*
        Name:  Hoda Abokhadra
        Assignment:  Assignment3
        Program: SDNE
        Date:  Feb 13th 2020
    
        Description:
        This program contains the enum class for the program.
 */
package abokhadr;

/**
 *
 * @author Hoda Abokhadra
 */
//creating the enum .
public enum Size {

    XS("Extra Small", 0.8),
    S("Small", 0.9),
    M("Medium", 1.0),
    L("Large", 1.1),
    XL("Extra Large", 1.2);

    private String sizeName;
    private double costCoefficient;

    // creating the constructor.
    private Size(String sizeName, double costCoefficient) {

        //intializing the data fields.
        this.sizeName = sizeName;
        this.costCoefficient = costCoefficient;

    }

    // a getter method for the size name.
    public String getSizeName() {
        return sizeName;
    }
    // a getter method for the cost cofficient.

    public double getCostCoefficient() {
        return costCoefficient;
    }
}
