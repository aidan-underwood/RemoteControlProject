// Copyright CompuScholar, Inc.
// Do not distribute or post in any public or private venue.

// No student changes should be made to this file.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize Scanner for user input
        Scanner input = new Scanner(System.in);

        // get the current day and hour and initialize the Schedule
        System.out.print("Enter the day of the week (0-6) and the hour of the day (0-23): ");
        int day = input.nextInt();
        int hour = input.nextInt();

        System.out.println(""); // blank line

        Schedule.setTime(day, hour);

        // create Television and Remote objects
        Television tv = new Television();
        Remote myRemote = new Remote(tv);

        // process user input with remote until power off signal
        while (true) {
            myRemote.processInput(input);
        }
    }
}
