package calorietracker.util;

public class SessionUtil {
    private static String username;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        SessionUtil.username = username;
    }
}