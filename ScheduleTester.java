// Copyright CompuScholar, Inc.
// Do not distribute or post in any public or private venue.

// No student changes should be made to this file.

public class ScheduleTester {
    public static void main(String[] args) {
        System.out.println("*** Testing Channel 0");
        // All days: Movies all day

        test(0, 0, 0, "Movies");
        test(0, 1, 12, "Movies");
        test(0, 5, 23, "Movies");

        System.out.println("\n*** Testing Channel 1");
        // All days: Live Sports shows between 12 and 20
        // Player Interviews otherwise

        test(1, 0, 0, "Player Interviews");
        test(1, 6, 23, "Player Interviews");
        test(1, 1, 12, "Live Sports");
        test(1, 3, 20, "Live Sports");

        System.out.println("\n*** Testing Channel 2");
        // Weekends: Cooking shows between 12 and 20
        // Infomercials otherwise
        // Weekdays: Talk shows before 12
        // Game shows between 12 and 18
        // News programs after 18

        test(2, 0, 11, "Infomercial");
        test(2, 0, 21, "Infomercial");
        test(2, 6, 11, "Infomercial");
        test(2, 6, 21, "Infomercial");
        test(2, 0, 12, "Cooking");
        test(2, 0, 20, "Cooking");
        test(2, 6, 12, "Cooking");
        test(2, 6, 20, "Cooking");
        test(2, 1, 11, "Talk Show");
        test(2, 2, 12, "Game Show");
        test(2, 3, 18, "Game Show");
        test(2, 4, 19, "News");

    }

    private static void test(int channel, int day, int hour, String expected) {
        Schedule.setTime(day, hour);
        String show = Schedule.getShow(channel);
        if (show.equals(expected)) {
            System.out.println("Channel " + channel + " (" + day + "," + hour
                + ") PASSED: Received expected show \"" + show + "\"");
        } else {
            System.out.println("Channel " + channel + " (" + day + "," + hour
                + ") FAILED: Expected \"" + expected + "\", got \"" + show + "\"");
        }
    }
}
