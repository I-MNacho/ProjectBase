package com.codeup.iknowaspot.models;

import java.util.Iterator;

public class funcitons {


    // Search for a pin
    public static void search() {
        boolean foundMatches = false;

        System.out.println("Search here: ");
        String searchTerm = sc.nextLine();

        Spot[] contactArrayList;
        for (Spot spot : contactArrayList) {
            if (contact.getName().contains(searchTerm) || contact.getNumber().contains(searchTerm)) {
                foundMatches = true;
                System.out.println("Hey we found a match to your entry!");
                System.out.printf("%-25s| %-12s\n", contact.getName(), contact.getFormattedNumber());
            }
        }
        if(!foundMatches){
            System.out.println("Sorry we did not find any matches :( ");
        }
    }



//    //Delete existing pin
//    public static void deleteContact(){
//        System.out.println("Please enter a contact to delete.");
//        String searchTerm = sc.nextLine();
//
//        Iterator<Contact> listIterator = contactArrayList.iterator();
//        boolean foundMatch = false;
//        while (listIterator.hasNext()){
//            Contact item = listIterator.next();
//            if (item.getName().contains(searchTerm)){
//                foundMatch = true;
//                System.out.println("Are you sure you would like to delete the following entry? y/n");
//                System.out.printf("%-25s| %-12s\n", item.getName(), item.getFormattedNumber());
//                if (sc.nextLine().equalsIgnoreCase("y")) {
//                    listIterator.remove();
//                    System.out.println("Delete confirmed!");
//                }else{
//                    System.out.println(item.getName() + " was not deleted.");
//                }
//            }
//        }
//        if(!foundMatch){
//            System.out.println("We didn't find a contact that matches " + searchTerm +".");
//            System.out.println("Rerouting you back to the main menu.");
//        }
//    }
}
