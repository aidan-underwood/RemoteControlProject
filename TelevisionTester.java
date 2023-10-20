// Copyright CompuScholar, Inc.
// Do not distribute or post in any public or private venue.

// No student changes should be made to this file.

/**
 * TelevisionTester class
 */
public class TelevisionTester {
    public static void main(String[] args) {
        Television myTV = new Television();

        // verify default properties
        System.out.println("***Testing Default Properties");
        testProperty("initial value", "currentChannel", myTV.getChannel(), 0);
        testProperty("initial value", "currentVolume", myTV.getVolume(), Television.MAX_VOLUME / 2);
        testProperty("initial value", "on", myTV.getOn(), false);

        // when power is off, no command should produce anything other than powerOn()
        System.out.println("\n***Testing behavior while power is off");
        myTV.setOn(false);
        myTV.channelUp();
        testProperty("channel up while power off", "currentChannel", myTV.getChannel(), 0);

        myTV.channelDown();
        testProperty("channel down while power off", "currentChannel", myTV.getChannel(), 0);

        myTV.volumeUp();
        testProperty("volume up while power off", "currentVolume", myTV.getVolume(),
            Television.MAX_VOLUME / 2);

        myTV.volumeDown();
        testProperty("volume down while power off", "currentVolume", myTV.getVolume(),
            Television.MAX_VOLUME / 2);

        // test power on
        System.out.println("\n***Testing powerOn() while power is off");
        myTV.setOn(false);
        myTV.powerOn();
        testProperty("power on when power is off", "on", myTV.getOn(), true);

        // test power off
        System.out.println("\n***Testing powerOff() while power is on");
        myTV.setOn(true);
        myTV.powerOff();
        testProperty("power off", "on", myTV.getOn(), false);


        // test channel up
        System.out.println("\n***Testing channelUp()");
        myTV.setOn(true);
        myTV.setChannel(0);
        myTV.channelUp(); // should increase to 1
        myTV.channelUp(); // should increase to 2
        testProperty("channel up", "currentChannel", myTV.getChannel(), 2);
        myTV.channelUp(); // should wrap to 0
        testProperty("channel up wrap to 0", "currentChannel", myTV.getChannel(), 0);

        // test channel down
        System.out.println("\n***Testing channelDown()");
        myTV.setChannel(0);
        myTV.channelDown(); // should wrap up to 2
        testProperty("channel down", "currentChannel", myTV.getChannel(), 2);
        myTV.channelDown(); // should decrease to 1
        myTV.channelDown(); // should decrease to 0
        testProperty("channel down", "currentChannel", myTV.getChannel(), 0);

        // test volume up
        System.out.println("\n***Testing volumeUp()");
        myTV.setVolume(4);
        myTV.volumeUp(); // should increase to 5
        testProperty("volume up", "currentVolume", myTV.getVolume(), 5);
        myTV.volumeUp(); // should increase to Television.MAX_VOLUME
        testProperty("volume up", "currentVolume", myTV.getVolume(), Television.MAX_VOLUME);
        myTV.volumeUp(); // should stay at Television.MAX_VOLUME
        testProperty("volume up", "currentVolume", myTV.getVolume(), Television.MAX_VOLUME);

        // test volume down
        System.out.println("\n***Testing volumeDown()");
        myTV.setVolume(2);
        myTV.volumeDown(); // should decrease to 1
        testProperty("volume down", "currentVolume", myTV.getVolume(), 1);
        myTV.volumeDown(); // should decrease to 0
        testProperty("volume down", "currentVolume", myTV.getVolume(), 0);
        myTV.volumeDown(); // should stay at 0
        testProperty("volume down", "currentVolume", myTV.getVolume(), 0);
    }

    static void testProperty(String description, String propertyName, int value, int expected) {
        if (value == expected) {
            System.out.println("PASSED: " + description + ", " + propertyName + " = " + value);
        } else {
            System.out.println("FAILED: " + description + ", " + propertyName + " = " + value
                + ", expected " + expected);
        }
    }

    static void testProperty(String description, String propertyName, boolean value,
        boolean expected) {
        if (value == expected) {
            System.out.println("PASSED: " + description + ", " + propertyName + " = " + value);
        } else {
            System.out.println("FAILED: " + description + ", " + propertyName + " = " + value
                + ", expected " + expected);
        }
    }
}
