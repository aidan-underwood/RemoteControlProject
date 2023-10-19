public class Television {
    final public static int MAX_CHANNEL = 2; // compuscholar makes it final public static
    final public static int MAX_VOLUME = 6; // i dislike compuscholar for doing this

    private int currentChannel;
    private int currentVolume;
    private static boolean on;

    public Television() {
        currentChannel = 0;
        currentVolume = MAX_VOLUME / 2;
        on = false;
    }

    public int getChannel() {
        return currentChannel;
    }

    public int getVolume() {
        return currentVolume;
    }

    public boolean getOn() {
        return on;
    }

    public void setChannel(int channelNum) {
        if (channelNum > MAX_CHANNEL) {
            currentChannel = 0;
        } else if (channelNum < 0) {
            currentChannel = MAX_CHANNEL;
        } else {
            currentChannel = channelNum;
        }
    }

    public void setVolume(int volumeNum) {
        if (volumeNum > MAX_VOLUME) {
            currentVolume = MAX_VOLUME;
        } else if (volumeNum < 0) {
            currentVolume = 0;
        } else {
            currentVolume = volumeNum;
        }
    }

    public void setOn(boolean status) {
        on = status;
    }

    public void powerOn() {
        setOn(true);
        System.out.println("TV: Powering On");
    }

    public void powerOff() {
        setOn(false);
        System.out.println("TV: Powering Off");
    }

    public void channelUp() {
        if (on) {
            currentChannel++;
            setChannel(currentChannel);
            System.out.println("TV: Now Showing \"" + Schedule.getShow(currentChannel)
                + "\" on Channel " + currentChannel);
        }
    }

    public void channelDown() {
        if (on) {
            currentChannel--;
            setChannel(currentChannel);
            System.out.println("TV: Now Showing \"" + Schedule.getShow(currentChannel)
                + "\" on Channel " + currentChannel);
        }
    }

    public void volumeUp() {
        if (on) {
            currentVolume++;
            setVolume(currentVolume);
            System.out.println("TV: Volume Up to " + currentVolume);
        }
    }

    public void volumeDown() {
        if (on) {
            currentVolume--;
            setVolume(currentVolume);
            System.out.println("TV: Volume Down to " + currentVolume);
        }
    }
}
