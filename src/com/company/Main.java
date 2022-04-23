package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
            ArrayList<String> items = new ArrayList<String>();
            items.add("Red Doritos");
            items.add("Ranch Doritos");
            items.add("Peps");
            items.add("Coke");
            items.add("Diet Soda");
            items.add("Energy Drink");
            items.add("Mac Book Pro Charger");
            items.add("Dell Charger");
            items.add("Seeds");
            items.add("Nuts");

            ArrayList<Double> itemsPrice = new ArrayList<Double>();
            itemsPrice.add(2.99);
            itemsPrice.add(2.99);
            itemsPrice.add(0.99);
            itemsPrice.add(0.99);
            itemsPrice.add(0.99);
            itemsPrice.add(3.99);
            itemsPrice.add(120.0);
            itemsPrice.add(50.0);
            itemsPrice.add(0.99);
            itemsPrice.add(0.99);

            ArrayList<String> custItem = new ArrayList<String>();
            ArrayList<Integer> custItemAmounts = new ArrayList<Integer>();
            String input;
            Scanner stringInput = new Scanner(System.in);

            String output = "";
            double total;
            double grandTotal = 0;
            System.out.print("Customer's Name: ");
            while(!(input = stringInput.nextLine()).equalsIgnoreCase("no")){ //loop to enter each customers order
                output += "\n" + input;
                total = 0; //assigning 0 for as initial for all customers
                System.out.println("Enter the name of items: (0 to exit at any time)");
                while(!(input = stringInput.nextLine()).equalsIgnoreCase("0")) { //loop to enter each ordered item
                    for(String i:items) {
                        if(i.contains(input) || i.equalsIgnoreCase(input)) {
                            total += itemsPrice.get(items.indexOf(i));
                            output += "\n\t"+input;
                            if(!custItem.contains(input)) {
                                custItem.add(input);
                                custItemAmounts.add(1);
                            }
                            else {
                                int index = custItem.indexOf(input);
                                custItemAmounts.set(index, custItemAmounts.get(index) + 1);
                            }
                            break;
                        }
                    }
                }
                output += "\n\t\t"+total+"\n";
                grandTotal += total;
                System.out.print("\nEnter the name of the next customer (no to exit): ");
            }
            System.out.println("\n Order List: "+output);
            System.out.println("\nInventory Sold: ");
            for(String i:custItem) {
                System.out.println("\t"+i+" ("+custItemAmounts.get(custItem.indexOf(i))+")");
            }
            System.out.println("\nGRAND TOTAL: "+grandTotal);
        }
    }


