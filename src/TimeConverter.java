public class TimeConverter {
    public static String convert(String time) {
//        String[] split = time.split(":");
//        int hour = Integer.parseInt(split[0]);
//        String seconds = split[2].substring(0, 2);
//        String timeFormat = split[2].substring(2);
//
//        hour = hour % 12;
//        if (timeFormat.equals("PM")) hour += 12;
//        return String.format("%02d:%s:%s", hour, split[1], seconds);

        int hour = Integer.parseInt(time.substring(0, 2));
        hour %= 12;
        if (time.endsWith("PM")) hour += 12;
        return String.format("%02d%s", hour, time.substring(2, 8));
    }
}
