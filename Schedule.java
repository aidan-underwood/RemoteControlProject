public class Schedule {

    private static int dayOfWeek;
    private static int hourOfDay;

    public Schedule() {}

    public static void setTime(int day, int hour) {
        dayOfWeek = day;
        hourOfDay = hour;
    }

    public static String getShow(int channelNumber) {
        if (channelNumber == 0) {
            return "Movies";
        } else if (channelNumber == 1) {
            if (hourOfDay >= 12 && hourOfDay <= 20) {
                return "Live Sports";
            } else {
                return "Player Interviews";
            }
        } else if (channelNumber == 2) {
            if (dayOfWeek == 0 || dayOfWeek == 6) {
                if (hourOfDay >= 12 && hourOfDay <= 20) {
                    return "Cooking";
                } else {
                    return "Infomercial";
                }
            } else {
                if (hourOfDay < 12) {
                    return "Talk Show";
                } else if (hourOfDay >= 12 && hourOfDay <= 18) {
                    return "Game Show";
                } else {
                    return "News";
                }
            }
        }

        return null;
    }
}
