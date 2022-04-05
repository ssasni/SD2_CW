//package arrays;
import java.io.*;
import java.util.Scanner;

public class Task01 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        String roomName;
        int roomNum = 0;
        String[] hotel = new String[13];
        for (int x = 0; x < 12; x++ ) hotel[x] = "";
//initialise
//        initialise(hotel); //better to initialise in a
//        procedure
        while ( roomNum < 12 )
        {
            for (int x = 0; x < 12; x++ )
            {
                if (hotel[x].equals("e"))
                    System.out.println("Room " + x + " is empty");
            }
            System.out.print("Enter room number (0-11) or 12 to stop: " );
            roomNum = input.nextInt();
            System.out.print("Enter name for room " + roomNum +" : " ) ;
            roomName = input.next();
            hotel[roomNum] = roomName ;
            for (int x = 0; x < 12; x++ )
            {
                System.out.println("Room " + x + " occupied by " + hotel[x]);
            }
        }
    }
    private static void initialise( String hotelRef[])
    {
        for (int x = 0; x < 12; x++ ) hotelRef[x] = "e";
        System.out.println( "initilise");
    }
}
