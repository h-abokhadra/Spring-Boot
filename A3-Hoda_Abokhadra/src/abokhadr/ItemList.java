/*
        Name:  Hoda Abokhadra
        Assignment:  Assignment3
        Program: SDNE
        Date:  Feb 13th 2020
    
        Description:
        This program create an Item list.
 */
package abokhadr;

import java.util.*;

/**
 *
 * @author Hoda Abokhadra
 */
public class ItemList {

    // creating the arraylist of Item.
    ArrayList<Item> itemList = new ArrayList<Item>();

    // creating the default constructor.
    public ItemList() {
    }

    //get method fot getting the index of Item.
    public Item get(int index) {
        return itemList.get(index);
    }

    // add method for validiting the items using the find item method.
    public void add(Item item) {
        int itemIndex = findItem(item.itemSize);
        if (itemIndex == -1) {
            itemList.add(item);
        } else {
            Item existingItem = get(itemIndex);
            double existingBaseCost = existingItem.getBaseCost();
            double updateBaseCost = existingBaseCost + item.getBaseCost();
            existingItem.setBaseCost(updateBaseCost);

        }

    }
// find Item method 

    public int findItem(Size Sie) {

        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).itemSize == Sie) {
                return i;
            }
        }
        return -1;
    }

    public int length(int length) {

        return length;
    }

    /**
     *
     * @return this Item as a String
     */
    @Override
    public String toString() {
        String output = "=============================================="
                + "\nItem Name" + "        " + " Base Cost " + "      "
                + " Item Cost "
                + "\n==============================================" + "\n";
        for (Item item : itemList) {
            output += item.toString() + "\n";
        }
        return output;
    }

}
