package arrays;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Task01 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaring variables
        String roomName;
        int roomNum = 0;

        // Create an array for rooms
        String[] hotel = new String[12];
        for (int x = 0; x < 12; x++ ) hotel[x] = "";

        // Initialise
        initialise(hotel);
        Scanner user = new Scanner(System.in);

        // While loop
        while (true)
        {
            // Displaying the menu option
            System.out.println("Cruise Ship Boarding. To");
            System.out.println("A : Add a customer to a cabin");
            System.out.println("E : Display empty cabins");
            System.out.println("D : Delete customer from cabin");
            System.out.println("F : Find cabin from customer name");
            System.out.println("S : Store program data into file");
            System.out.println("L : Load program data from file");
            System.out.println("O : View passengers ordered alphabetically by name");
            System.out.println("V : View all cabins");
            System.out.println("Q : Quit the programme");

            System.out.println("-----------------------------------------");

            System.out.print("Enter your option: ");
            String option = user.nextLine();

            if (option.equals("A"))
                add(hotel, input);

            else if (option.equals("E"))
                empty(hotel);

            else if (option.equals("D"))
                delete(hotel, input);

            else if (option.equals("F"))
                find(hotel, input);

//            else if (option.equals("S"))
//                store(hotel);

//            else if (option.equals("L"))
//                load(hotel);

//            else if (option.equals("O"))
//                sort(hotel);

            else if (option.equals("V"))
                view(hotel);

            else if (option.equals("Q")){
                System.out.println("Thank you");
                System.out.println("Run again !!..");
                break;
                }

//            for (int x = 0; x < 12; x++ )
//            {
//                if (hotel[x].equals("e"))
//                    System.out.println("Room " + x + " is empty");
//            }
//            System.out.println(" ");
//            System.out.print("Enter room number (0-11) or 12 to stop: " );
//            roomNum = input.nextInt();
//            System.out.println(" ");
//            if (roomNum < 12){
//                System.out.print("Enter name for room " + roomNum +" : " ) ;
//                roomName = input.next();
//                hotel[roomNum] = roomName ;
//            }
//
//            for (int x = 0; x < 12; x++ )
//            {
//                System.out.println("Room " + x + " occupied by " + hotel[x]);
//            }
            System.out.println("-----------------------------------------");
        }
    }

    // Add room (cabin)
    private static void add(String [] hotel, Scanner input){
        System.out.println(" ");
        System.out.print("Enter room number (0-11) : "); // Getting the user input for room number
        int roomNum = input.nextInt();
        System.out.println(" ");
        if (roomNum < 12) {
            System.out.print("Enter name for room " + roomNum + " : "); // Getting the user input for customer name
            String roomName = input.next();
            hotel[roomNum] = roomName;
        }
    }

    // Display empty rooms (cabins)
    private static void empty(String [] hotel) {
        for (int x = 0; x < 12; x++ ) {
            if (hotel[x].equals("e")) // if room is empty
                System.out.println("Room " + x + " is empty"); // Display the empty rooms
        }
    }

    // Delete customer from room (cabin)
    private static void delete(String [] hotel, Scanner input){
        System.out.print("Enter the room number to delete the customer name: ");
        int dlt = input.nextInt();
        hotel[dlt] = "e";
    }

    //Need to change
    // Find the cabin by customer name
    private static void find(String [] hotel, Scanner input){
        System.out.print("Enter the customer name to find his room: ");
        String roomName = input.next();
        for (int i=0; i < hotel.length; i++) {
            if (hotel[i].equals(roomName))
                System.out.print("Room " + i + " is " + "occupied by " + roomName);
        }
        System.out.println();
    }

//    private static void store(String [] hotel, Scanner input) {
//
//    }

//    private static void load(String [] hotel) {
//
//    }

//    private static void sort(String [] hotel) {
//
//    }

    // View all rooms (cabins)
    private static void view(String[] hotel) {
        for (int x = 0; x < hotel.length; x++) {
            if (hotel[x].equals("e")) // if room is empty
                System.out.println("Room " + x + " is empty"); // Display the empty rooms
            else // else booked
                System.out.println("Room " + x + " is occupied by " + hotel[x]); // Display the occupied rooms
        }
    }

    // Initialise
    private static void initialise( String hotel[])
    {
        for (int x = 0; x < 12; x++ ) hotel[x] = "e";
        System.out.println(" ");
    }
}
