import java.util.*;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Task02 {
    public static Scanner input = new Scanner(System.in); // Global Scanner input
    public static Passenger[] passenger = new Passenger[12];
    public static Cabin[] cabin = new Cabin[12];
    public static int roomNum = 0;
    public static String roomName = "";

    public static void main (String[] args) {
        // Initialise
        initialise();
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
                add(); // Calling method to add Passengers

            else if (option.equals("E"))
                empty(); // Calling method to display empty cabins

            else if (option.equals("D"))
                delete(); // Calling method to delete Passengers name

            else if (option.equals("F"))
                find(); // Calling method to find cabin by Passengers name

            else if (option.equals("S"))
                try {
                    store(); // Calling method to store details to file
                } catch (IOException e) {
                    System.out.println("Error");
                }

            else if (option.equals("L"))
                try {
                    load(); // Calling method to load  details from stored file
                } catch (IOException e) {
                    System.out.println("Error");
                }

            else if (option.equals("O"))
                sort(); // Calling method to display names in alphabetical order

            else if (option.equals("V"))
                view();  // Calling method to view all cabins

            else if (option.equals("Q")){ // Method to quit the program
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

    // Initialise
    private static void initialise()
    {
        for (int x = 0; x < 12; x++ ) {
            passenger[x] = new Passenger("e","e","0");
            cabin[x] = new Cabin('0');
        }
        System.out.println(" ");
    }

    // Add room (cabin)
    private static void add(){
//        int c = 0;
//        for (int i = 0; i < 12; i++) {
//            if (!(passenger[i].fName.equals("e"))) {
//                c += 1;
//            }
//        }
//
//        if (c == 12) {
//            System.out.println("All the cabins are full, You have to be waiting");
//            System.out.println("Please enter your name to add the waiting list : ");
//            waitingList.add(input.next());
//        }

        System.out.println(" ");
        System.out.print("Enter room number (0-11) : "); // Getting the user input for room number
        int roomNum = input.nextInt();
        System.out.println(" ");
        if (roomNum < 0 || roomNum >= 12){
            System.out.println("Invalid room number"); // if room number is not between 0 - 11 it will print an error message
        }
        else {
            if (passenger[roomNum].fName.equals("e")) { // if room number is empty
                if (roomNum <= 12) {
//                    System.out.print("Enter the number of members in your room : ");
//                    cabin[roomNum].member = input.nextInt();
                    System.out.print("Enter the first name : "); // Getting the user input for customers first name
                    String roomName = input.next();
                    passenger[roomNum].fName = roomName;
                    System.out.print("Enter the surname : "); // Getting the user input for customers surname
                    passenger[roomNum].sName = input.next();
                    System.out.print("Enter the expenses : "); // Getting the user input for customers expenses
                    passenger[roomNum].expenses = input.next();

                    System.out.println( );
                    System.out.println("Details added successfully"); // Notify message
                }
            } else {
                System.out.println("Sorry, Room is already occupied"); // else room number is not empty
            }
        }
    }

    // View all rooms (cabins)
    private static void view() {
        for (int x = 0; x < passenger.length; x++) {
            if (passenger[x].fName.equals("e")) // if room is empty
                System.out.println("Room " + x + " is empty"); // Display the empty rooms
            else // else booked
                System.out.println("Room " + x + " is occupied by " + passenger[x].fName); // Display the occupied rooms
        }
    }

    // Display empty rooms (cabins)
    private static void empty() {
        for (int x = 0; x < 12; x++ ) {
            if (passenger[x].fName.equals("e")) // if room is empty
                System.out.println("Room " + x + " is empty"); // Display the empty rooms
        }
    }

    // Delete customer from room (cabin)
    private static void delete(){
        System.out.print("Enter the member name to delete from the room: "); // User input to get customer name
        String Name = input.next();
        for (int x= 0; x < passenger.length; x++) {
            if (passenger[x].fName.equals(Name)) { // if passengers name is equal to user input name
                passenger[x].fName = "e"; // Delete the passengers first name
                passenger[x].sName = ""; // Delete the passengers surname
                passenger[x].expenses = ""; // Delete the passengers expenses
                System.out.println("Member name in room number " + x + " is deleted"); // Display a notify message that the member name is deleted
                break;
            }
            else { // else room is empty
                System.out.println("No member at any room in this name"); // Display a notify message that the passengers name does not match
                break;
            }
        }
//        int dlt = input.nextInt();
//        passenger[dlt] = "e";
    }

    // Find the cabin by customer name
    private static void find(){
        System.out.print("Enter the member's first name to find his room: "); // User input to get customer name
        String roomName = input.next();
        for (int i=0; i < passenger.length; i++) {
            if (passenger[i].fName.equals(roomName))
                System.out.print("Room " + i + " is " + "occupied by " + roomName);
        }
        System.out.println();
    }

    // Store data into file
    private static void store() throws IOException {
        File object1 = new File("details.txt"); // Create a file
        object1.createNewFile();
        FileWriter write = new FileWriter(object1.getName()); // Write file
//        String names = "";
        for (int i = 0; i < passenger.length; i++){
            if (passenger[i].fName.equals("e")) { // if room is empty
                write.write("Room number " + i + " is empty\n"); // Store the empty rooms
                write.write("-----------------------------" + "\n");
            }
            else {
                write.write("Room number " + i + " is occupied by " + passenger[i].fName + "\n"); // Store the occupied room by name
                write.write("Firs Name: " + passenger[i].fName + "\n"); // Customer's First name
                write.write("Surname: " + passenger[i].sName + "\n"); // Customer's Surname
                write.write("Expenses: " + passenger[i].expenses + "\n"); // Customer's Expenses
                write.write("-----------------------------" + "\n");
            }
//            if (!passenger[i].equals("e")) {
//                write.write("Room number: " + i + " is occupied by " + passenger[i] + "\n");
//                write.write("Firs Name: " + passenger[i].fName + "\n");
//                write.write("Surname: " + passenger[i].sName + "\n");
//                write.write("Expenses: " + passenger[i].expenses + "\n");
//                write.write("" + "\n");
//            }
//            else {
//                write.write("Room number " + i + " is empty\n");
//            }

//            if (passenger[i].equals("e")) // if room is empty
//                names += "Room number " + i + " is empty\n"; // Display the empty rooms
//            else // else booked
//                names += "Room number " + i + " is occupied by " + passenger[i] + "\n"; // Display the occupied room
        }
//        System.out.println();
//        write.write(names + "\n");

        write.close(); // Close the file
        System.out.println("Data saved");
    }

    // Load data from file
    private static void load() throws IOException {
        System.out.println("Details loaded\n");
        File object2 = new File("details.txt");
        object2.createNewFile();

        Scanner File = new Scanner(object2);
        while (File.hasNextLine()) {
            System.out.println(File.nextLine());
        }
        File.close();
    }

    // Members first name Ordered in alphabetically
    public static void sort() {
        for (int i = 0; i <passenger.length; i++)
        {
            for (int j = i + 1; j < passenger.length; j++)
            {
                if (passenger[i].fName.compareTo(passenger[j].fName) > 0) // Compares different elements of array
                {
                    String temp = passenger[i].fName;
                    passenger[i].fName = passenger[j].fName;
                    passenger[j].fName = temp;
                }
            }
        }
        System.out.println("Members first name Ordered in alphabetically");
        for (int x = 0; x < passenger.length; x++) {
            if (! passenger[x].fName.equals("e"))
                System.out.println(passenger[x].fName); // Display the names in alphabetically
        }
    }
}
