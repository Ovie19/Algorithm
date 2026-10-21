public class RegexValidator {
    public static boolean isValidEmail(String email) {
        String regex = "[a-z]\\.[a-z]+@native\\.semicolon\\.africa";
        return email.matches(regex);
    }

    public static boolean isValidPassword(String password) {
        String regex = "(?=\\S+$)(?=.*[@#_+])(?=.*\\d).{8,16}";
        return password.matches(regex);
    }
}
