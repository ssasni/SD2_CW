package arrays;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Task01 {
    public static String[] roomName = new String[12];
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        // Declaring variables
//        String roomName;
        int roomNum = 0;

        // Create an array for cabin and name
        String[] hotel = new String[12];
        String[] roomName = new String[12];
        for (int x = 0; x < 12; x++ ) hotel[x] = "";

        // Initialise
        initialise(hotel,roomName);
        Scanner user = new Scanner(System.in);

        // While loop for repeat the program
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

            System.out.print("Enter your option: "); // User input for select from menu option
            String option = user.nextLine();


            if (option.equals("A"))
                add(hotel, input);

            else if (option.equals("E"))
                empty(hotel);

            else if (option.equals("D"))
                delete(hotel, input);

            else if (option.equals("F"))
                find(hotel, input);

            else if (option.equals("S"))
                try {
                    store(hotel);
                } catch (IOException e) {
                    System.out.println("Error");
                }

            else if (option.equals("L"))
                try {
                    load(hotel);
                } catch (IOException e) {
                    System.out.println("Error");
                }

            else if (option.equals("O"))
                sort(hotel, roomName);

            else if (option.equals("V"))
                view(hotel);

            else if (option.equals("Q")){
                System.out.println("Thank you");
                System.out.println("Run again !!.....");
                break;
                }

            else {
                System.out.println("Invalid option");
            }

            System.out.println("-----------------------------------------");
        }
    }

    // Add room (cabin)
    private static void add(String [] hotel, Scanner input){
        System.out.println(" ");
        System.out.print("Enter room number (0-11) : "); // Getting the user input for room number
        int roomNum = input.nextInt();
        System.out.println(" ");
        if (roomNum < 0 || roomNum >= 12){
            System.out.println("Invalid room number"); // if room number is not between 0 - 11 it will print an error message
        }
        else {
            if (hotel[roomNum].equals("e")) { // if room is empty
                if (roomNum <= 12) { // if room number is less than or equal to 12
                    System.out.print("Enter name for room " + roomNum + " : "); // Getting the user input for customer name
                    String roomName = input.next();
                    hotel[roomNum] = roomName;
                }
            } else { // else room is already occupied
                System.out.println("Sorry, Room is already occupied"); // else room number is not empty
            }
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
        System.out.print("Enter the room number to delete the customer name: "); // User input to get customer name
        int roomNum = input.nextInt();
        if (!hotel[roomNum].equals("e")) { // if room is not empty (Already customer in the room
            int dlt = roomNum;
            hotel[dlt] = "e";
            System.out.println("Customer name in room is deleted"); // Display a notify message that the member name is deleted
        }
        else { // else room is empty
            System.out.println("Room is already empty"); // Display a notify message that the room is already empty
        }
    }

    // Find the cabin by customer name
    private static void find(String [] hotel, Scanner input){
        System.out.print("Enter the customer name to find his room: "); // User input to get customer name
        String roomName = input.next();
        for (int i=0; i < hotel.length; i++) {
            if (hotel[i].equals(roomName))
                System.out.print("Room " + i + " is " + "occupied by " + roomName);
        }
        System.out.println();
    }

    // Store data into file
    private static void store(String [] hotel) throws IOException {
        File object1 = new File("data.txt"); // Create a file
        object1.createNewFile();
        FileWriter write = new FileWriter(object1.getName()); // Write file
        String names = "";
        for (int i = 0; i < hotel.length; i++){
            if (hotel[i].equals("e")) // if room is empty
                names += "Room number " + i + " is empty\n"; // Store the empty rooms
            else // else booked
                names += "Room number " + i + " is occupied by " + hotel[i] + "\n"; // Store the occupied room by name
        }
        write.write(names + "\n");

        write.close(); // Close the file
        System.out.println("Data saved");
    }


    // Load data from file
    private static void load(String [] hotel) throws IOException {
        System.out.println("Details loaded\n");
        File object2 = new File("data.txt");
        object2.createNewFile();

        Scanner File = new Scanner(object2);
        while (File.hasNextLine()) {
            System.out.println(File.nextLine());
        }
        File.close();
    }


    // Members first name Ordered in alphabetically
    private static void sort(String [] hotel , String[] roomName) {
        for (int i = 0; i < hotel.length; i++)
        {
            for (int j = i + 1; j < hotel.length; j++)
            {
                if (hotel[i].compareTo(hotel[j]) > 0) // Compares different elements of array
                {
                    String temp = hotel[i];
                    hotel[i] = hotel[j];
                    hotel[j] = temp;
                }
            }
        }
        System.out.println("Members first name Ordered in alphabetically");
        for (int x = 0; x < hotel.length; x++) {
            if (! hotel[x].equals("e"))
                System.out.println("Cabin number " + x + " is occupied by " + hotel[x]); // Display the names in alphabetically
        }
    }

//    String[] passengerName = new String[12];
//        for (int element = 0; element < cabin.length; element++) passengerName[element] = cabin[element];
//    // Bubble sort
//        for(int i = 0 ; i < passengerName.length; i ++)
//    {
//        for(int j = 0; j < passengerName.length-1 ; j ++)
//        {
//            // Swapper the names if the first name is greater second name
//            if(passengerName[j].compareTo(passengerName[j+1]) > 0 )
//            {
//                String temp = passengerName[j];
//                passengerName[j] = passengerName[j+1];
//                passengerName[j+1] = temp;
//            }
//        }
//    }
//
//    // Displaying names in alphabetic order
//        for(int outer = 0; outer < passengerName.length; outer++){
//        for (int inner = 0; inner < passengerName.length; inner++){
//            if (passengerName[outer] != "e"){
//                if (passengerName[outer].equals(cabin[inner])){
//                    System.out.println("Cabin number " + (inner + 1) + " is occupied by " + passengerName[outer]);
//                }
//            }
//        }
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
    private static void initialise( String hotel[], String[] roomName)
    {
        for (int x = 0; x < 12; x++ )
            hotel[x] = "e";
//            roomName[x] = "";
        System.out.println(" ");
    }
}
