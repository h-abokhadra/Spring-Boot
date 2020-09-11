/*
        Name:  Hoda Abokhadra
        Assignment:  Assignment3
        Program: SDNE
        Date:  Feb 13th 2020
    
        Description:
        This program is about creating an arraylist of Item.
        This class contains the main method for the program.
 */
package abokhadr;

import java.util.*;

/**
 *
 * @author Hoda Abokhadra
 */
public class ItemListApp {

    //This method is for validating and getting user inputs.
    //do while loop is being used in getValues method.
    public void getValues(Scanner input) {
        ItemList itemsList = new ItemList();
        boolean inputDone = false;

        do {
            boolean isValidSize = false;
            boolean isValidCost = false;
            
            Size inputSize = null;
            double d = 0;
            do {
                try {
                    System.out.println("Enter Size Code: (XS|S|M|L|XL)");
                    String s1 = input.nextLine().toUpperCase();
                    if (!s1.matches("[XS S M L XL].*") ) {
                        System.out.println("Error! There is no such size!");
                        isValidSize = false;
                    } else {
                        isValidSize = true;
                        inputSize = Size.valueOf(s1);
                    }
                } catch (InputMismatchException e) {
                    isValidSize = false;
                    System.out.println("Enter Size Code: (XS|S|M|L|XL)");
                    input.nextLine();

                }
            } while (!isValidSize);

           
            do {
                System.out.println("Enter Item's Base Cost");
                try {
                    d = input.nextDouble();
                    if (d < 0) {
                        System.out.println("Error: Item price must be positive");
                        isValidCost = false;
                    } else {
                        isValidCost = true;
                    }
                } catch (InputMismatchException e) {
                    isValidCost = false;
                    System.out.println("Enter Item's Base Cost");
                    input.nextLine();
                }
            } while (!isValidCost);
            
            
            if (isValidSize && isValidCost) {
                Item inputItem = new Item(inputSize,d);
                itemsList.add(inputItem);
            }

            input.nextLine();
            System.out.println("Would you like to enter another item (Y/N)?");
            String s = input.nextLine();
            if (s.equalsIgnoreCase("Y")) {
                inputDone = false;
            } else {
                inputDone = true;
                
                //printing the output of the program using toString method.
                System.out.println(itemsList.toString());
            }

        } while (!inputDone);

    }

   
    /**
     * The main method for this application
     *
     * @param args The array of string arguments passed
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ItemListApp itemObj = new ItemListApp();
        itemObj.getValues(input);

    }
}
