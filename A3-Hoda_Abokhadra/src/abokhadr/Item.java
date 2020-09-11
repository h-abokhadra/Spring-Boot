    /*
        Name:  [your name here]
        Assignment:  [assignment name]
        Program: [your program name here]
        Date:  [assignment due date here]
    
        Description:
        [program description in your own words]
    */

package abokhadr;

/*
    Item.java
    Author: H.D
    Date: n / a

    Description
    The Item class represents a single item that will be of a specific size
    (Size). Each item has a size and a price.
 
    @author Haxhi Dvorani
    @see Size
    @see ItemList
 */
//package dvoranih;

public class Item {

    /* itemSize is declared public because it is an Enum. In this case we don't
    * need getters and setters since can access the value directly. There
    * is not risk of placing illegal values because Enum will implicitly throw
    * IllegalArgument exception if an attemt to pass a value that does not
    * match any of the values in the Enum.*/
    public Size itemSize;

    private double baseCost;

    /**
     * Constructs an empty Item object with a size M and a price of $0.
     */
    public Item() {
        itemSize = Size.M;
        baseCost = 0.0;
    }

    /**
     * Constructs an Item of a specific Size and price.
     *
     * @param size the item size
     * @param baseCost the price for this item
     */
    public Item(Size size, double baseCost) {
        itemSize = size;
        setBaseCost(baseCost);
    }

    /**
     * Retrieves the price of this item.
     *
     * @return the item price
     */
    public double getBaseCost() {
        return baseCost;
    }

    /**
     * Adds a dollar amount to the item's current value. The value must be
     * greater than 0, otherwise an exception is thrown.
     *
     * @param cost the value to add to this item price
     * @return the real cost of the item based on its size and base cost
     */
    public double getItemCost(double cost) {

        // ensure cost is greater than 0, otherwise throw exception
        if (cost > 0) {
            return baseCost * itemSize.getCostCoefficient();

        } else // cost is invalid
        {
            throw new IllegalArgumentException("Eror: "
                    + "Item cost must be positive!");
        }
    }

    /**
     * Places a valid price into the baseCost member. The price value must be 0
     * or greater.
     *
     * @param itemCost the price of this item
     * @throws IllegalArgumentException if the shipment value is less than 0
     */
    public void setBaseCost(double itemCost) {

        // ensure value is 0 or greater, otherwise throw exception
        if (itemCost > 0) {
            this.baseCost = itemCost;
        } else // value is invalid
        {
            throw new IllegalArgumentException("Error: "
                    + "Item price must be positive.");
        }
    }
    
    /**
     * Returns a formatted String representing this item object.
     *
     * @return this Item as a String
     */
    @Override
    public String toString() {
        
        // return the item's name, base cost and the actual cost
        return String.format("%-12s %8.2f %10.2f", itemSize.getSizeName(),
                baseCost, getItemCost(baseCost));
    }
}

